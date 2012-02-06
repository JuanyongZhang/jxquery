package jxquery.google;

import static jxquery.google.utils.Constants.XML_ROOT;

import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import jxquery.google.utils.ClassHelper;
import jxquery.google.utils.Constants;
import jxquery.google.utils.JSONHelper;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.io.IOUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Text;

public class JSONXMLBuilder {

	private static Element buildLeaf(Document doc, String key, Object value) {
		Element child = doc.createElement(key);
		Text text = doc.createTextNode(value.toString());
		child.appendChild(text);
		return child;
	}

	@SuppressWarnings("unchecked")
	private static Node buildNode(Document doc, Node node, Object json)
			throws ParserConfigurationException {
		// Check nulls
		if (null == doc || null == node)
			return null;
		if (null == json)
			return node;

		if (json instanceof JSONObject) {
			JSONObject jo = (JSONObject) json;
			Set<String> keys = jo.keySet();
			for (String key : keys) {
				Object value = jo.get(key);
				Element child = null;

				if (ClassHelper.isLangType(value)) {
					child = buildLeaf(doc, key, value);
					if (!XML_ROOT.equals(node.getNodeName())) {
						((Element) node).setAttribute(key, value.toString());
					}
					node.appendChild(child);
				} else if (value instanceof JSONArray) {
					for (Object jObj : ((JSONArray) value).toArray()) {
						if (ClassHelper.isLangType(jObj)) {
							child = buildLeaf(doc, key, jObj);
						} else {
							child = doc.createElement(key);
							child.setAttribute(Constants.XML_EMBEDDED_JSON,
									JSONHelper.getSingleQuoteString(jObj
											.toString()));
						}
						node.appendChild(buildNode(doc, child, jObj));
					}
				} else if (value instanceof JSONObject) {
					child = doc.createElement(key);
					child.setAttribute(Constants.XML_EMBEDDED_JSON, JSONHelper
							.getSingleQuoteString(value.toString()));
					node.appendChild(buildNode(doc, child, value));
				}
			}
		}

		return node;
	}

	public static Document toXML(InputStream is) throws IOException {
		return toXML(IOUtils.toString(is));
	}

	public static Document toXML(String json) {
		Document doc = null;
		try {
			DocumentBuilder db = DocumentBuilderFactory.newInstance()
					.newDocumentBuilder();
			doc = db.newDocument();
			Element root = doc.createElement(XML_ROOT);
			doc.appendChild(buildNode(doc, root, JSONObject.fromObject(json)));

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}

		return doc;
	}
}
