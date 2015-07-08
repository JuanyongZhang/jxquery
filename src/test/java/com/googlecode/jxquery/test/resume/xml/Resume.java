package com.googlecode.jxquery.test.resume.xml;

import java.util.Date;
import java.util.List;

import com.googlecode.jxquery.jxQuery;

/**
 * @Author : <a href="mailto:Juanyong.zhang@gmail.com">Juanyong.zhang</a>
 * @Date : Oct 2, 2011
 */
public class Resume {
	@jxQuery(query = "/xmlRoot/firstName")
	private String firstName;
	@jxQuery(query = "/xmlRoot/lastName")
	private String lastName;
	@jxQuery(query = "/xmlRoot/gender")
	private String gender;
	@jxQuery(query = "/xmlRoot/dob", creator = com.googlecode.jxquery.creator.DateCreator.class)
	private Date dob;
	@jxQuery(query = "/xmlRoot/email")
	private String email;
	@jxQuery(query = "/xmlRoot/address")
	private Address address;
	@jxQuery(query = "/xmlRoot/phoneNumber[@type='home']")
	private PhoneNumber[] homeNumber;
	@jxQuery(query = "/xmlRoot/phoneNumber[@type='mobile']")
	private PhoneNumber[] mobile;
	@jxQuery(query = "/xmlRoot/summary")
	private String summary;
	@jxQuery(query = "/xmlRoot/skills")
	private String[] skills;
	@jxQuery(query = "/xmlRoot/projects")
	private List<Project> projects;
	@jxQuery(query = "/xmlRoot/projects[@teamMbrCnt>=20]")
	private List<Project> projectsSizeGt20;

	public Address getAddress() {
		return address;
	}

	public Date getDob() {
		return dob;
	}

	public String getEmail() {
		return email;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getGender() {
		return gender;
	}

	public PhoneNumber[] getHomeNumber() {
		return homeNumber;
	}

	public String getLastName() {
		return lastName;
	}

	public PhoneNumber[] getMobile() {
		return mobile;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public List<Project> getProjectsSizeGt20() {
		return projectsSizeGt20;
	}

	public String[] getSkills() {
		return skills;
	}

	public String getSummary() {
		return summary;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setHomeNumber(PhoneNumber[] homeNumber) {
		this.homeNumber = homeNumber;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setMobile(PhoneNumber[] mobile) {
		this.mobile = mobile;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public void setProjectsSizeGt20(List<Project> projectsSizeGt20) {
		this.projectsSizeGt20 = projectsSizeGt20;
	}

	public void setSkills(String[] skills) {
		this.skills = skills;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

}
