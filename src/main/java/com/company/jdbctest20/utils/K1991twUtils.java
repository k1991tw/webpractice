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
		/**
		* 產生指令，內容為"Update Table名稱( 目前CLASS SIMAPLE nAME同於TABLE名稱，例如:com.company.jdbctest1.model.Player的simpleName為Player) set  "		
                **/ 
		StringBuffer sbf =new StringBuffer("Update "+pet.getClass().getSimpleName() +" set  ");
		
		/***
		* 將此PO(persistent Object )的field(有時也稱proerty，因為她對應資料庫表格的欄位)列出來		
                ****/
		final PropertyDescriptor[] pds = PropertyUtils.getPropertyDescriptors(pet);
		List<String> nameList =new LinkedList<String>();
		for (PropertyDescriptor pd :pds){
			try {
				/***
				*  取得property名稱...由於這邊名稱(camel name rule)與資料庫欄位名稱一致，並沒有遵照資料庫欄位名稱慣例(PERSON_NAME,MOTHER_NAME)
 				**/
				String name = pd.getName();
				
				/****
				* 略過屬性名稱為class,name				
                                */
				if("class".equalsIgnoreCase(name)||"new".equalsIgnoreCase(name)){
					continue;
				} 
				
				/***
				* 模仿spring jdbc template update statement對欄位的處理				
                                */
				nameList.add(name+"=:"+name);
				
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		String setSatement =	StringUtils.join(nameList.toArray(), ",");
		sbf.append(setSatement).append("  WHERE id=:id");
		
		/****
		* 最後完成spring jdbc template update sql
                */
		String sql =sbf.toString(); 
		
		return sql;
	}
}
