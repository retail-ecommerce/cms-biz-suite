
package com.doublechaintech.cms.target;
//import com.doublechaintech.cms.EntityNotFoundException;
import com.doublechaintech.cms.CmsException;
import com.doublechaintech.cms.Message;
import java.util.List;

public class TargetManagerException extends CmsException {
	private static final long serialVersionUID = 1L;
	public TargetManagerException(String string) {
		super(string);
	}
	public TargetManagerException(Message message) {
		super(message);
	}
	public TargetManagerException(List<Message> messageList) {
		super(messageList);
	}

}


