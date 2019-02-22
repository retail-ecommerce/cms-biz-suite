
package com.doublechaintech.cms.useralert;
import com.doublechaintech.cms.EntityNotFoundException;

public class UserAlertVersionChangedException extends UserAlertManagerException {
	private static final long serialVersionUID = 1L;
	public UserAlertVersionChangedException(String string) {
		super(string);
	}


}


