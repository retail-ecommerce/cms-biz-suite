
package com.doublechaintech.cms.alertbar;
import com.doublechaintech.cms.CommonTokens;
import java.util.Map;
public class AlertBarTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="alertBar";
	
	public static boolean checkOptions(Map<String,Object> options, String optionToCheck){
		
		if(options==null){
 			return false; //completely no option here
 		}
 		if(options.containsKey(ALL)){
 			//danger, debug only, might load the entire database!, really terrible
 			return true;
 		}
		String ownerKey = getOwnerObjectKey();
		Object ownerObject =(String) options.get(ownerKey);
		if(ownerObject ==  null){
			return false;
		}
		if(!ownerObject.equals(OWNER_OBJECT_NAME)){ //is the owner? 
			return false; 
		}
		
 		if(options.containsKey(optionToCheck)){
 			//options.remove(optionToCheck);
 			//consume the key, can not use any more to extract the data with the same token.			
 			return true;
 		}
 		
 		return false;
	
	}
	protected AlertBarTokens(){
		//ensure not initialized outside the class
	}
	
	public AlertBarTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static AlertBarTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected AlertBarTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static AlertBarTokens start(){
		return new AlertBarTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static AlertBarTokens allTokens(){
		
		return start()
			.withPlatform();
	
	}
	public static AlertBarTokens withoutListsTokens(){
		
		return start()
			.withPlatform();
	
	}
	
	public static Map <String,Object> all(){
		return allTokens().done();
	}
	public static Map <String,Object> withoutLists(){
		return withoutListsTokens().done();
	}
	public static Map <String,Object> empty(){
		return start().done();
	}

	protected static final String PLATFORM = "platform";
	public String getPlatform(){
		return PLATFORM;
	}
	public AlertBarTokens withPlatform(){		
		addSimpleOptions(PLATFORM);
		return this;
	}
	
	
	
	public  AlertBarTokens searchEntireObjectText(String verb, String value){
		
		return this;
	}
}
