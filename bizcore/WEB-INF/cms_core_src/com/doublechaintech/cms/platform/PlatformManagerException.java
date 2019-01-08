
package com.doublechaintech.cms.platform;
//import com.doublechaintech.cms.EntityNotFoundException;
import com.doublechaintech.cms.CmsException;
import com.doublechaintech.cms.Message;
import java.util.List;

public class PlatformManagerException extends CmsException {
	private static final long serialVersionUID = 1L;
	public PlatformManagerException(String string) {
		super(string);
	}
	public PlatformManagerException(Message message) {
		super(message);
	}
	public PlatformManagerException(List<Message> messageList) {
		super(messageList);
	}

}


