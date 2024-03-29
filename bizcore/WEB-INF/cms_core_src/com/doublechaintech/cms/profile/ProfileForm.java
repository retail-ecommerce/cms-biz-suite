package com.doublechaintech.cms.profile;
import com.doublechaintech.cms.BaseForm;
import com.doublechaintech.cms.genericform.GenericForm;
import com.doublechaintech.cms.formfield.FormField;
import com.doublechaintech.cms.formaction.FormAction;
import com.doublechaintech.cms.formmessage.FormMessage;
import com.doublechaintech.cms.formfieldmessage.FormFieldMessage;



public class ProfileForm extends BaseForm {
	
	
	public ProfileForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public ProfileForm profileIdField(String parameterName, String initValue){
		FormField field = idFromProfile(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm profileIdField(String initValue){
		return profileIdField("profileId",initValue);
	}
	public ProfileForm profileIdField(){
		return profileIdField("profileId","");
	}


	public ProfileForm nameField(String parameterName, String initValue){
		FormField field = nameFromProfile(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public ProfileForm nameField(){
		return nameField("name","");
	}


	public ProfileForm platformIdField(String parameterName, String initValue){
		FormField field = platformIdFromProfile(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm platformIdField(String initValue){
		return platformIdField("platformId",initValue);
	}
	public ProfileForm platformIdField(){
		return platformIdField("platformId","");
	}

	
	


	public ProfileForm platformIdFieldOfPlatform(String parameterName, String initValue){
		FormField field =  idFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ProfileForm platformIdFieldOfPlatform(String initValue){
		return platformIdFieldOfPlatform("platformId",initValue);
	}
	public ProfileForm platformIdFieldOfPlatform(){
		return platformIdFieldOfPlatform("platformId","");
	}


	public ProfileForm nameFieldOfPlatform(String parameterName, String initValue){
		FormField field =  nameFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ProfileForm nameFieldOfPlatform(String initValue){
		return nameFieldOfPlatform("name",initValue);
	}
	public ProfileForm nameFieldOfPlatform(){
		return nameFieldOfPlatform("name","");
	}


	public ProfileForm introductionFieldOfPlatform(String parameterName, String initValue){
		FormField field =  introductionFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ProfileForm introductionFieldOfPlatform(String initValue){
		return introductionFieldOfPlatform("introduction",initValue);
	}
	public ProfileForm introductionFieldOfPlatform(){
		return introductionFieldOfPlatform("introduction","");
	}


	public ProfileForm currentVersionFieldOfPlatform(String parameterName, String initValue){
		FormField field =  currentVersionFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ProfileForm currentVersionFieldOfPlatform(String initValue){
		return currentVersionFieldOfPlatform("currentVersion",initValue);
	}
	public ProfileForm currentVersionFieldOfPlatform(){
		return currentVersionFieldOfPlatform("currentVersion","");
	}

	



	public ProfileForm targetIdFieldForTarget(String parameterName, String initValue){
		FormField field =  idFromTarget(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm targetIdFieldForTarget(String initValue){
		return targetIdFieldForTarget("targetId",initValue);
	}
	public ProfileForm targetIdFieldForTarget(){
		return targetIdFieldForTarget("targetId","");
	}


	public ProfileForm nameFieldForTarget(String parameterName, String initValue){
		FormField field =  nameFromTarget(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm nameFieldForTarget(String initValue){
		return nameFieldForTarget("name",initValue);
	}
	public ProfileForm nameFieldForTarget(){
		return nameFieldForTarget("name","");
	}


	public ProfileForm profileIdFieldForTarget(String parameterName, String initValue){
		FormField field =  profileIdFromTarget(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm profileIdFieldForTarget(String initValue){
		return profileIdFieldForTarget("profileId",initValue);
	}
	public ProfileForm profileIdFieldForTarget(){
		return profileIdFieldForTarget("profileId","");
	}


	public ProfileForm bannerIdFieldForTarget(String parameterName, String initValue){
		FormField field =  bannerIdFromTarget(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm bannerIdFieldForTarget(String initValue){
		return bannerIdFieldForTarget("bannerId",initValue);
	}
	public ProfileForm bannerIdFieldForTarget(){
		return bannerIdFieldForTarget("bannerId","");
	}


	public ProfileForm locationFieldForTarget(String parameterName, String initValue){
		FormField field =  locationFromTarget(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm locationFieldForTarget(String initValue){
		return locationFieldForTarget("location",initValue);
	}
	public ProfileForm locationFieldForTarget(){
		return locationFieldForTarget("location","");
	}


	public ProfileForm lastUpdateFieldForTarget(String parameterName, String initValue){
		FormField field =  lastUpdateFromTarget(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm lastUpdateFieldForTarget(String initValue){
		return lastUpdateFieldForTarget("lastUpdate",initValue);
	}
	public ProfileForm lastUpdateFieldForTarget(){
		return lastUpdateFieldForTarget("lastUpdate","");
	}


	public ProfileForm platformIdFieldForTarget(String parameterName, String initValue){
		FormField field =  platformIdFromTarget(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm platformIdFieldForTarget(String initValue){
		return platformIdFieldForTarget("platformId",initValue);
	}
	public ProfileForm platformIdFieldForTarget(){
		return platformIdFieldForTarget("platformId","");
	}


	public ProfileForm userAlertIdFieldForUserAlert(String parameterName, String initValue){
		FormField field =  idFromUserAlert(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm userAlertIdFieldForUserAlert(String initValue){
		return userAlertIdFieldForUserAlert("userAlertId",initValue);
	}
	public ProfileForm userAlertIdFieldForUserAlert(){
		return userAlertIdFieldForUserAlert("userAlertId","");
	}


	public ProfileForm messageFieldForUserAlert(String parameterName, String initValue){
		FormField field =  messageFromUserAlert(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm messageFieldForUserAlert(String initValue){
		return messageFieldForUserAlert("message",initValue);
	}
	public ProfileForm messageFieldForUserAlert(){
		return messageFieldForUserAlert("message","");
	}


	public ProfileForm profileIdFieldForUserAlert(String parameterName, String initValue){
		FormField field =  profileIdFromUserAlert(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm profileIdFieldForUserAlert(String initValue){
		return profileIdFieldForUserAlert("profileId",initValue);
	}
	public ProfileForm profileIdFieldForUserAlert(){
		return profileIdFieldForUserAlert("profileId","");
	}


	public ProfileForm locationFieldForUserAlert(String parameterName, String initValue){
		FormField field =  locationFromUserAlert(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm locationFieldForUserAlert(String initValue){
		return locationFieldForUserAlert("location",initValue);
	}
	public ProfileForm locationFieldForUserAlert(){
		return locationFieldForUserAlert("location","");
	}


	public ProfileForm lastUpdateFieldForUserAlert(String parameterName, String initValue){
		FormField field =  lastUpdateFromUserAlert(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm lastUpdateFieldForUserAlert(String initValue){
		return lastUpdateFieldForUserAlert("lastUpdate",initValue);
	}
	public ProfileForm lastUpdateFieldForUserAlert(){
		return lastUpdateFieldForUserAlert("lastUpdate","");
	}


	public ProfileForm platformIdFieldForUserAlert(String parameterName, String initValue){
		FormField field =  platformIdFromUserAlert(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfileForm platformIdFieldForUserAlert(String initValue){
		return platformIdFieldForUserAlert("platformId",initValue);
	}
	public ProfileForm platformIdFieldForUserAlert(){
		return platformIdFieldForUserAlert("platformId","");
	}

	

	
 	public ProfileForm transferToAnotherPlatformAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherPlatform/profileId/");
		this.addFormAction(action);
		return this;
	}

 

	public ProfileForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


