
package com.doublechaintech.cms.alertbar;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.cms.BaseRowMapper;
import com.doublechaintech.cms.platform.Platform;

public class AlertBarMapper extends BaseRowMapper<AlertBar>{
	
	protected AlertBar internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		AlertBar alertBar = getAlertBar();		
		 		
 		setId(alertBar, rs, rowNumber); 		
 		setName(alertBar, rs, rowNumber); 		
 		setMessage(alertBar, rs, rowNumber); 		
 		setLastUpdate(alertBar, rs, rowNumber); 		
 		setPlatform(alertBar, rs, rowNumber); 		
 		setVersion(alertBar, rs, rowNumber);

		return alertBar;
	}
	
	protected AlertBar getAlertBar(){
		return new AlertBar();
	}		
		
	protected void setId(AlertBar alertBar, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(AlertBarTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		alertBar.setId(id);
	}
		
	protected void setName(AlertBar alertBar, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String name = rs.getString(AlertBarTable.COLUMN_NAME);
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		alertBar.setName(name);
	}
		
	protected void setMessage(AlertBar alertBar, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String message = rs.getString(AlertBarTable.COLUMN_MESSAGE);
		if(message == null){
			//do nothing when nothing found in database
			return;
		}
		
		alertBar.setMessage(message);
	}
		
	protected void setLastUpdate(AlertBar alertBar, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Date lastUpdate = rs.getTimestamp(AlertBarTable.COLUMN_LAST_UPDATE);
		if(lastUpdate == null){
			//do nothing when nothing found in database
			return;
		}
		
		alertBar.setLastUpdate(convertToDateTime(lastUpdate));
	}
		 		
 	protected void setPlatform(AlertBar alertBar, ResultSet rs, int rowNumber) throws SQLException{
 		String platformId = rs.getString(AlertBarTable.COLUMN_PLATFORM);
 		if( platformId == null){
 			return;
 		}
 		if( platformId.isEmpty()){
 			return;
 		}
 		Platform platform = alertBar.getPlatform();
 		if( platform != null ){
 			//if the root object 'alertBar' already have the property, just set the id for it;
 			platform.setId(platformId);
 			
 			return;
 		}
 		alertBar.setPlatform(createEmptyPlatform(platformId));
 	}
 	
	protected void setVersion(AlertBar alertBar, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(AlertBarTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		alertBar.setVersion(version);
	}
		
		

 	protected Platform  createEmptyPlatform(String platformId){
 		Platform platform = new Platform();
 		platform.setId(platformId);
 		platform.setVersion(Integer.MAX_VALUE);
 		return platform;
 	}
 	
}


