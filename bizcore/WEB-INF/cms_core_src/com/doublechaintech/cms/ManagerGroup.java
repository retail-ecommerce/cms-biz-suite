package com.doublechaintech.cms;


import com.doublechaintech.cms.platform.PlatformManager;

import com.doublechaintech.cms.alertbar.AlertBarManager;

import com.doublechaintech.cms.banner.BannerManager;

import com.doublechaintech.cms.profile.ProfileManager;

import com.doublechaintech.cms.target.TargetManager;

import com.doublechaintech.cms.useralert.UserAlertManager;

import com.doublechaintech.cms.userdomain.UserDomainManager;

import com.doublechaintech.cms.userwhitelist.UserWhiteListManager;

import com.doublechaintech.cms.secuser.SecUserManager;

import com.doublechaintech.cms.secuserblocking.SecUserBlockingManager;

import com.doublechaintech.cms.userapp.UserAppManager;

import com.doublechaintech.cms.listaccess.ListAccessManager;

import com.doublechaintech.cms.objectaccess.ObjectAccessManager;

import com.doublechaintech.cms.loginhistory.LoginHistoryManager;

import com.doublechaintech.cms.genericform.GenericFormManager;

import com.doublechaintech.cms.formmessage.FormMessageManager;

import com.doublechaintech.cms.formfieldmessage.FormFieldMessageManager;

import com.doublechaintech.cms.formfield.FormFieldManager;

import com.doublechaintech.cms.formaction.FormActionManager;


public class ManagerGroup {

	protected PlatformManager platformManager;

	protected AlertBarManager alertBarManager;

	protected BannerManager bannerManager;

	protected ProfileManager profileManager;

	protected TargetManager targetManager;

	protected UserAlertManager userAlertManager;

	protected UserDomainManager userDomainManager;

	protected UserWhiteListManager userWhiteListManager;

	protected SecUserManager secUserManager;

	protected SecUserBlockingManager secUserBlockingManager;

	protected UserAppManager userAppManager;

	protected ListAccessManager listAccessManager;

	protected ObjectAccessManager objectAccessManager;

	protected LoginHistoryManager loginHistoryManager;

	protected GenericFormManager genericFormManager;

	protected FormMessageManager formMessageManager;

	protected FormFieldMessageManager formFieldMessageManager;

	protected FormFieldManager formFieldManager;

	protected FormActionManager formActionManager;

	

	public PlatformManager getPlatformManager(){
		return this.platformManager;
	}
	public void setPlatformManager(PlatformManager manager){
		this.platformManager = manager;
	}


	public AlertBarManager getAlertBarManager(){
		return this.alertBarManager;
	}
	public void setAlertBarManager(AlertBarManager manager){
		this.alertBarManager = manager;
	}


	public BannerManager getBannerManager(){
		return this.bannerManager;
	}
	public void setBannerManager(BannerManager manager){
		this.bannerManager = manager;
	}


	public ProfileManager getProfileManager(){
		return this.profileManager;
	}
	public void setProfileManager(ProfileManager manager){
		this.profileManager = manager;
	}


	public TargetManager getTargetManager(){
		return this.targetManager;
	}
	public void setTargetManager(TargetManager manager){
		this.targetManager = manager;
	}


	public UserAlertManager getUserAlertManager(){
		return this.userAlertManager;
	}
	public void setUserAlertManager(UserAlertManager manager){
		this.userAlertManager = manager;
	}


	public UserDomainManager getUserDomainManager(){
		return this.userDomainManager;
	}
	public void setUserDomainManager(UserDomainManager manager){
		this.userDomainManager = manager;
	}


	public UserWhiteListManager getUserWhiteListManager(){
		return this.userWhiteListManager;
	}
	public void setUserWhiteListManager(UserWhiteListManager manager){
		this.userWhiteListManager = manager;
	}


	public SecUserManager getSecUserManager(){
		return this.secUserManager;
	}
	public void setSecUserManager(SecUserManager manager){
		this.secUserManager = manager;
	}


	public SecUserBlockingManager getSecUserBlockingManager(){
		return this.secUserBlockingManager;
	}
	public void setSecUserBlockingManager(SecUserBlockingManager manager){
		this.secUserBlockingManager = manager;
	}


	public UserAppManager getUserAppManager(){
		return this.userAppManager;
	}
	public void setUserAppManager(UserAppManager manager){
		this.userAppManager = manager;
	}


	public ListAccessManager getListAccessManager(){
		return this.listAccessManager;
	}
	public void setListAccessManager(ListAccessManager manager){
		this.listAccessManager = manager;
	}


	public ObjectAccessManager getObjectAccessManager(){
		return this.objectAccessManager;
	}
	public void setObjectAccessManager(ObjectAccessManager manager){
		this.objectAccessManager = manager;
	}


	public LoginHistoryManager getLoginHistoryManager(){
		return this.loginHistoryManager;
	}
	public void setLoginHistoryManager(LoginHistoryManager manager){
		this.loginHistoryManager = manager;
	}


	public GenericFormManager getGenericFormManager(){
		return this.genericFormManager;
	}
	public void setGenericFormManager(GenericFormManager manager){
		this.genericFormManager = manager;
	}


	public FormMessageManager getFormMessageManager(){
		return this.formMessageManager;
	}
	public void setFormMessageManager(FormMessageManager manager){
		this.formMessageManager = manager;
	}


	public FormFieldMessageManager getFormFieldMessageManager(){
		return this.formFieldMessageManager;
	}
	public void setFormFieldMessageManager(FormFieldMessageManager manager){
		this.formFieldMessageManager = manager;
	}


	public FormFieldManager getFormFieldManager(){
		return this.formFieldManager;
	}
	public void setFormFieldManager(FormFieldManager manager){
		this.formFieldManager = manager;
	}


	public FormActionManager getFormActionManager(){
		return this.formActionManager;
	}
	public void setFormActionManager(FormActionManager manager){
		this.formActionManager = manager;
	}


}









