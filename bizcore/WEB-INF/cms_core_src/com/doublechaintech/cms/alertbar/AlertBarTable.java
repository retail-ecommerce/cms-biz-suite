
package com.doublechaintech.cms.alertbar;
import com.doublechaintech.cms.AccessKey;


public class AlertBarTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	static final String TABLE_NAME="alert_bar_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_NAME = "name";
	static final String COLUMN_MESSAGE = "message";
	static final String COLUMN_LAST_UPDATE = "last_update";
	static final String COLUMN_PLATFORM = "platform";
	static final String COLUMN_VERSION = "version";
 
	static final String []ALL_CLOUMNS = {COLUMN_ID, 
		COLUMN_NAME, COLUMN_MESSAGE, COLUMN_LAST_UPDATE, COLUMN_PLATFORM, 
		COLUMN_VERSION};
	static final String []NORMAL_CLOUMNS = {
		COLUMN_NAME, COLUMN_MESSAGE, COLUMN_LAST_UPDATE, COLUMN_PLATFORM
		};
	
	
}


