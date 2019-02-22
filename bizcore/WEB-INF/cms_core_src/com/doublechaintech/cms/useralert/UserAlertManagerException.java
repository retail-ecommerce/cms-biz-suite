
package com.doublechaintech.cms.useralert;
//import com.doublechaintech.cms.EntityNotFoundException;
import com.doublechaintech.cms.CmsException;
import com.doublechaintech.cms.Message;
import java.util.List;

public class UserAlertManagerException extends CmsException {
	private static final long serialVersionUID = 1L;
	public UserAlertManagerException(String string) {
		super(string);
	}
	public UserAlertManagerException(Message message) {
		super(message);
	}
	public UserAlertManagerException(List<Message> messageList) {
		super(messageList);
	}

}


