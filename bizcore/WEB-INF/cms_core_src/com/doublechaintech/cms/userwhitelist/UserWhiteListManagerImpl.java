
package com.doublechaintech.cms.userwhitelist;

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

import com.doublechaintech.cms.userdomain.UserDomain;

import com.doublechaintech.cms.userdomain.CandidateUserDomain;







public class UserWhiteListManagerImpl extends CustomCmsCheckerManager implements UserWhiteListManager {
	
	private static final String SERVICE_TYPE = "UserWhiteList";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws UserWhiteListManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new UserWhiteListManagerException(message);

	}
	
	

 	protected UserWhiteList saveUserWhiteList(CmsUserContext userContext, UserWhiteList userWhiteList, String [] tokensExpr) throws Exception{	
 		//return getUserWhiteListDAO().save(userWhiteList, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveUserWhiteList(userContext, userWhiteList, tokens);
 	}
 	
 	protected UserWhiteList saveUserWhiteListDetail(CmsUserContext userContext, UserWhiteList userWhiteList) throws Exception{	

 		
 		return saveUserWhiteList(userContext, userWhiteList, allTokens());
 	}
 	
 	public UserWhiteList loadUserWhiteList(CmsUserContext userContext, String userWhiteListId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfUserWhiteList(userWhiteListId);
		userContext.getChecker().throwExceptionIfHasErrors( UserWhiteListManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		UserWhiteList userWhiteList = loadUserWhiteList( userContext, userWhiteListId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,userWhiteList, tokens);
 	}
 	
 	
 	 public UserWhiteList searchUserWhiteList(CmsUserContext userContext, String userWhiteListId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfUserWhiteList(userWhiteListId);
		userContext.getChecker().throwExceptionIfHasErrors( UserWhiteListManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		UserWhiteList userWhiteList = loadUserWhiteList( userContext, userWhiteListId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,userWhiteList, tokens);
 	}
 	
 	

 	protected UserWhiteList present(CmsUserContext userContext, UserWhiteList userWhiteList, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,userWhiteList,tokens);
		
		
		UserWhiteList  userWhiteListToPresent = userContext.getDAOGroup().getUserWhiteListDAO().present(userWhiteList, tokens);
		
		List<BaseEntity> entityListToNaming = userWhiteListToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getUserWhiteListDAO().alias(entityListToNaming);
		
		return  userWhiteListToPresent;
		
		
	}
 
 	
 	
 	public UserWhiteList loadUserWhiteListDetail(CmsUserContext userContext, String userWhiteListId) throws Exception{	
 		UserWhiteList userWhiteList = loadUserWhiteList( userContext, userWhiteListId, allTokens());
 		return present(userContext,userWhiteList, allTokens());
		
 	}
 	
 	public Object view(CmsUserContext userContext, String userWhiteListId) throws Exception{	
 		UserWhiteList userWhiteList = loadUserWhiteList( userContext, userWhiteListId, viewTokens());
 		return present(userContext,userWhiteList, allTokens());
		
 	}
 	protected UserWhiteList saveUserWhiteList(CmsUserContext userContext, UserWhiteList userWhiteList, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getUserWhiteListDAO().save(userWhiteList, tokens);
 	}
 	protected UserWhiteList loadUserWhiteList(CmsUserContext userContext, String userWhiteListId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfUserWhiteList(userWhiteListId);
		userContext.getChecker().throwExceptionIfHasErrors( UserWhiteListManagerException.class);

 
 		return userContext.getDAOGroup().getUserWhiteListDAO().load(userWhiteListId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(CmsUserContext userContext, UserWhiteList userWhiteList, Map<String, Object> tokens){
		super.addActions(userContext, userWhiteList, tokens);
		
		addAction(userContext, userWhiteList, tokens,"@create","createUserWhiteList","createUserWhiteList/","main","primary");
		addAction(userContext, userWhiteList, tokens,"@update","updateUserWhiteList","updateUserWhiteList/"+userWhiteList.getId()+"/","main","primary");
		addAction(userContext, userWhiteList, tokens,"@copy","cloneUserWhiteList","cloneUserWhiteList/"+userWhiteList.getId()+"/","main","primary");
		
		addAction(userContext, userWhiteList, tokens,"user_white_list.transfer_to_domain","transferToAnotherDomain","transferToAnotherDomain/"+userWhiteList.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(CmsUserContext userContext, UserWhiteList userWhiteList, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public UserWhiteList createUserWhiteList(CmsUserContext userContext,String userIdentity, String userSpecialFunctions, String domainId) throws Exception
	{
		
		

		

		userContext.getChecker().checkUserIdentityOfUserWhiteList(userIdentity);
		userContext.getChecker().checkUserSpecialFunctionsOfUserWhiteList(userSpecialFunctions);
	
		userContext.getChecker().throwExceptionIfHasErrors(UserWhiteListManagerException.class);


		UserWhiteList userWhiteList=createNewUserWhiteList();	

		userWhiteList.setUserIdentity(userIdentity);
		userWhiteList.setUserSpecialFunctions(userSpecialFunctions);
			
		UserDomain domain = loadUserDomain(userContext, domainId,emptyOptions());
		userWhiteList.setDomain(domain);
		
		

		userWhiteList = saveUserWhiteList(userContext, userWhiteList, emptyOptions());
		
		onNewInstanceCreated(userContext, userWhiteList);
		return userWhiteList;

		
	}
	protected UserWhiteList createNewUserWhiteList() 
	{
		
		return new UserWhiteList();		
	}
	
	protected void checkParamsForUpdatingUserWhiteList(CmsUserContext userContext,String userWhiteListId, int userWhiteListVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfUserWhiteList(userWhiteListId);
		userContext.getChecker().checkVersionOfUserWhiteList( userWhiteListVersion);
		

		if(UserWhiteList.USER_IDENTITY_PROPERTY.equals(property)){
			userContext.getChecker().checkUserIdentityOfUserWhiteList(parseString(newValueExpr));
		}
		if(UserWhiteList.USER_SPECIAL_FUNCTIONS_PROPERTY.equals(property)){
			userContext.getChecker().checkUserSpecialFunctionsOfUserWhiteList(parseString(newValueExpr));
		}		

		
	
		userContext.getChecker().throwExceptionIfHasErrors(UserWhiteListManagerException.class);
	
		
	}
	
	
	
	public UserWhiteList clone(CmsUserContext userContext, String fromUserWhiteListId) throws Exception{
		
		return userContext.getDAOGroup().getUserWhiteListDAO().clone(fromUserWhiteListId, this.allTokens());
	}
	
	public UserWhiteList internalSaveUserWhiteList(CmsUserContext userContext, UserWhiteList userWhiteList) throws Exception 
	{
		return internalSaveUserWhiteList(userContext, userWhiteList, allTokens());

	}
	public UserWhiteList internalSaveUserWhiteList(CmsUserContext userContext, UserWhiteList userWhiteList, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingUserWhiteList(userContext, userWhiteListId, userWhiteListVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(userWhiteList){ 
			//will be good when the userWhiteList loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to UserWhiteList.
			
			
			userWhiteList = saveUserWhiteList(userContext, userWhiteList, options);
			return userWhiteList;
			
		}

	}
	
	public UserWhiteList updateUserWhiteList(CmsUserContext userContext,String userWhiteListId, int userWhiteListVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingUserWhiteList(userContext, userWhiteListId, userWhiteListVersion, property, newValueExpr, tokensExpr);
		
		
		
		UserWhiteList userWhiteList = loadUserWhiteList(userContext, userWhiteListId, allTokens());
		if(userWhiteList.getVersion() != userWhiteListVersion){
			String message = "The target version("+userWhiteList.getVersion()+") is not equals to version("+userWhiteListVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(userWhiteList){ 
			//will be good when the userWhiteList loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to UserWhiteList.
			
			userWhiteList.changeProperty(property, newValueExpr);
			userWhiteList = saveUserWhiteList(userContext, userWhiteList, tokens().done());
			return present(userContext,userWhiteList, mergedAllTokens(tokensExpr));
			//return saveUserWhiteList(userContext, userWhiteList, tokens().done());
		}

	}
	
	public UserWhiteList updateUserWhiteListProperty(CmsUserContext userContext,String userWhiteListId, int userWhiteListVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingUserWhiteList(userContext, userWhiteListId, userWhiteListVersion, property, newValueExpr, tokensExpr);
		
		UserWhiteList userWhiteList = loadUserWhiteList(userContext, userWhiteListId, allTokens());
		if(userWhiteList.getVersion() != userWhiteListVersion){
			String message = "The target version("+userWhiteList.getVersion()+") is not equals to version("+userWhiteListVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(userWhiteList){ 
			//will be good when the userWhiteList loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to UserWhiteList.
			
			userWhiteList.changeProperty(property, newValueExpr);
			
			userWhiteList = saveUserWhiteList(userContext, userWhiteList, tokens().done());
			return present(userContext,userWhiteList, mergedAllTokens(tokensExpr));
			//return saveUserWhiteList(userContext, userWhiteList, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected UserWhiteListTokens tokens(){
		return UserWhiteListTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return UserWhiteListTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return UserWhiteListTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherDomain(CmsUserContext userContext, String userWhiteListId, String anotherDomainId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfUserWhiteList(userWhiteListId);
 		userContext.getChecker().checkIdOfUserDomain(anotherDomainId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(UserWhiteListManagerException.class);
 		
 	}
 	public UserWhiteList transferToAnotherDomain(CmsUserContext userContext, String userWhiteListId, String anotherDomainId) throws Exception
 	{
 		checkParamsForTransferingAnotherDomain(userContext, userWhiteListId,anotherDomainId);
 
		UserWhiteList userWhiteList = loadUserWhiteList(userContext, userWhiteListId, allTokens());	
		synchronized(userWhiteList){
			//will be good when the userWhiteList loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			UserDomain domain = loadUserDomain(userContext, anotherDomainId, emptyOptions());		
			userWhiteList.updateDomain(domain);		
			userWhiteList = saveUserWhiteList(userContext, userWhiteList, emptyOptions());
			
			return present(userContext,userWhiteList, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateUserDomain requestCandidateDomain(CmsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateUserDomain result = new CandidateUserDomain();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<UserDomain> candidateList = userContext.getDAOGroup().getUserDomainDAO().requestCandidateUserDomainForUserWhiteList(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected UserDomain loadUserDomain(CmsUserContext userContext, String newDomainId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getUserDomainDAO().load(newDomainId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(CmsUserContext userContext, String userWhiteListId, int userWhiteListVersion) throws Exception {
		//deleteInternal(userContext, userWhiteListId, userWhiteListVersion);		
	}
	protected void deleteInternal(CmsUserContext userContext,
			String userWhiteListId, int userWhiteListVersion) throws Exception{
			
		userContext.getDAOGroup().getUserWhiteListDAO().delete(userWhiteListId, userWhiteListVersion);
	}
	
	public UserWhiteList forgetByAll(CmsUserContext userContext, String userWhiteListId, int userWhiteListVersion) throws Exception {
		return forgetByAllInternal(userContext, userWhiteListId, userWhiteListVersion);		
	}
	protected UserWhiteList forgetByAllInternal(CmsUserContext userContext,
			String userWhiteListId, int userWhiteListVersion) throws Exception{
			
		return userContext.getDAOGroup().getUserWhiteListDAO().disconnectFromAll(userWhiteListId, userWhiteListVersion);
	}
	

	
	public int deleteAll(CmsUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new UserWhiteListManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(CmsUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getUserWhiteListDAO().deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(CmsUserContext userContext, UserWhiteList newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


