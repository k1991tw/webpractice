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

import org.springframework.dao.DataAccessException;

import com.company.jdbctest20.model.Match1;

/**
 * Mostly used as a facade for all Petclinic controllers
 *
 * @author Michael Isvy
 */
public interface Match1Service {

	Collection<Match1> readMatch1() throws DataAccessException;
	
	void saveMatch1(Match1 po)throws DataAccessException;
	
	void deleteMatch1ById(Integer i)throws DataAccessException;

}
