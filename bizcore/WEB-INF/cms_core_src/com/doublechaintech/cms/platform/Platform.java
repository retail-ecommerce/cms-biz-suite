
package com.doublechaintech.cms.platform;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.doublechaintech.cms.BaseEntity;
import com.doublechaintech.cms.SmartList;
import com.doublechaintech.cms.KeyValuePair;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.doublechaintech.cms.target.Target;
import com.doublechaintech.cms.useralert.UserAlert;
import com.doublechaintech.cms.banner.Banner;
import com.doublechaintech.cms.profile.Profile;
import com.doublechaintech.cms.alertbar.AlertBar;

@JsonSerialize(using = PlatformSerializer.class)
public class Platform extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String INTRODUCTION_PROPERTY          = "introduction"      ;
	public static final String CURRENT_VERSION_PROPERTY       = "currentVersion"    ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String ALERT_BAR_LIST                           = "alertBarList"      ;
	public static final String BANNER_LIST                              = "bannerList"        ;
	public static final String PROFILE_LIST                             = "profileList"       ;
	public static final String TARGET_LIST                              = "targetList"        ;
	public static final String USER_ALERT_LIST                          = "userAlertList"     ;

	public static final String INTERNAL_TYPE="Platform";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}
	
	public String getDisplayName(){
	
		String displayName = getName();
		if(displayName!=null){
			return displayName;
		}
		
		return super.getDisplayName();
		
	}

	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mName               ;
	protected		String              	mIntroduction       ;
	protected		String              	mCurrentVersion     ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<AlertBar> 	mAlertBarList       ;
	protected		SmartList<Banner>   	mBannerList         ;
	protected		SmartList<Profile>  	mProfileList        ;
	protected		SmartList<Target>   	mTargetList         ;
	protected		SmartList<UserAlert>	mUserAlertList      ;
	
		
	public 	Platform(){
		//lazy load for all the properties
	}
	//disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){

		this.changed = true;
	}
	
	public 	Platform(String name, String introduction, String currentVersion)
	{
		setName(name);
		setIntroduction(introduction);
		setCurrentVersion(currentVersion);

		this.mAlertBarList = new SmartList<AlertBar>();
		this.mBannerList = new SmartList<Banner>();
		this.mProfileList = new SmartList<Profile>();
		this.mTargetList = new SmartList<Target>();
		this.mUserAlertList = new SmartList<UserAlert>();	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(INTRODUCTION_PROPERTY.equals(property)){
			changeIntroductionProperty(newValueExpr);
		}
		if(CURRENT_VERSION_PROPERTY.equals(property)){
			changeCurrentVersionProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeNameProperty(String newValueExpr){
		String oldValue = getName();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateName(newValue);
		this.onChangeProperty(NAME_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeIntroductionProperty(String newValueExpr){
		String oldValue = getIntroduction();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateIntroduction(newValue);
		this.onChangeProperty(INTRODUCTION_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeCurrentVersionProperty(String newValueExpr){
		String oldValue = getCurrentVersion();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateCurrentVersion(newValue);
		this.onChangeProperty(CURRENT_VERSION_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	public Platform updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}
	
	
	public void setName(String name){
		this.mName = trimString(name);;
	}
	public String getName(){
		return this.mName;
	}
	public Platform updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}
	
	
	public void setIntroduction(String introduction){
		this.mIntroduction = trimString(introduction);;
	}
	public String getIntroduction(){
		return this.mIntroduction;
	}
	public Platform updateIntroduction(String introduction){
		this.mIntroduction = trimString(introduction);;
		this.changed = true;
		return this;
	}
	public void mergeIntroduction(String introduction){
		if(introduction != null) { setIntroduction(introduction);}
	}
	
	
	public void setCurrentVersion(String currentVersion){
		this.mCurrentVersion = trimString(currentVersion);;
	}
	public String getCurrentVersion(){
		return this.mCurrentVersion;
	}
	public Platform updateCurrentVersion(String currentVersion){
		this.mCurrentVersion = trimString(currentVersion);;
		this.changed = true;
		return this;
	}
	public void mergeCurrentVersion(String currentVersion){
		if(currentVersion != null) { setCurrentVersion(currentVersion);}
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public Platform updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public  SmartList<AlertBar> getAlertBarList(){
		if(this.mAlertBarList == null){
			this.mAlertBarList = new SmartList<AlertBar>();
			this.mAlertBarList.setListInternalName (ALERT_BAR_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mAlertBarList;	
	}
	public  void setAlertBarList(SmartList<AlertBar> alertBarList){
		for( AlertBar alertBar:alertBarList){
			alertBar.setPlatform(this);
		}

		this.mAlertBarList = alertBarList;
		this.mAlertBarList.setListInternalName (ALERT_BAR_LIST );
		
	}
	
	public  void addAlertBar(AlertBar alertBar){
		alertBar.setPlatform(this);
		getAlertBarList().add(alertBar);
	}
	public  void addAlertBarList(SmartList<AlertBar> alertBarList){
		for( AlertBar alertBar:alertBarList){
			alertBar.setPlatform(this);
		}
		getAlertBarList().addAll(alertBarList);
	}
	public  void mergeAlertBarList(SmartList<AlertBar> alertBarList){
		if(alertBarList==null){
			return;
		}
		if(alertBarList.isEmpty()){
			return;
		}
		addAlertBarList( alertBarList );
		
	}
	public  AlertBar removeAlertBar(AlertBar alertBarIndex){
		
		int index = getAlertBarList().indexOf(alertBarIndex);
        if(index < 0){
        	String message = "AlertBar("+alertBarIndex.getId()+") with version='"+alertBarIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        AlertBar alertBar = getAlertBarList().get(index);        
        // alertBar.clearPlatform(); //disconnect with Platform
        alertBar.clearFromAll(); //disconnect with Platform
		
		boolean result = getAlertBarList().planToRemove(alertBar);
        if(!result){
        	String message = "AlertBar("+alertBarIndex.getId()+") with version='"+alertBarIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return alertBar;
        
	
	}
	//断舍离
	public  void breakWithAlertBar(AlertBar alertBar){
		
		if(alertBar == null){
			return;
		}
		alertBar.setPlatform(null);
		//getAlertBarList().remove();
	
	}
	
	public  boolean hasAlertBar(AlertBar alertBar){
	
		return getAlertBarList().contains(alertBar);
  
	}
	
	public void copyAlertBarFrom(AlertBar alertBar) {

		AlertBar alertBarInList = findTheAlertBar(alertBar);
		AlertBar newAlertBar = new AlertBar();
		alertBarInList.copyTo(newAlertBar);
		newAlertBar.setVersion(0);//will trigger copy
		getAlertBarList().add(newAlertBar);
		addItemToFlexiableObject(COPIED_CHILD, newAlertBar);
	}
	
	public  AlertBar findTheAlertBar(AlertBar alertBar){
		
		int index =  getAlertBarList().indexOf(alertBar);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "AlertBar("+alertBar.getId()+") with version='"+alertBar.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getAlertBarList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpAlertBarList(){
		getAlertBarList().clear();
	}
	
	
	


	public  SmartList<Banner> getBannerList(){
		if(this.mBannerList == null){
			this.mBannerList = new SmartList<Banner>();
			this.mBannerList.setListInternalName (BANNER_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mBannerList;	
	}
	public  void setBannerList(SmartList<Banner> bannerList){
		for( Banner banner:bannerList){
			banner.setPlatform(this);
		}

		this.mBannerList = bannerList;
		this.mBannerList.setListInternalName (BANNER_LIST );
		
	}
	
	public  void addBanner(Banner banner){
		banner.setPlatform(this);
		getBannerList().add(banner);
	}
	public  void addBannerList(SmartList<Banner> bannerList){
		for( Banner banner:bannerList){
			banner.setPlatform(this);
		}
		getBannerList().addAll(bannerList);
	}
	public  void mergeBannerList(SmartList<Banner> bannerList){
		if(bannerList==null){
			return;
		}
		if(bannerList.isEmpty()){
			return;
		}
		addBannerList( bannerList );
		
	}
	public  Banner removeBanner(Banner bannerIndex){
		
		int index = getBannerList().indexOf(bannerIndex);
        if(index < 0){
        	String message = "Banner("+bannerIndex.getId()+") with version='"+bannerIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        Banner banner = getBannerList().get(index);        
        // banner.clearPlatform(); //disconnect with Platform
        banner.clearFromAll(); //disconnect with Platform
		
		boolean result = getBannerList().planToRemove(banner);
        if(!result){
        	String message = "Banner("+bannerIndex.getId()+") with version='"+bannerIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return banner;
        
	
	}
	//断舍离
	public  void breakWithBanner(Banner banner){
		
		if(banner == null){
			return;
		}
		banner.setPlatform(null);
		//getBannerList().remove();
	
	}
	
	public  boolean hasBanner(Banner banner){
	
		return getBannerList().contains(banner);
  
	}
	
	public void copyBannerFrom(Banner banner) {

		Banner bannerInList = findTheBanner(banner);
		Banner newBanner = new Banner();
		bannerInList.copyTo(newBanner);
		newBanner.setVersion(0);//will trigger copy
		getBannerList().add(newBanner);
		addItemToFlexiableObject(COPIED_CHILD, newBanner);
	}
	
	public  Banner findTheBanner(Banner banner){
		
		int index =  getBannerList().indexOf(banner);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "Banner("+banner.getId()+") with version='"+banner.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getBannerList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpBannerList(){
		getBannerList().clear();
	}
	
	
	


	public  SmartList<Profile> getProfileList(){
		if(this.mProfileList == null){
			this.mProfileList = new SmartList<Profile>();
			this.mProfileList.setListInternalName (PROFILE_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mProfileList;	
	}
	public  void setProfileList(SmartList<Profile> profileList){
		for( Profile profile:profileList){
			profile.setPlatform(this);
		}

		this.mProfileList = profileList;
		this.mProfileList.setListInternalName (PROFILE_LIST );
		
	}
	
	public  void addProfile(Profile profile){
		profile.setPlatform(this);
		getProfileList().add(profile);
	}
	public  void addProfileList(SmartList<Profile> profileList){
		for( Profile profile:profileList){
			profile.setPlatform(this);
		}
		getProfileList().addAll(profileList);
	}
	public  void mergeProfileList(SmartList<Profile> profileList){
		if(profileList==null){
			return;
		}
		if(profileList.isEmpty()){
			return;
		}
		addProfileList( profileList );
		
	}
	public  Profile removeProfile(Profile profileIndex){
		
		int index = getProfileList().indexOf(profileIndex);
        if(index < 0){
        	String message = "Profile("+profileIndex.getId()+") with version='"+profileIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        Profile profile = getProfileList().get(index);        
        // profile.clearPlatform(); //disconnect with Platform
        profile.clearFromAll(); //disconnect with Platform
		
		boolean result = getProfileList().planToRemove(profile);
        if(!result){
        	String message = "Profile("+profileIndex.getId()+") with version='"+profileIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return profile;
        
	
	}
	//断舍离
	public  void breakWithProfile(Profile profile){
		
		if(profile == null){
			return;
		}
		profile.setPlatform(null);
		//getProfileList().remove();
	
	}
	
	public  boolean hasProfile(Profile profile){
	
		return getProfileList().contains(profile);
  
	}
	
	public void copyProfileFrom(Profile profile) {

		Profile profileInList = findTheProfile(profile);
		Profile newProfile = new Profile();
		profileInList.copyTo(newProfile);
		newProfile.setVersion(0);//will trigger copy
		getProfileList().add(newProfile);
		addItemToFlexiableObject(COPIED_CHILD, newProfile);
	}
	
	public  Profile findTheProfile(Profile profile){
		
		int index =  getProfileList().indexOf(profile);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "Profile("+profile.getId()+") with version='"+profile.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getProfileList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpProfileList(){
		getProfileList().clear();
	}
	
	
	


	public  SmartList<Target> getTargetList(){
		if(this.mTargetList == null){
			this.mTargetList = new SmartList<Target>();
			this.mTargetList.setListInternalName (TARGET_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mTargetList;	
	}
	public  void setTargetList(SmartList<Target> targetList){
		for( Target target:targetList){
			target.setPlatform(this);
		}

		this.mTargetList = targetList;
		this.mTargetList.setListInternalName (TARGET_LIST );
		
	}
	
	public  void addTarget(Target target){
		target.setPlatform(this);
		getTargetList().add(target);
	}
	public  void addTargetList(SmartList<Target> targetList){
		for( Target target:targetList){
			target.setPlatform(this);
		}
		getTargetList().addAll(targetList);
	}
	public  void mergeTargetList(SmartList<Target> targetList){
		if(targetList==null){
			return;
		}
		if(targetList.isEmpty()){
			return;
		}
		addTargetList( targetList );
		
	}
	public  Target removeTarget(Target targetIndex){
		
		int index = getTargetList().indexOf(targetIndex);
        if(index < 0){
        	String message = "Target("+targetIndex.getId()+") with version='"+targetIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        Target target = getTargetList().get(index);        
        // target.clearPlatform(); //disconnect with Platform
        target.clearFromAll(); //disconnect with Platform
		
		boolean result = getTargetList().planToRemove(target);
        if(!result){
        	String message = "Target("+targetIndex.getId()+") with version='"+targetIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return target;
        
	
	}
	//断舍离
	public  void breakWithTarget(Target target){
		
		if(target == null){
			return;
		}
		target.setPlatform(null);
		//getTargetList().remove();
	
	}
	
	public  boolean hasTarget(Target target){
	
		return getTargetList().contains(target);
  
	}
	
	public void copyTargetFrom(Target target) {

		Target targetInList = findTheTarget(target);
		Target newTarget = new Target();
		targetInList.copyTo(newTarget);
		newTarget.setVersion(0);//will trigger copy
		getTargetList().add(newTarget);
		addItemToFlexiableObject(COPIED_CHILD, newTarget);
	}
	
	public  Target findTheTarget(Target target){
		
		int index =  getTargetList().indexOf(target);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "Target("+target.getId()+") with version='"+target.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getTargetList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpTargetList(){
		getTargetList().clear();
	}
	
	
	


	public  SmartList<UserAlert> getUserAlertList(){
		if(this.mUserAlertList == null){
			this.mUserAlertList = new SmartList<UserAlert>();
			this.mUserAlertList.setListInternalName (USER_ALERT_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mUserAlertList;	
	}
	public  void setUserAlertList(SmartList<UserAlert> userAlertList){
		for( UserAlert userAlert:userAlertList){
			userAlert.setPlatform(this);
		}

		this.mUserAlertList = userAlertList;
		this.mUserAlertList.setListInternalName (USER_ALERT_LIST );
		
	}
	
	public  void addUserAlert(UserAlert userAlert){
		userAlert.setPlatform(this);
		getUserAlertList().add(userAlert);
	}
	public  void addUserAlertList(SmartList<UserAlert> userAlertList){
		for( UserAlert userAlert:userAlertList){
			userAlert.setPlatform(this);
		}
		getUserAlertList().addAll(userAlertList);
	}
	public  void mergeUserAlertList(SmartList<UserAlert> userAlertList){
		if(userAlertList==null){
			return;
		}
		if(userAlertList.isEmpty()){
			return;
		}
		addUserAlertList( userAlertList );
		
	}
	public  UserAlert removeUserAlert(UserAlert userAlertIndex){
		
		int index = getUserAlertList().indexOf(userAlertIndex);
        if(index < 0){
        	String message = "UserAlert("+userAlertIndex.getId()+") with version='"+userAlertIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        UserAlert userAlert = getUserAlertList().get(index);        
        // userAlert.clearPlatform(); //disconnect with Platform
        userAlert.clearFromAll(); //disconnect with Platform
		
		boolean result = getUserAlertList().planToRemove(userAlert);
        if(!result){
        	String message = "UserAlert("+userAlertIndex.getId()+") with version='"+userAlertIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return userAlert;
        
	
	}
	//断舍离
	public  void breakWithUserAlert(UserAlert userAlert){
		
		if(userAlert == null){
			return;
		}
		userAlert.setPlatform(null);
		//getUserAlertList().remove();
	
	}
	
	public  boolean hasUserAlert(UserAlert userAlert){
	
		return getUserAlertList().contains(userAlert);
  
	}
	
	public void copyUserAlertFrom(UserAlert userAlert) {

		UserAlert userAlertInList = findTheUserAlert(userAlert);
		UserAlert newUserAlert = new UserAlert();
		userAlertInList.copyTo(newUserAlert);
		newUserAlert.setVersion(0);//will trigger copy
		getUserAlertList().add(newUserAlert);
		addItemToFlexiableObject(COPIED_CHILD, newUserAlert);
	}
	
	public  UserAlert findTheUserAlert(UserAlert userAlert){
		
		int index =  getUserAlertList().indexOf(userAlert);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "UserAlert("+userAlert.getId()+") with version='"+userAlert.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getUserAlertList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpUserAlertList(){
		getUserAlertList().clear();
	}
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){


		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getAlertBarList(), internalType);
		collectFromList(this, entityList, getBannerList(), internalType);
		collectFromList(this, entityList, getProfileList(), internalType);
		collectFromList(this, entityList, getTargetList(), internalType);
		collectFromList(this, entityList, getUserAlertList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getAlertBarList());
		listOfList.add( getBannerList());
		listOfList.add( getProfileList());
		listOfList.add( getTargetList());
		listOfList.add( getUserAlertList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, INTRODUCTION_PROPERTY, getIntroduction());
		appendKeyValuePair(result, CURRENT_VERSION_PROPERTY, getCurrentVersion());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, ALERT_BAR_LIST, getAlertBarList());
		if(!getAlertBarList().isEmpty()){
			appendKeyValuePair(result, "alertBarCount", getAlertBarList().getTotalCount());
			appendKeyValuePair(result, "alertBarCurrentPageNumber", getAlertBarList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, BANNER_LIST, getBannerList());
		if(!getBannerList().isEmpty()){
			appendKeyValuePair(result, "bannerCount", getBannerList().getTotalCount());
			appendKeyValuePair(result, "bannerCurrentPageNumber", getBannerList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, PROFILE_LIST, getProfileList());
		if(!getProfileList().isEmpty()){
			appendKeyValuePair(result, "profileCount", getProfileList().getTotalCount());
			appendKeyValuePair(result, "profileCurrentPageNumber", getProfileList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, TARGET_LIST, getTargetList());
		if(!getTargetList().isEmpty()){
			appendKeyValuePair(result, "targetCount", getTargetList().getTotalCount());
			appendKeyValuePair(result, "targetCurrentPageNumber", getTargetList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, USER_ALERT_LIST, getUserAlertList());
		if(!getUserAlertList().isEmpty()){
			appendKeyValuePair(result, "userAlertCount", getUserAlertList().getTotalCount());
			appendKeyValuePair(result, "userAlertCurrentPageNumber", getUserAlertList().getCurrentPageNumber());
		}

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Platform){
		
		
			Platform dest =(Platform)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setIntroduction(getIntroduction());
			dest.setCurrentVersion(getCurrentVersion());
			dest.setVersion(getVersion());
			dest.setAlertBarList(getAlertBarList());
			dest.setBannerList(getBannerList());
			dest.setProfileList(getProfileList());
			dest.setTargetList(getTargetList());
			dest.setUserAlertList(getUserAlertList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Platform){
		
			
			Platform dest =(Platform)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeIntroduction(getIntroduction());
			dest.mergeCurrentVersion(getCurrentVersion());
			dest.mergeVersion(getVersion());
			dest.mergeAlertBarList(getAlertBarList());
			dest.mergeBannerList(getBannerList());
			dest.mergeProfileList(getProfileList());
			dest.mergeTargetList(getTargetList());
			dest.mergeUserAlertList(getUserAlertList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("Platform{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tintroduction='"+getIntroduction()+"';");
		stringBuilder.append("\tcurrentVersion='"+getCurrentVersion()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

