package com.company.jdbctest20.utils;

import java.beans.PropertyDescriptor;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component; 
@Component
public class K1991twUtils {
	public MapSqlParameterSource createPoParameterSource(Object pet) {
		final MapSqlParameterSource origin = new MapSqlParameterSource();
		final PropertyDescriptor[] pds = PropertyUtils.getPropertyDescriptors(pet);
		for (PropertyDescriptor pd :pds){
			try {
				String name = pd.getName();
				Object value = PropertyUtils.getProperty(pet, name); 
					origin.addValue(name, value ); 
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		return origin;
	}
	public String createUpdateSQL(Object pet) {
		 
		StringBuffer sbf =new StringBuffer("Update "+pet.getClass().getSimpleName() +" set  ");
		final PropertyDescriptor[] pds = PropertyUtils.getPropertyDescriptors(pet);
		List<String> nameList =new LinkedList<String>();
		for (PropertyDescriptor pd :pds){
			try {
				String name = pd.getName();
				if("class".equalsIgnoreCase(name)||"new".equalsIgnoreCase(name)){
					continue;
				} 
				nameList.add(name+"=:"+name);	 
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		String setSatement =	StringUtils.join(nameList.toArray(), ",");
		sbf.append(setSatement).append("  WHERE id=:id");
		String sql =sbf.toString(); 
		return sql;
	}
}
