
package com.doublechaintech.cms.platform;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.cms.BaseEntity;
import com.doublechaintech.cms.SmartList;
import com.doublechaintech.cms.MultipleAccessKey;
import com.doublechaintech.cms.CmsUserContext;
import com.doublechaintech.cms.target.TargetDAO;
import com.doublechaintech.cms.alertbar.AlertBarDAO;
import com.doublechaintech.cms.banner.BannerDAO;
import com.doublechaintech.cms.useralert.UserAlertDAO;
import com.doublechaintech.cms.profile.ProfileDAO;


public interface PlatformDAO{

	
	public Platform load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<Platform> platformList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public Platform present(Platform platform,Map<String,Object> options) throws Exception;
	public Platform clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public Platform save(Platform platform,Map<String,Object> options);
	public SmartList<Platform> savePlatformList(SmartList<Platform> platformList,Map<String,Object> options);
	public SmartList<Platform> removePlatformList(SmartList<Platform> platformList,Map<String,Object> options);
	public SmartList<Platform> findPlatformWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countPlatformWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countPlatformWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String platformId, int version) throws Exception;
	public Platform disconnectFromAll(String platformId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public AlertBarDAO getAlertBarDAO();
		
	public BannerDAO getBannerDAO();
		
	public ProfileDAO getProfileDAO();
		
	public TargetDAO getTargetDAO();
		
	public UserAlertDAO getUserAlertDAO();
		
	
 	public SmartList<Platform> requestCandidatePlatformForAlertBar(CmsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Platform> requestCandidatePlatformForBanner(CmsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Platform> requestCandidatePlatformForProfile(CmsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Platform> requestCandidatePlatformForTarget(CmsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Platform> requestCandidatePlatformForUserAlert(CmsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public Platform planToRemoveAlertBarList(Platform platform, String alertBarIds[], Map<String,Object> options)throws Exception;


	public Platform planToRemoveBannerList(Platform platform, String bannerIds[], Map<String,Object> options)throws Exception;


	public Platform planToRemoveProfileList(Platform platform, String profileIds[], Map<String,Object> options)throws Exception;


	public Platform planToRemoveTargetList(Platform platform, String targetIds[], Map<String,Object> options)throws Exception;


	//disconnect Platform with profile in Target
	public Platform planToRemoveTargetListWithProfile(Platform platform, String profileId, Map<String,Object> options)throws Exception;
	public int countTargetListWithProfile(String platformId, String profileId, Map<String,Object> options)throws Exception;
	
	//disconnect Platform with banner in Target
	public Platform planToRemoveTargetListWithBanner(Platform platform, String bannerId, Map<String,Object> options)throws Exception;
	public int countTargetListWithBanner(String platformId, String bannerId, Map<String,Object> options)throws Exception;
	
	public Platform planToRemoveUserAlertList(Platform platform, String userAlertIds[], Map<String,Object> options)throws Exception;


	//disconnect Platform with profile in UserAlert
	public Platform planToRemoveUserAlertListWithProfile(Platform platform, String profileId, Map<String,Object> options)throws Exception;
	public int countUserAlertListWithProfile(String platformId, String profileId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<Platform> queryList(String sql, Object ... parmeters);
}


