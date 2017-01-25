package com.company.jdbctest20.service;

import static org.junit.Assert.assertEquals;

import java.util.Collection;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.jdbctest20.AbstractClinicServiceTests;
import com.company.jdbctest20.model.Match1;
@ContextConfiguration(locations = {"classpath:spring/business-config.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("jdbc")
public class Match1ServiceImplTest  extends AbstractClinicServiceTests {

	@Autowired
    protected Match1Service match1Service;

    @Test
    @Ignore
    public void testReadMatch1() {
        Collection<Match1> match1 = this.match1Service.readMatch1();
//        assertEquals(match1.size(), 1);
    }
    @Test
//    @Ignore
    public void testSaveMatch1() {
        Match1 po = new Match1();
//        po.setId(2);
        po.setServer("haha");
        po.setWinner(23);
		this.match1Service.saveMatch1(po); 
        Collection<Match1> match2 = this.match1Service.readMatch1();
//        assertEquals(  2,match2.size());
    }
    @Test
    public void testUpdateMatch1() {
        Match1 po = new Match1();
        po.setId(2);
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
