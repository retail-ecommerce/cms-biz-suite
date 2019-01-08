
package com.doublechaintech.cms;
import java.util.Map;

import com.doublechaintech.cms.platform.Platform;
import com.doublechaintech.cms.userdomain.UserDomain;
import com.doublechaintech.cms.userwhitelist.UserWhiteList;
import com.doublechaintech.cms.secuser.SecUser;
import com.doublechaintech.cms.secuserblocking.SecUserBlocking;
import com.doublechaintech.cms.userapp.UserApp;
import com.doublechaintech.cms.listaccess.ListAccess;
import com.doublechaintech.cms.objectaccess.ObjectAccess;
import com.doublechaintech.cms.loginhistory.LoginHistory;
import com.doublechaintech.cms.genericform.GenericForm;
import com.doublechaintech.cms.formmessage.FormMessage;
import com.doublechaintech.cms.formfieldmessage.FormFieldMessage;
import com.doublechaintech.cms.formfield.FormField;
import com.doublechaintech.cms.formaction.FormAction;

public class BeanFactoryImpl{


	public Platform createPlatform(Map<String,Object> options){
		return new Platform();
	}


	public UserDomain createUserDomain(Map<String,Object> options){
		return new UserDomain();
	}


	public UserWhiteList createUserWhiteList(Map<String,Object> options){
		return new UserWhiteList();
	}


	public SecUser createSecUser(Map<String,Object> options){
		return new SecUser();
	}


	public SecUserBlocking createSecUserBlocking(Map<String,Object> options){
		return new SecUserBlocking();
	}


	public UserApp createUserApp(Map<String,Object> options){
		return new UserApp();
	}


	public ListAccess createListAccess(Map<String,Object> options){
		return new ListAccess();
	}


	public ObjectAccess createObjectAccess(Map<String,Object> options){
		return new ObjectAccess();
	}


	public LoginHistory createLoginHistory(Map<String,Object> options){
		return new LoginHistory();
	}


	public GenericForm createGenericForm(Map<String,Object> options){
		return new GenericForm();
	}


	public FormMessage createFormMessage(Map<String,Object> options){
		return new FormMessage();
	}


	public FormFieldMessage createFormFieldMessage(Map<String,Object> options){
		return new FormFieldMessage();
	}


	public FormField createFormField(Map<String,Object> options){
		return new FormField();
	}


	public FormAction createFormAction(Map<String,Object> options){
		return new FormAction();
	}





}










