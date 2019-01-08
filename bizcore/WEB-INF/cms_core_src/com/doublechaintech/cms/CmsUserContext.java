package com.doublechaintech.cms;

public interface CmsUserContext extends UserContext{
    //define the domain specific user model
	String getLocaleKey(String subject);
	void setChecker(CmsChecker checker);
	CmsChecker getChecker();
}

