
package com.doublechaintech.cms.profile;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.cms.CmsUserContext;
import com.doublechaintech.cms.BaseEntity;
import com.doublechaintech.cms.SmartList;

public interface ProfileManager{

		

	public Profile createProfile(CmsUserContext userContext, String name, String platformId) throws Exception;	
	public Profile updateProfile(CmsUserContext userContext,String profileId, int profileVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Profile loadProfile(CmsUserContext userContext, String profileId, String [] tokensExpr) throws Exception;
	public Profile internalSaveProfile(CmsUserContext userContext, Profile profile) throws Exception;
	public Profile internalSaveProfile(CmsUserContext userContext, Profile profile,Map<String,Object>option) throws Exception;
	
	public Profile transferToAnotherPlatform(CmsUserContext userContext, String profileId, String anotherPlatformId)  throws Exception;
 

	public void delete(CmsUserContext userContext, String profileId, int version) throws Exception;
	public int deleteAll(CmsUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(CmsUserContext userContext, Profile newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  TargetManager getTargetManager(CmsUserContext userContext, String profileId, String name, String bannerId, String location ,String [] tokensExpr)  throws Exception;
	
	public  Profile addTarget(CmsUserContext userContext, String profileId, String name, String bannerId, String location , String [] tokensExpr)  throws Exception;
	public  Profile removeTarget(CmsUserContext userContext, String profileId, String targetId, int targetVersion,String [] tokensExpr)  throws Exception;
	public  Profile updateTarget(CmsUserContext userContext, String profileId, String targetId, int targetVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


