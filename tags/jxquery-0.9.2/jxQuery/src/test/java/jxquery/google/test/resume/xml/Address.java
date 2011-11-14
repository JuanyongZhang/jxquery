package jxquery.google.test.resume.xml;

import jxquery.google.jxQuery;

/**
 * @Author : <a href="mailto:Juanyong.zhang@gmail.com">Juanyong.zhang</a>
 * @Date : Oct 2, 2011
 */
public class Address {
	@jxQuery(query = "streetAddress")
	private String streetAddress;
	@jxQuery(query = "city")
	private String city;
	@jxQuery(query = "state")
	private String state;
	@jxQuery(query = "postalCode")
	private String postalCode;

	public String getCity() {
		return city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public String getState() {
		return state;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

}
