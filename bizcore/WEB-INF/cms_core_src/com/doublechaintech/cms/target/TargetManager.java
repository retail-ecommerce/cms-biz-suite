
package com.doublechaintech.cms.target;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.cms.CmsUserContext;
import com.doublechaintech.cms.BaseEntity;
import com.doublechaintech.cms.SmartList;

public interface TargetManager{

		

	public Target createTarget(CmsUserContext userContext, String name, String profileId, String bannerId, String location, String platformId) throws Exception;	
	public Target updateTarget(CmsUserContext userContext,String targetId, int targetVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Target loadTarget(CmsUserContext userContext, String targetId, String [] tokensExpr) throws Exception;
	public Target internalSaveTarget(CmsUserContext userContext, Target target) throws Exception;
	public Target internalSaveTarget(CmsUserContext userContext, Target target,Map<String,Object>option) throws Exception;
	
	public Target transferToAnotherProfile(CmsUserContext userContext, String targetId, String anotherProfileId)  throws Exception;
 	public Target transferToAnotherBanner(CmsUserContext userContext, String targetId, String anotherBannerId)  throws Exception;
 	public Target transferToAnotherPlatform(CmsUserContext userContext, String targetId, String anotherPlatformId)  throws Exception;
 

	public void delete(CmsUserContext userContext, String targetId, int version) throws Exception;
	public int deleteAll(CmsUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(CmsUserContext userContext, Target newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


