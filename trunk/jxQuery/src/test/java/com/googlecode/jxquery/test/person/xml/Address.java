package com.googlecode.jxquery.test.person.xml;

import com.googlecode.jxquery.jxQuery;

/**
 * @Author : <a href="mailto:Juanyong.zhang@gmail.com">Juanyong.zhang</a>
 * @Date : Aug 31, 2011
 */
public class Address {
	@jxQuery(query = "address/streetAddress")
	private String streetAddress;
	@jxQuery(query = "address/city")
	private String city;
	@jxQuery(query = "address/state")
	private String state;
	@jxQuery(query = "address/postalCode")
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
