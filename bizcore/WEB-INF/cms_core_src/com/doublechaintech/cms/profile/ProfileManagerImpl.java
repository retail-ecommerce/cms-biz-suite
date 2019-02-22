
package com.doublechaintech.cms.profile;

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

import com.doublechaintech.cms.target.Target;
import com.doublechaintech.cms.useralert.UserAlert;
import com.doublechaintech.cms.platform.Platform;

import com.doublechaintech.cms.platform.CandidatePlatform;

import com.doublechaintech.cms.platform.Platform;
import com.doublechaintech.cms.profile.Profile;
import com.doublechaintech.cms.banner.Banner;






public class ProfileManagerImpl extends CustomCmsCheckerManager implements ProfileManager {
	
	private static final String SERVICE_TYPE = "Profile";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws ProfileManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new ProfileManagerException(message);

	}
	
	

 	protected Profile saveProfile(CmsUserContext userContext, Profile profile, String [] tokensExpr) throws Exception{	
 		//return getProfileDAO().save(profile, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveProfile(userContext, profile, tokens);
 	}
 	
 	protected Profile saveProfileDetail(CmsUserContext userContext, Profile profile) throws Exception{	

 		
 		return saveProfile(userContext, profile, allTokens());
 	}
 	
 	public Profile loadProfile(CmsUserContext userContext, String profileId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfProfile(profileId);
		userContext.getChecker().throwExceptionIfHasErrors( ProfileManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Profile profile = loadProfile( userContext, profileId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,profile, tokens);
 	}
 	
 	
 	 public Profile searchProfile(CmsUserContext userContext, String profileId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfProfile(profileId);
		userContext.getChecker().throwExceptionIfHasErrors( ProfileManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		Profile profile = loadProfile( userContext, profileId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,profile, tokens);
 	}
 	
 	

 	protected Profile present(CmsUserContext userContext, Profile profile, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,profile,tokens);
		
		
		Profile  profileToPresent = userContext.getDAOGroup().getProfileDAO().present(profile, tokens);
		
		List<BaseEntity> entityListToNaming = profileToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getProfileDAO().alias(entityListToNaming);
		
		return  profileToPresent;
		
		
	}
 
 	
 	
 	public Profile loadProfileDetail(CmsUserContext userContext, String profileId) throws Exception{	
 		Profile profile = loadProfile( userContext, profileId, allTokens());
 		return present(userContext,profile, allTokens());
		
 	}
 	
 	public Object view(CmsUserContext userContext, String profileId) throws Exception{	
 		Profile profile = loadProfile( userContext, profileId, viewTokens());
 		return present(userContext,profile, allTokens());
		
 	}
 	protected Profile saveProfile(CmsUserContext userContext, Profile profile, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getProfileDAO().save(profile, tokens);
 	}
 	protected Profile loadProfile(CmsUserContext userContext, String profileId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfProfile(profileId);
		userContext.getChecker().throwExceptionIfHasErrors( ProfileManagerException.class);

 
 		return userContext.getDAOGroup().getProfileDAO().load(profileId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(CmsUserContext userContext, Profile profile, Map<String, Object> tokens){
		super.addActions(userContext, profile, tokens);
		
		addAction(userContext, profile, tokens,"@create","createProfile","createProfile/","main","primary");
		addAction(userContext, profile, tokens,"@update","updateProfile","updateProfile/"+profile.getId()+"/","main","primary");
		addAction(userContext, profile, tokens,"@copy","cloneProfile","cloneProfile/"+profile.getId()+"/","main","primary");
		
		addAction(userContext, profile, tokens,"profile.transfer_to_platform","transferToAnotherPlatform","transferToAnotherPlatform/"+profile.getId()+"/","main","primary");
		addAction(userContext, profile, tokens,"profile.addTarget","addTarget","addTarget/"+profile.getId()+"/","targetList","primary");
		addAction(userContext, profile, tokens,"profile.removeTarget","removeTarget","removeTarget/"+profile.getId()+"/","targetList","primary");
		addAction(userContext, profile, tokens,"profile.updateTarget","updateTarget","updateTarget/"+profile.getId()+"/","targetList","primary");
		addAction(userContext, profile, tokens,"profile.copyTargetFrom","copyTargetFrom","copyTargetFrom/"+profile.getId()+"/","targetList","primary");
		addAction(userContext, profile, tokens,"profile.addUserAlert","addUserAlert","addUserAlert/"+profile.getId()+"/","userAlertList","primary");
		addAction(userContext, profile, tokens,"profile.removeUserAlert","removeUserAlert","removeUserAlert/"+profile.getId()+"/","userAlertList","primary");
		addAction(userContext, profile, tokens,"profile.updateUserAlert","updateUserAlert","updateUserAlert/"+profile.getId()+"/","userAlertList","primary");
		addAction(userContext, profile, tokens,"profile.copyUserAlertFrom","copyUserAlertFrom","copyUserAlertFrom/"+profile.getId()+"/","userAlertList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(CmsUserContext userContext, Profile profile, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public Profile createProfile(CmsUserContext userContext,String name, String platformId) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfProfile(name);
	
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);


		Profile profile=createNewProfile();	

		profile.setName(name);
			
		Platform platform = loadPlatform(userContext, platformId,emptyOptions());
		profile.setPlatform(platform);
		
		

		profile = saveProfile(userContext, profile, emptyOptions());
		
		onNewInstanceCreated(userContext, profile);
		return profile;

		
	}
	protected Profile createNewProfile() 
	{
		
		return new Profile();		
	}
	
	protected void checkParamsForUpdatingProfile(CmsUserContext userContext,String profileId, int profileVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfProfile(profileId);
		userContext.getChecker().checkVersionOfProfile( profileVersion);
		

		if(Profile.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfProfile(parseString(newValueExpr));
		}		

		
	
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
	
		
	}
	
	
	
	public Profile clone(CmsUserContext userContext, String fromProfileId) throws Exception{
		
		return userContext.getDAOGroup().getProfileDAO().clone(fromProfileId, this.allTokens());
	}
	
	public Profile internalSaveProfile(CmsUserContext userContext, Profile profile) throws Exception 
	{
		return internalSaveProfile(userContext, profile, allTokens());

	}
	public Profile internalSaveProfile(CmsUserContext userContext, Profile profile, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingProfile(userContext, profileId, profileVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(profile){ 
			//will be good when the profile loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Profile.
			
			
			profile = saveProfile(userContext, profile, options);
			return profile;
			
		}

	}
	
	public Profile updateProfile(CmsUserContext userContext,String profileId, int profileVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingProfile(userContext, profileId, profileVersion, property, newValueExpr, tokensExpr);
		
		
		
		Profile profile = loadProfile(userContext, profileId, allTokens());
		if(profile.getVersion() != profileVersion){
			String message = "The target version("+profile.getVersion()+") is not equals to version("+profileVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(profile){ 
			//will be good when the profile loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Profile.
			
			profile.changeProperty(property, newValueExpr);
			profile = saveProfile(userContext, profile, tokens().done());
			return present(userContext,profile, mergedAllTokens(tokensExpr));
			//return saveProfile(userContext, profile, tokens().done());
		}

	}
	
	public Profile updateProfileProperty(CmsUserContext userContext,String profileId, int profileVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingProfile(userContext, profileId, profileVersion, property, newValueExpr, tokensExpr);
		
		Profile profile = loadProfile(userContext, profileId, allTokens());
		if(profile.getVersion() != profileVersion){
			String message = "The target version("+profile.getVersion()+") is not equals to version("+profileVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(profile){ 
			//will be good when the profile loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Profile.
			
			profile.changeProperty(property, newValueExpr);
			
			profile = saveProfile(userContext, profile, tokens().done());
			return present(userContext,profile, mergedAllTokens(tokensExpr));
			//return saveProfile(userContext, profile, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected ProfileTokens tokens(){
		return ProfileTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ProfileTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortTargetListWith("id","desc")
		.sortUserAlertListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ProfileTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherPlatform(CmsUserContext userContext, String profileId, String anotherPlatformId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfProfile(profileId);
 		userContext.getChecker().checkIdOfPlatform(anotherPlatformId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
 		
 	}
 	public Profile transferToAnotherPlatform(CmsUserContext userContext, String profileId, String anotherPlatformId) throws Exception
 	{
 		checkParamsForTransferingAnotherPlatform(userContext, profileId,anotherPlatformId);
 
		Profile profile = loadProfile(userContext, profileId, allTokens());	
		synchronized(profile){
			//will be good when the profile loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Platform platform = loadPlatform(userContext, anotherPlatformId, emptyOptions());		
			profile.updatePlatform(platform);		
			profile = saveProfile(userContext, profile, emptyOptions());
			
			return present(userContext,profile, allTokens());
			
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
		SmartList<Platform> candidateList = userContext.getDAOGroup().getPlatformDAO().requestCandidatePlatformForProfile(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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

	public void delete(CmsUserContext userContext, String profileId, int profileVersion) throws Exception {
		//deleteInternal(userContext, profileId, profileVersion);		
	}
	protected void deleteInternal(CmsUserContext userContext,
			String profileId, int profileVersion) throws Exception{
			
		userContext.getDAOGroup().getProfileDAO().delete(profileId, profileVersion);
	}
	
	public Profile forgetByAll(CmsUserContext userContext, String profileId, int profileVersion) throws Exception {
		return forgetByAllInternal(userContext, profileId, profileVersion);		
	}
	protected Profile forgetByAllInternal(CmsUserContext userContext,
			String profileId, int profileVersion) throws Exception{
			
		return userContext.getDAOGroup().getProfileDAO().disconnectFromAll(profileId, profileVersion);
	}
	

	
	public int deleteAll(CmsUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ProfileManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(CmsUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getProfileDAO().deleteAll();
	}


	//disconnect Profile with banner in Target
	protected Profile breakWithTargetByBanner(CmsUserContext userContext, String profileId, String bannerId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Profile profile = loadProfile(userContext, profileId, allTokens());

			synchronized(profile){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getProfileDAO().planToRemoveTargetListWithBanner(profile, bannerId, this.emptyOptions());

				profile = saveProfile(userContext, profile, tokens().withTargetList().done());
				return profile;
			}
	}
	//disconnect Profile with platform in Target
	protected Profile breakWithTargetByPlatform(CmsUserContext userContext, String profileId, String platformId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Profile profile = loadProfile(userContext, profileId, allTokens());

			synchronized(profile){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getProfileDAO().planToRemoveTargetListWithPlatform(profile, platformId, this.emptyOptions());

				profile = saveProfile(userContext, profile, tokens().withTargetList().done());
				return profile;
			}
	}
	//disconnect Profile with platform in UserAlert
	protected Profile breakWithUserAlertByPlatform(CmsUserContext userContext, String profileId, String platformId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Profile profile = loadProfile(userContext, profileId, allTokens());

			synchronized(profile){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getProfileDAO().planToRemoveUserAlertListWithPlatform(profile, platformId, this.emptyOptions());

				profile = saveProfile(userContext, profile, tokens().withUserAlertList().done());
				return profile;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingTarget(CmsUserContext userContext, String profileId, String name, String bannerId, String location, String platformId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfProfile(profileId);

		
		userContext.getChecker().checkNameOfTarget(name);
		
		userContext.getChecker().checkBannerIdOfTarget(bannerId);
		
		userContext.getChecker().checkLocationOfTarget(location);
		
		userContext.getChecker().checkPlatformIdOfTarget(platformId);
	
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);

	
	}
	public  Profile addTarget(CmsUserContext userContext, String profileId, String name, String bannerId, String location, String platformId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingTarget(userContext,profileId,name, bannerId, location, platformId,tokensExpr);
		
		Target target = createTarget(userContext,name, bannerId, location, platformId);
		
		Profile profile = loadProfile(userContext, profileId, allTokens());
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			profile.addTarget( target );		
			profile = saveProfile(userContext, profile, tokens().withTargetList().done());
			
			userContext.getManagerGroup().getTargetManager().onNewInstanceCreated(userContext, target);
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingTargetProperties(CmsUserContext userContext, String profileId,String id,String name,String location,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfProfile(profileId);
		userContext.getChecker().checkIdOfTarget(id);
		
		userContext.getChecker().checkNameOfTarget( name);
		userContext.getChecker().checkLocationOfTarget( location);

		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
		
	}
	public  Profile updateTargetProperties(CmsUserContext userContext, String profileId, String id,String name,String location, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingTargetProperties(userContext,profileId,id,name,location,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withTargetListList()
				.searchTargetListWith(Target.ID_PROPERTY, "is", id).done();
		
		Profile profileToUpdate = loadProfile(userContext, profileId, options);
		
		if(profileToUpdate.getTargetList().isEmpty()){
			throw new ProfileManagerException("Target is NOT FOUND with id: '"+id+"'");
		}
		
		Target item = profileToUpdate.getTargetList().first();
		
		item.updateName( name );
		item.updateLocation( location );

		
		//checkParamsForAddingTarget(userContext,profileId,name, code, used,tokensExpr);
		Profile profile = saveProfile(userContext, profileToUpdate, tokens().withTargetList().done());
		synchronized(profile){ 
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected Target createTarget(CmsUserContext userContext, String name, String bannerId, String location, String platformId) throws Exception{

		Target target = new Target();
		
		
		target.setName(name);		
		Banner  banner = new Banner();
		banner.setId(bannerId);		
		target.setBanner(banner);		
		target.setLocation(location);		
		target.setLastUpdate(userContext.now());		
		Platform  platform = new Platform();
		platform.setId(platformId);		
		target.setPlatform(platform);
	
		
		return target;
	
		
	}
	
	protected Target createIndexedTarget(String id, int version){

		Target target = new Target();
		target.setId(id);
		target.setVersion(version);
		return target;			
		
	}
	
	protected void checkParamsForRemovingTargetList(CmsUserContext userContext, String profileId, 
			String targetIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfProfile(profileId);
		for(String targetId: targetIds){
			userContext.getChecker().checkIdOfTarget(targetId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
		
	}
	public  Profile removeTargetList(CmsUserContext userContext, String profileId, 
			String targetIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingTargetList(userContext, profileId,  targetIds, tokensExpr);
			
			
			Profile profile = loadProfile(userContext, profileId, allTokens());
			synchronized(profile){ 
				//Will be good when the profile loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getProfileDAO().planToRemoveTargetList(profile, targetIds, allTokens());
				profile = saveProfile(userContext, profile, tokens().withTargetList().done());
				deleteRelationListInGraph(userContext, profile.getTargetList());
				return present(userContext,profile, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingTarget(CmsUserContext userContext, String profileId, 
		String targetId, int targetVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfProfile( profileId);
		userContext.getChecker().checkIdOfTarget(targetId);
		userContext.getChecker().checkVersionOfTarget(targetVersion);
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
	
	}
	public  Profile removeTarget(CmsUserContext userContext, String profileId, 
		String targetId, int targetVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingTarget(userContext,profileId, targetId, targetVersion,tokensExpr);
		
		Target target = createIndexedTarget(targetId, targetVersion);
		Profile profile = loadProfile(userContext, profileId, allTokens());
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			profile.removeTarget( target );		
			profile = saveProfile(userContext, profile, tokens().withTargetList().done());
			deleteRelationInGraph(userContext, target);
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingTarget(CmsUserContext userContext, String profileId, 
		String targetId, int targetVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfProfile( profileId);
		userContext.getChecker().checkIdOfTarget(targetId);
		userContext.getChecker().checkVersionOfTarget(targetVersion);
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
	
	}
	public  Profile copyTargetFrom(CmsUserContext userContext, String profileId, 
		String targetId, int targetVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingTarget(userContext,profileId, targetId, targetVersion,tokensExpr);
		
		Target target = createIndexedTarget(targetId, targetVersion);
		Profile profile = loadProfile(userContext, profileId, allTokens());
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			target.updateLastUpdate(userContext.now());
			
			profile.copyTargetFrom( target );		
			profile = saveProfile(userContext, profile, tokens().withTargetList().done());
			
			userContext.getManagerGroup().getTargetManager().onNewInstanceCreated(userContext, (Target)profile.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingTarget(CmsUserContext userContext, String profileId, String targetId, int targetVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfProfile(profileId);
		userContext.getChecker().checkIdOfTarget(targetId);
		userContext.getChecker().checkVersionOfTarget(targetVersion);
		

		if(Target.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfTarget(parseString(newValueExpr));
		}
		
		if(Target.LOCATION_PROPERTY.equals(property)){
			userContext.getChecker().checkLocationOfTarget(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
	
	}
	
	public  Profile updateTarget(CmsUserContext userContext, String profileId, String targetId, int targetVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingTarget(userContext, profileId, targetId, targetVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withTargetList().searchTargetListWith(Target.ID_PROPERTY, "eq", targetId).done();
		
		
		
		Profile profile = loadProfile(userContext, profileId, loadTokens);
		
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//profile.removeTarget( target );	
			//make changes to AcceleraterAccount.
			Target targetIndex = createIndexedTarget(targetId, targetVersion);
		
			Target target = profile.findTheTarget(targetIndex);
			if(target == null){
				throw new ProfileManagerException(target+" is NOT FOUND" );
			}
			
			target.changeProperty(property, newValueExpr);
			target.updateLastUpdate(userContext.now());
			profile = saveProfile(userContext, profile, tokens().withTargetList().done());
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingUserAlert(CmsUserContext userContext, String profileId, String message, String location, String platformId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfProfile(profileId);

		
		userContext.getChecker().checkMessageOfUserAlert(message);
		
		userContext.getChecker().checkLocationOfUserAlert(location);
		
		userContext.getChecker().checkPlatformIdOfUserAlert(platformId);
	
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);

	
	}
	public  Profile addUserAlert(CmsUserContext userContext, String profileId, String message, String location, String platformId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingUserAlert(userContext,profileId,message, location, platformId,tokensExpr);
		
		UserAlert userAlert = createUserAlert(userContext,message, location, platformId);
		
		Profile profile = loadProfile(userContext, profileId, allTokens());
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			profile.addUserAlert( userAlert );		
			profile = saveProfile(userContext, profile, tokens().withUserAlertList().done());
			
			userContext.getManagerGroup().getUserAlertManager().onNewInstanceCreated(userContext, userAlert);
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingUserAlertProperties(CmsUserContext userContext, String profileId,String id,String message,String location,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfProfile(profileId);
		userContext.getChecker().checkIdOfUserAlert(id);
		
		userContext.getChecker().checkMessageOfUserAlert( message);
		userContext.getChecker().checkLocationOfUserAlert( location);

		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
		
	}
	public  Profile updateUserAlertProperties(CmsUserContext userContext, String profileId, String id,String message,String location, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingUserAlertProperties(userContext,profileId,id,message,location,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withUserAlertListList()
				.searchUserAlertListWith(UserAlert.ID_PROPERTY, "is", id).done();
		
		Profile profileToUpdate = loadProfile(userContext, profileId, options);
		
		if(profileToUpdate.getUserAlertList().isEmpty()){
			throw new ProfileManagerException("UserAlert is NOT FOUND with id: '"+id+"'");
		}
		
		UserAlert item = profileToUpdate.getUserAlertList().first();
		
		item.updateMessage( message );
		item.updateLocation( location );

		
		//checkParamsForAddingUserAlert(userContext,profileId,name, code, used,tokensExpr);
		Profile profile = saveProfile(userContext, profileToUpdate, tokens().withUserAlertList().done());
		synchronized(profile){ 
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected UserAlert createUserAlert(CmsUserContext userContext, String message, String location, String platformId) throws Exception{

		UserAlert userAlert = new UserAlert();
		
		
		userAlert.setMessage(message);		
		userAlert.setLocation(location);		
		userAlert.setLastUpdate(userContext.now());		
		Platform  platform = new Platform();
		platform.setId(platformId);		
		userAlert.setPlatform(platform);
	
		
		return userAlert;
	
		
	}
	
	protected UserAlert createIndexedUserAlert(String id, int version){

		UserAlert userAlert = new UserAlert();
		userAlert.setId(id);
		userAlert.setVersion(version);
		return userAlert;			
		
	}
	
	protected void checkParamsForRemovingUserAlertList(CmsUserContext userContext, String profileId, 
			String userAlertIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfProfile(profileId);
		for(String userAlertId: userAlertIds){
			userContext.getChecker().checkIdOfUserAlert(userAlertId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
		
	}
	public  Profile removeUserAlertList(CmsUserContext userContext, String profileId, 
			String userAlertIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingUserAlertList(userContext, profileId,  userAlertIds, tokensExpr);
			
			
			Profile profile = loadProfile(userContext, profileId, allTokens());
			synchronized(profile){ 
				//Will be good when the profile loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getProfileDAO().planToRemoveUserAlertList(profile, userAlertIds, allTokens());
				profile = saveProfile(userContext, profile, tokens().withUserAlertList().done());
				deleteRelationListInGraph(userContext, profile.getUserAlertList());
				return present(userContext,profile, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingUserAlert(CmsUserContext userContext, String profileId, 
		String userAlertId, int userAlertVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfProfile( profileId);
		userContext.getChecker().checkIdOfUserAlert(userAlertId);
		userContext.getChecker().checkVersionOfUserAlert(userAlertVersion);
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
	
	}
	public  Profile removeUserAlert(CmsUserContext userContext, String profileId, 
		String userAlertId, int userAlertVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingUserAlert(userContext,profileId, userAlertId, userAlertVersion,tokensExpr);
		
		UserAlert userAlert = createIndexedUserAlert(userAlertId, userAlertVersion);
		Profile profile = loadProfile(userContext, profileId, allTokens());
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			profile.removeUserAlert( userAlert );		
			profile = saveProfile(userContext, profile, tokens().withUserAlertList().done());
			deleteRelationInGraph(userContext, userAlert);
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingUserAlert(CmsUserContext userContext, String profileId, 
		String userAlertId, int userAlertVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfProfile( profileId);
		userContext.getChecker().checkIdOfUserAlert(userAlertId);
		userContext.getChecker().checkVersionOfUserAlert(userAlertVersion);
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
	
	}
	public  Profile copyUserAlertFrom(CmsUserContext userContext, String profileId, 
		String userAlertId, int userAlertVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingUserAlert(userContext,profileId, userAlertId, userAlertVersion,tokensExpr);
		
		UserAlert userAlert = createIndexedUserAlert(userAlertId, userAlertVersion);
		Profile profile = loadProfile(userContext, profileId, allTokens());
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			userAlert.updateLastUpdate(userContext.now());
			
			profile.copyUserAlertFrom( userAlert );		
			profile = saveProfile(userContext, profile, tokens().withUserAlertList().done());
			
			userContext.getManagerGroup().getUserAlertManager().onNewInstanceCreated(userContext, (UserAlert)profile.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingUserAlert(CmsUserContext userContext, String profileId, String userAlertId, int userAlertVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfProfile(profileId);
		userContext.getChecker().checkIdOfUserAlert(userAlertId);
		userContext.getChecker().checkVersionOfUserAlert(userAlertVersion);
		

		if(UserAlert.MESSAGE_PROPERTY.equals(property)){
			userContext.getChecker().checkMessageOfUserAlert(parseString(newValueExpr));
		}
		
		if(UserAlert.LOCATION_PROPERTY.equals(property)){
			userContext.getChecker().checkLocationOfUserAlert(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(ProfileManagerException.class);
	
	}
	
	public  Profile updateUserAlert(CmsUserContext userContext, String profileId, String userAlertId, int userAlertVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingUserAlert(userContext, profileId, userAlertId, userAlertVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withUserAlertList().searchUserAlertListWith(UserAlert.ID_PROPERTY, "eq", userAlertId).done();
		
		
		
		Profile profile = loadProfile(userContext, profileId, loadTokens);
		
		synchronized(profile){ 
			//Will be good when the profile loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//profile.removeUserAlert( userAlert );	
			//make changes to AcceleraterAccount.
			UserAlert userAlertIndex = createIndexedUserAlert(userAlertId, userAlertVersion);
		
			UserAlert userAlert = profile.findTheUserAlert(userAlertIndex);
			if(userAlert == null){
				throw new ProfileManagerException(userAlert+" is NOT FOUND" );
			}
			
			userAlert.changeProperty(property, newValueExpr);
			userAlert.updateLastUpdate(userContext.now());
			profile = saveProfile(userContext, profile, tokens().withUserAlertList().done());
			return present(userContext,profile, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(CmsUserContext userContext, Profile newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


