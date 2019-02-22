
package com.doublechaintech.cms.useralert;
import com.doublechaintech.cms.AccessKey;


public class UserAlertTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	static final String TABLE_NAME="user_alert_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_MESSAGE = "message";
	static final String COLUMN_PROFILE = "profile";
	static final String COLUMN_LOCATION = "location";
	static final String COLUMN_LAST_UPDATE = "last_update";
	static final String COLUMN_PLATFORM = "platform";
	static final String COLUMN_VERSION = "version";
 
	static final String []ALL_CLOUMNS = {COLUMN_ID, 
		COLUMN_MESSAGE, COLUMN_PROFILE, COLUMN_LOCATION, COLUMN_LAST_UPDATE, COLUMN_PLATFORM, 
		COLUMN_VERSION};
	static final String []NORMAL_CLOUMNS = {
		COLUMN_MESSAGE, COLUMN_PROFILE, COLUMN_LOCATION, COLUMN_LAST_UPDATE, COLUMN_PLATFORM
		};
	
	
}


