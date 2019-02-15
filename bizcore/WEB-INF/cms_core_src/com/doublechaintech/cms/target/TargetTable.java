
package com.doublechaintech.cms.target;
import com.doublechaintech.cms.AccessKey;


public class TargetTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	static final String TABLE_NAME="target_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_NAME = "name";
	static final String COLUMN_PROFILE = "profile";
	static final String COLUMN_BANNER = "banner";
	static final String COLUMN_WHEN = "when";
	static final String COLUMN_LOCATION = "location";
	static final String COLUMN_LASTUPDATE = "lastUpdate";
	static final String COLUMN_VERSION = "version";
 
	static final String []ALL_CLOUMNS = {COLUMN_ID, 
		COLUMN_NAME, COLUMN_PROFILE, COLUMN_BANNER, COLUMN_WHEN, COLUMN_LOCATION, COLUMN_LASTUPDATE, 
		COLUMN_VERSION};
	static final String []NORMAL_CLOUMNS = {
		COLUMN_NAME, COLUMN_PROFILE, COLUMN_BANNER, COLUMN_WHEN, COLUMN_LOCATION, COLUMN_LASTUPDATE
		};
	
	
}


