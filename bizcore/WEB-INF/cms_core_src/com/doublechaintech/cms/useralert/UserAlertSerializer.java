package com.doublechaintech.cms.useralert;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.cms.CmsObjectPlainCustomSerializer;
public class UserAlertSerializer extends CmsObjectPlainCustomSerializer<UserAlert>{

	@Override
	public void serialize(UserAlert userAlert, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, userAlert, provider);
		
	}
}


