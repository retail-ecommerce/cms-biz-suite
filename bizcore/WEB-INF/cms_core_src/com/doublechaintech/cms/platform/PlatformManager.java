
package com.doublechaintech.cms.platform;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.cms.CmsUserContext;
import com.doublechaintech.cms.BaseEntity;
import com.doublechaintech.cms.SmartList;

public interface PlatformManager{

		

	public Platform createPlatform(CmsUserContext userContext, String name, String introduction, String currentVersion) throws Exception;	
	public Platform updatePlatform(CmsUserContext userContext,String platformId, int platformVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Platform loadPlatform(CmsUserContext userContext, String platformId, String [] tokensExpr) throws Exception;
	public Platform internalSavePlatform(CmsUserContext userContext, Platform platform) throws Exception;
	public Platform internalSavePlatform(CmsUserContext userContext, Platform platform,Map<String,Object>option) throws Exception;
	


	public void delete(CmsUserContext userContext, String platformId, int version) throws Exception;
	public int deleteAll(CmsUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(CmsUserContext userContext, Platform newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


