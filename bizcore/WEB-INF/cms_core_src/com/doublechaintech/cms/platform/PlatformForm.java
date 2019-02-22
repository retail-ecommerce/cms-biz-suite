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

	
	

	



	public PlatformForm alertBarIdFieldForAlertBar(String parameterName, String initValue){
		FormField field =  idFromAlertBar(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm alertBarIdFieldForAlertBar(String initValue){
		return alertBarIdFieldForAlertBar("alertBarId",initValue);
	}
	public PlatformForm alertBarIdFieldForAlertBar(){
		return alertBarIdFieldForAlertBar("alertBarId","");
	}


	public PlatformForm nameFieldForAlertBar(String parameterName, String initValue){
		FormField field =  nameFromAlertBar(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm nameFieldForAlertBar(String initValue){
		return nameFieldForAlertBar("name",initValue);
	}
	public PlatformForm nameFieldForAlertBar(){
		return nameFieldForAlertBar("name","");
	}


	public PlatformForm messageFieldForAlertBar(String parameterName, String initValue){
		FormField field =  messageFromAlertBar(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm messageFieldForAlertBar(String initValue){
		return messageFieldForAlertBar("message",initValue);
	}
	public PlatformForm messageFieldForAlertBar(){
		return messageFieldForAlertBar("message","");
	}


	public PlatformForm lastUpdateFieldForAlertBar(String parameterName, String initValue){
		FormField field =  lastUpdateFromAlertBar(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm lastUpdateFieldForAlertBar(String initValue){
		return lastUpdateFieldForAlertBar("lastUpdate",initValue);
	}
	public PlatformForm lastUpdateFieldForAlertBar(){
		return lastUpdateFieldForAlertBar("lastUpdate","");
	}


	public PlatformForm platformIdFieldForAlertBar(String parameterName, String initValue){
		FormField field =  platformIdFromAlertBar(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm platformIdFieldForAlertBar(String initValue){
		return platformIdFieldForAlertBar("platformId",initValue);
	}
	public PlatformForm platformIdFieldForAlertBar(){
		return platformIdFieldForAlertBar("platformId","");
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


	public PlatformForm userAlertIdFieldForUserAlert(String parameterName, String initValue){
		FormField field =  idFromUserAlert(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm userAlertIdFieldForUserAlert(String initValue){
		return userAlertIdFieldForUserAlert("userAlertId",initValue);
	}
	public PlatformForm userAlertIdFieldForUserAlert(){
		return userAlertIdFieldForUserAlert("userAlertId","");
	}


	public PlatformForm messageFieldForUserAlert(String parameterName, String initValue){
		FormField field =  messageFromUserAlert(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm messageFieldForUserAlert(String initValue){
		return messageFieldForUserAlert("message",initValue);
	}
	public PlatformForm messageFieldForUserAlert(){
		return messageFieldForUserAlert("message","");
	}


	public PlatformForm profileIdFieldForUserAlert(String parameterName, String initValue){
		FormField field =  profileIdFromUserAlert(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm profileIdFieldForUserAlert(String initValue){
		return profileIdFieldForUserAlert("profileId",initValue);
	}
	public PlatformForm profileIdFieldForUserAlert(){
		return profileIdFieldForUserAlert("profileId","");
	}


	public PlatformForm locationFieldForUserAlert(String parameterName, String initValue){
		FormField field =  locationFromUserAlert(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm locationFieldForUserAlert(String initValue){
		return locationFieldForUserAlert("location",initValue);
	}
	public PlatformForm locationFieldForUserAlert(){
		return locationFieldForUserAlert("location","");
	}


	public PlatformForm lastUpdateFieldForUserAlert(String parameterName, String initValue){
		FormField field =  lastUpdateFromUserAlert(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm lastUpdateFieldForUserAlert(String initValue){
		return lastUpdateFieldForUserAlert("lastUpdate",initValue);
	}
	public PlatformForm lastUpdateFieldForUserAlert(){
		return lastUpdateFieldForUserAlert("lastUpdate","");
	}


	public PlatformForm platformIdFieldForUserAlert(String parameterName, String initValue){
		FormField field =  platformIdFromUserAlert(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm platformIdFieldForUserAlert(String initValue){
		return platformIdFieldForUserAlert("platformId",initValue);
	}
	public PlatformForm platformIdFieldForUserAlert(){
		return platformIdFieldForUserAlert("platformId","");
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


