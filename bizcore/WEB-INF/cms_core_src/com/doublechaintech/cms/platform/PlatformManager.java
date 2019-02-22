
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
	

	//public  AlertBarManager getAlertBarManager(CmsUserContext userContext, String platformId, String name, String message ,String [] tokensExpr)  throws Exception;
	
	public  Platform addAlertBar(CmsUserContext userContext, String platformId, String name, String message , String [] tokensExpr)  throws Exception;
	public  Platform removeAlertBar(CmsUserContext userContext, String platformId, String alertBarId, int alertBarVersion,String [] tokensExpr)  throws Exception;
	public  Platform updateAlertBar(CmsUserContext userContext, String platformId, String alertBarId, int alertBarVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  BannerManager getBannerManager(CmsUserContext userContext, String platformId, String name, String imagePath ,String [] tokensExpr)  throws Exception;
	
	public  Platform addBanner(CmsUserContext userContext, String platformId, String name, String imagePath , String [] tokensExpr)  throws Exception;
	public  Platform removeBanner(CmsUserContext userContext, String platformId, String bannerId, int bannerVersion,String [] tokensExpr)  throws Exception;
	public  Platform updateBanner(CmsUserContext userContext, String platformId, String bannerId, int bannerVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  ProfileManager getProfileManager(CmsUserContext userContext, String platformId, String name ,String [] tokensExpr)  throws Exception;
	
	public  Platform addProfile(CmsUserContext userContext, String platformId, String name , String [] tokensExpr)  throws Exception;
	public  Platform removeProfile(CmsUserContext userContext, String platformId, String profileId, int profileVersion,String [] tokensExpr)  throws Exception;
	public  Platform updateProfile(CmsUserContext userContext, String platformId, String profileId, int profileVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  TargetManager getTargetManager(CmsUserContext userContext, String platformId, String name, String profileId, String bannerId, String location ,String [] tokensExpr)  throws Exception;
	
	public  Platform addTarget(CmsUserContext userContext, String platformId, String name, String profileId, String bannerId, String location , String [] tokensExpr)  throws Exception;
	public  Platform removeTarget(CmsUserContext userContext, String platformId, String targetId, int targetVersion,String [] tokensExpr)  throws Exception;
	public  Platform updateTarget(CmsUserContext userContext, String platformId, String targetId, int targetVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  UserAlertManager getUserAlertManager(CmsUserContext userContext, String platformId, String message, String profileId, String location ,String [] tokensExpr)  throws Exception;
	
	public  Platform addUserAlert(CmsUserContext userContext, String platformId, String message, String profileId, String location , String [] tokensExpr)  throws Exception;
	public  Platform removeUserAlert(CmsUserContext userContext, String platformId, String userAlertId, int userAlertVersion,String [] tokensExpr)  throws Exception;
	public  Platform updateUserAlert(CmsUserContext userContext, String platformId, String userAlertId, int userAlertVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


