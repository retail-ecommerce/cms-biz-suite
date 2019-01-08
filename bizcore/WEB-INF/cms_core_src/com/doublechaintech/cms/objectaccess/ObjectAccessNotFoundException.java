
package com.doublechaintech.cms.objectaccess;
import com.doublechaintech.cms.EntityNotFoundException;
public class ObjectAccessNotFoundException extends EntityNotFoundException {
	private static final long serialVersionUID = 1L;
	public ObjectAccessNotFoundException(String string) {
		super(string);
	}

}

