/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.company.jdbctest20.repository;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowCountCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.company.jdbctest20.model.Match1;
import com.company.jdbctest20.utils.K1991twUtils;

/**
 * A simple JDBC-based implementation of the {@link Match1Repository} interface.
 * Uses @Cacheable to cache the result of the {@link findAll} method
 *
 * @author Ken Krebs
 * @author Juergen Hoeller
 * @author Rob Harrop
 * @author Sam Brannen
 * @author Thomas Risberg
 * @author Mark Fisher
 * @author Michael Isvy
 */
@Repository
public class JdbcMatch1RepositoryImpl implements Match1Repository {

	private NamedParameterJdbcTemplate jdbcTemplate;
	private SimpleJdbcInsert insertTemplate;

	@Autowired
	private K1991twUtils utils;
	
	@Autowired
	public JdbcMatch1RepositoryImpl(NamedParameterJdbcTemplate jdbcTemplate,DataSource dataSource) {
		this.jdbcTemplate = jdbcTemplate;

		this.insertTemplate = new SimpleJdbcInsert(dataSource)
		.withTableName("Match1")   ;;
	}

	/**
	 * Refresh the cache of Vets that the ClinicService is holding.
	 *
	 * @see org.springframework.Match1Service.petclinic.model.service.ClinicService#readMatch1()
	 */
	@Override
	public Collection<Match1> findAll() throws DataAccessException {
		List<Match1> vets = new ArrayList<Match1>();
		// Retrieve the list of all Match1. 
		vets.addAll(this.jdbcTemplate.query("SELECT * FROM match1 ",
				BeanPropertyRowMapper.newInstance(Match1.class)));

		return vets;
	}

	@Override
	public void save(Match1 po) {
		save02(po);
	}

	protected void save01(Match1 po) {
		String sql = "INSERT INTO match1  VALUES" + " (" + po.getCourt()
				+ " , " + po.getCrt() + ", " + po.getDay1() + ", "
				+ po.getEvent() + "," + po.getEventType() + ","
				+ po.getHeadToHead() + "," + po.getId() + "," + po.getPt()
				+ "," + po.getRound() + ",'" + po.getServer() + "',"
				+ po.getStatus() + "," + po.getVideo() + "," + po.getWinner()
				+ ")";
		System.out.println(sql);
		jdbcTemplate.getJdbcOperations().update(sql);
	}

	protected void save02(Match1 po) {
		if (po.isNew()) { 
			RowMapper<Integer> rowMapper =new RowMapper<Integer>(){

				public Integer mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					
					return rs.getInt(1);
				}};
			List<Integer> tmpList = this.jdbcTemplate.query("SELECT COUNT(*) FROM  Match1 " ,rowMapper);
			  
			  
			int max =  tmpList.get(0);
			po.setId(max + 1);
			Number newKey = this.insertTemplate.execute(utils
					.createPoParameterSource(po));
		} else {
			this.jdbcTemplate
					.update(utils.createUpdateSQL(po),
							utils.createPoParameterSource(po));
		}

	}

	@Override
	public void deleteMatch1ById(Integer i) {
		jdbcTemplate.getJdbcOperations().execute("DELETE FROM Match1 WHERE id="+i);
		
	}
 
	
}
