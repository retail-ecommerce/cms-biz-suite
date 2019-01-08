
package com.doublechaintech.cms.secuserblocking;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.cms.CmsUserContext;
import com.doublechaintech.cms.BaseEntity;
import com.doublechaintech.cms.SmartList;

public interface SecUserBlockingManager{

		

	public SecUserBlocking createSecUserBlocking(CmsUserContext userContext, String who, String comments) throws Exception;	
	public SecUserBlocking updateSecUserBlocking(CmsUserContext userContext,String secUserBlockingId, int secUserBlockingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public SecUserBlocking loadSecUserBlocking(CmsUserContext userContext, String secUserBlockingId, String [] tokensExpr) throws Exception;
	public SecUserBlocking internalSaveSecUserBlocking(CmsUserContext userContext, SecUserBlocking secUserBlocking) throws Exception;
	public SecUserBlocking internalSaveSecUserBlocking(CmsUserContext userContext, SecUserBlocking secUserBlocking,Map<String,Object>option) throws Exception;
	


	public void delete(CmsUserContext userContext, String secUserBlockingId, int version) throws Exception;
	public int deleteAll(CmsUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(CmsUserContext userContext, SecUserBlocking newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  SecUserManager getSecUserManager(CmsUserContext userContext, String secUserBlockingId, String login, String mobile, String email, String pwd, int verificationCode, DateTime verificationCodeExpire, DateTime lastLoginTime, String domainId ,String [] tokensExpr)  throws Exception;
	
	public  SecUserBlocking addSecUser(CmsUserContext userContext, String secUserBlockingId, String login, String mobile, String email, String pwd, int verificationCode, DateTime verificationCodeExpire, DateTime lastLoginTime, String domainId , String [] tokensExpr)  throws Exception;
	public  SecUserBlocking removeSecUser(CmsUserContext userContext, String secUserBlockingId, String secUserId, int secUserVersion,String [] tokensExpr)  throws Exception;
	public  SecUserBlocking updateSecUser(CmsUserContext userContext, String secUserBlockingId, String secUserId, int secUserVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


