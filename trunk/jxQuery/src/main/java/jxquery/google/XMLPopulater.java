package jxquery.google;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import jxquery.google.creator.FieldCreator;
import jxquery.google.utils.ArrayHelper;
import jxquery.google.utils.ClassHelper;
import jxquery.google.utils.Constants;
import jxquery.google.utils.ReflectionHelper;
import net.sf.json.JSONObject;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * @Author : <a href="mailto:Juanyong.zhang@carefirst.com">Cham
 *         Juanyong.zhang</a>
 * @Date : Sep 27, 2011
 */
public class XMLPopulater {
	private static Log log = LogFactory.getLog(XMLPopulater.class);

	public static <Vo extends Object> Vo eval(String xml, Vo vo)
			throws ParserConfigurationException, SAXException, IOException,
			XPathExpressionException {
		DocumentBuilder db = DocumentBuilderFactory.newInstance()
				.newDocumentBuilder();
		Document doc = db.parse(new InputSource(new ByteArrayInputStream(xml
				.getBytes("utf-8"))));
		return eval(doc, vo);
	}

	public static <Vo extends Object> Vo eval(InputStream xml, Vo vo)
			throws ParserConfigurationException, SAXException, IOException,
			XPathExpressionException {
		// Document doc = JSONXMLBuilder.toXML(xml);

		DocumentBuilder db = DocumentBuilderFactory.newInstance()
				.newDocumentBuilder();
		Document doc = db.parse(xml);

		return eval(doc, vo);
	}

	private static Object createValue(XQueryField xqf, Object org) {

		return createValue(xqf.creator(), org);
	}

	private static Object createValue(String creatorName, Object org) {

		Object value = null;
		try {
			if (StringUtils.isNotBlank(creatorName)) {
				Object creator = Class.forName(creatorName).newInstance();
				if (creator instanceof FieldCreator) {
					value = ((FieldCreator) creator).build(org);
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		return value;
	}

	@SuppressWarnings("unchecked")
	public static <Vo extends Object, Attr extends Object> Vo eval(Node xml,
			Vo vo) throws XPathExpressionException {
		log.debug("evaluate object:" + vo);

		Field[] fields = ReflectionHelper.getAllFields(vo.getClass(),
				XQueryField.class);
		for (Field f : fields) {
			XQueryField xQuery = f.getAnnotation(XQueryField.class);
			Object result = XQuerier.get(xml, f, xQuery);
			if (null != result) {

				try {
					Object value = createValue(xQuery, result);
					if (null != value) {
						BeanUtils.setProperty(vo, f.getName(), value);
					} else {
						if (result instanceof Node) {
							if (ClassHelper.isLangType(f.getType())) {
								BeanUtils.setProperty(vo, f.getName(),
										((Node) result).getTextContent());
							} else if (JSONObject.class.equals(f.getType())) {
								if (StringUtils
										.isNotBlank(((Element) result)
												.getAttribute(Constants.XML_EMBEDDED_JSON))) {

									JSONObject jObj = JSONObject
											.fromObject(((Element) result)
													.getAttribute(Constants.XML_EMBEDDED_JSON));
									BeanUtils
											.setProperty(vo, f.getName(), jObj);
								}

							} else {
								Object attr = f.getType().newInstance();
								eval((Node) result, attr);
								BeanUtils.setProperty(vo, f.getName(), attr);
							}
						} else if (result instanceof NodeList) {
							NodeList nl = (NodeList) result;

							List<Attr> attr = new ArrayList<Attr>();
							Class<Attr> attrType = (Class<Attr>) ReflectionHelper
									.getFieldComponentType(f);

							for (int i = 0; i < nl.getLength(); i++) {
								Node n = nl.item(i);
								if (ClassHelper.isLangType(attrType)) {
									attr.add((Attr) n.getTextContent());
								} else if (JSONObject.class.equals(attrType)) {
									if (StringUtils
											.isNotBlank(((Element) n)
													.getAttribute(Constants.XML_EMBEDDED_JSON))) {
										attr.add((Attr) JSONObject.fromObject(((Element) n)
												.getAttribute(Constants.XML_EMBEDDED_JSON)));
									}
								} else {
									attr.add((Attr) eval(n,
											attrType.newInstance()));
								}
							}

							if (f.getType().isArray()) {
								if (ClassHelper.isLangType(attrType)) {
									BeanUtils.setProperty(vo, f.getName(),
											attr.toArray());
								} else {
									BeanUtils.setProperty(vo, f.getName(),
											ArrayHelper.createArray(attr,
													attrType));
								}
							} else {
								BeanUtils.setProperty(vo, f.getName(), attr);
							}
						}
					}

				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				} catch (InstantiationException e) {
					e.printStackTrace();
				}
			}
		}
		return vo;
	}
}
