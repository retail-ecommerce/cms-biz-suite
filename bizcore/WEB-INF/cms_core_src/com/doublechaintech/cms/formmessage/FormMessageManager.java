
package com.doublechaintech.cms.formmessage;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.cms.CmsUserContext;
import com.doublechaintech.cms.BaseEntity;
import com.doublechaintech.cms.SmartList;

public interface FormMessageManager{

		

	public FormMessage createFormMessage(CmsUserContext userContext, String title, String formId, String level) throws Exception;	
	public FormMessage updateFormMessage(CmsUserContext userContext,String formMessageId, int formMessageVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public FormMessage loadFormMessage(CmsUserContext userContext, String formMessageId, String [] tokensExpr) throws Exception;
	public FormMessage internalSaveFormMessage(CmsUserContext userContext, FormMessage formMessage) throws Exception;
	public FormMessage internalSaveFormMessage(CmsUserContext userContext, FormMessage formMessage,Map<String,Object>option) throws Exception;
	
	public FormMessage transferToAnotherForm(CmsUserContext userContext, String formMessageId, String anotherFormId)  throws Exception;
 

	public void delete(CmsUserContext userContext, String formMessageId, int version) throws Exception;
	public int deleteAll(CmsUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(CmsUserContext userContext, FormMessage newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


