
package com.doublechaintech.cms.target;

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


import com.doublechaintech.cms.platform.Platform;
import com.doublechaintech.cms.profile.Profile;
import com.doublechaintech.cms.banner.Banner;

import com.doublechaintech.cms.banner.BannerDAO;
import com.doublechaintech.cms.platform.PlatformDAO;
import com.doublechaintech.cms.profile.ProfileDAO;



import org.springframework.dao.EmptyResultDataAccessException;

public class TargetJDBCTemplateDAO extends CmsNamingServiceDAO implements TargetDAO{
 
 	
 	private  ProfileDAO  profileDAO;
 	public void setProfileDAO(ProfileDAO profileDAO){
	 	this.profileDAO = profileDAO;
 	}
 	public ProfileDAO getProfileDAO(){
	 	return this.profileDAO;
 	}
 
 	
 	private  BannerDAO  bannerDAO;
 	public void setBannerDAO(BannerDAO bannerDAO){
	 	this.bannerDAO = bannerDAO;
 	}
 	public BannerDAO getBannerDAO(){
	 	return this.bannerDAO;
 	}
 
 	
 	private  PlatformDAO  platformDAO;
 	public void setPlatformDAO(PlatformDAO platformDAO){
	 	this.platformDAO = platformDAO;
 	}
 	public PlatformDAO getPlatformDAO(){
	 	return this.platformDAO;
 	}


			
		

	
	/*
	protected Target load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalTarget(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public Target load(String id,Map<String,Object> options) throws Exception{
		return loadInternalTarget(TargetTable.withId(id), options);
	}
	
	
	
	public Target save(Target target,Map<String,Object> options){
		
		String methodName="save(Target target,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(target, methodName, "target");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalTarget(target,options);
	}
	public Target clone(String targetId, Map<String,Object> options) throws Exception{
	
		return clone(TargetTable.withId(targetId),options);
	}
	
	protected Target clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String targetId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		Target newTarget = loadInternalTarget(accessKey, options);
		newTarget.setVersion(0);
		
		

		
		saveInternalTarget(newTarget,options);
		
		return newTarget;
	}
	
	
	
	

	protected void throwIfHasException(String targetId,int version,int count) throws Exception{
		if (count == 1) {
			throw new TargetVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new TargetNotFoundException(
					"The " + this.getTableName() + "(" + targetId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String targetId, int version) throws Exception{
	
		String methodName="delete(String targetId, int version)";
		assertMethodArgumentNotNull(targetId, methodName, "targetId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{targetId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(targetId,version);
		}
		
	
	}
	
	
	
	
	

	public Target disconnectFromAll(String targetId, int version) throws Exception{
	
		
		Target target = loadInternalTarget(TargetTable.withId(targetId), emptyOptions());
		target.clearFromAll();
		this.saveTarget(target);
		return target;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return TargetTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "target";
	}
	@Override
	protected String getBeanName() {
		
		return "target";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return TargetTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractProfileEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, TargetTokens.PROFILE);
 	}

 	protected boolean isSaveProfileEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, TargetTokens.PROFILE);
 	}
 	

 	
  

 	protected boolean isExtractBannerEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, TargetTokens.BANNER);
 	}

 	protected boolean isSaveBannerEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, TargetTokens.BANNER);
 	}
 	

 	
  

 	protected boolean isExtractPlatformEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, TargetTokens.PLATFORM);
 	}

 	protected boolean isSavePlatformEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, TargetTokens.PLATFORM);
 	}
 	

 	
 
		

	

	protected TargetMapper getTargetMapper(){
		return new TargetMapper();
	}

	
	
	protected Target extractTarget(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			Target target = loadSingleObject(accessKey, getTargetMapper());
			return target;
		}catch(EmptyResultDataAccessException e){
			throw new TargetNotFoundException("Target("+accessKey+") is not found!");
		}

	}

	
	

	protected Target loadInternalTarget(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		Target target = extractTarget(accessKey, loadOptions);
 	
 		if(isExtractProfileEnabled(loadOptions)){
	 		extractProfile(target, loadOptions);
 		}
  	
 		if(isExtractBannerEnabled(loadOptions)){
	 		extractBanner(target, loadOptions);
 		}
  	
 		if(isExtractPlatformEnabled(loadOptions)){
	 		extractPlatform(target, loadOptions);
 		}
 
		
		return target;
		
	}

	 

 	protected Target extractProfile(Target target, Map<String,Object> options) throws Exception{

		if(target.getProfile() == null){
			return target;
		}
		String profileId = target.getProfile().getId();
		if( profileId == null){
			return target;
		}
		Profile profile = getProfileDAO().load(profileId,options);
		if(profile != null){
			target.setProfile(profile);
		}
		
 		
 		return target;
 	}
 		
  

 	protected Target extractBanner(Target target, Map<String,Object> options) throws Exception{

		if(target.getBanner() == null){
			return target;
		}
		String bannerId = target.getBanner().getId();
		if( bannerId == null){
			return target;
		}
		Banner banner = getBannerDAO().load(bannerId,options);
		if(banner != null){
			target.setBanner(banner);
		}
		
 		
 		return target;
 	}
 		
  

 	protected Target extractPlatform(Target target, Map<String,Object> options) throws Exception{

		if(target.getPlatform() == null){
			return target;
		}
		String platformId = target.getPlatform().getId();
		if( platformId == null){
			return target;
		}
		Platform platform = getPlatformDAO().load(platformId,options);
		if(platform != null){
			target.setPlatform(platform);
		}
		
 		
 		return target;
 	}
 		
 
		
		
  	
 	public SmartList<Target> findTargetByProfile(String profileId,Map<String,Object> options){
 	
  		SmartList<Target> resultList = queryWith(TargetTable.COLUMN_PROFILE, profileId, options, getTargetMapper());
		// analyzeTargetByProfile(resultList, profileId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<Target> findTargetByProfile(String profileId, int start, int count,Map<String,Object> options){
 		
 		SmartList<Target> resultList =  queryWithRange(TargetTable.COLUMN_PROFILE, profileId, options, getTargetMapper(), start, count);
 		//analyzeTargetByProfile(resultList, profileId, options);
 		return resultList;
 		
 	}
 	public void analyzeTargetByProfile(SmartList<Target> resultList, String profileId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(Target.PROFILE_PROPERTY, profileId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem lastUpdateStatsItem = new StatsItem();
		//Target.LAST_UPDATE_PROPERTY
		lastUpdateStatsItem.setDisplayName("Target");
		lastUpdateStatsItem.setInternalName(formatKeyForDateLine(Target.LAST_UPDATE_PROPERTY));
		lastUpdateStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(Target.LAST_UPDATE_PROPERTY),filterKey,emptyOptions));
		info.addItem(lastUpdateStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countTargetByProfile(String profileId,Map<String,Object> options){

 		return countWith(TargetTable.COLUMN_PROFILE, profileId, options);
 	}
 	@Override
	public Map<String, Integer> countTargetByProfileIds(String[] ids, Map<String, Object> options) {
		return countWithIds(TargetTable.COLUMN_PROFILE, ids, options);
	}
 	
  	
 	public SmartList<Target> findTargetByBanner(String bannerId,Map<String,Object> options){
 	
  		SmartList<Target> resultList = queryWith(TargetTable.COLUMN_BANNER, bannerId, options, getTargetMapper());
		// analyzeTargetByBanner(resultList, bannerId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<Target> findTargetByBanner(String bannerId, int start, int count,Map<String,Object> options){
 		
 		SmartList<Target> resultList =  queryWithRange(TargetTable.COLUMN_BANNER, bannerId, options, getTargetMapper(), start, count);
 		//analyzeTargetByBanner(resultList, bannerId, options);
 		return resultList;
 		
 	}
 	public void analyzeTargetByBanner(SmartList<Target> resultList, String bannerId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(Target.BANNER_PROPERTY, bannerId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem lastUpdateStatsItem = new StatsItem();
		//Target.LAST_UPDATE_PROPERTY
		lastUpdateStatsItem.setDisplayName("Target");
		lastUpdateStatsItem.setInternalName(formatKeyForDateLine(Target.LAST_UPDATE_PROPERTY));
		lastUpdateStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(Target.LAST_UPDATE_PROPERTY),filterKey,emptyOptions));
		info.addItem(lastUpdateStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countTargetByBanner(String bannerId,Map<String,Object> options){

 		return countWith(TargetTable.COLUMN_BANNER, bannerId, options);
 	}
 	@Override
	public Map<String, Integer> countTargetByBannerIds(String[] ids, Map<String, Object> options) {
		return countWithIds(TargetTable.COLUMN_BANNER, ids, options);
	}
 	
  	
 	public SmartList<Target> findTargetByPlatform(String platformId,Map<String,Object> options){
 	
  		SmartList<Target> resultList = queryWith(TargetTable.COLUMN_PLATFORM, platformId, options, getTargetMapper());
		// analyzeTargetByPlatform(resultList, platformId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<Target> findTargetByPlatform(String platformId, int start, int count,Map<String,Object> options){
 		
 		SmartList<Target> resultList =  queryWithRange(TargetTable.COLUMN_PLATFORM, platformId, options, getTargetMapper(), start, count);
 		//analyzeTargetByPlatform(resultList, platformId, options);
 		return resultList;
 		
 	}
 	public void analyzeTargetByPlatform(SmartList<Target> resultList, String platformId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(Target.PLATFORM_PROPERTY, platformId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem lastUpdateStatsItem = new StatsItem();
		//Target.LAST_UPDATE_PROPERTY
		lastUpdateStatsItem.setDisplayName("Target");
		lastUpdateStatsItem.setInternalName(formatKeyForDateLine(Target.LAST_UPDATE_PROPERTY));
		lastUpdateStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(Target.LAST_UPDATE_PROPERTY),filterKey,emptyOptions));
		info.addItem(lastUpdateStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countTargetByPlatform(String platformId,Map<String,Object> options){

 		return countWith(TargetTable.COLUMN_PLATFORM, platformId, options);
 	}
 	@Override
	public Map<String, Integer> countTargetByPlatformIds(String[] ids, Map<String, Object> options) {
		return countWithIds(TargetTable.COLUMN_PLATFORM, ids, options);
	}
 	
 	
		
		
		

	

	protected Target saveTarget(Target  target){
		
		if(!target.isChanged()){
			return target;
		}
		
		
		String SQL=this.getSaveTargetSQL(target);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveTargetParameters(target);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		target.incVersion();
		return target;
	
	}
	public SmartList<Target> saveTargetList(SmartList<Target> targetList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitTargetList(targetList);
		
		batchTargetCreate((List<Target>)lists[CREATE_LIST_INDEX]);
		
		batchTargetUpdate((List<Target>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(Target target:targetList){
			if(target.isChanged()){
				target.incVersion();
			}
			
		
		}
		
		
		return targetList;
	}

	public SmartList<Target> removeTargetList(SmartList<Target> targetList,Map<String,Object> options){
		
		
		super.removeList(targetList, options);
		
		return targetList;
		
		
	}
	
	protected List<Object[]> prepareTargetBatchCreateArgs(List<Target> targetList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Target target:targetList ){
			Object [] parameters = prepareTargetCreateParameters(target);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareTargetBatchUpdateArgs(List<Target> targetList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Target target:targetList ){
			if(!target.isChanged()){
				continue;
			}
			Object [] parameters = prepareTargetUpdateParameters(target);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchTargetCreate(List<Target> targetList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareTargetBatchCreateArgs(targetList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchTargetUpdate(List<Target> targetList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareTargetBatchUpdateArgs(targetList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitTargetList(List<Target> targetList){
		
		List<Target> targetCreateList=new ArrayList<Target>();
		List<Target> targetUpdateList=new ArrayList<Target>();
		
		for(Target target: targetList){
			if(isUpdateRequest(target)){
				targetUpdateList.add( target);
				continue;
			}
			targetCreateList.add(target);
		}
		
		return new Object[]{targetCreateList,targetUpdateList};
	}
	
	protected boolean isUpdateRequest(Target target){
 		return target.getVersion() > 0;
 	}
 	protected String getSaveTargetSQL(Target target){
 		if(isUpdateRequest(target)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveTargetParameters(Target target){
 		if(isUpdateRequest(target) ){
 			return prepareTargetUpdateParameters(target);
 		}
 		return prepareTargetCreateParameters(target);
 	}
 	protected Object[] prepareTargetUpdateParameters(Target target){
 		Object[] parameters = new Object[9];
 
 		parameters[0] = target.getName(); 	
 		if(target.getProfile() != null){
 			parameters[1] = target.getProfile().getId();
 		}
  	
 		if(target.getBanner() != null){
 			parameters[2] = target.getBanner().getId();
 		}
 
 		parameters[3] = target.getLocation();
 		parameters[4] = target.getLastUpdate(); 	
 		if(target.getPlatform() != null){
 			parameters[5] = target.getPlatform().getId();
 		}
 		
 		parameters[6] = target.nextVersion();
 		parameters[7] = target.getId();
 		parameters[8] = target.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareTargetCreateParameters(Target target){
		Object[] parameters = new Object[7];
		String newTargetId=getNextId();
		target.setId(newTargetId);
		parameters[0] =  target.getId();
 
 		parameters[1] = target.getName(); 	
 		if(target.getProfile() != null){
 			parameters[2] = target.getProfile().getId();
 		
 		}
 		 	
 		if(target.getBanner() != null){
 			parameters[3] = target.getBanner().getId();
 		
 		}
 		
 		parameters[4] = target.getLocation();
 		parameters[5] = target.getLastUpdate(); 	
 		if(target.getPlatform() != null){
 			parameters[6] = target.getPlatform().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected Target saveInternalTarget(Target target, Map<String,Object> options){
		
		saveTarget(target);
 	
 		if(isSaveProfileEnabled(options)){
	 		saveProfile(target, options);
 		}
  	
 		if(isSaveBannerEnabled(options)){
	 		saveBanner(target, options);
 		}
  	
 		if(isSavePlatformEnabled(options)){
	 		savePlatform(target, options);
 		}
 
		
		return target;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected Target saveProfile(Target target, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(target.getProfile() == null){
 			return target;//do nothing when it is null
 		}
 		
 		getProfileDAO().save(target.getProfile(),options);
 		return target;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected Target saveBanner(Target target, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(target.getBanner() == null){
 			return target;//do nothing when it is null
 		}
 		
 		getBannerDAO().save(target.getBanner(),options);
 		return target;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected Target savePlatform(Target target, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(target.getPlatform() == null){
 			return target;//do nothing when it is null
 		}
 		
 		getPlatformDAO().save(target.getPlatform(),options);
 		return target;
 		
 	}
 	
 	
 	
 	 
	
 

	

		

	public Target present(Target target,Map<String, Object> options){
	

		return target;
	
	}
		

	

	protected String getTableName(){
		return TargetTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<Target> targetList) {		
		this.enhanceListInternal(targetList, this.getTargetMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<Target> targetList = ownerEntity.collectRefsWithType(Target.INTERNAL_TYPE);
		this.enhanceList(targetList);
		
	}
	
	@Override
	public SmartList<Target> findTargetWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getTargetMapper());

	}
	@Override
	public int countTargetWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countTargetWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<Target> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getTargetMapper());
	}
}


