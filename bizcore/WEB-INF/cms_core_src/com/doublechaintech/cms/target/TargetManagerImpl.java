
package com.doublechaintech.cms.target;

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

import com.doublechaintech.cms.profile.Profile;
import com.doublechaintech.cms.banner.Banner;

import com.doublechaintech.cms.profile.CandidateProfile;
import com.doublechaintech.cms.banner.CandidateBanner;







public class TargetManagerImpl extends CustomCmsCheckerManager implements TargetManager {
	
	private static final String SERVICE_TYPE = "Target";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws TargetManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new TargetManagerException(message);

	}
	
	

 	protected Target saveTarget(CmsUserContext userContext, Target target, String [] tokensExpr) throws Exception{	
 		//return getTargetDAO().save(target, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveTarget(userContext, target, tokens);
 	}
 	
 	protected Target saveTargetDetail(CmsUserContext userContext, Target target) throws Exception{	

 		
 		return saveTarget(userContext, target, allTokens());
 	}
 	
 	public Target loadTarget(CmsUserContext userContext, String targetId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfTarget(targetId);
		userContext.getChecker().throwExceptionIfHasErrors( TargetManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Target target = loadTarget( userContext, targetId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,target, tokens);
 	}
 	
 	
 	 public Target searchTarget(CmsUserContext userContext, String targetId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfTarget(targetId);
		userContext.getChecker().throwExceptionIfHasErrors( TargetManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		Target target = loadTarget( userContext, targetId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,target, tokens);
 	}
 	
 	

 	protected Target present(CmsUserContext userContext, Target target, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,target,tokens);
		
		
		Target  targetToPresent = userContext.getDAOGroup().getTargetDAO().present(target, tokens);
		
		List<BaseEntity> entityListToNaming = targetToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getTargetDAO().alias(entityListToNaming);
		
		return  targetToPresent;
		
		
	}
 
 	
 	
 	public Target loadTargetDetail(CmsUserContext userContext, String targetId) throws Exception{	
 		Target target = loadTarget( userContext, targetId, allTokens());
 		return present(userContext,target, allTokens());
		
 	}
 	
 	public Object view(CmsUserContext userContext, String targetId) throws Exception{	
 		Target target = loadTarget( userContext, targetId, viewTokens());
 		return present(userContext,target, allTokens());
		
 	}
 	protected Target saveTarget(CmsUserContext userContext, Target target, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getTargetDAO().save(target, tokens);
 	}
 	protected Target loadTarget(CmsUserContext userContext, String targetId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfTarget(targetId);
		userContext.getChecker().throwExceptionIfHasErrors( TargetManagerException.class);

 
 		return userContext.getDAOGroup().getTargetDAO().load(targetId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(CmsUserContext userContext, Target target, Map<String, Object> tokens){
		super.addActions(userContext, target, tokens);
		
		addAction(userContext, target, tokens,"@create","createTarget","createTarget/","main","primary");
		addAction(userContext, target, tokens,"@update","updateTarget","updateTarget/"+target.getId()+"/","main","primary");
		addAction(userContext, target, tokens,"@copy","cloneTarget","cloneTarget/"+target.getId()+"/","main","primary");
		
		addAction(userContext, target, tokens,"target.transfer_to_profile","transferToAnotherProfile","transferToAnotherProfile/"+target.getId()+"/","main","primary");
		addAction(userContext, target, tokens,"target.transfer_to_banner","transferToAnotherBanner","transferToAnotherBanner/"+target.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(CmsUserContext userContext, Target target, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public Target createTarget(CmsUserContext userContext,String name, String profileId, String bannerId, String when, String location) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfTarget(name);
		userContext.getChecker().checkWhenOfTarget(when);
		userContext.getChecker().checkLocationOfTarget(location);
	
		userContext.getChecker().throwExceptionIfHasErrors(TargetManagerException.class);


		Target target=createNewTarget();	

		target.setName(name);
			
		Profile profile = loadProfile(userContext, profileId,emptyOptions());
		target.setProfile(profile);
		
		
			
		Banner banner = loadBanner(userContext, bannerId,emptyOptions());
		target.setBanner(banner);
		
		
		target.setWhen(when);
		target.setLocation(location);
		target.setLastUpdate(userContext.now());

		target = saveTarget(userContext, target, emptyOptions());
		
		onNewInstanceCreated(userContext, target);
		return target;

		
	}
	protected Target createNewTarget() 
	{
		
		return new Target();		
	}
	
	protected void checkParamsForUpdatingTarget(CmsUserContext userContext,String targetId, int targetVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfTarget(targetId);
		userContext.getChecker().checkVersionOfTarget( targetVersion);
		

		if(Target.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfTarget(parseString(newValueExpr));
		}		

				

		
		if(Target.WHEN_PROPERTY.equals(property)){
			userContext.getChecker().checkWhenOfTarget(parseString(newValueExpr));
		}
		if(Target.LOCATION_PROPERTY.equals(property)){
			userContext.getChecker().checkLocationOfTarget(parseString(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(TargetManagerException.class);
	
		
	}
	
	
	
	public Target clone(CmsUserContext userContext, String fromTargetId) throws Exception{
		
		return userContext.getDAOGroup().getTargetDAO().clone(fromTargetId, this.allTokens());
	}
	
	public Target internalSaveTarget(CmsUserContext userContext, Target target) throws Exception 
	{
		return internalSaveTarget(userContext, target, allTokens());

	}
	public Target internalSaveTarget(CmsUserContext userContext, Target target, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingTarget(userContext, targetId, targetVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(target){ 
			//will be good when the target loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Target.
			
			
			target = saveTarget(userContext, target, options);
			return target;
			
		}

	}
	
	public Target updateTarget(CmsUserContext userContext,String targetId, int targetVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingTarget(userContext, targetId, targetVersion, property, newValueExpr, tokensExpr);
		
		
		
		Target target = loadTarget(userContext, targetId, allTokens());
		if(target.getVersion() != targetVersion){
			String message = "The target version("+target.getVersion()+") is not equals to version("+targetVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(target){ 
			//will be good when the target loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Target.
			target.updateLastUpdate(userContext.now());
			target.changeProperty(property, newValueExpr);
			target = saveTarget(userContext, target, tokens().done());
			return present(userContext,target, mergedAllTokens(tokensExpr));
			//return saveTarget(userContext, target, tokens().done());
		}

	}
	
	public Target updateTargetProperty(CmsUserContext userContext,String targetId, int targetVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingTarget(userContext, targetId, targetVersion, property, newValueExpr, tokensExpr);
		
		Target target = loadTarget(userContext, targetId, allTokens());
		if(target.getVersion() != targetVersion){
			String message = "The target version("+target.getVersion()+") is not equals to version("+targetVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(target){ 
			//will be good when the target loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Target.
			
			target.changeProperty(property, newValueExpr);
			target.updateLastUpdate(userContext.now());
			target = saveTarget(userContext, target, tokens().done());
			return present(userContext,target, mergedAllTokens(tokensExpr));
			//return saveTarget(userContext, target, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected TargetTokens tokens(){
		return TargetTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return TargetTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return TargetTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherProfile(CmsUserContext userContext, String targetId, String anotherProfileId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfTarget(targetId);
 		userContext.getChecker().checkIdOfProfile(anotherProfileId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(TargetManagerException.class);
 		
 	}
 	public Target transferToAnotherProfile(CmsUserContext userContext, String targetId, String anotherProfileId) throws Exception
 	{
 		checkParamsForTransferingAnotherProfile(userContext, targetId,anotherProfileId);
 
		Target target = loadTarget(userContext, targetId, allTokens());	
		synchronized(target){
			//will be good when the target loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Profile profile = loadProfile(userContext, anotherProfileId, emptyOptions());		
			target.updateProfile(profile);		
			target = saveTarget(userContext, target, emptyOptions());
			
			return present(userContext,target, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateProfile requestCandidateProfile(CmsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateProfile result = new CandidateProfile();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<Profile> candidateList = userContext.getDAOGroup().getProfileDAO().requestCandidateProfileForTarget(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherBanner(CmsUserContext userContext, String targetId, String anotherBannerId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfTarget(targetId);
 		userContext.getChecker().checkIdOfBanner(anotherBannerId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(TargetManagerException.class);
 		
 	}
 	public Target transferToAnotherBanner(CmsUserContext userContext, String targetId, String anotherBannerId) throws Exception
 	{
 		checkParamsForTransferingAnotherBanner(userContext, targetId,anotherBannerId);
 
		Target target = loadTarget(userContext, targetId, allTokens());	
		synchronized(target){
			//will be good when the target loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Banner banner = loadBanner(userContext, anotherBannerId, emptyOptions());		
			target.updateBanner(banner);		
			target = saveTarget(userContext, target, emptyOptions());
			
			return present(userContext,target, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateBanner requestCandidateBanner(CmsUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateBanner result = new CandidateBanner();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<Banner> candidateList = userContext.getDAOGroup().getBannerDAO().requestCandidateBannerForTarget(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected Profile loadProfile(CmsUserContext userContext, String newProfileId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getProfileDAO().load(newProfileId, options);
 	}
 	
 	
 	
	
	 	
 	protected Banner loadBanner(CmsUserContext userContext, String newBannerId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getBannerDAO().load(newBannerId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(CmsUserContext userContext, String targetId, int targetVersion) throws Exception {
		//deleteInternal(userContext, targetId, targetVersion);		
	}
	protected void deleteInternal(CmsUserContext userContext,
			String targetId, int targetVersion) throws Exception{
			
		userContext.getDAOGroup().getTargetDAO().delete(targetId, targetVersion);
	}
	
	public Target forgetByAll(CmsUserContext userContext, String targetId, int targetVersion) throws Exception {
		return forgetByAllInternal(userContext, targetId, targetVersion);		
	}
	protected Target forgetByAllInternal(CmsUserContext userContext,
			String targetId, int targetVersion) throws Exception{
			
		return userContext.getDAOGroup().getTargetDAO().disconnectFromAll(targetId, targetVersion);
	}
	

	
	public int deleteAll(CmsUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new TargetManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(CmsUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getTargetDAO().deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(CmsUserContext userContext, Target newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


