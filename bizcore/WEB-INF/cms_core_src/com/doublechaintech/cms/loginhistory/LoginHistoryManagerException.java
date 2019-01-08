
package com.doublechaintech.cms.loginhistory;
//import com.doublechaintech.cms.EntityNotFoundException;
import com.doublechaintech.cms.CmsException;
import com.doublechaintech.cms.Message;
import java.util.List;

public class LoginHistoryManagerException extends CmsException {
	private static final long serialVersionUID = 1L;
	public LoginHistoryManagerException(String string) {
		super(string);
	}
	public LoginHistoryManagerException(Message message) {
		super(message);
	}
	public LoginHistoryManagerException(List<Message> messageList) {
		super(messageList);
	}

}


