package jxquery.google;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.xpath.XPathExpressionException;

import org.w3c.dom.Document;

/**
 * @Author : <a href="mailto:Juanyong.zhang@carefirst.com">Cham
 *         Juanyong.zhang</a>
 * @Date : Sep 27, 2011
 */
public class JSONPopulater {
	public static <Vo extends Object> Vo eval(String xml, Vo vo)
			throws IOException, XPathExpressionException {

		Document doc = JSONXMLBuilder.toXML(xml);

		return XMLPopulater.eval(doc, vo, true);
	}

	public static <Vo extends Object> Vo eval(InputStream xml, Vo vo)
			throws IOException, XPathExpressionException {
		Document doc = JSONXMLBuilder.toXML(xml);

		return XMLPopulater.eval(doc, vo, true);
	}

}
