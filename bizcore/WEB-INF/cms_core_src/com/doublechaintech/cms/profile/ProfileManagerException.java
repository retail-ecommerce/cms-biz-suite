
package com.doublechaintech.cms.profile;
//import com.doublechaintech.cms.EntityNotFoundException;
import com.doublechaintech.cms.CmsException;
import com.doublechaintech.cms.Message;
import java.util.List;

public class ProfileManagerException extends CmsException {
	private static final long serialVersionUID = 1L;
	public ProfileManagerException(String string) {
		super(string);
	}
	public ProfileManagerException(Message message) {
		super(message);
	}
	public ProfileManagerException(List<Message> messageList) {
		super(messageList);
	}

}


