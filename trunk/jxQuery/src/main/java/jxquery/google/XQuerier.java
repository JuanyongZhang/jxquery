package jxquery.google;

import static jxquery.google.utils.Constants.SLASH;

import java.lang.reflect.Field;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import jxquery.google.utils.Constants;
import jxquery.google.utils.ReflectionHelper;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @Author : <a href="mailto:Juanyong.zhang@gmail.com">Juanyong.zhang</a>
 * @Date : Sep 27, 2011
 */
public class XQuerier {
	private final static XPath XPath = XPathFactory.newInstance().newXPath();

	public static Object get(Node xml, Field f, XQueryField xqf)
			throws XPathExpressionException {
		String query = getQueryString(xqf);
		XPathExpression xquery = XPath.compile(query);
		Object result = (Node) xquery.evaluate(xml, XPathConstants.NODE);

		if (ReflectionHelper.isCollectionType(f.getType())) {
			result = (NodeList) xquery.evaluate(xml, XPathConstants.NODESET);
		} else {
			result = (Node) xquery.evaluate(xml, XPathConstants.NODE);
		}
		return result;
	}

	private static String getQueryString(XQueryField xqf) {
		String query = xqf.query();

		if (StringUtils.startsWith(query, SLASH)) {
			query = Constants.XML_ROOT + query;
		}

		return query;
	}
}
