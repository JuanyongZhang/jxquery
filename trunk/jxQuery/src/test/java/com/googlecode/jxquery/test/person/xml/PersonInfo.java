package com.googlecode.jxquery.test.person.xml;

import java.util.Date;
import java.util.List;

import com.googlecode.jxquery.jxQuery;

import net.sf.json.JSONObject;

/**
 * @Author : <a href="mailto:Juanyong.zhang@gmail.com">Juanyong.zhang</a>
 * @Date : Aug 31, 2011
 */
public class PersonInfo {
	@jxQuery(query = "/xmlRoot/firstName")
	private String firstName;
	@jxQuery(query = "/xmlRoot/lastName")
	private String lastName;
	@jxQuery(query = "/xmlRoot/age")
	private Integer age;
	@jxQuery(query = "/xmlRoot/dob", creator = com.googlecode.jxquery.creator.DateCreator.class)
	private Date dob;
	@jxQuery(query = "/xmlRoot/height")
	private Float height;
	@jxQuery(query = "/xmlRoot/isMarried")
	private Boolean isMarried;
	@jxQuery(query = "/xmlRoot/nickname")
	private String[] nickname;
	@jxQuery(query = "/xmlRoot/eyeSight")
	private Float[] eyeSight;
	@jxQuery(query = "/xmlRoot/address")
	private Address address;
	@jxQuery(query = "/xmlRoot/address")
	private JSONObject addressJSON;
	@jxQuery(query = "/xmlRoot/phoneNumber")
	private PhoneNumber[] phoneNumber;
	@jxQuery(query = "/xmlRoot/phoneNumber[@type='fax']")
	private PhoneNumber[] fax;
	@jxQuery(query = "/xmlRoot/phoneNumber")
	private JSONObject[] phoneNumberJSON;
	@jxQuery(query = "/xmlRoot/phoneNumber")
	private List<PhoneNumber> phoneNumberList;

	public Address getAddress() {
		return address;
	}

	public JSONObject getAddressJSON() {
		return addressJSON;
	}

	public Integer getAge() {
		return age;
	}

	public Date getDob() {
		return dob;
	}

	public Float[] getEyeSight() {
		return eyeSight;
	}

	public PhoneNumber[] getFax() {
		return fax;
	}

	public String getFirstName() {
		return firstName;
	}

	public Float getHeight() {
		return height;
	}

	public Boolean getIsMarried() {
		return isMarried;
	}

	public String getLastName() {
		return lastName;
	}

	public String[] getNickname() {
		return nickname;
	}

	public PhoneNumber[] getPhoneNumber() {
		return phoneNumber;
	}

	public JSONObject[] getPhoneNumberJSON() {
		return phoneNumberJSON;
	}

	public List<PhoneNumber> getPhoneNumberList() {
		return phoneNumberList;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setAddressJSON(JSONObject addressJSON) {
		this.addressJSON = addressJSON;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public void setEyeSight(Float[] eyeSight) {
		this.eyeSight = eyeSight;
	}

	public void setFax(PhoneNumber[] fax) {
		this.fax = fax;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setHeight(Float height) {
		this.height = height;
	}

	public void setIsMarried(Boolean isMarried) {
		this.isMarried = isMarried;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setNickname(String[] nickname) {
		this.nickname = nickname;
	}

	public void setPhoneNumber(PhoneNumber[] phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setPhoneNumberJSON(JSONObject[] phoneNumberJSON) {
		this.phoneNumberJSON = phoneNumberJSON;
	}

	public void setPhoneNumberList(List<PhoneNumber> phoneNumberList) {
		this.phoneNumberList = phoneNumberList;
	}

}
