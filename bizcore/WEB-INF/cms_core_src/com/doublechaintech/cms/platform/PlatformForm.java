package com.doublechaintech.cms.platform;
import com.doublechaintech.cms.BaseForm;
import com.doublechaintech.cms.genericform.GenericForm;
import com.doublechaintech.cms.formfield.FormField;
import com.doublechaintech.cms.formaction.FormAction;
import com.doublechaintech.cms.formmessage.FormMessage;
import com.doublechaintech.cms.formfieldmessage.FormFieldMessage;



public class PlatformForm extends BaseForm {
	
	
	public PlatformForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public PlatformForm platformIdField(String parameterName, String initValue){
		FormField field = idFromPlatform(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm platformIdField(String initValue){
		return platformIdField("platformId",initValue);
	}
	public PlatformForm platformIdField(){
		return platformIdField("platformId","");
	}


	public PlatformForm nameField(String parameterName, String initValue){
		FormField field = nameFromPlatform(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public PlatformForm nameField(){
		return nameField("name","");
	}


	public PlatformForm introductionField(String parameterName, String initValue){
		FormField field = introductionFromPlatform(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm introductionField(String initValue){
		return introductionField("introduction",initValue);
	}
	public PlatformForm introductionField(){
		return introductionField("introduction","");
	}


	public PlatformForm currentVersionField(String parameterName, String initValue){
		FormField field = currentVersionFromPlatform(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm currentVersionField(String initValue){
		return currentVersionField("currentVersion",initValue);
	}
	public PlatformForm currentVersionField(){
		return currentVersionField("currentVersion","");
	}

	
	

	



	public PlatformForm bannerIdFieldForBanner(String parameterName, String initValue){
		FormField field =  idFromBanner(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm bannerIdFieldForBanner(String initValue){
		return bannerIdFieldForBanner("bannerId",initValue);
	}
	public PlatformForm bannerIdFieldForBanner(){
		return bannerIdFieldForBanner("bannerId","");
	}


	public PlatformForm nameFieldForBanner(String parameterName, String initValue){
		FormField field =  nameFromBanner(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm nameFieldForBanner(String initValue){
		return nameFieldForBanner("name",initValue);
	}
	public PlatformForm nameFieldForBanner(){
		return nameFieldForBanner("name","");
	}


	public PlatformForm imagePathFieldForBanner(String parameterName, String initValue){
		FormField field =  imagePathFromBanner(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm imagePathFieldForBanner(String initValue){
		return imagePathFieldForBanner("imagePath",initValue);
	}
	public PlatformForm imagePathFieldForBanner(){
		return imagePathFieldForBanner("imagePath","");
	}


	public PlatformForm lastUpdateFieldForBanner(String parameterName, String initValue){
		FormField field =  lastUpdateFromBanner(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm lastUpdateFieldForBanner(String initValue){
		return lastUpdateFieldForBanner("lastUpdate",initValue);
	}
	public PlatformForm lastUpdateFieldForBanner(){
		return lastUpdateFieldForBanner("lastUpdate","");
	}


	public PlatformForm platformIdFieldForBanner(String parameterName, String initValue){
		FormField field =  platformIdFromBanner(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm platformIdFieldForBanner(String initValue){
		return platformIdFieldForBanner("platformId",initValue);
	}
	public PlatformForm platformIdFieldForBanner(){
		return platformIdFieldForBanner("platformId","");
	}


	public PlatformForm profileIdFieldForProfile(String parameterName, String initValue){
		FormField field =  idFromProfile(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm profileIdFieldForProfile(String initValue){
		return profileIdFieldForProfile("profileId",initValue);
	}
	public PlatformForm profileIdFieldForProfile(){
		return profileIdFieldForProfile("profileId","");
	}


	public PlatformForm nameFieldForProfile(String parameterName, String initValue){
		FormField field =  nameFromProfile(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm nameFieldForProfile(String initValue){
		return nameFieldForProfile("name",initValue);
	}
	public PlatformForm nameFieldForProfile(){
		return nameFieldForProfile("name","");
	}


	public PlatformForm platformIdFieldForProfile(String parameterName, String initValue){
		FormField field =  platformIdFromProfile(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm platformIdFieldForProfile(String initValue){
		return platformIdFieldForProfile("platformId",initValue);
	}
	public PlatformForm platformIdFieldForProfile(){
		return platformIdFieldForProfile("platformId","");
	}


	public PlatformForm targetIdFieldForTarget(String parameterName, String initValue){
		FormField field =  idFromTarget(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm targetIdFieldForTarget(String initValue){
		return targetIdFieldForTarget("targetId",initValue);
	}
	public PlatformForm targetIdFieldForTarget(){
		return targetIdFieldForTarget("targetId","");
	}


	public PlatformForm nameFieldForTarget(String parameterName, String initValue){
		FormField field =  nameFromTarget(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm nameFieldForTarget(String initValue){
		return nameFieldForTarget("name",initValue);
	}
	public PlatformForm nameFieldForTarget(){
		return nameFieldForTarget("name","");
	}


	public PlatformForm profileIdFieldForTarget(String parameterName, String initValue){
		FormField field =  profileIdFromTarget(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm profileIdFieldForTarget(String initValue){
		return profileIdFieldForTarget("profileId",initValue);
	}
	public PlatformForm profileIdFieldForTarget(){
		return profileIdFieldForTarget("profileId","");
	}


	public PlatformForm bannerIdFieldForTarget(String parameterName, String initValue){
		FormField field =  bannerIdFromTarget(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm bannerIdFieldForTarget(String initValue){
		return bannerIdFieldForTarget("bannerId",initValue);
	}
	public PlatformForm bannerIdFieldForTarget(){
		return bannerIdFieldForTarget("bannerId","");
	}


	public PlatformForm locationFieldForTarget(String parameterName, String initValue){
		FormField field =  locationFromTarget(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm locationFieldForTarget(String initValue){
		return locationFieldForTarget("location",initValue);
	}
	public PlatformForm locationFieldForTarget(){
		return locationFieldForTarget("location","");
	}


	public PlatformForm lastUpdateFieldForTarget(String parameterName, String initValue){
		FormField field =  lastUpdateFromTarget(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm lastUpdateFieldForTarget(String initValue){
		return lastUpdateFieldForTarget("lastUpdate",initValue);
	}
	public PlatformForm lastUpdateFieldForTarget(){
		return lastUpdateFieldForTarget("lastUpdate","");
	}


	public PlatformForm platformIdFieldForTarget(String parameterName, String initValue){
		FormField field =  platformIdFromTarget(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm platformIdFieldForTarget(String initValue){
		return platformIdFieldForTarget("platformId",initValue);
	}
	public PlatformForm platformIdFieldForTarget(){
		return platformIdFieldForTarget("platformId","");
	}

	



	public PlatformForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


