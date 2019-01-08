
package com.doublechaintech.cms.userwhitelist;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.cms.CmsUserContext;
import com.doublechaintech.cms.BaseEntity;
import com.doublechaintech.cms.SmartList;

public interface UserWhiteListManager{

		

	public UserWhiteList createUserWhiteList(CmsUserContext userContext, String userIdentity, String userSpecialFunctions, String domainId) throws Exception;	
	public UserWhiteList updateUserWhiteList(CmsUserContext userContext,String userWhiteListId, int userWhiteListVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public UserWhiteList loadUserWhiteList(CmsUserContext userContext, String userWhiteListId, String [] tokensExpr) throws Exception;
	public UserWhiteList internalSaveUserWhiteList(CmsUserContext userContext, UserWhiteList userWhiteList) throws Exception;
	public UserWhiteList internalSaveUserWhiteList(CmsUserContext userContext, UserWhiteList userWhiteList,Map<String,Object>option) throws Exception;
	
	public UserWhiteList transferToAnotherDomain(CmsUserContext userContext, String userWhiteListId, String anotherDomainId)  throws Exception;
 

	public void delete(CmsUserContext userContext, String userWhiteListId, int version) throws Exception;
	public int deleteAll(CmsUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(CmsUserContext userContext, UserWhiteList newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


