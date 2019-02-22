
package com.doublechaintech.cms.alertbar;

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

import com.doublechaintech.cms.platform.PlatformDAO;



import org.springframework.dao.EmptyResultDataAccessException;

public class AlertBarJDBCTemplateDAO extends CmsNamingServiceDAO implements AlertBarDAO{
 
 	
 	private  PlatformDAO  platformDAO;
 	public void setPlatformDAO(PlatformDAO platformDAO){
	 	this.platformDAO = platformDAO;
 	}
 	public PlatformDAO getPlatformDAO(){
	 	return this.platformDAO;
 	}


			
		

	
	/*
	protected AlertBar load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalAlertBar(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public AlertBar load(String id,Map<String,Object> options) throws Exception{
		return loadInternalAlertBar(AlertBarTable.withId(id), options);
	}
	
	
	
	public AlertBar save(AlertBar alertBar,Map<String,Object> options){
		
		String methodName="save(AlertBar alertBar,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(alertBar, methodName, "alertBar");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalAlertBar(alertBar,options);
	}
	public AlertBar clone(String alertBarId, Map<String,Object> options) throws Exception{
	
		return clone(AlertBarTable.withId(alertBarId),options);
	}
	
	protected AlertBar clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String alertBarId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		AlertBar newAlertBar = loadInternalAlertBar(accessKey, options);
		newAlertBar.setVersion(0);
		
		

		
		saveInternalAlertBar(newAlertBar,options);
		
		return newAlertBar;
	}
	
	
	
	

	protected void throwIfHasException(String alertBarId,int version,int count) throws Exception{
		if (count == 1) {
			throw new AlertBarVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new AlertBarNotFoundException(
					"The " + this.getTableName() + "(" + alertBarId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String alertBarId, int version) throws Exception{
	
		String methodName="delete(String alertBarId, int version)";
		assertMethodArgumentNotNull(alertBarId, methodName, "alertBarId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{alertBarId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(alertBarId,version);
		}
		
	
	}
	
	
	
	
	

	public AlertBar disconnectFromAll(String alertBarId, int version) throws Exception{
	
		
		AlertBar alertBar = loadInternalAlertBar(AlertBarTable.withId(alertBarId), emptyOptions());
		alertBar.clearFromAll();
		this.saveAlertBar(alertBar);
		return alertBar;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return AlertBarTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "alert_bar";
	}
	@Override
	protected String getBeanName() {
		
		return "alertBar";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return AlertBarTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractPlatformEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, AlertBarTokens.PLATFORM);
 	}

 	protected boolean isSavePlatformEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, AlertBarTokens.PLATFORM);
 	}
 	

 	
 
		

	

	protected AlertBarMapper getAlertBarMapper(){
		return new AlertBarMapper();
	}

	
	
	protected AlertBar extractAlertBar(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			AlertBar alertBar = loadSingleObject(accessKey, getAlertBarMapper());
			return alertBar;
		}catch(EmptyResultDataAccessException e){
			throw new AlertBarNotFoundException("AlertBar("+accessKey+") is not found!");
		}

	}

	
	

	protected AlertBar loadInternalAlertBar(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		AlertBar alertBar = extractAlertBar(accessKey, loadOptions);
 	
 		if(isExtractPlatformEnabled(loadOptions)){
	 		extractPlatform(alertBar, loadOptions);
 		}
 
		
		return alertBar;
		
	}

	 

 	protected AlertBar extractPlatform(AlertBar alertBar, Map<String,Object> options) throws Exception{

		if(alertBar.getPlatform() == null){
			return alertBar;
		}
		String platformId = alertBar.getPlatform().getId();
		if( platformId == null){
			return alertBar;
		}
		Platform platform = getPlatformDAO().load(platformId,options);
		if(platform != null){
			alertBar.setPlatform(platform);
		}
		
 		
 		return alertBar;
 	}
 		
 
		
		
  	
 	public SmartList<AlertBar> findAlertBarByPlatform(String platformId,Map<String,Object> options){
 	
  		SmartList<AlertBar> resultList = queryWith(AlertBarTable.COLUMN_PLATFORM, platformId, options, getAlertBarMapper());
		// analyzeAlertBarByPlatform(resultList, platformId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<AlertBar> findAlertBarByPlatform(String platformId, int start, int count,Map<String,Object> options){
 		
 		SmartList<AlertBar> resultList =  queryWithRange(AlertBarTable.COLUMN_PLATFORM, platformId, options, getAlertBarMapper(), start, count);
 		//analyzeAlertBarByPlatform(resultList, platformId, options);
 		return resultList;
 		
 	}
 	public void analyzeAlertBarByPlatform(SmartList<AlertBar> resultList, String platformId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(AlertBar.PLATFORM_PROPERTY, platformId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem lastUpdateStatsItem = new StatsItem();
		//AlertBar.LAST_UPDATE_PROPERTY
		lastUpdateStatsItem.setDisplayName("Alert Bar");
		lastUpdateStatsItem.setInternalName(formatKeyForDateLine(AlertBar.LAST_UPDATE_PROPERTY));
		lastUpdateStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(AlertBar.LAST_UPDATE_PROPERTY),filterKey,emptyOptions));
		info.addItem(lastUpdateStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countAlertBarByPlatform(String platformId,Map<String,Object> options){

 		return countWith(AlertBarTable.COLUMN_PLATFORM, platformId, options);
 	}
 	@Override
	public Map<String, Integer> countAlertBarByPlatformIds(String[] ids, Map<String, Object> options) {
		return countWithIds(AlertBarTable.COLUMN_PLATFORM, ids, options);
	}
 	
 	
		
		
		

	

	protected AlertBar saveAlertBar(AlertBar  alertBar){
		
		if(!alertBar.isChanged()){
			return alertBar;
		}
		
		
		String SQL=this.getSaveAlertBarSQL(alertBar);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveAlertBarParameters(alertBar);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		alertBar.incVersion();
		return alertBar;
	
	}
	public SmartList<AlertBar> saveAlertBarList(SmartList<AlertBar> alertBarList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitAlertBarList(alertBarList);
		
		batchAlertBarCreate((List<AlertBar>)lists[CREATE_LIST_INDEX]);
		
		batchAlertBarUpdate((List<AlertBar>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(AlertBar alertBar:alertBarList){
			if(alertBar.isChanged()){
				alertBar.incVersion();
			}
			
		
		}
		
		
		return alertBarList;
	}

	public SmartList<AlertBar> removeAlertBarList(SmartList<AlertBar> alertBarList,Map<String,Object> options){
		
		
		super.removeList(alertBarList, options);
		
		return alertBarList;
		
		
	}
	
	protected List<Object[]> prepareAlertBarBatchCreateArgs(List<AlertBar> alertBarList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(AlertBar alertBar:alertBarList ){
			Object [] parameters = prepareAlertBarCreateParameters(alertBar);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareAlertBarBatchUpdateArgs(List<AlertBar> alertBarList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(AlertBar alertBar:alertBarList ){
			if(!alertBar.isChanged()){
				continue;
			}
			Object [] parameters = prepareAlertBarUpdateParameters(alertBar);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchAlertBarCreate(List<AlertBar> alertBarList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareAlertBarBatchCreateArgs(alertBarList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchAlertBarUpdate(List<AlertBar> alertBarList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareAlertBarBatchUpdateArgs(alertBarList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitAlertBarList(List<AlertBar> alertBarList){
		
		List<AlertBar> alertBarCreateList=new ArrayList<AlertBar>();
		List<AlertBar> alertBarUpdateList=new ArrayList<AlertBar>();
		
		for(AlertBar alertBar: alertBarList){
			if(isUpdateRequest(alertBar)){
				alertBarUpdateList.add( alertBar);
				continue;
			}
			alertBarCreateList.add(alertBar);
		}
		
		return new Object[]{alertBarCreateList,alertBarUpdateList};
	}
	
	protected boolean isUpdateRequest(AlertBar alertBar){
 		return alertBar.getVersion() > 0;
 	}
 	protected String getSaveAlertBarSQL(AlertBar alertBar){
 		if(isUpdateRequest(alertBar)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveAlertBarParameters(AlertBar alertBar){
 		if(isUpdateRequest(alertBar) ){
 			return prepareAlertBarUpdateParameters(alertBar);
 		}
 		return prepareAlertBarCreateParameters(alertBar);
 	}
 	protected Object[] prepareAlertBarUpdateParameters(AlertBar alertBar){
 		Object[] parameters = new Object[7];
 
 		parameters[0] = alertBar.getName();
 		parameters[1] = alertBar.getMessage();
 		parameters[2] = alertBar.getLastUpdate(); 	
 		if(alertBar.getPlatform() != null){
 			parameters[3] = alertBar.getPlatform().getId();
 		}
 		
 		parameters[4] = alertBar.nextVersion();
 		parameters[5] = alertBar.getId();
 		parameters[6] = alertBar.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareAlertBarCreateParameters(AlertBar alertBar){
		Object[] parameters = new Object[5];
		String newAlertBarId=getNextId();
		alertBar.setId(newAlertBarId);
		parameters[0] =  alertBar.getId();
 
 		parameters[1] = alertBar.getName();
 		parameters[2] = alertBar.getMessage();
 		parameters[3] = alertBar.getLastUpdate(); 	
 		if(alertBar.getPlatform() != null){
 			parameters[4] = alertBar.getPlatform().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected AlertBar saveInternalAlertBar(AlertBar alertBar, Map<String,Object> options){
		
		saveAlertBar(alertBar);
 	
 		if(isSavePlatformEnabled(options)){
	 		savePlatform(alertBar, options);
 		}
 
		
		return alertBar;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected AlertBar savePlatform(AlertBar alertBar, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(alertBar.getPlatform() == null){
 			return alertBar;//do nothing when it is null
 		}
 		
 		getPlatformDAO().save(alertBar.getPlatform(),options);
 		return alertBar;
 		
 	}
 	
 	
 	
 	 
	
 

	

		

	public AlertBar present(AlertBar alertBar,Map<String, Object> options){
	

		return alertBar;
	
	}
		

	

	protected String getTableName(){
		return AlertBarTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<AlertBar> alertBarList) {		
		this.enhanceListInternal(alertBarList, this.getAlertBarMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<AlertBar> alertBarList = ownerEntity.collectRefsWithType(AlertBar.INTERNAL_TYPE);
		this.enhanceList(alertBarList);
		
	}
	
	@Override
	public SmartList<AlertBar> findAlertBarWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getAlertBarMapper());

	}
	@Override
	public int countAlertBarWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countAlertBarWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<AlertBar> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getAlertBarMapper());
	}
}


