package com.doublechaintech.cms;

import com.doublechaintech.cms.genericform.GenericForm;
import com.doublechaintech.cms.formfield.FormField;
import com.doublechaintech.cms.formaction.FormAction;
import com.doublechaintech.cms.formmessage.FormMessage;
import com.doublechaintech.cms.formfieldmessage.FormFieldMessage;




public class BaseForm extends GenericForm{

	public FormField getFieldByParamterName(String parameterName){
        
        for(FormField field: this.getFormFieldList()){
            if(parameterName.equals(field.getParameterName())){
                return field;
            }
            
        }
        return null;
    }
	public BaseForm hideByParamterName(String parameterName){
		
		for(FormField field: this.getFormFieldList()){
			if(parameterName.equals(field.getParameterName())){
				field.setType("hidden");
				break;
			}
			
		}
		return this;
	}
	public BaseForm disableByParamterName(String parameterName){
		
		for(FormField field: this.getFormFieldList()){
			if(parameterName.equals(field.getParameterName())){
				field.setDisabled(true);
				break;
			}
			
		}
		return this;
	}
	public BaseForm setAllGroupNameTo(String groupName){
		
		for(FormField field: this.getFormFieldList()){
			field.setFieldGroup(groupName);
		}
		return this;
		
	}
	
	public BaseForm disableByGroup(String groupName){
		
		for(FormField field: this.getFormFieldList()){
			if(groupName.equals(field.getFieldGroup())){
				field.setDisabled(true);
				continue;
			}
			
		}
		return this;
		
	}
	
	public BaseForm setGroupNameByParamterName(String parameterName, String groupName){
		
		for(FormField field: this.getFormFieldList()){
			if(parameterName.equals(field.getParameterName())){
				field.setFieldGroup(groupName);
				break;
			}
			
		}
		return this;
		
	}


	protected FormField idFromPlatform(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Id");
		field.setLocaleKey("platform.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Id");
		return field;
	}

	protected FormField nameFromPlatform(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Name");
		field.setLocaleKey("platform.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Name");
		return field;
	}

	protected FormField introductionFromPlatform(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Introduction");
		field.setLocaleKey("platform.introduction");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Introduction");
		return field;
	}

	protected FormField currentVersionFromPlatform(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Current Version");
		field.setLocaleKey("platform.current_version");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Current Version");
		return field;
	}

	protected FormField idFromAlertBar(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Id");
		field.setLocaleKey("alert_bar.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Id");
		return field;
	}

	protected FormField nameFromAlertBar(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Name");
		field.setLocaleKey("alert_bar.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Name");
		return field;
	}

	protected FormField messageFromAlertBar(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Message");
		field.setLocaleKey("alert_bar.message");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Message");
		return field;
	}

	protected FormField lastUpdateFromAlertBar(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Last Update");
		field.setLocaleKey("alert_bar.last_update");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date_time");
		field.setRequired(true);
		field.setPlaceholder("请填写Last Update");
		return field;
	}

	protected FormField platformIdFromAlertBar(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Platform");
		field.setLocaleKey("alert_bar.platform");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("Platform");
		field.setRequired(true);
		field.setPlaceholder("请填写Platform");
		return field;
	}

	protected FormField idFromBanner(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Id");
		field.setLocaleKey("banner.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Id");
		return field;
	}

	protected FormField nameFromBanner(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Name");
		field.setLocaleKey("banner.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Name");
		return field;
	}

	protected FormField imagePathFromBanner(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Image Path");
		field.setLocaleKey("banner.image_path");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("image");
		field.setRequired(true);
		field.setPlaceholder("请填写Image Path");
		return field;
	}

	protected FormField lastUpdateFromBanner(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Last Update");
		field.setLocaleKey("banner.last_update");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date_time");
		field.setRequired(true);
		field.setPlaceholder("请填写Last Update");
		return field;
	}

	protected FormField platformIdFromBanner(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Platform");
		field.setLocaleKey("banner.platform");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("Platform");
		field.setRequired(true);
		field.setPlaceholder("请填写Platform");
		return field;
	}

	protected FormField idFromProfile(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Id");
		field.setLocaleKey("profile.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Id");
		return field;
	}

	protected FormField nameFromProfile(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Name");
		field.setLocaleKey("profile.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Name");
		return field;
	}

	protected FormField platformIdFromProfile(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Platform");
		field.setLocaleKey("profile.platform");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("Platform");
		field.setRequired(true);
		field.setPlaceholder("请填写Platform");
		return field;
	}

	protected FormField idFromTarget(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Id");
		field.setLocaleKey("target.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Id");
		return field;
	}

	protected FormField nameFromTarget(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Name");
		field.setLocaleKey("target.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Name");
		return field;
	}

	protected FormField profileIdFromTarget(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Profile");
		field.setLocaleKey("target.profile");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("Profile");
		field.setRequired(true);
		field.setPlaceholder("请填写Profile");
		return field;
	}

	protected FormField bannerIdFromTarget(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Banner");
		field.setLocaleKey("target.banner");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("Banner");
		field.setRequired(true);
		field.setPlaceholder("请填写Banner");
		return field;
	}

	protected FormField locationFromTarget(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Location");
		field.setLocaleKey("target.location");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Location");
		return field;
	}

	protected FormField lastUpdateFromTarget(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Last Update");
		field.setLocaleKey("target.last_update");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date_time");
		field.setRequired(true);
		field.setPlaceholder("请填写Last Update");
		return field;
	}

	protected FormField platformIdFromTarget(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Platform");
		field.setLocaleKey("target.platform");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("Platform");
		field.setRequired(true);
		field.setPlaceholder("请填写Platform");
		return field;
	}

	protected FormField idFromUserAlert(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Id");
		field.setLocaleKey("user_alert.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Id");
		return field;
	}

	protected FormField messageFromUserAlert(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Message");
		field.setLocaleKey("user_alert.message");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Message");
		return field;
	}

	protected FormField profileIdFromUserAlert(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Profile");
		field.setLocaleKey("user_alert.profile");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("Profile");
		field.setRequired(true);
		field.setPlaceholder("请填写Profile");
		return field;
	}

	protected FormField locationFromUserAlert(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Location");
		field.setLocaleKey("user_alert.location");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Location");
		return field;
	}

	protected FormField lastUpdateFromUserAlert(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Last Update");
		field.setLocaleKey("user_alert.last_update");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date_time");
		field.setRequired(true);
		field.setPlaceholder("请填写Last Update");
		return field;
	}

	protected FormField platformIdFromUserAlert(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Platform");
		field.setLocaleKey("user_alert.platform");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("Platform");
		field.setRequired(true);
		field.setPlaceholder("请填写Platform");
		return field;
	}

	protected FormField idFromUserDomain(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Id");
		field.setLocaleKey("user_domain.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Id");
		return field;
	}

	protected FormField nameFromUserDomain(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Name");
		field.setLocaleKey("user_domain.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Name");
		return field;
	}

	protected FormField idFromUserWhiteList(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Id");
		field.setLocaleKey("user_white_list.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Id");
		return field;
	}

	protected FormField userIdentityFromUserWhiteList(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("User Identity");
		field.setLocaleKey("user_white_list.user_identity");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写User Identity");
		return field;
	}

	protected FormField userSpecialFunctionsFromUserWhiteList(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("User Special Functions");
		field.setLocaleKey("user_white_list.user_special_functions");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写User Special Functions");
		return field;
	}

	protected FormField domainIdFromUserWhiteList(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Domain");
		field.setLocaleKey("user_white_list.domain");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("UserDomain");
		field.setRequired(true);
		field.setPlaceholder("请填写Domain");
		return field;
	}

	protected FormField idFromSecUser(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Id");
		field.setLocaleKey("sec_user.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Id");
		return field;
	}

	protected FormField loginFromSecUser(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Login");
		field.setLocaleKey("sec_user.login");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Login");
		return field;
	}

	protected FormField mobileFromSecUser(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Mobile");
		field.setLocaleKey("sec_user.mobile");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("mobile");
		field.setRequired(true);
		field.setPlaceholder("请填写Mobile");
		return field;
	}

	protected FormField emailFromSecUser(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Email");
		field.setLocaleKey("sec_user.email");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Email");
		return field;
	}

	protected FormField pwdFromSecUser(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Pwd");
		field.setLocaleKey("sec_user.pwd");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("password");
		field.setRequired(true);
		field.setPlaceholder("请填写Pwd");
		return field;
	}

	protected FormField verificationCodeFromSecUser(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Verification Code");
		field.setLocaleKey("sec_user.verification_code");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("number");
		field.setRequired(true);
		field.setPlaceholder("请填写Verification Code");
		return field;
	}

	protected FormField verificationCodeExpireFromSecUser(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Verification Code Expire");
		field.setLocaleKey("sec_user.verification_code_expire");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date_time");
		field.setRequired(true);
		field.setPlaceholder("请填写Verification Code Expire");
		return field;
	}

	protected FormField lastLoginTimeFromSecUser(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Last Login Time");
		field.setLocaleKey("sec_user.last_login_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date_time");
		field.setRequired(true);
		field.setPlaceholder("请填写Last Login Time");
		return field;
	}

	protected FormField domainIdFromSecUser(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Domain");
		field.setLocaleKey("sec_user.domain");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("UserDomain");
		field.setRequired(true);
		field.setPlaceholder("请填写Domain");
		return field;
	}

	protected FormField blockingIdFromSecUser(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Blocking");
		field.setLocaleKey("sec_user.blocking");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("SecUserBlocking");
		field.setRequired(true);
		field.setPlaceholder("请填写Blocking");
		return field;
	}

	protected FormField currentStatusFromSecUser(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Current Status");
		field.setLocaleKey("sec_user.current_status");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Current Status");
		return field;
	}

	protected FormField idFromSecUserBlocking(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Id");
		field.setLocaleKey("sec_user_blocking.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Id");
		return field;
	}

	protected FormField whoFromSecUserBlocking(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Who");
		field.setLocaleKey("sec_user_blocking.who");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Who");
		return field;
	}

	protected FormField blockTimeFromSecUserBlocking(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Block Time");
		field.setLocaleKey("sec_user_blocking.block_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date_time");
		field.setRequired(true);
		field.setPlaceholder("请填写Block Time");
		return field;
	}

	protected FormField commentsFromSecUserBlocking(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Comments");
		field.setLocaleKey("sec_user_blocking.comments");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Comments");
		return field;
	}

	protected FormField idFromUserApp(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Id");
		field.setLocaleKey("user_app.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Id");
		return field;
	}

	protected FormField titleFromUserApp(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Title");
		field.setLocaleKey("user_app.title");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Title");
		return field;
	}

	protected FormField secUserIdFromUserApp(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Sec User");
		field.setLocaleKey("user_app.sec_user");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("SecUser");
		field.setRequired(true);
		field.setPlaceholder("请填写Sec User");
		return field;
	}

	protected FormField appIconFromUserApp(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("App Icon");
		field.setLocaleKey("user_app.app_icon");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写App Icon");
		return field;
	}

	protected FormField fullAccessFromUserApp(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Full Access");
		field.setLocaleKey("user_app.full_access");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("switch");
		field.setRequired(true);
		field.setPlaceholder("请填写Full Access");
		return field;
	}

	protected FormField permissionFromUserApp(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Permission");
		field.setLocaleKey("user_app.permission");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Permission");
		return field;
	}

	protected FormField objectTypeFromUserApp(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Object Type");
		field.setLocaleKey("user_app.object_type");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Object Type");
		return field;
	}

	protected FormField objectIdFromUserApp(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Object Id");
		field.setLocaleKey("user_app.object_id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Object Id");
		return field;
	}

	protected FormField locationFromUserApp(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Location");
		field.setLocaleKey("user_app.location");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Location");
		return field;
	}

	protected FormField idFromListAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Id");
		field.setLocaleKey("list_access.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Id");
		return field;
	}

	protected FormField nameFromListAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Name");
		field.setLocaleKey("list_access.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Name");
		return field;
	}

	protected FormField internalNameFromListAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Internal Name");
		field.setLocaleKey("list_access.internal_name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Internal Name");
		return field;
	}

	protected FormField readPermissionFromListAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Read Permission");
		field.setLocaleKey("list_access.read_permission");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("switch");
		field.setRequired(true);
		field.setPlaceholder("请填写Read Permission");
		return field;
	}

	protected FormField createPermissionFromListAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Create Permission");
		field.setLocaleKey("list_access.create_permission");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("switch");
		field.setRequired(true);
		field.setPlaceholder("请填写Create Permission");
		return field;
	}

	protected FormField deletePermissionFromListAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Delete Permission");
		field.setLocaleKey("list_access.delete_permission");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("switch");
		field.setRequired(true);
		field.setPlaceholder("请填写Delete Permission");
		return field;
	}

	protected FormField updatePermissionFromListAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Update Permission");
		field.setLocaleKey("list_access.update_permission");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("switch");
		field.setRequired(true);
		field.setPlaceholder("请填写Update Permission");
		return field;
	}

	protected FormField executionPermissionFromListAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Execution Permission");
		field.setLocaleKey("list_access.execution_permission");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("switch");
		field.setRequired(true);
		field.setPlaceholder("请填写Execution Permission");
		return field;
	}

	protected FormField appIdFromListAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("App");
		field.setLocaleKey("list_access.app");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("UserApp");
		field.setRequired(true);
		field.setPlaceholder("请填写App");
		return field;
	}

	protected FormField idFromObjectAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Id");
		field.setLocaleKey("object_access.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Id");
		return field;
	}

	protected FormField nameFromObjectAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Name");
		field.setLocaleKey("object_access.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Name");
		return field;
	}

	protected FormField objectTypeFromObjectAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Object Type");
		field.setLocaleKey("object_access.object_type");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Object Type");
		return field;
	}

	protected FormField list1FromObjectAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("List1");
		field.setLocaleKey("object_access.list1");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写List1");
		return field;
	}

	protected FormField list2FromObjectAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("List2");
		field.setLocaleKey("object_access.list2");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写List2");
		return field;
	}

	protected FormField list3FromObjectAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("List3");
		field.setLocaleKey("object_access.list3");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写List3");
		return field;
	}

	protected FormField list4FromObjectAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("List4");
		field.setLocaleKey("object_access.list4");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写List4");
		return field;
	}

	protected FormField list5FromObjectAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("List5");
		field.setLocaleKey("object_access.list5");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写List5");
		return field;
	}

	protected FormField list6FromObjectAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("List6");
		field.setLocaleKey("object_access.list6");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写List6");
		return field;
	}

	protected FormField list7FromObjectAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("List7");
		field.setLocaleKey("object_access.list7");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写List7");
		return field;
	}

	protected FormField list8FromObjectAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("List8");
		field.setLocaleKey("object_access.list8");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写List8");
		return field;
	}

	protected FormField list9FromObjectAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("List9");
		field.setLocaleKey("object_access.list9");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写List9");
		return field;
	}

	protected FormField appIdFromObjectAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("App");
		field.setLocaleKey("object_access.app");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("UserApp");
		field.setRequired(true);
		field.setPlaceholder("请填写App");
		return field;
	}

	protected FormField idFromLoginHistory(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Id");
		field.setLocaleKey("login_history.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Id");
		return field;
	}

	protected FormField loginTimeFromLoginHistory(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Login Time");
		field.setLocaleKey("login_history.login_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date_time");
		field.setRequired(true);
		field.setPlaceholder("请填写Login Time");
		return field;
	}

	protected FormField fromIpFromLoginHistory(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("From Ip");
		field.setLocaleKey("login_history.from_ip");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写From Ip");
		return field;
	}

	protected FormField descriptionFromLoginHistory(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Description");
		field.setLocaleKey("login_history.description");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Description");
		return field;
	}

	protected FormField secUserIdFromLoginHistory(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Sec User");
		field.setLocaleKey("login_history.sec_user");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("SecUser");
		field.setRequired(true);
		field.setPlaceholder("请填写Sec User");
		return field;
	}

	protected FormField idFromGenericForm(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Id");
		field.setLocaleKey("generic_form.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Id");
		return field;
	}

	protected FormField titleFromGenericForm(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Title");
		field.setLocaleKey("generic_form.title");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Title");
		return field;
	}

	protected FormField descriptionFromGenericForm(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Description");
		field.setLocaleKey("generic_form.description");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Description");
		return field;
	}

	protected FormField idFromFormMessage(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Id");
		field.setLocaleKey("form_message.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Id");
		return field;
	}

	protected FormField titleFromFormMessage(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Title");
		field.setLocaleKey("form_message.title");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Title");
		return field;
	}

	protected FormField formIdFromFormMessage(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Form");
		field.setLocaleKey("form_message.form");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("GenericForm");
		field.setRequired(true);
		field.setPlaceholder("请填写Form");
		return field;
	}

	protected FormField levelFromFormMessage(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Level");
		field.setLocaleKey("form_message.level");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Level");
		return field;
	}

	protected FormField idFromFormFieldMessage(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Id");
		field.setLocaleKey("form_field_message.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Id");
		return field;
	}

	protected FormField titleFromFormFieldMessage(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Title");
		field.setLocaleKey("form_field_message.title");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Title");
		return field;
	}

	protected FormField parameterNameFromFormFieldMessage(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Parameter Name");
		field.setLocaleKey("form_field_message.parameter_name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Parameter Name");
		return field;
	}

	protected FormField formIdFromFormFieldMessage(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Form");
		field.setLocaleKey("form_field_message.form");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("GenericForm");
		field.setRequired(true);
		field.setPlaceholder("请填写Form");
		return field;
	}

	protected FormField levelFromFormFieldMessage(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Level");
		field.setLocaleKey("form_field_message.level");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Level");
		return field;
	}

	protected FormField idFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Id");
		field.setLocaleKey("form_field.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Id");
		return field;
	}

	protected FormField labelFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Label");
		field.setLocaleKey("form_field.label");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Label");
		return field;
	}

	protected FormField localeKeyFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Locale Key");
		field.setLocaleKey("form_field.locale_key");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Locale Key");
		return field;
	}

	protected FormField parameterNameFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Parameter Name");
		field.setLocaleKey("form_field.parameter_name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Parameter Name");
		return field;
	}

	protected FormField typeFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Type");
		field.setLocaleKey("form_field.type");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Type");
		return field;
	}

	protected FormField formIdFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Form");
		field.setLocaleKey("form_field.form");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("GenericForm");
		field.setRequired(true);
		field.setPlaceholder("请填写Form");
		return field;
	}

	protected FormField placeholderFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Placeholder");
		field.setLocaleKey("form_field.placeholder");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Placeholder");
		return field;
	}

	protected FormField defaultValueFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Default Value");
		field.setLocaleKey("form_field.default_value");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Default Value");
		return field;
	}

	protected FormField descriptionFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Description");
		field.setLocaleKey("form_field.description");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Description");
		return field;
	}

	protected FormField fieldGroupFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Field Group");
		field.setLocaleKey("form_field.field_group");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Field Group");
		return field;
	}

	protected FormField minimumValueFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Minimum Value");
		field.setLocaleKey("form_field.minimum_value");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Minimum Value");
		return field;
	}

	protected FormField maximumValueFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Maximum Value");
		field.setLocaleKey("form_field.maximum_value");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Maximum Value");
		return field;
	}

	protected FormField requiredFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Required");
		field.setLocaleKey("form_field.required");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("switch");
		field.setRequired(true);
		field.setPlaceholder("请填写Required");
		return field;
	}

	protected FormField disabledFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Disabled");
		field.setLocaleKey("form_field.disabled");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("switch");
		field.setRequired(true);
		field.setPlaceholder("请填写Disabled");
		return field;
	}

	protected FormField customRenderingFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Custom Rendering");
		field.setLocaleKey("form_field.custom_rendering");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("switch");
		field.setRequired(true);
		field.setPlaceholder("请填写Custom Rendering");
		return field;
	}

	protected FormField candidateValuesFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Candidate Values");
		field.setLocaleKey("form_field.candidate_values");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Candidate Values");
		return field;
	}

	protected FormField suggestValuesFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Suggest Values");
		field.setLocaleKey("form_field.suggest_values");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Suggest Values");
		return field;
	}

	protected FormField idFromFormAction(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Id");
		field.setLocaleKey("form_action.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Id");
		return field;
	}

	protected FormField labelFromFormAction(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Label");
		field.setLocaleKey("form_action.label");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Label");
		return field;
	}

	protected FormField localeKeyFromFormAction(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Locale Key");
		field.setLocaleKey("form_action.locale_key");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Locale Key");
		return field;
	}

	protected FormField actionKeyFromFormAction(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Action Key");
		field.setLocaleKey("form_action.action_key");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Action Key");
		return field;
	}

	protected FormField levelFromFormAction(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Level");
		field.setLocaleKey("form_action.level");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Level");
		return field;
	}

	protected FormField urlFromFormAction(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Url");
		field.setLocaleKey("form_action.url");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Url");
		return field;
	}

	protected FormField formIdFromFormAction(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Form");
		field.setLocaleKey("form_action.form");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("GenericForm");
		field.setRequired(true);
		field.setPlaceholder("请填写Form");
		return field;
	}

}









