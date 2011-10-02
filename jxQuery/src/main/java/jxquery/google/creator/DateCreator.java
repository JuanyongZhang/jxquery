package jxquery.google.creator;

import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;
import org.w3c.dom.Node;

/**
 * @Author : <a href="mailto:Juanyong.zhang@carefirst.com">Cham
 *         Juanyong.zhang</a>
 * @Date : Sep 29, 2011
 */
public class DateCreator implements FieldCreator {
	private final static String[] patterns = { "yyyy-MM-dd", "yyyy/MM/dd" };

	
    /**
     * Covert node txt node into {@link Date Date} with patterns:  "yyyy-MM-dd", "yyyy/MM/dd"
     *
     * @param  dateNode  the initial capacity of the list
     * @return  {@link Date Date}
     */
	public Date build(Object dateNode) {
		Date date = null;
		if (dateNode instanceof Node) {
			try {
				date = DateUtils.parseDate(((Node) dateNode).getTextContent(),
						patterns);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return date;
	}

}
