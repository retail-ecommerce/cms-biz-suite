<%@ page import='java.util.*,com.doublechaintech.cms.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${ empty targetList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['target']}! 
		 <a href="./${ownerBeanName}Manager/addTarget/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty targetList}" >
    
    
<%

 	SmartList list=(SmartList)request.getAttribute("targetList"); 
 	int totalCount = list.getTotalCount();
 	List pages = list.getPages();
 	pageContext.setAttribute("rowsPerPage",list.getRowsPerPage()); 
 	
 	pageContext.setAttribute("pages",pages); 
 	pageContext.setAttribute("totalCount",totalCount); 
 	//pageContext.setAttribute("accessible",list.isAccessible()); 
 	//the reason using scriptlet here is the el express is currently not able resolv common property from a subclass of list
%>
    
 	   
    <div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		<i class='fa fa-table'></i> ${userContext.localeMap['target']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addTarget/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'targetList' eq action.actionGroup}">
		<a class="btn btn-${action.actionLevel} btn-sm" href="${action.managerBeanName}/${action.actionPath}">${userContext.localeMap[action.localeKey]}</a>
		</c:if>
	</c:forEach>
	</div><!--end of div class="btn-group" -->
	
		 
		 
		 
		 </div>
 </div>
    
    
<div class="table-responsive">


<c:set var="currentPageNumber" value="1"/>	



<nav aria-label="Page navigation example">
  <ul class="pagination">
<c:forEach var="page" items="${pages}"> 
<c:set var="classType" value=""/>
<c:if test='${page.selected}' >
<c:set var="classType" value="active"/>
<c:set var="currentPageNumber" value="${page.pageNumber}"/>
</c:if>


	<li class="page-item ${classType}">
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/${targetListName};${targetListName}CurrentPage=${page.pageNumber};${targetListName}RowsPerPage=${rowsPerPage}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='targetListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['target.id']}</th>
</c:if>
<c:if test="${param.referName ne 'name'}">
	<th>${userContext.localeMap['target.name']}</th>
</c:if>
<c:if test="${param.referName ne 'profile'}">
	<th>${userContext.localeMap['target.profile']}</th>
</c:if>
<c:if test="${param.referName ne 'banner'}">
	<th>${userContext.localeMap['target.banner']}</th>
</c:if>
<c:if test="${param.referName ne 'when'}">
	<th>${userContext.localeMap['target.when']}</th>
</c:if>
<c:if test="${param.referName ne 'location'}">
	<th>${userContext.localeMap['target.location']}</th>
</c:if>
<c:if test="${param.referName ne 'lastUpdate'}">
	<th>${userContext.localeMap['target.lastUpdate']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${targetList}">
				<tr currentVersion='${item.version}' id="target-${item.id}" ><td><a class="link-action-removed" href="./targetManager/view/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'name'}">	<td contenteditable='true' class='edit-value'  propertyToChange='name' storedCellValue='${item.name}' prefix='${ownerBeanName}Manager/updateTarget/${result.id}/${item.id}/'>${item.name}</td>
</c:if><c:if test="${param.referName ne 'profile'}">
	<td class="select_candidate_td"
			data-candidate-method="./targetManager/requestCandidateProfile/${ownerBeanName}/${item.id}/"
			data-switch-method="./targetManager/transferToAnotherProfile/${item.id}/"
			data-link-template="./profileManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.profile}">
			<a href='./profileManager/view/${item.profile.id}/'>${item.profile.displayName}</a>
			</c:if>
			<c:if test="${empty  item.profile}">
			<a href='#'></a>
			</c:if>
			<button class="btn btn-link candidate-action">...</button>
		</span>
		<div class="candidate_span" style="display:none;">
			<input type="text" data-provide="typeahead" class="input-sm form-control candidate-filter-input" autocomplete="off" />
		</div>
	</td>
</c:if>
<c:if test="${param.referName ne 'banner'}">
	<td class="select_candidate_td"
			data-candidate-method="./targetManager/requestCandidateBanner/${ownerBeanName}/${item.id}/"
			data-switch-method="./targetManager/transferToAnotherBanner/${item.id}/"
			data-link-template="./bannerManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.banner}">
			<a href='./bannerManager/view/${item.banner.id}/'>${item.banner.displayName}</a>
			</c:if>
			<c:if test="${empty  item.banner}">
			<a href='#'></a>
			</c:if>
			<button class="btn btn-link candidate-action">...</button>
		</span>
		<div class="candidate_span" style="display:none;">
			<input type="text" data-provide="typeahead" class="input-sm form-control candidate-filter-input" autocomplete="off" />
		</div>
	</td>
</c:if>
<c:if test="${param.referName ne 'when'}">	<td contenteditable='true' class='edit-value'  propertyToChange='when' storedCellValue='${item.when}' prefix='${ownerBeanName}Manager/updateTarget/${result.id}/${item.id}/'>${item.when}</td>
</c:if><c:if test="${param.referName ne 'location'}">	<td contenteditable='true' class='edit-value'  propertyToChange='location' storedCellValue='${item.location}' prefix='${ownerBeanName}Manager/updateTarget/${result.id}/${item.id}/'>${item.location}</td>
</c:if><c:if test="${param.referName ne 'lastUpdate'}">	<td contenteditable='true' class='edit-value'  propertyToChange='lastUpdate' storedCellValue='${item.lastUpdate}' prefix='${ownerBeanName}Manager/updateTarget/${result.id}/${item.id}/'><fmt:formatDate pattern="yyyy-MM-dd'T'HH:mm:ss" value="${item.lastUpdate}" /></td>
</c:if>
				<td>

				<a href='#${ownerBeanName}Manager/removeTarget/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyTargetFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


