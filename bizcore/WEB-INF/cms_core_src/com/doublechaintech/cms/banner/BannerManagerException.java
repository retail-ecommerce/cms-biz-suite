
package com.doublechaintech.cms.banner;
//import com.doublechaintech.cms.EntityNotFoundException;
import com.doublechaintech.cms.CmsException;
import com.doublechaintech.cms.Message;
import java.util.List;

public class BannerManagerException extends CmsException {
	private static final long serialVersionUID = 1L;
	public BannerManagerException(String string) {
		super(string);
	}
	public BannerManagerException(Message message) {
		super(message);
	}
	public BannerManagerException(List<Message> messageList) {
		super(messageList);
	}

}


