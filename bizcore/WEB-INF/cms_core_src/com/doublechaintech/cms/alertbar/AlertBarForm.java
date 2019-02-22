package com.doublechaintech.cms.alertbar;
import com.doublechaintech.cms.BaseForm;
import com.doublechaintech.cms.genericform.GenericForm;
import com.doublechaintech.cms.formfield.FormField;
import com.doublechaintech.cms.formaction.FormAction;
import com.doublechaintech.cms.formmessage.FormMessage;
import com.doublechaintech.cms.formfieldmessage.FormFieldMessage;



public class AlertBarForm extends BaseForm {
	
	
	public AlertBarForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public AlertBarForm alertBarIdField(String parameterName, String initValue){
		FormField field = idFromAlertBar(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AlertBarForm alertBarIdField(String initValue){
		return alertBarIdField("alertBarId",initValue);
	}
	public AlertBarForm alertBarIdField(){
		return alertBarIdField("alertBarId","");
	}


	public AlertBarForm nameField(String parameterName, String initValue){
		FormField field = nameFromAlertBar(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AlertBarForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public AlertBarForm nameField(){
		return nameField("name","");
	}


	public AlertBarForm messageField(String parameterName, String initValue){
		FormField field = messageFromAlertBar(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AlertBarForm messageField(String initValue){
		return messageField("message",initValue);
	}
	public AlertBarForm messageField(){
		return messageField("message","");
	}


	public AlertBarForm lastUpdateField(String parameterName, String initValue){
		FormField field = lastUpdateFromAlertBar(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AlertBarForm lastUpdateField(String initValue){
		return lastUpdateField("lastUpdate",initValue);
	}
	public AlertBarForm lastUpdateField(){
		return lastUpdateField("lastUpdate","");
	}


	public AlertBarForm platformIdField(String parameterName, String initValue){
		FormField field = platformIdFromAlertBar(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AlertBarForm platformIdField(String initValue){
		return platformIdField("platformId",initValue);
	}
	public AlertBarForm platformIdField(){
		return platformIdField("platformId","");
	}

	
	


	public AlertBarForm platformIdFieldOfPlatform(String parameterName, String initValue){
		FormField field =  idFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AlertBarForm platformIdFieldOfPlatform(String initValue){
		return platformIdFieldOfPlatform("platformId",initValue);
	}
	public AlertBarForm platformIdFieldOfPlatform(){
		return platformIdFieldOfPlatform("platformId","");
	}


	public AlertBarForm nameFieldOfPlatform(String parameterName, String initValue){
		FormField field =  nameFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AlertBarForm nameFieldOfPlatform(String initValue){
		return nameFieldOfPlatform("name",initValue);
	}
	public AlertBarForm nameFieldOfPlatform(){
		return nameFieldOfPlatform("name","");
	}


	public AlertBarForm introductionFieldOfPlatform(String parameterName, String initValue){
		FormField field =  introductionFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AlertBarForm introductionFieldOfPlatform(String initValue){
		return introductionFieldOfPlatform("introduction",initValue);
	}
	public AlertBarForm introductionFieldOfPlatform(){
		return introductionFieldOfPlatform("introduction","");
	}


	public AlertBarForm currentVersionFieldOfPlatform(String parameterName, String initValue){
		FormField field =  currentVersionFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AlertBarForm currentVersionFieldOfPlatform(String initValue){
		return currentVersionFieldOfPlatform("currentVersion",initValue);
	}
	public AlertBarForm currentVersionFieldOfPlatform(){
		return currentVersionFieldOfPlatform("currentVersion","");
	}

	


	

	
 	public AlertBarForm transferToAnotherPlatformAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherPlatform/alertBarId/");
		this.addFormAction(action);
		return this;
	}

 

	public AlertBarForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


