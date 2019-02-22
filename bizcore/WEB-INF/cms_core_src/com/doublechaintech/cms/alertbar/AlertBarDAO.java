
package com.doublechaintech.cms.alertbar;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.cms.BaseEntity;
import com.doublechaintech.cms.SmartList;
import com.doublechaintech.cms.MultipleAccessKey;
import com.doublechaintech.cms.CmsUserContext;
import com.doublechaintech.cms.platform.PlatformDAO;


public interface AlertBarDAO{

	
	public AlertBar load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<AlertBar> alertBarList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public AlertBar present(AlertBar alertBar,Map<String,Object> options) throws Exception;
	public AlertBar clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public AlertBar save(AlertBar alertBar,Map<String,Object> options);
	public SmartList<AlertBar> saveAlertBarList(SmartList<AlertBar> alertBarList,Map<String,Object> options);
	public SmartList<AlertBar> removeAlertBarList(SmartList<AlertBar> alertBarList,Map<String,Object> options);
	public SmartList<AlertBar> findAlertBarWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countAlertBarWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countAlertBarWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String alertBarId, int version) throws Exception;
	public AlertBar disconnectFromAll(String alertBarId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<AlertBar> queryList(String sql, Object ... parmeters);
 
 	public SmartList<AlertBar> findAlertBarByPlatform(String platformId, Map<String,Object> options);
 	public int countAlertBarByPlatform(String platformId, Map<String,Object> options);
 	public Map<String, Integer> countAlertBarByPlatformIds(String[] ids, Map<String,Object> options);
 	public SmartList<AlertBar> findAlertBarByPlatform(String platformId, int start, int count, Map<String,Object> options);
 	public void analyzeAlertBarByPlatform(SmartList<AlertBar> resultList, String platformId, Map<String,Object> options);

 
 }


