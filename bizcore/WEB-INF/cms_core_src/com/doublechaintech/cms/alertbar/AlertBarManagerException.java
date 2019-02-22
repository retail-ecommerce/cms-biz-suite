
package com.doublechaintech.cms.alertbar;
//import com.doublechaintech.cms.EntityNotFoundException;
import com.doublechaintech.cms.CmsException;
import com.doublechaintech.cms.Message;
import java.util.List;

public class AlertBarManagerException extends CmsException {
	private static final long serialVersionUID = 1L;
	public AlertBarManagerException(String string) {
		super(string);
	}
	public AlertBarManagerException(Message message) {
		super(message);
	}
	public AlertBarManagerException(List<Message> messageList) {
		super(messageList);
	}

}


