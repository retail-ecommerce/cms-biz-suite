
package com.doublechaintech.cms.loginhistory;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.cms.CmsUserContext;
import com.doublechaintech.cms.BaseEntity;
import com.doublechaintech.cms.SmartList;

public interface LoginHistoryManager{

		

	public LoginHistory createLoginHistory(CmsUserContext userContext, String fromIp, String description, String secUserId) throws Exception;	
	public LoginHistory updateLoginHistory(CmsUserContext userContext,String loginHistoryId, int loginHistoryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public LoginHistory loadLoginHistory(CmsUserContext userContext, String loginHistoryId, String [] tokensExpr) throws Exception;
	public LoginHistory internalSaveLoginHistory(CmsUserContext userContext, LoginHistory loginHistory) throws Exception;
	public LoginHistory internalSaveLoginHistory(CmsUserContext userContext, LoginHistory loginHistory,Map<String,Object>option) throws Exception;
	
	public LoginHistory transferToAnotherSecUser(CmsUserContext userContext, String loginHistoryId, String anotherSecUserId)  throws Exception;
 

	public void delete(CmsUserContext userContext, String loginHistoryId, int version) throws Exception;
	public int deleteAll(CmsUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(CmsUserContext userContext, LoginHistory newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


