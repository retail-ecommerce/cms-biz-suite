
package com.doublechaintech.cms.useralert;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.doublechaintech.cms.BaseEntity;
import com.doublechaintech.cms.SmartList;
import com.doublechaintech.cms.KeyValuePair;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.doublechaintech.cms.platform.Platform;
import com.doublechaintech.cms.profile.Profile;

@JsonSerialize(using = UserAlertSerializer.class)
public class UserAlert extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String MESSAGE_PROPERTY               = "message"           ;
	public static final String PROFILE_PROPERTY               = "profile"           ;
	public static final String LOCATION_PROPERTY              = "location"          ;
	public static final String LAST_UPDATE_PROPERTY           = "lastUpdate"        ;
	public static final String PLATFORM_PROPERTY              = "platform"          ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="UserAlert";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}
	
	public String getDisplayName(){
	
		String displayName = getMessage();
		if(displayName!=null){
			return displayName;
		}
		
		return super.getDisplayName();
		
	}

	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mMessage            ;
	protected		Profile             	mProfile            ;
	protected		String              	mLocation           ;
	protected		DateTime            	mLastUpdate         ;
	protected		Platform            	mPlatform           ;
	protected		int                 	mVersion            ;
	
	
	
		
	public 	UserAlert(){
		//lazy load for all the properties
	}
	//disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setProfile( null );
		setPlatform( null );

		this.changed = true;
	}
	
	public 	UserAlert(String message, Profile profile, String location, DateTime lastUpdate, Platform platform)
	{
		setMessage(message);
		setProfile(profile);
		setLocation(location);
		setLastUpdate(lastUpdate);
		setPlatform(platform);
	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(MESSAGE_PROPERTY.equals(property)){
			changeMessageProperty(newValueExpr);
		}
		if(LOCATION_PROPERTY.equals(property)){
			changeLocationProperty(newValueExpr);
		}
		if(LAST_UPDATE_PROPERTY.equals(property)){
			changeLastUpdateProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeMessageProperty(String newValueExpr){
		String oldValue = getMessage();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateMessage(newValue);
		this.onChangeProperty(MESSAGE_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeLocationProperty(String newValueExpr){
		String oldValue = getLocation();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateLocation(newValue);
		this.onChangeProperty(LOCATION_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeLastUpdateProperty(String newValueExpr){
		DateTime oldValue = getLastUpdate();
		DateTime newValue = parseTimestamp(newValueExpr);
		if(equalsTimestamp(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateLastUpdate(newValue);
		this.onChangeProperty(LAST_UPDATE_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	public UserAlert updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}
	
	
	public void setMessage(String message){
		this.mMessage = trimString(message);;
	}
	public String getMessage(){
		return this.mMessage;
	}
	public UserAlert updateMessage(String message){
		this.mMessage = trimString(message);;
		this.changed = true;
		return this;
	}
	public void mergeMessage(String message){
		if(message != null) { setMessage(message);}
	}
	
	
	public void setProfile(Profile profile){
		this.mProfile = profile;;
	}
	public Profile getProfile(){
		return this.mProfile;
	}
	public UserAlert updateProfile(Profile profile){
		this.mProfile = profile;;
		this.changed = true;
		return this;
	}
	public void mergeProfile(Profile profile){
		if(profile != null) { setProfile(profile);}
	}
	
	
	public void clearProfile(){
		setProfile ( null );
		this.changed = true;
	}
	
	public void setLocation(String location){
		this.mLocation = trimString(location);;
	}
	public String getLocation(){
		return this.mLocation;
	}
	public UserAlert updateLocation(String location){
		this.mLocation = trimString(location);;
		this.changed = true;
		return this;
	}
	public void mergeLocation(String location){
		if(location != null) { setLocation(location);}
	}
	
	
	public void setLastUpdate(DateTime lastUpdate){
		this.mLastUpdate = lastUpdate;;
	}
	public DateTime getLastUpdate(){
		return this.mLastUpdate;
	}
	public UserAlert updateLastUpdate(DateTime lastUpdate){
		this.mLastUpdate = lastUpdate;;
		this.changed = true;
		return this;
	}
	public void mergeLastUpdate(DateTime lastUpdate){
		setLastUpdate(lastUpdate);
	}
	
	
	public void setPlatform(Platform platform){
		this.mPlatform = platform;;
	}
	public Platform getPlatform(){
		return this.mPlatform;
	}
	public UserAlert updatePlatform(Platform platform){
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
	public UserAlert updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getProfile(), internalType);
		addToEntityList(this, entityList, getPlatform(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, MESSAGE_PROPERTY, getMessage());
		appendKeyValuePair(result, PROFILE_PROPERTY, getProfile());
		appendKeyValuePair(result, LOCATION_PROPERTY, getLocation());
		appendKeyValuePair(result, LAST_UPDATE_PROPERTY, getLastUpdate());
		appendKeyValuePair(result, PLATFORM_PROPERTY, getPlatform());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof UserAlert){
		
		
			UserAlert dest =(UserAlert)baseDest;
		
			dest.setId(getId());
			dest.setMessage(getMessage());
			dest.setProfile(getProfile());
			dest.setLocation(getLocation());
			dest.setLastUpdate(getLastUpdate());
			dest.setPlatform(getPlatform());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof UserAlert){
		
			
			UserAlert dest =(UserAlert)baseDest;
		
			dest.mergeId(getId());
			dest.mergeMessage(getMessage());
			dest.mergeProfile(getProfile());
			dest.mergeLocation(getLocation());
			dest.mergeLastUpdate(getLastUpdate());
			dest.mergePlatform(getPlatform());
			dest.mergeVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("UserAlert{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tmessage='"+getMessage()+"';");
		if(getProfile() != null ){
 			stringBuilder.append("\tprofile='Profile("+getProfile().getId()+")';");
 		}
		stringBuilder.append("\tlocation='"+getLocation()+"';");
		stringBuilder.append("\tlastUpdate='"+getLastUpdate()+"';");
		if(getPlatform() != null ){
 			stringBuilder.append("\tplatform='Platform("+getPlatform().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

