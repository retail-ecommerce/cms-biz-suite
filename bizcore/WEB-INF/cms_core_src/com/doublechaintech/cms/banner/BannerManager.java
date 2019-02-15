
package com.doublechaintech.cms.banner;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.cms.CmsUserContext;
import com.doublechaintech.cms.BaseEntity;
import com.doublechaintech.cms.SmartList;

public interface BannerManager{

		

	public Banner createBanner(CmsUserContext userContext, String name, String imagePath, String platformId) throws Exception;	
	public Banner updateBanner(CmsUserContext userContext,String bannerId, int bannerVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Banner loadBanner(CmsUserContext userContext, String bannerId, String [] tokensExpr) throws Exception;
	public Banner internalSaveBanner(CmsUserContext userContext, Banner banner) throws Exception;
	public Banner internalSaveBanner(CmsUserContext userContext, Banner banner,Map<String,Object>option) throws Exception;
	
	public Banner transferToAnotherPlatform(CmsUserContext userContext, String bannerId, String anotherPlatformId)  throws Exception;
 

	public void delete(CmsUserContext userContext, String bannerId, int version) throws Exception;
	public int deleteAll(CmsUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(CmsUserContext userContext, Banner newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  TargetManager getTargetManager(CmsUserContext userContext, String bannerId, String name, String profileId, String location, String platformId ,String [] tokensExpr)  throws Exception;
	
	public  Banner addTarget(CmsUserContext userContext, String bannerId, String name, String profileId, String location, String platformId , String [] tokensExpr)  throws Exception;
	public  Banner removeTarget(CmsUserContext userContext, String bannerId, String targetId, int targetVersion,String [] tokensExpr)  throws Exception;
	public  Banner updateTarget(CmsUserContext userContext, String bannerId, String targetId, int targetVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


