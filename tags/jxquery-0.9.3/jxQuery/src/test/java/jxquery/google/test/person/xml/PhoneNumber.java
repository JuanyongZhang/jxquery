package jxquery.google.test.person.xml;

import jxquery.google.jxQuery;

/**
 * @Author : <a href="mailto:Juanyong.zhang@gmail.com">Juanyong.zhang</a>
 * @Date : Aug 31, 2011
 */
public class PhoneNumber {
	@jxQuery(query = "type")
	private String type;
	@jxQuery(query = "number")
	private String number;

	public String getNumber() {
		return number;
	}

	public String getType() {
		return type;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void setType(String type) {
		this.type = type;
	}
}
