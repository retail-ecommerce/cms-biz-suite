
package com.doublechaintech.cms.profile;
import com.doublechaintech.cms.CommonTokens;
import java.util.Map;
public class ProfileTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="profile";
	
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
	protected ProfileTokens(){
		//ensure not initialized outside the class
	}
	
	public ProfileTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static ProfileTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected ProfileTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static ProfileTokens start(){
		return new ProfileTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static ProfileTokens allTokens(){
		
		return start()
			.withPlatform()
			.withTargetList();
	
	}
	public static ProfileTokens withoutListsTokens(){
		
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
	public ProfileTokens withPlatform(){		
		addSimpleOptions(PLATFORM);
		return this;
	}
	
	
	protected static final String TARGET_LIST = "targetList";
	public String getTargetList(){
		return TARGET_LIST;
	}
	public ProfileTokens withTargetList(){		
		addSimpleOptions(TARGET_LIST);
		return this;
	}
	public ProfileTokens analyzeTargetList(){		
		addSimpleOptions(TARGET_LIST+".anaylze");
		return this;
	}
	public boolean analyzeTargetListEnabled(){		
		
		return checkOptions(this.options(), TARGET_LIST+".anaylze");
	}
	public ProfileTokens extractMoreFromTargetList(String idsSeperatedWithComma){		
		addSimpleOptions(TARGET_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int targetListSortCounter = 0;
	public ProfileTokens sortTargetListWith(String field, String descOrAsc){		
		addSortMoreOptions(TARGET_LIST,targetListSortCounter++, field, descOrAsc);
		return this;
	}
	private int targetListSearchCounter = 0;
	public ProfileTokens searchTargetListWith(String field, String verb, String value){		
		addSearchMoreOptions(TARGET_LIST,targetListSearchCounter++, field, verb, value);
		return this;
	}
	
	public ProfileTokens searchAllTextOfTargetList(String verb, String value){	
		String field = "id|name|location";
		addSearchMoreOptions(TARGET_LIST,targetListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public ProfileTokens rowsPerPageOfTargetList(int rowsPerPage){		
		addSimpleOptions(TARGET_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public ProfileTokens currentPageNumberOfTargetList(int currentPageNumber){		
		addSimpleOptions(TARGET_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public ProfileTokens retainColumnsOfTargetList(String[] columns){		
		addSimpleOptions(TARGET_LIST+"RetainColumns",columns);
		return this;
	}
	public ProfileTokens excludeColumnsOfTargetList(String[] columns){		
		addSimpleOptions(TARGET_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  ProfileTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfTargetList(verb, value);	
		return this;
	}
}

