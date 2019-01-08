
package com.doublechaintech.cms.secuser;
//import com.doublechaintech.cms.EntityNotFoundException;
import com.doublechaintech.cms.CmsException;
import com.doublechaintech.cms.Message;
import java.util.List;

public class SecUserManagerException extends CmsException {
	private static final long serialVersionUID = 1L;
	public SecUserManagerException(String string) {
		super(string);
	}
	public SecUserManagerException(Message message) {
		super(message);
	}
	public SecUserManagerException(List<Message> messageList) {
		super(messageList);
	}

}


