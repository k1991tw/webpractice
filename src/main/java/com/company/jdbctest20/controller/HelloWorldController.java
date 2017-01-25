package com.company.jdbctest20.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.jdbctest20.model.Match1;
import com.company.jdbctest20.service.Match1Service;

@Controller
@RequestMapping("/hello-world")
public class HelloWorldController {
	@Autowired
	protected Match1Service match1Service;

	@RequestMapping(value = "readAll",method = RequestMethod.GET)
	public @ResponseBody List<Match1> testReadMatch1(
			@RequestParam(value = "name", required = false, defaultValue = "Stranger") String name) {
		Collection<Match1> all = match1Service.readMatch1();
		List<Match1> result = new ArrayList<Match1>(all);
		return result;
	} 

	@RequestMapping(value = "save", method = RequestMethod.GET)
	public void testSaveMatch1(
			@RequestParam(value = "court", required = false, defaultValue = "1") String court,
			@RequestParam(value = "crt", required = false, defaultValue = "1") String crt,
			@RequestParam(value = "day1", required = false, defaultValue = "1") Integer day1,
			@RequestParam(value = "event", required = false, defaultValue = "1") String event,
			@RequestParam(value = "eventType", required = false, defaultValue = "1") String eventType,
			@RequestParam(value = "headToHead", required = false, defaultValue = "1") String headToHead, 
			@RequestParam(value = "pt", required = false, defaultValue = "1") Integer pt,
			@RequestParam(value = "round", required = false, defaultValue = "1") Integer round,
			@RequestParam(value = "server", required = false, defaultValue = "1") String server,
			@RequestParam(value = "status", required = false, defaultValue = "1") String status,
			@RequestParam(value = "video", required = false, defaultValue = "1") String video,
			@RequestParam(value = "winner", required = false, defaultValue = "1") Integer winner 
			 
 
			
			) {
		Match1 po = new Match1();
		po.setCourt(court);
		po.setCrt(crt);
		po.setDay1(day1);
		po.setEvent(event);
		po.setEventType(eventType);
		po.setHeadToHead(headToHead);
		po.setPt(pt);
		po.setRound(round);
		po.setServer(server);
		po.setStatus(status);
		po.setVideo(video);
		po.setWinner(winner);
		match1Service.saveMatch1(po );
	}
  @Test
  @RequestMapping(value = "update", method = RequestMethod.GET)
  public void testUpdateMatch1(
		  @RequestParam(value = "court", required = false, defaultValue = "1") String court,
			@RequestParam(value = "crt", required = false, defaultValue = "1") String crt,
			@RequestParam(value = "day1", required = false, defaultValue = "1") Integer day1,
			@RequestParam(value = "event", required = false, defaultValue = "1") String event,
			@RequestParam(value = "eventType", required = false, defaultValue = "1") String eventType,
			@RequestParam(value = "headToHead", required = false, defaultValue = "1") String headToHead, 
			@RequestParam(value = "pt", required = false, defaultValue = "1") Integer pt,
			@RequestParam(value = "round", required = false, defaultValue = "1") Integer round,
			@RequestParam(value = "server", required = false, defaultValue = "1") String server,
			@RequestParam(value = "status", required = false, defaultValue = "1") String status,
			@RequestParam(value = "video", required = false, defaultValue = "1") String video,
			@RequestParam(value = "winner", required = false, defaultValue = "1") Integer winner
		  ) {
	  
      Match1 po = new Match1();
      po.setId(5);
      po.setEvent("sss");
      po.setServer("hello");
      po.setWinner(23);
		this.match1Service.saveMatch1(po); 
      
  }
	 

	@Test
	@Ignore
	public void testDeleteMatch1ById() throws Exception {
		for(int i=0 ;i <20 ;i++){
			this.match1Service.deleteMatch1ById(i);
		}
		
	}

}
