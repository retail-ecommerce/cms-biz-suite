
package com.doublechaintech.cms.objectaccess;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.cms.CmsUserContext;
import com.doublechaintech.cms.BaseEntity;
import com.doublechaintech.cms.SmartList;

public interface ObjectAccessManager{

		

	public ObjectAccess createObjectAccess(CmsUserContext userContext, String name, String objectType, String list1, String list2, String list3, String list4, String list5, String list6, String list7, String list8, String list9, String appId) throws Exception;	
	public ObjectAccess updateObjectAccess(CmsUserContext userContext,String objectAccessId, int objectAccessVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public ObjectAccess loadObjectAccess(CmsUserContext userContext, String objectAccessId, String [] tokensExpr) throws Exception;
	public ObjectAccess internalSaveObjectAccess(CmsUserContext userContext, ObjectAccess objectAccess) throws Exception;
	public ObjectAccess internalSaveObjectAccess(CmsUserContext userContext, ObjectAccess objectAccess,Map<String,Object>option) throws Exception;
	
	public ObjectAccess transferToAnotherApp(CmsUserContext userContext, String objectAccessId, String anotherAppId)  throws Exception;
 

	public void delete(CmsUserContext userContext, String objectAccessId, int version) throws Exception;
	public int deleteAll(CmsUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(CmsUserContext userContext, ObjectAccess newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


