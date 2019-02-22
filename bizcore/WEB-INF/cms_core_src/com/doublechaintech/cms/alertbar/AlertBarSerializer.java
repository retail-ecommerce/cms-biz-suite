package com.doublechaintech.cms.alertbar;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.cms.CmsObjectPlainCustomSerializer;
public class AlertBarSerializer extends CmsObjectPlainCustomSerializer<AlertBar>{

	@Override
	public void serialize(AlertBar alertBar, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, alertBar, provider);
		
	}
}


