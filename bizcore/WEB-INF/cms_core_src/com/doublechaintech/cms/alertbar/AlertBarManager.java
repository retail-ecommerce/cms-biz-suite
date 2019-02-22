
package com.doublechaintech.cms.alertbar;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.cms.CmsUserContext;
import com.doublechaintech.cms.BaseEntity;
import com.doublechaintech.cms.SmartList;

public interface AlertBarManager{

		

	public AlertBar createAlertBar(CmsUserContext userContext, String name, String message, String platformId) throws Exception;	
	public AlertBar updateAlertBar(CmsUserContext userContext,String alertBarId, int alertBarVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public AlertBar loadAlertBar(CmsUserContext userContext, String alertBarId, String [] tokensExpr) throws Exception;
	public AlertBar internalSaveAlertBar(CmsUserContext userContext, AlertBar alertBar) throws Exception;
	public AlertBar internalSaveAlertBar(CmsUserContext userContext, AlertBar alertBar,Map<String,Object>option) throws Exception;
	
	public AlertBar transferToAnotherPlatform(CmsUserContext userContext, String alertBarId, String anotherPlatformId)  throws Exception;
 

	public void delete(CmsUserContext userContext, String alertBarId, int version) throws Exception;
	public int deleteAll(CmsUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(CmsUserContext userContext, AlertBar newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


