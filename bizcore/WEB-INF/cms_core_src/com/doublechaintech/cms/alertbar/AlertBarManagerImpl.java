
package com.doublechaintech.cms.alertbar;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.doublechaintech.cms.BaseEntity;


import com.doublechaintech.cms.Message;
import com.doublechaintech.cms.SmartList;
import com.doublechaintech.cms.MultipleAccessKey;

import com.doublechaintech.cms.CmsUserContext;
//import com.doublechaintech.cms.BaseManagerImpl;
import com.doublechaintech.cms.CmsCheckerManager;
import com.doublechaintech.cms.CustomCmsCheckerManager;

import com.doublechaintech.cms.platform.Platform;

import com.doublechaintech.cms.platform.CandidatePlatform;







public class AlertBarManagerImpl extends CustomCmsCheckerManager implements AlertBarManager {
	
	private static final String SERVICE_TYPE = "AlertBar";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws AlertBarManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new AlertBarManagerException(message);

	}
	
	

 	protected AlertBar saveAlertBar(CmsUserContext userContext, AlertBar alertBar, String [] tokensExpr) throws Exception{	
 		//return getAlertBarDAO().save(alertBar, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveAlertBar(userContext, alertBar, tokens);
 	}
 	
 	protected AlertBar saveAlertBarDetail(CmsUserContext userContext, AlertBar alertBar) throws Exception{	

 		
 		return saveAlertBar(userContext, alertBar, allTokens());
 	}
 	
 	public AlertBar loadAlertBar(CmsUserContext userContext, String alertBarId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfAlertBar(alertBarId);
		userContext.getChecker().throwExceptionIfHasErrors( AlertBarManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		AlertBar alertBar = loadAlertBar( userContext, alertBarId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,alertBar, tokens);
 	}
 	
 	
 	 public AlertBar searchAlertBar(CmsUserContext userContext, String alertBarId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfAlertBar(alertBarId);
		userContext.getChecker().throwExceptionIfHasErrors( AlertBarManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		AlertBar alertBar = loadAlertBar( userContext, alertBarId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,alertBar, tokens);
 	}
 	
 	

 	protected AlertBar present(CmsUserContext userContext, AlertBar alertBar, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,alertBar,tokens);
		
		
		AlertBar  alertBarToPresent = userContext.getDAOGroup().getAlertBarDAO().present(alertBar, tokens);
		
		List<BaseEntity> entityListToNaming = alertBarToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getAlertBarDAO().alias(entityListToNaming);
		
		return  alertBarToPresent;
		
		
	}
 
 	
 	
 	public AlertBar loadAlertBarDetail(CmsUserContext userContext, String alertBarId) throws Exception{	
 		AlertBar alertBar = loadAlertBar( userContext, alertBarId, allTokens());
 		return present(userContext,alertBar, allTokens());
		
 	}
 	
 	public Object view(CmsUserContext userContext, String alertBarId) throws Exception{	
 		AlertBar alertBar = loadAlertBar( userContext, alertBarId, viewTokens());
 		return present(userContext,alertBar, allTokens());
		
 	}
 	protected AlertBar saveAlertBar(CmsUserContext userContext, AlertBar alertBar, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getAlertBarDAO().save(alertBar, tokens);
 	}
 	protected AlertBar loadAlertBar(CmsUserContext userContext, String alertBarId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfAlertBar(alertBarId);
		userContext.getChecker().throwExceptionIfHasErrors( AlertBarManagerException.class);

 
 		return userContext.getDAOGroup().getAlertBarDAO().load(alertBarId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(CmsUserContext userContext, AlertBar alertBar, Map<String, Object> tokens){
		super.addActions(userContext, alertBar, tokens);
		
		addAction(userContext, alertBar, tokens,"@create","createAlertBar","createAlertBar/","main","primary");
		addAction(userContext, alertBar, tokens,"@update","updateAlertBar","updateAlertBar/"+alertBar.getId()+"/","main","primary");
		addAction(userContext, alertBar, tokens,"@copy","cloneAlertBar","cloneAlertBar/"+alertBar.getId()+"/","main","primary");
		
		addAction(userContext, alertBar, tokens,"alert_bar.transfer_to_platform","transferToAnotherPlatform","transferToAnotherPlatform/"+alertBar.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(CmsUserContext userContext, AlertBar alertBar, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public AlertBar createAlertBar(CmsUserContext userContext,String name, String message, String platformId) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfAlertBar(name);
		userContext.getChecker().checkMessageOfAlertBar(message);
	
		userContext.getChecker().throwExceptionIfHasErrors(AlertBarManagerException.class);


		AlertBar alertBar=createNewAlertBar();	

		alertBar.setName(name);
		alertBar.setMessage(message);
		alertBar.setLastUpdate(userContext.now());
			
		Platform platform = loadPlatform(userContext, platformId,emptyOptions());
		alertBar.setPlatform(platform);
		
		

		alertBar = saveAlertBar(userContext, alertBar, emptyOptions());
		
		onNewInstanceCreated(userContext, alertBar);
		return alertBar;

		
	}
	protected AlertBar createNewAlertBar() 
	{
		
		return new AlertBar();		
	}
	
	protected void checkParamsForUpdatingAlertBar(CmsUserContext userContext,String alertBarId, int alertBarVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfAlertBar(alertBarId);
		userContext.getChecker().checkVersionOfAlertBar( alertBarVersion);
		

		if(AlertBar.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfAlertBar(parseString(newValueExpr));
		}
		if(AlertBar.MESSAGE_PROPERTY.equals(property)){
			userContext.getChecker().checkMessageOfAlertBar(parseString(newValueExpr));
		}		

		
	
		userContext.getChecker().throwExceptionIfHasErrors(AlertBarManagerException.class);
	
		
	}
	
	
	
	public AlertBar clone(CmsUserContext userContext, String fromAlertBarId) throws Exception{
		
		return userContext.getDAOGroup().getAlertBarDAO().clone(fromAlertBarId, this.allTokens());
	}
	
	public AlertBar internalSaveAlertBar(CmsUserContext userContext, AlertBar alertBar) throws Exception 
	{
		return internalSaveAlertBar(userContext, alertBar, allTokens());

	}
	public AlertBar internalSaveAlertBar(CmsUserContext userContext, AlertBar alertBar, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingAlertBar(userContext, alertBarId, alertBarVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(alertBar){ 
			//will be good when the alertBar loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to AlertBar.
			
			
			alertBar = saveAlertBar(userContext, alertBar, options);
			return alertBar;
			
		}

	}
	
	public AlertBar updateAlertBar(CmsUserContext userContext,String alertBarId, int alertBarVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingAlertBar(userContext, alertBarId, alertBarVersion, property, newValueExpr, tokensExpr);
		
		
		
		AlertBar alertBar = loadAlertBar(userContext, alertBarId, allTokens());
		if(alertBar.getVersion() != alertBarVersion){
			String message = "The target version("+alertBar.getVersion()+") is not equals to version("+alertBarVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(alertBar){ 
			//will be good when the alertBar loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to AlertBar.
			alertBar.updateLastUpdate(userContext.now());
			alertBar.changeProperty(property, newValueExpr);
			alertBar = saveAlertBar(userContext, alertBar, tokens().done());
			return present(userContext,alertBar, mergedAllTokens(tokensExpr));
			//return saveAlertBar(userContext, alertBar, tokens().done());
		}

	}
	
	public AlertBar updateAlertBarProperty(CmsUserContext userContext,String alertBarId, int alertBarVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingAlertBar(userContext, alertBarId, alertBarVersion, property, newValueExpr, tokensExpr);
		
		AlertBar alertBar = loadAlertBar(userContext, alertBarId, allTokens());
		if(alertBar.getVersion() != alertBarVersion){
			String message = "The target version("+alertBar.getVersion()+") is not equals to version("+alertBarVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(alertBar){ 
			//will be good when the alertBar loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to AlertBar.
			
			alertBar.changeProperty(property, newValueExpr);
			alertBar.updateLastUpdate(userContext.now());
			alertBar = saveAlertBar(userContext, alertBar, tokens().done());
			return present(userContext,alertBar, mergedAllTokens(tokensExpr));
			//return saveAlertBar(userContext, alertBar, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected AlertBarTokens tokens(){
		return AlertBarTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return AlertBarTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return AlertBarTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherPlatform(CmsUserContext userContext, String alertBarId, String anotherPlatformId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfAlertBar(alertBarId);
 		userContext.getChecker().checkIdOfPlatform(anotherPlatformId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(AlertBarManagerException.class);
 		
 	}
 	public AlertBar transferToAnotherPlatform(CmsUserContext userContext, String alertBarId, String anotherPlatformId) throws Exception
 	{
 		checkParamsForTransferingAnotherPlatform(userContext, alertBarId,anotherPlatformId);
 
		AlertBar alertBar = loadAlertBar(userContext, alertBarId, allTokens());	
		synchronized(alertBar){
			//will be good when the alertBar loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Platform platform = loadPlatform(userContext, anotherPlatformId, emptyOptions());		
			alertBar.updatePlatform(platform);		
			alertBar = saveAlertBar(userContext, alertBar, emptyOptions());
			
			return present(userContext,alertBar, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidatePlatform requestCandidatePlatform(CmsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidatePlatform result = new CandidatePlatform();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<Platform> candidateList = userContext.getDAOGroup().getPlatformDAO().requestCandidatePlatformForAlertBar(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected Platform loadPlatform(CmsUserContext userContext, String newPlatformId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getPlatformDAO().load(newPlatformId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(CmsUserContext userContext, String alertBarId, int alertBarVersion) throws Exception {
		//deleteInternal(userContext, alertBarId, alertBarVersion);		
	}
	protected void deleteInternal(CmsUserContext userContext,
			String alertBarId, int alertBarVersion) throws Exception{
			
		userContext.getDAOGroup().getAlertBarDAO().delete(alertBarId, alertBarVersion);
	}
	
	public AlertBar forgetByAll(CmsUserContext userContext, String alertBarId, int alertBarVersion) throws Exception {
		return forgetByAllInternal(userContext, alertBarId, alertBarVersion);		
	}
	protected AlertBar forgetByAllInternal(CmsUserContext userContext,
			String alertBarId, int alertBarVersion) throws Exception{
			
		return userContext.getDAOGroup().getAlertBarDAO().disconnectFromAll(alertBarId, alertBarVersion);
	}
	

	
	public int deleteAll(CmsUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new AlertBarManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(CmsUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getAlertBarDAO().deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(CmsUserContext userContext, AlertBar newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


