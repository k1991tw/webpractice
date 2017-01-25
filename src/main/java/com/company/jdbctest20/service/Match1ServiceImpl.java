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
package com.company.jdbctest20.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.jdbctest20.model.Match1;
import com.company.jdbctest20.repository.Match1Repository;

/**
 * Mostly used as a facade for all Petclinic controllers Also a placeholder for @Transactional
 * and @Cacheable annotations
 *
 * @author Michael Isvy
 */
@Service
public class Match1ServiceImpl implements Match1Service {

	private Match1Repository match1Repository;

	@Autowired
	public Match1ServiceImpl(Match1Repository match1Repository) {
		this.match1Repository = match1Repository;

	}

	@Transactional(readOnly = true)
	public Collection<Match1> readMatch1() throws DataAccessException {
		return match1Repository.findAll();
	}

	@Override 
	@Transactional
	public void saveMatch1(Match1 po) throws DataAccessException {
		this.match1Repository.save(po);
		
	}

	@Override
	public void deleteMatch1ById(Integer i) throws DataAccessException {
		this.match1Repository.deleteMatch1ById(i);
		
	}

	
}
