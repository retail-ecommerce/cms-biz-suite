package com.doublechaintech.cms.target;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.cms.CmsObjectPlainCustomSerializer;
public class TargetSerializer extends CmsObjectPlainCustomSerializer<Target>{

	@Override
	public void serialize(Target target, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, target, provider);
		
	}
}


