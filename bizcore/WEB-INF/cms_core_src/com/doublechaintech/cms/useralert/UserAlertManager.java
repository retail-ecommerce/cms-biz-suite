
package com.doublechaintech.cms.useralert;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.cms.CmsUserContext;
import com.doublechaintech.cms.BaseEntity;
import com.doublechaintech.cms.SmartList;

public interface UserAlertManager{

		

	public UserAlert createUserAlert(CmsUserContext userContext, String message, String profileId, String location, String platformId) throws Exception;	
	public UserAlert updateUserAlert(CmsUserContext userContext,String userAlertId, int userAlertVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public UserAlert loadUserAlert(CmsUserContext userContext, String userAlertId, String [] tokensExpr) throws Exception;
	public UserAlert internalSaveUserAlert(CmsUserContext userContext, UserAlert userAlert) throws Exception;
	public UserAlert internalSaveUserAlert(CmsUserContext userContext, UserAlert userAlert,Map<String,Object>option) throws Exception;
	
	public UserAlert transferToAnotherProfile(CmsUserContext userContext, String userAlertId, String anotherProfileId)  throws Exception;
 	public UserAlert transferToAnotherPlatform(CmsUserContext userContext, String userAlertId, String anotherPlatformId)  throws Exception;
 

	public void delete(CmsUserContext userContext, String userAlertId, int version) throws Exception;
	public int deleteAll(CmsUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(CmsUserContext userContext, UserAlert newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


