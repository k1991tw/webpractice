package com.company.jdbctest20.model;

import java.io.Serializable; 


/**
 * The persistent class for the match1 database table.
 * 
 */ 
public class Match1 implements Serializable {
	 

	 

	private Integer  id;

	private String court;

	private String crt;

	private Integer day1;

	private String event;

	private String eventType;

	private String headToHead;

	private Integer pt;

	private Integer round;

	private String server;

	private String status;

	private String video;

	private Integer winner;

	public Match1() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer  id) {
		this.id = id;
	}

	public String getCourt() {
		return this.court;
	}

	public void setCourt(String court) {
		this.court = court;
	}

	public String getCrt() {
		return this.crt;
	}

	public void setCrt(String crt) {
		this.crt = crt;
	}

	public Integer getDay1() {
		return this.day1;
	}

	public void setDay1(Integer day1) {
		this.day1 = day1;
	}

	public String getEvent() {
		return this.event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getEventType() {
		return this.eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getHeadToHead() {
		return this.headToHead;
	}

	public void setHeadToHead(String headToHead) {
		this.headToHead = headToHead;
	}

	public Integer getPt() {
		return this.pt;
	}

	public void setPt(Integer pt) {
		this.pt = pt;
	}

	public Integer getRound() {
		return this.round;
	}

	public void setRound(Integer round) {
		this.round = round;
	}

	public String getServer() {
		return this.server;
	}

	public void setServer(String server) {
		this.server = server;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getVideo() {
		return this.video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public Integer getWinner() {
		return this.winner;
	}

	public void setWinner(Integer winner) {
		this.winner = winner;
	}
    public boolean isNew() {
        return (this.id == null);
    }
}