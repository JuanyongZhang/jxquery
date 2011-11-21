package jxquery.google.test.resume.xml;

import java.util.Date;

import jxquery.google.jxQuery;

/**
 * @Author : <a href="mailto:Juanyong.zhang@gmail.com">Juanyong.zhang</a>
 * @Date : Oct 2, 2011
 */
public class Project {
	@jxQuery(query = "name")
	private String name;
	@jxQuery(query = "start", creator = jxquery.google.creator.DateCreator.class)
	private Date start;
	@jxQuery(query = "end", creator = jxquery.google.creator.DateCreator.class)
	private Date end;
	@jxQuery(query = "teamMbrCnt")
	private Integer teamMbrCnt;
	@jxQuery(query = "type")
	private String type;
	@jxQuery(query = "role")
	private String role;
	@jxQuery(query = "details")
	private String details;
	@jxQuery(query = "enviroment")
	private String enviroment;

	public String getDetails() {
		return details;
	}

	public Date getEnd() {
		return end;
	}

	public String getEnviroment() {
		return enviroment;
	}

	public String getName() {
		return name;
	}

	public String getRole() {
		return role;
	}

	public Date getStart() {
		return start;
	}

	public Integer getTeamMbrCnt() {
		return teamMbrCnt;
	}

	public String getType() {
		return type;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public void setEnviroment(String enviroment) {
		this.enviroment = enviroment;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public void setTeamMbrCnt(Integer teamMbrCnt) {
		this.teamMbrCnt = teamMbrCnt;
	}

	public void setType(String type) {
		this.type = type;
	}
}
