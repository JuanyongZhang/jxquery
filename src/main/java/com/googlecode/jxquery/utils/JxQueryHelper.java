package com.googlecode.jxquery.utils;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import com.googlecode.jxquery.JSONXMLBuilder;

public class JxQueryHelper {

	public static String queryJSON(String json, String query) {
		Document doc = JSONXMLBuilder.toXML(json);
		System.out.println(XMLHelper.getString(doc));
		return queryXML(doc, convertToXQuery(query));
	}

	private static String convertToXQuery(String query) {
		if (!StringUtils.startsWith(query, Constants.SLASH)) {
			query = Constants.SLASH + query;
		}
		return Constants.XML_ROOT + query;
	}

	private static String queryXML(Document doc, String query) {
		String res = null;

		try {
			XPath XPath = XPathFactory.newInstance().newXPath();
			XPathExpression xquery = XPath.compile(query);

			Node node = (Node) xquery.evaluate(doc, XPathConstants.NODE);
			if (null != node) {
				res = node.getTextContent();
			}

		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}

		return res;
	}

	public static String queryXML(String xml, String query) {
		String res = null;
		try {
			DocumentBuilder db = DocumentBuilderFactory.newInstance()
					.newDocumentBuilder();
			Document doc = db.parse(xml);
			res = queryXML(doc, query);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return res;
	}

}
