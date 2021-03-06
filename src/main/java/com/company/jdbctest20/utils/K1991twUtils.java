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
	
	/***
	* 模仿spring jdbc template範例中,由PO產生key-value Map物件(MapSqlParameterSource)	
        **/
	public MapSqlParameterSource createPoParameterSource(Object pet) {
		final MapSqlParameterSource origin = new MapSqlParameterSource();
		final PropertyDescriptor[] pds = PropertyUtils.getPropertyDescriptors(pet);
		/***
		* 將此PO(persistent Object )的field(有時也稱proerty，因為她對應資料庫表格的欄位)列出來		
                ****/
		for (PropertyDescriptor pd :pds){
			try { 	
				
				/***
				*  取得property名稱...由於這邊名稱(camel name rule)與資料庫欄位名稱一致，
				*  並沒有遵照資料庫欄位名稱慣例(PERSON_NAME,MOTHER_NAME)
 				**/
                                String name = pd.getName();
				
				/***
				*  取得property實際資料內容...由於資料型別為String,Integer 居多, Object為父類別可以接受
 				**/
				Object value = PropertyUtils.getProperty(pet, name); 
				
				/***
				* 放入Map當中
				**/
				origin.addValue(name, value ); 
				
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		return origin;
	}
	
	/****
	* 根據PO產生為spring jdbc template用的SQL	
        **/
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
				*  取得property名稱...由於這邊名稱(camel name rule)與資料庫欄位名稱一致，
				*  並沒有遵照資料庫欄位名稱慣例(PERSON_NAME,MOTHER_NAME)
 				**/
				String name = pd.getName();
				
				/****
				* 略過屬性名稱為class,name，不會執行nameList.add(name+"=:"+name);
				*  因為這兩個屬性是繼承Object來的，實際上無此兩個欄位			
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
