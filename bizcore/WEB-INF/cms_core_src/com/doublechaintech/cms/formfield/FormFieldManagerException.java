
package com.doublechaintech.cms.formfield;
//import com.doublechaintech.cms.EntityNotFoundException;
import com.doublechaintech.cms.CmsException;
import com.doublechaintech.cms.Message;
import java.util.List;

public class FormFieldManagerException extends CmsException {
	private static final long serialVersionUID = 1L;
	public FormFieldManagerException(String string) {
		super(string);
	}
	public FormFieldManagerException(Message message) {
		super(message);
	}
	public FormFieldManagerException(List<Message> messageList) {
		super(messageList);
	}

}


