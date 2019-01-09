package com.doublechaintech.cms.platform;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.cms.CmsObjectPlainCustomSerializer;
public class PlatformSerializer extends CmsObjectPlainCustomSerializer<Platform>{

	@Override
	public void serialize(Platform platform, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, platform, provider);
		
	}
}


