package com.googlecode.jxquery.test;

import static com.googlecode.jxquery.utils.ResourceHelper.getResourceAsStreamFromPackage;

import java.io.InputStream;

import junit.framework.Assert;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.junit.Test;

import com.googlecode.jxquery.JSONPopulater;
import com.googlecode.jxquery.XMLPopulater;
import com.googlecode.jxquery.test.person.PersonInfo;
import com.googlecode.jxquery.test.resume.Resume;

/**
 * @Author : <a href="mailto:Juanyong.zhang@gmail.com">Cham Juanyong.zhang</a>
 * @Date : Jan 21, 2011
 */
public class AppTest {

	@Test
	public void testPersonJSON() throws Exception {
		final String fileName = "person.json";
		final String fName = "John";
		final String faxNbr = "212 555-2345";

		InputStream in = getResourceAsStreamFromPackage(PersonInfo.class,
				fileName);

		PersonInfo p = new PersonInfo();
		System.out.println(ToStringBuilder.reflectionToString(JSONPopulater
				.eval(in, p)));
		Assert.assertEquals(fName, p.getFirstName());
		Assert.assertEquals(faxNbr, p.getFax()[0].getNumber());

		System.out.println(p.getPhoneNumberJSON()[0].get("number"));
		System.out.println("##########################");
	}

	@Test
	public void testResumeJSON() throws Exception {
		final String fileName = "resume.json";

		final String email = "jsmith@gmail.com";
		final int count = 1;

		InputStream in = getResourceAsStreamFromPackage(Resume.class, fileName);

		Resume r = new Resume();

		System.out.println(ToStringBuilder.reflectionToString(JSONPopulater
				.eval(in, r)));

		Assert.assertEquals(email, r.getEmail());
		Assert.assertEquals(count, r.getProjectsSizeGt20().size());

		System.out.println("##########################");
	}

	@Test
	public void testPersonXML() throws Exception {
		final String fileName = "person.xml";
		final String fName = "John";
		final String faxNbr = "212 555-2345";

		InputStream in = getResourceAsStreamFromPackage(
				com.googlecode.jxquery.test.person.xml.PersonInfo.class, fileName);

		com.googlecode.jxquery.test.person.xml.PersonInfo p = new com.googlecode.jxquery.test.person.xml.PersonInfo();
		System.out.println(ToStringBuilder.reflectionToString(XMLPopulater
				.eval(in, p)));

		Assert.assertEquals(fName, p.getFirstName());
		Assert.assertEquals(faxNbr, p.getFax()[0].getNumber());
		System.out.println("##########################");
	}

	@Test
	public void testResumeXML() throws Exception {
		final String fileName = "resume.xml";

		final String email = "jsmith@gmail.com";
		final int count = 2;

		InputStream in = getResourceAsStreamFromPackage(
				com.googlecode.jxquery.test.resume.xml.Resume.class, fileName);

		com.googlecode.jxquery.test.resume.xml.Resume r = new com.googlecode.jxquery.test.resume.xml.Resume();

		System.out.println(ToStringBuilder.reflectionToString(XMLPopulater
				.eval(in, r)));

		Assert.assertEquals(email, r.getEmail());
		Assert.assertEquals(count, r.getProjectsSizeGt20().size());

		System.out.println("##########################");
	}
}
