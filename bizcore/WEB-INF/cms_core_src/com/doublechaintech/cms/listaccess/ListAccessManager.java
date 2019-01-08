
package com.doublechaintech.cms.listaccess;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.cms.CmsUserContext;
import com.doublechaintech.cms.BaseEntity;
import com.doublechaintech.cms.SmartList;

public interface ListAccessManager{

		

	public ListAccess createListAccess(CmsUserContext userContext, String name, String internalName, boolean readPermission, boolean createPermission, boolean deletePermission, boolean updatePermission, boolean executionPermission, String appId) throws Exception;	
	public ListAccess updateListAccess(CmsUserContext userContext,String listAccessId, int listAccessVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public ListAccess loadListAccess(CmsUserContext userContext, String listAccessId, String [] tokensExpr) throws Exception;
	public ListAccess internalSaveListAccess(CmsUserContext userContext, ListAccess listAccess) throws Exception;
	public ListAccess internalSaveListAccess(CmsUserContext userContext, ListAccess listAccess,Map<String,Object>option) throws Exception;
	
	public ListAccess transferToAnotherApp(CmsUserContext userContext, String listAccessId, String anotherAppId)  throws Exception;
 

	public void delete(CmsUserContext userContext, String listAccessId, int version) throws Exception;
	public int deleteAll(CmsUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(CmsUserContext userContext, ListAccess newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


