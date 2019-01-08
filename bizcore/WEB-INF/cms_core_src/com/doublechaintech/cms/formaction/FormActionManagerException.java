
package com.doublechaintech.cms.formaction;
//import com.doublechaintech.cms.EntityNotFoundException;
import com.doublechaintech.cms.CmsException;
import com.doublechaintech.cms.Message;
import java.util.List;

public class FormActionManagerException extends CmsException {
	private static final long serialVersionUID = 1L;
	public FormActionManagerException(String string) {
		super(string);
	}
	public FormActionManagerException(Message message) {
		super(message);
	}
	public FormActionManagerException(List<Message> messageList) {
		super(messageList);
	}

}












