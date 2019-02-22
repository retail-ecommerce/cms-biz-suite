
package com.doublechaintech.cms.profile;

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
import com.doublechaintech.cms.platform.Platform;

@JsonSerialize(using = ProfileSerializer.class)
public class Profile extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String PLATFORM_PROPERTY              = "platform"          ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String TARGET_LIST                              = "targetList"        ;
	public static final String USER_ALERT_LIST                          = "userAlertList"     ;

	public static final String INTERNAL_TYPE="Profile";
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
	protected		Platform            	mPlatform           ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<Target>   	mTargetList         ;
	protected		SmartList<UserAlert>	mUserAlertList      ;
	
		
	public 	Profile(){
		//lazy load for all the properties
	}
	//disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setPlatform( null );

		this.changed = true;
	}
	
	public 	Profile(String name, Platform platform)
	{
		setName(name);
		setPlatform(platform);

		this.mTargetList = new SmartList<Target>();
		this.mUserAlertList = new SmartList<UserAlert>();	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
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
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	public Profile updateId(String id){
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
	public Profile updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}
	
	
	public void setPlatform(Platform platform){
		this.mPlatform = platform;;
	}
	public Platform getPlatform(){
		return this.mPlatform;
	}
	public Profile updatePlatform(Platform platform){
		this.mPlatform = platform;;
		this.changed = true;
		return this;
	}
	public void mergePlatform(Platform platform){
		if(platform != null) { setPlatform(platform);}
	}
	
	
	public void clearPlatform(){
		setPlatform ( null );
		this.changed = true;
	}
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public Profile updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
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
			target.setProfile(this);
		}

		this.mTargetList = targetList;
		this.mTargetList.setListInternalName (TARGET_LIST );
		
	}
	
	public  void addTarget(Target target){
		target.setProfile(this);
		getTargetList().add(target);
	}
	public  void addTargetList(SmartList<Target> targetList){
		for( Target target:targetList){
			target.setProfile(this);
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
        // target.clearProfile(); //disconnect with Profile
        target.clearFromAll(); //disconnect with Profile
		
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
		target.setProfile(null);
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
			userAlert.setProfile(this);
		}

		this.mUserAlertList = userAlertList;
		this.mUserAlertList.setListInternalName (USER_ALERT_LIST );
		
	}
	
	public  void addUserAlert(UserAlert userAlert){
		userAlert.setProfile(this);
		getUserAlertList().add(userAlert);
	}
	public  void addUserAlertList(SmartList<UserAlert> userAlertList){
		for( UserAlert userAlert:userAlertList){
			userAlert.setProfile(this);
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
        // userAlert.clearProfile(); //disconnect with Profile
        userAlert.clearFromAll(); //disconnect with Profile
		
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
		userAlert.setProfile(null);
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

		addToEntityList(this, entityList, getPlatform(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getTargetList(), internalType);
		collectFromList(this, entityList, getUserAlertList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getTargetList());
		listOfList.add( getUserAlertList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, PLATFORM_PROPERTY, getPlatform());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
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
		
		
		if(baseDest instanceof Profile){
		
		
			Profile dest =(Profile)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setPlatform(getPlatform());
			dest.setVersion(getVersion());
			dest.setTargetList(getTargetList());
			dest.setUserAlertList(getUserAlertList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Profile){
		
			
			Profile dest =(Profile)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergePlatform(getPlatform());
			dest.mergeVersion(getVersion());
			dest.mergeTargetList(getTargetList());
			dest.mergeUserAlertList(getUserAlertList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("Profile{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		if(getPlatform() != null ){
 			stringBuilder.append("\tplatform='Platform("+getPlatform().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

