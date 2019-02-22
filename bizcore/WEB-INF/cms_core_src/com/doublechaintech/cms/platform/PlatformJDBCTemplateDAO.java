
package com.doublechaintech.cms.platform;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;
import com.doublechaintech.cms.CmsNamingServiceDAO;
import com.doublechaintech.cms.BaseEntity;
import com.doublechaintech.cms.SmartList;
import com.doublechaintech.cms.AccessKey;
import com.doublechaintech.cms.DateKey;
import com.doublechaintech.cms.StatsInfo;
import com.doublechaintech.cms.StatsItem;

import com.doublechaintech.cms.MultipleAccessKey;
import com.doublechaintech.cms.CmsUserContext;


import com.doublechaintech.cms.target.Target;
import com.doublechaintech.cms.useralert.UserAlert;
import com.doublechaintech.cms.banner.Banner;
import com.doublechaintech.cms.profile.Profile;
import com.doublechaintech.cms.alertbar.AlertBar;

import com.doublechaintech.cms.target.TargetDAO;
import com.doublechaintech.cms.alertbar.AlertBarDAO;
import com.doublechaintech.cms.banner.BannerDAO;
import com.doublechaintech.cms.useralert.UserAlertDAO;
import com.doublechaintech.cms.profile.ProfileDAO;



import org.springframework.dao.EmptyResultDataAccessException;

public class PlatformJDBCTemplateDAO extends CmsNamingServiceDAO implements PlatformDAO{


			
		
	
  	private  AlertBarDAO  alertBarDAO;
 	public void setAlertBarDAO(AlertBarDAO pAlertBarDAO){
 	
 		if(pAlertBarDAO == null){
 			throw new IllegalStateException("Do not try to set alertBarDAO to null.");
 		}
	 	this.alertBarDAO = pAlertBarDAO;
 	}
 	public AlertBarDAO getAlertBarDAO(){
 		if(this.alertBarDAO == null){
 			throw new IllegalStateException("The alertBarDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.alertBarDAO;
 	}	
 	
			
		
	
  	private  BannerDAO  bannerDAO;
 	public void setBannerDAO(BannerDAO pBannerDAO){
 	
 		if(pBannerDAO == null){
 			throw new IllegalStateException("Do not try to set bannerDAO to null.");
 		}
	 	this.bannerDAO = pBannerDAO;
 	}
 	public BannerDAO getBannerDAO(){
 		if(this.bannerDAO == null){
 			throw new IllegalStateException("The bannerDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.bannerDAO;
 	}	
 	
			
		
	
  	private  ProfileDAO  profileDAO;
 	public void setProfileDAO(ProfileDAO pProfileDAO){
 	
 		if(pProfileDAO == null){
 			throw new IllegalStateException("Do not try to set profileDAO to null.");
 		}
	 	this.profileDAO = pProfileDAO;
 	}
 	public ProfileDAO getProfileDAO(){
 		if(this.profileDAO == null){
 			throw new IllegalStateException("The profileDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.profileDAO;
 	}	
 	
			
		
	
  	private  TargetDAO  targetDAO;
 	public void setTargetDAO(TargetDAO pTargetDAO){
 	
 		if(pTargetDAO == null){
 			throw new IllegalStateException("Do not try to set targetDAO to null.");
 		}
	 	this.targetDAO = pTargetDAO;
 	}
 	public TargetDAO getTargetDAO(){
 		if(this.targetDAO == null){
 			throw new IllegalStateException("The targetDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.targetDAO;
 	}	
 	
			
		
	
  	private  UserAlertDAO  userAlertDAO;
 	public void setUserAlertDAO(UserAlertDAO pUserAlertDAO){
 	
 		if(pUserAlertDAO == null){
 			throw new IllegalStateException("Do not try to set userAlertDAO to null.");
 		}
	 	this.userAlertDAO = pUserAlertDAO;
 	}
 	public UserAlertDAO getUserAlertDAO(){
 		if(this.userAlertDAO == null){
 			throw new IllegalStateException("The userAlertDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.userAlertDAO;
 	}	
 	
			
		

	
	/*
	protected Platform load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalPlatform(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public Platform load(String id,Map<String,Object> options) throws Exception{
		return loadInternalPlatform(PlatformTable.withId(id), options);
	}
	
	
	
	public Platform save(Platform platform,Map<String,Object> options){
		
		String methodName="save(Platform platform,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(platform, methodName, "platform");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalPlatform(platform,options);
	}
	public Platform clone(String platformId, Map<String,Object> options) throws Exception{
	
		return clone(PlatformTable.withId(platformId),options);
	}
	
	protected Platform clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String platformId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		Platform newPlatform = loadInternalPlatform(accessKey, options);
		newPlatform.setVersion(0);
		
		
 		
 		if(isSaveAlertBarListEnabled(options)){
 			for(AlertBar item: newPlatform.getAlertBarList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveBannerListEnabled(options)){
 			for(Banner item: newPlatform.getBannerList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveProfileListEnabled(options)){
 			for(Profile item: newPlatform.getProfileList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveTargetListEnabled(options)){
 			for(Target item: newPlatform.getTargetList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveUserAlertListEnabled(options)){
 			for(UserAlert item: newPlatform.getUserAlertList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalPlatform(newPlatform,options);
		
		return newPlatform;
	}
	
	
	
	

	protected void throwIfHasException(String platformId,int version,int count) throws Exception{
		if (count == 1) {
			throw new PlatformVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new PlatformNotFoundException(
					"The " + this.getTableName() + "(" + platformId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String platformId, int version) throws Exception{
	
		String methodName="delete(String platformId, int version)";
		assertMethodArgumentNotNull(platformId, methodName, "platformId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{platformId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(platformId,version);
		}
		
	
	}
	
	
	
	
	

	public Platform disconnectFromAll(String platformId, int version) throws Exception{
	
		
		Platform platform = loadInternalPlatform(PlatformTable.withId(platformId), emptyOptions());
		platform.clearFromAll();
		this.savePlatform(platform);
		return platform;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return PlatformTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "platform";
	}
	@Override
	protected String getBeanName() {
		
		return "platform";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return PlatformTokens.checkOptions(options, optionToCheck);
	
	}


		
	
	protected boolean isExtractAlertBarListEnabled(Map<String,Object> options){		
 		return checkOptions(options,PlatformTokens.ALERT_BAR_LIST);
 	}
 	protected boolean isAnalyzeAlertBarListEnabled(Map<String,Object> options){		
 		return true;
 		//return checkOptions(options,PlatformTokens.ALERT_BAR_LIST+".analyze");
 	}
	
	protected boolean isSaveAlertBarListEnabled(Map<String,Object> options){
		return checkOptions(options, PlatformTokens.ALERT_BAR_LIST);
		
 	}
 	
		
	
	protected boolean isExtractBannerListEnabled(Map<String,Object> options){		
 		return checkOptions(options,PlatformTokens.BANNER_LIST);
 	}
 	protected boolean isAnalyzeBannerListEnabled(Map<String,Object> options){		
 		return true;
 		//return checkOptions(options,PlatformTokens.BANNER_LIST+".analyze");
 	}
	
	protected boolean isSaveBannerListEnabled(Map<String,Object> options){
		return checkOptions(options, PlatformTokens.BANNER_LIST);
		
 	}
 	
		
	
	protected boolean isExtractProfileListEnabled(Map<String,Object> options){		
 		return checkOptions(options,PlatformTokens.PROFILE_LIST);
 	}
 	protected boolean isAnalyzeProfileListEnabled(Map<String,Object> options){		
 		return true;
 		//return checkOptions(options,PlatformTokens.PROFILE_LIST+".analyze");
 	}
	
	protected boolean isSaveProfileListEnabled(Map<String,Object> options){
		return checkOptions(options, PlatformTokens.PROFILE_LIST);
		
 	}
 	
		
	
	protected boolean isExtractTargetListEnabled(Map<String,Object> options){		
 		return checkOptions(options,PlatformTokens.TARGET_LIST);
 	}
 	protected boolean isAnalyzeTargetListEnabled(Map<String,Object> options){		
 		return true;
 		//return checkOptions(options,PlatformTokens.TARGET_LIST+".analyze");
 	}
	
	protected boolean isSaveTargetListEnabled(Map<String,Object> options){
		return checkOptions(options, PlatformTokens.TARGET_LIST);
		
 	}
 	
		
	
	protected boolean isExtractUserAlertListEnabled(Map<String,Object> options){		
 		return checkOptions(options,PlatformTokens.USER_ALERT_LIST);
 	}
 	protected boolean isAnalyzeUserAlertListEnabled(Map<String,Object> options){		
 		return true;
 		//return checkOptions(options,PlatformTokens.USER_ALERT_LIST+".analyze");
 	}
	
	protected boolean isSaveUserAlertListEnabled(Map<String,Object> options){
		return checkOptions(options, PlatformTokens.USER_ALERT_LIST);
		
 	}
 	
		

	

	protected PlatformMapper getPlatformMapper(){
		return new PlatformMapper();
	}

	
	
	protected Platform extractPlatform(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			Platform platform = loadSingleObject(accessKey, getPlatformMapper());
			return platform;
		}catch(EmptyResultDataAccessException e){
			throw new PlatformNotFoundException("Platform("+accessKey+") is not found!");
		}

	}

	
	

	protected Platform loadInternalPlatform(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		Platform platform = extractPlatform(accessKey, loadOptions);

		
		if(isExtractAlertBarListEnabled(loadOptions)){
	 		extractAlertBarList(platform, loadOptions);
 		}	
 		if(isAnalyzeAlertBarListEnabled(loadOptions)){
	 		analyzeAlertBarList(platform, loadOptions);
 		}
 		
		
		if(isExtractBannerListEnabled(loadOptions)){
	 		extractBannerList(platform, loadOptions);
 		}	
 		if(isAnalyzeBannerListEnabled(loadOptions)){
	 		analyzeBannerList(platform, loadOptions);
 		}
 		
		
		if(isExtractProfileListEnabled(loadOptions)){
	 		extractProfileList(platform, loadOptions);
 		}	
 		if(isAnalyzeProfileListEnabled(loadOptions)){
	 		analyzeProfileList(platform, loadOptions);
 		}
 		
		
		if(isExtractTargetListEnabled(loadOptions)){
	 		extractTargetList(platform, loadOptions);
 		}	
 		if(isAnalyzeTargetListEnabled(loadOptions)){
	 		analyzeTargetList(platform, loadOptions);
 		}
 		
		
		if(isExtractUserAlertListEnabled(loadOptions)){
	 		extractUserAlertList(platform, loadOptions);
 		}	
 		if(isAnalyzeUserAlertListEnabled(loadOptions)){
	 		analyzeUserAlertList(platform, loadOptions);
 		}
 		
		
		return platform;
		
	}

	
		
	protected void enhanceAlertBarList(SmartList<AlertBar> alertBarList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Platform extractAlertBarList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<AlertBar> alertBarList = getAlertBarDAO().findAlertBarByPlatform(platform.getId(),options);
		if(alertBarList != null){
			enhanceAlertBarList(alertBarList,options);
			platform.setAlertBarList(alertBarList);
		}
		
		return platform;
	
	}	
	
	protected Platform analyzeAlertBarList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<AlertBar> alertBarList = platform.getAlertBarList();
		if(alertBarList != null){
			getAlertBarDAO().analyzeAlertBarByPlatform(alertBarList, platform.getId(), options);
			
		}
		
		return platform;
	
	}	
	
		
	protected void enhanceBannerList(SmartList<Banner> bannerList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Platform extractBannerList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<Banner> bannerList = getBannerDAO().findBannerByPlatform(platform.getId(),options);
		if(bannerList != null){
			enhanceBannerList(bannerList,options);
			platform.setBannerList(bannerList);
		}
		
		return platform;
	
	}	
	
	protected Platform analyzeBannerList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<Banner> bannerList = platform.getBannerList();
		if(bannerList != null){
			getBannerDAO().analyzeBannerByPlatform(bannerList, platform.getId(), options);
			
		}
		
		return platform;
	
	}	
	
		
	protected void enhanceProfileList(SmartList<Profile> profileList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Platform extractProfileList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<Profile> profileList = getProfileDAO().findProfileByPlatform(platform.getId(),options);
		if(profileList != null){
			enhanceProfileList(profileList,options);
			platform.setProfileList(profileList);
		}
		
		return platform;
	
	}	
	
	protected Platform analyzeProfileList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<Profile> profileList = platform.getProfileList();
		if(profileList != null){
			getProfileDAO().analyzeProfileByPlatform(profileList, platform.getId(), options);
			
		}
		
		return platform;
	
	}	
	
		
	protected void enhanceTargetList(SmartList<Target> targetList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Platform extractTargetList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<Target> targetList = getTargetDAO().findTargetByPlatform(platform.getId(),options);
		if(targetList != null){
			enhanceTargetList(targetList,options);
			platform.setTargetList(targetList);
		}
		
		return platform;
	
	}	
	
	protected Platform analyzeTargetList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<Target> targetList = platform.getTargetList();
		if(targetList != null){
			getTargetDAO().analyzeTargetByPlatform(targetList, platform.getId(), options);
			
		}
		
		return platform;
	
	}	
	
		
	protected void enhanceUserAlertList(SmartList<UserAlert> userAlertList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Platform extractUserAlertList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<UserAlert> userAlertList = getUserAlertDAO().findUserAlertByPlatform(platform.getId(),options);
		if(userAlertList != null){
			enhanceUserAlertList(userAlertList,options);
			platform.setUserAlertList(userAlertList);
		}
		
		return platform;
	
	}	
	
	protected Platform analyzeUserAlertList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<UserAlert> userAlertList = platform.getUserAlertList();
		if(userAlertList != null){
			getUserAlertDAO().analyzeUserAlertByPlatform(userAlertList, platform.getId(), options);
			
		}
		
		return platform;
	
	}	
	
		
		
 	
		
		
		

	

	protected Platform savePlatform(Platform  platform){
		
		if(!platform.isChanged()){
			return platform;
		}
		
		
		String SQL=this.getSavePlatformSQL(platform);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSavePlatformParameters(platform);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		platform.incVersion();
		return platform;
	
	}
	public SmartList<Platform> savePlatformList(SmartList<Platform> platformList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitPlatformList(platformList);
		
		batchPlatformCreate((List<Platform>)lists[CREATE_LIST_INDEX]);
		
		batchPlatformUpdate((List<Platform>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(Platform platform:platformList){
			if(platform.isChanged()){
				platform.incVersion();
			}
			
		
		}
		
		
		return platformList;
	}

	public SmartList<Platform> removePlatformList(SmartList<Platform> platformList,Map<String,Object> options){
		
		
		super.removeList(platformList, options);
		
		return platformList;
		
		
	}
	
	protected List<Object[]> preparePlatformBatchCreateArgs(List<Platform> platformList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Platform platform:platformList ){
			Object [] parameters = preparePlatformCreateParameters(platform);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> preparePlatformBatchUpdateArgs(List<Platform> platformList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Platform platform:platformList ){
			if(!platform.isChanged()){
				continue;
			}
			Object [] parameters = preparePlatformUpdateParameters(platform);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchPlatformCreate(List<Platform> platformList){
		String SQL=getCreateSQL();
		List<Object[]> args=preparePlatformBatchCreateArgs(platformList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchPlatformUpdate(List<Platform> platformList){
		String SQL=getUpdateSQL();
		List<Object[]> args=preparePlatformBatchUpdateArgs(platformList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitPlatformList(List<Platform> platformList){
		
		List<Platform> platformCreateList=new ArrayList<Platform>();
		List<Platform> platformUpdateList=new ArrayList<Platform>();
		
		for(Platform platform: platformList){
			if(isUpdateRequest(platform)){
				platformUpdateList.add( platform);
				continue;
			}
			platformCreateList.add(platform);
		}
		
		return new Object[]{platformCreateList,platformUpdateList};
	}
	
	protected boolean isUpdateRequest(Platform platform){
 		return platform.getVersion() > 0;
 	}
 	protected String getSavePlatformSQL(Platform platform){
 		if(isUpdateRequest(platform)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSavePlatformParameters(Platform platform){
 		if(isUpdateRequest(platform) ){
 			return preparePlatformUpdateParameters(platform);
 		}
 		return preparePlatformCreateParameters(platform);
 	}
 	protected Object[] preparePlatformUpdateParameters(Platform platform){
 		Object[] parameters = new Object[6];
 
 		parameters[0] = platform.getName();
 		parameters[1] = platform.getIntroduction();
 		parameters[2] = platform.getCurrentVersion();		
 		parameters[3] = platform.nextVersion();
 		parameters[4] = platform.getId();
 		parameters[5] = platform.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] preparePlatformCreateParameters(Platform platform){
		Object[] parameters = new Object[4];
		String newPlatformId=getNextId();
		platform.setId(newPlatformId);
		parameters[0] =  platform.getId();
 
 		parameters[1] = platform.getName();
 		parameters[2] = platform.getIntroduction();
 		parameters[3] = platform.getCurrentVersion();		
 				
 		return parameters;
 	}
 	
	protected Platform saveInternalPlatform(Platform platform, Map<String,Object> options){
		
		savePlatform(platform);

		
		if(isSaveAlertBarListEnabled(options)){
	 		saveAlertBarList(platform, options);
	 		//removeAlertBarList(platform, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveBannerListEnabled(options)){
	 		saveBannerList(platform, options);
	 		//removeBannerList(platform, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveProfileListEnabled(options)){
	 		saveProfileList(platform, options);
	 		//removeProfileList(platform, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveTargetListEnabled(options)){
	 		saveTargetList(platform, options);
	 		//removeTargetList(platform, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveUserAlertListEnabled(options)){
	 		saveUserAlertList(platform, options);
	 		//removeUserAlertList(platform, options);
	 		//Not delete the record
	 		
 		}		
		
		return platform;
		
	}
	
	
	
	//======================================================================================
	

	
	public Platform planToRemoveAlertBarList(Platform platform, String alertBarIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(AlertBar.PLATFORM_PROPERTY, platform.getId());
		key.put(AlertBar.ID_PROPERTY, alertBarIds);
		
		SmartList<AlertBar> externalAlertBarList = getAlertBarDAO().
				findAlertBarWithKey(key, options);
		if(externalAlertBarList == null){
			return platform;
		}
		if(externalAlertBarList.isEmpty()){
			return platform;
		}
		
		for(AlertBar alertBar: externalAlertBarList){

			alertBar.clearFromAll();
		}
		
		
		SmartList<AlertBar> alertBarList = platform.getAlertBarList();		
		alertBarList.addAllToRemoveList(externalAlertBarList);
		return platform;	
	
	}


	public Platform planToRemoveBannerList(Platform platform, String bannerIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Banner.PLATFORM_PROPERTY, platform.getId());
		key.put(Banner.ID_PROPERTY, bannerIds);
		
		SmartList<Banner> externalBannerList = getBannerDAO().
				findBannerWithKey(key, options);
		if(externalBannerList == null){
			return platform;
		}
		if(externalBannerList.isEmpty()){
			return platform;
		}
		
		for(Banner banner: externalBannerList){

			banner.clearFromAll();
		}
		
		
		SmartList<Banner> bannerList = platform.getBannerList();		
		bannerList.addAllToRemoveList(externalBannerList);
		return platform;	
	
	}


	public Platform planToRemoveProfileList(Platform platform, String profileIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Profile.PLATFORM_PROPERTY, platform.getId());
		key.put(Profile.ID_PROPERTY, profileIds);
		
		SmartList<Profile> externalProfileList = getProfileDAO().
				findProfileWithKey(key, options);
		if(externalProfileList == null){
			return platform;
		}
		if(externalProfileList.isEmpty()){
			return platform;
		}
		
		for(Profile profile: externalProfileList){

			profile.clearFromAll();
		}
		
		
		SmartList<Profile> profileList = platform.getProfileList();		
		profileList.addAllToRemoveList(externalProfileList);
		return platform;	
	
	}


	public Platform planToRemoveTargetList(Platform platform, String targetIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Target.PLATFORM_PROPERTY, platform.getId());
		key.put(Target.ID_PROPERTY, targetIds);
		
		SmartList<Target> externalTargetList = getTargetDAO().
				findTargetWithKey(key, options);
		if(externalTargetList == null){
			return platform;
		}
		if(externalTargetList.isEmpty()){
			return platform;
		}
		
		for(Target target: externalTargetList){

			target.clearFromAll();
		}
		
		
		SmartList<Target> targetList = platform.getTargetList();		
		targetList.addAllToRemoveList(externalTargetList);
		return platform;	
	
	}


	//disconnect Platform with profile in Target
	public Platform planToRemoveTargetListWithProfile(Platform platform, String profileId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Target.PLATFORM_PROPERTY, platform.getId());
		key.put(Target.PROFILE_PROPERTY, profileId);
		
		SmartList<Target> externalTargetList = getTargetDAO().
				findTargetWithKey(key, options);
		if(externalTargetList == null){
			return platform;
		}
		if(externalTargetList.isEmpty()){
			return platform;
		}
		
		for(Target target: externalTargetList){
			target.clearProfile();
			target.clearPlatform();
			
		}
		
		
		SmartList<Target> targetList = platform.getTargetList();		
		targetList.addAllToRemoveList(externalTargetList);
		return platform;
	}
	
	public int countTargetListWithProfile(String platformId, String profileId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Target.PLATFORM_PROPERTY, platformId);
		key.put(Target.PROFILE_PROPERTY, profileId);
		
		int count = getTargetDAO().countTargetWithKey(key, options);
		return count;
	}
	
	//disconnect Platform with banner in Target
	public Platform planToRemoveTargetListWithBanner(Platform platform, String bannerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Target.PLATFORM_PROPERTY, platform.getId());
		key.put(Target.BANNER_PROPERTY, bannerId);
		
		SmartList<Target> externalTargetList = getTargetDAO().
				findTargetWithKey(key, options);
		if(externalTargetList == null){
			return platform;
		}
		if(externalTargetList.isEmpty()){
			return platform;
		}
		
		for(Target target: externalTargetList){
			target.clearBanner();
			target.clearPlatform();
			
		}
		
		
		SmartList<Target> targetList = platform.getTargetList();		
		targetList.addAllToRemoveList(externalTargetList);
		return platform;
	}
	
	public int countTargetListWithBanner(String platformId, String bannerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Target.PLATFORM_PROPERTY, platformId);
		key.put(Target.BANNER_PROPERTY, bannerId);
		
		int count = getTargetDAO().countTargetWithKey(key, options);
		return count;
	}
	
	public Platform planToRemoveUserAlertList(Platform platform, String userAlertIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(UserAlert.PLATFORM_PROPERTY, platform.getId());
		key.put(UserAlert.ID_PROPERTY, userAlertIds);
		
		SmartList<UserAlert> externalUserAlertList = getUserAlertDAO().
				findUserAlertWithKey(key, options);
		if(externalUserAlertList == null){
			return platform;
		}
		if(externalUserAlertList.isEmpty()){
			return platform;
		}
		
		for(UserAlert userAlert: externalUserAlertList){

			userAlert.clearFromAll();
		}
		
		
		SmartList<UserAlert> userAlertList = platform.getUserAlertList();		
		userAlertList.addAllToRemoveList(externalUserAlertList);
		return platform;	
	
	}


	//disconnect Platform with profile in UserAlert
	public Platform planToRemoveUserAlertListWithProfile(Platform platform, String profileId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(UserAlert.PLATFORM_PROPERTY, platform.getId());
		key.put(UserAlert.PROFILE_PROPERTY, profileId);
		
		SmartList<UserAlert> externalUserAlertList = getUserAlertDAO().
				findUserAlertWithKey(key, options);
		if(externalUserAlertList == null){
			return platform;
		}
		if(externalUserAlertList.isEmpty()){
			return platform;
		}
		
		for(UserAlert userAlert: externalUserAlertList){
			userAlert.clearProfile();
			userAlert.clearPlatform();
			
		}
		
		
		SmartList<UserAlert> userAlertList = platform.getUserAlertList();		
		userAlertList.addAllToRemoveList(externalUserAlertList);
		return platform;
	}
	
	public int countUserAlertListWithProfile(String platformId, String profileId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(UserAlert.PLATFORM_PROPERTY, platformId);
		key.put(UserAlert.PROFILE_PROPERTY, profileId);
		
		int count = getUserAlertDAO().countUserAlertWithKey(key, options);
		return count;
	}
	

		
	protected Platform saveAlertBarList(Platform platform, Map<String,Object> options){
		
		
		
		
		SmartList<AlertBar> alertBarList = platform.getAlertBarList();
		if(alertBarList == null){
			//null list means nothing
			return platform;
		}
		SmartList<AlertBar> mergedUpdateAlertBarList = new SmartList<AlertBar>();
		
		
		mergedUpdateAlertBarList.addAll(alertBarList); 
		if(alertBarList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateAlertBarList.addAll(alertBarList.getToRemoveList());
			alertBarList.removeAll(alertBarList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getAlertBarDAO().saveAlertBarList(mergedUpdateAlertBarList,options);
		
		if(alertBarList.getToRemoveList() != null){
			alertBarList.removeAll(alertBarList.getToRemoveList());
		}
		
		
		return platform;
	
	}
	
	protected Platform removeAlertBarList(Platform platform, Map<String,Object> options){
	
	
		SmartList<AlertBar> alertBarList = platform.getAlertBarList();
		if(alertBarList == null){
			return platform;
		}	
	
		SmartList<AlertBar> toRemoveAlertBarList = alertBarList.getToRemoveList();
		
		if(toRemoveAlertBarList == null){
			return platform;
		}
		if(toRemoveAlertBarList.isEmpty()){
			return platform;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getAlertBarDAO().removeAlertBarList(toRemoveAlertBarList,options);
		
		return platform;
	
	}
	
	

 	
 	
	
	
	
		
	protected Platform saveBannerList(Platform platform, Map<String,Object> options){
		
		
		
		
		SmartList<Banner> bannerList = platform.getBannerList();
		if(bannerList == null){
			//null list means nothing
			return platform;
		}
		SmartList<Banner> mergedUpdateBannerList = new SmartList<Banner>();
		
		
		mergedUpdateBannerList.addAll(bannerList); 
		if(bannerList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateBannerList.addAll(bannerList.getToRemoveList());
			bannerList.removeAll(bannerList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getBannerDAO().saveBannerList(mergedUpdateBannerList,options);
		
		if(bannerList.getToRemoveList() != null){
			bannerList.removeAll(bannerList.getToRemoveList());
		}
		
		
		return platform;
	
	}
	
	protected Platform removeBannerList(Platform platform, Map<String,Object> options){
	
	
		SmartList<Banner> bannerList = platform.getBannerList();
		if(bannerList == null){
			return platform;
		}	
	
		SmartList<Banner> toRemoveBannerList = bannerList.getToRemoveList();
		
		if(toRemoveBannerList == null){
			return platform;
		}
		if(toRemoveBannerList.isEmpty()){
			return platform;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getBannerDAO().removeBannerList(toRemoveBannerList,options);
		
		return platform;
	
	}
	
	

 	
 	
	
	
	
		
	protected Platform saveProfileList(Platform platform, Map<String,Object> options){
		
		
		
		
		SmartList<Profile> profileList = platform.getProfileList();
		if(profileList == null){
			//null list means nothing
			return platform;
		}
		SmartList<Profile> mergedUpdateProfileList = new SmartList<Profile>();
		
		
		mergedUpdateProfileList.addAll(profileList); 
		if(profileList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateProfileList.addAll(profileList.getToRemoveList());
			profileList.removeAll(profileList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getProfileDAO().saveProfileList(mergedUpdateProfileList,options);
		
		if(profileList.getToRemoveList() != null){
			profileList.removeAll(profileList.getToRemoveList());
		}
		
		
		return platform;
	
	}
	
	protected Platform removeProfileList(Platform platform, Map<String,Object> options){
	
	
		SmartList<Profile> profileList = platform.getProfileList();
		if(profileList == null){
			return platform;
		}	
	
		SmartList<Profile> toRemoveProfileList = profileList.getToRemoveList();
		
		if(toRemoveProfileList == null){
			return platform;
		}
		if(toRemoveProfileList.isEmpty()){
			return platform;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getProfileDAO().removeProfileList(toRemoveProfileList,options);
		
		return platform;
	
	}
	
	

 	
 	
	
	
	
		
	protected Platform saveTargetList(Platform platform, Map<String,Object> options){
		
		
		
		
		SmartList<Target> targetList = platform.getTargetList();
		if(targetList == null){
			//null list means nothing
			return platform;
		}
		SmartList<Target> mergedUpdateTargetList = new SmartList<Target>();
		
		
		mergedUpdateTargetList.addAll(targetList); 
		if(targetList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateTargetList.addAll(targetList.getToRemoveList());
			targetList.removeAll(targetList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getTargetDAO().saveTargetList(mergedUpdateTargetList,options);
		
		if(targetList.getToRemoveList() != null){
			targetList.removeAll(targetList.getToRemoveList());
		}
		
		
		return platform;
	
	}
	
	protected Platform removeTargetList(Platform platform, Map<String,Object> options){
	
	
		SmartList<Target> targetList = platform.getTargetList();
		if(targetList == null){
			return platform;
		}	
	
		SmartList<Target> toRemoveTargetList = targetList.getToRemoveList();
		
		if(toRemoveTargetList == null){
			return platform;
		}
		if(toRemoveTargetList.isEmpty()){
			return platform;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getTargetDAO().removeTargetList(toRemoveTargetList,options);
		
		return platform;
	
	}
	
	

 	
 	
	
	
	
		
	protected Platform saveUserAlertList(Platform platform, Map<String,Object> options){
		
		
		
		
		SmartList<UserAlert> userAlertList = platform.getUserAlertList();
		if(userAlertList == null){
			//null list means nothing
			return platform;
		}
		SmartList<UserAlert> mergedUpdateUserAlertList = new SmartList<UserAlert>();
		
		
		mergedUpdateUserAlertList.addAll(userAlertList); 
		if(userAlertList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateUserAlertList.addAll(userAlertList.getToRemoveList());
			userAlertList.removeAll(userAlertList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getUserAlertDAO().saveUserAlertList(mergedUpdateUserAlertList,options);
		
		if(userAlertList.getToRemoveList() != null){
			userAlertList.removeAll(userAlertList.getToRemoveList());
		}
		
		
		return platform;
	
	}
	
	protected Platform removeUserAlertList(Platform platform, Map<String,Object> options){
	
	
		SmartList<UserAlert> userAlertList = platform.getUserAlertList();
		if(userAlertList == null){
			return platform;
		}	
	
		SmartList<UserAlert> toRemoveUserAlertList = userAlertList.getToRemoveList();
		
		if(toRemoveUserAlertList == null){
			return platform;
		}
		if(toRemoveUserAlertList.isEmpty()){
			return platform;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getUserAlertDAO().removeUserAlertList(toRemoveUserAlertList,options);
		
		return platform;
	
	}
	
	

 	
 	
	
	
	
		

	public Platform present(Platform platform,Map<String, Object> options){
	
		presentAlertBarList(platform,options);
		presentBannerList(platform,options);
		presentProfileList(platform,options);
		presentTargetList(platform,options);
		presentUserAlertList(platform,options);

		return platform;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected Platform presentAlertBarList(
			Platform platform,
			Map<String, Object> options) {

		SmartList<AlertBar> alertBarList = platform.getAlertBarList();		
				SmartList<AlertBar> newList= presentSubList(platform.getId(),
				alertBarList,
				options,
				getAlertBarDAO()::countAlertBarByPlatform,
				getAlertBarDAO()::findAlertBarByPlatform
				);

		
		platform.setAlertBarList(newList);
		

		return platform;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected Platform presentBannerList(
			Platform platform,
			Map<String, Object> options) {

		SmartList<Banner> bannerList = platform.getBannerList();		
				SmartList<Banner> newList= presentSubList(platform.getId(),
				bannerList,
				options,
				getBannerDAO()::countBannerByPlatform,
				getBannerDAO()::findBannerByPlatform
				);

		
		platform.setBannerList(newList);
		

		return platform;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected Platform presentProfileList(
			Platform platform,
			Map<String, Object> options) {

		SmartList<Profile> profileList = platform.getProfileList();		
				SmartList<Profile> newList= presentSubList(platform.getId(),
				profileList,
				options,
				getProfileDAO()::countProfileByPlatform,
				getProfileDAO()::findProfileByPlatform
				);

		
		platform.setProfileList(newList);
		

		return platform;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected Platform presentTargetList(
			Platform platform,
			Map<String, Object> options) {

		SmartList<Target> targetList = platform.getTargetList();		
				SmartList<Target> newList= presentSubList(platform.getId(),
				targetList,
				options,
				getTargetDAO()::countTargetByPlatform,
				getTargetDAO()::findTargetByPlatform
				);

		
		platform.setTargetList(newList);
		

		return platform;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected Platform presentUserAlertList(
			Platform platform,
			Map<String, Object> options) {

		SmartList<UserAlert> userAlertList = platform.getUserAlertList();		
				SmartList<UserAlert> newList= presentSubList(platform.getId(),
				userAlertList,
				options,
				getUserAlertDAO()::countUserAlertByPlatform,
				getUserAlertDAO()::findUserAlertByPlatform
				);

		
		platform.setUserAlertList(newList);
		

		return platform;
	}			
		

	
    public SmartList<Platform> requestCandidatePlatformForAlertBar(CmsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(PlatformTable.COLUMN_NAME, filterKey, pageNo, pageSize, getPlatformMapper());
    }
		
    public SmartList<Platform> requestCandidatePlatformForBanner(CmsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(PlatformTable.COLUMN_NAME, filterKey, pageNo, pageSize, getPlatformMapper());
    }
		
    public SmartList<Platform> requestCandidatePlatformForProfile(CmsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(PlatformTable.COLUMN_NAME, filterKey, pageNo, pageSize, getPlatformMapper());
    }
		
    public SmartList<Platform> requestCandidatePlatformForTarget(CmsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(PlatformTable.COLUMN_NAME, filterKey, pageNo, pageSize, getPlatformMapper());
    }
		
    public SmartList<Platform> requestCandidatePlatformForUserAlert(CmsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(PlatformTable.COLUMN_NAME, filterKey, pageNo, pageSize, getPlatformMapper());
    }
		

	protected String getTableName(){
		return PlatformTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<Platform> platformList) {		
		this.enhanceListInternal(platformList, this.getPlatformMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<Platform> platformList = ownerEntity.collectRefsWithType(Platform.INTERNAL_TYPE);
		this.enhanceList(platformList);
		
	}
	
	@Override
	public SmartList<Platform> findPlatformWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getPlatformMapper());

	}
	@Override
	public int countPlatformWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countPlatformWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<Platform> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getPlatformMapper());
	}
}


