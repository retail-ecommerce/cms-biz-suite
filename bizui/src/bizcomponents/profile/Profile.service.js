import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}profileManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}profileManager/loadProfile/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidatePlatform = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}profileManager/requestCandidatePlatform/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherPlatform = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}profileManager/transferToAnotherPlatform/id/anotherPlatformId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addTarget = (targetObjectId, parameters) => {
  const url = `${PREFIX}profileManager/addTarget/profileId/name/bannerId/location/platformId/tokensExpr/`
  const profileId = targetObjectId
  const requestParameters = { ...parameters, profileId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateTarget = (targetObjectId, parameters) => {
  const url = `${PREFIX}profileManager/updateTargetProperties/profileId/id/name/location/tokensExpr/`
  const profileId = targetObjectId
  const requestParameters = { ...parameters, profileId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeTargetList = (targetObjectId, parameters) => {
  const url = `${PREFIX}profileManager/removeTargetList/profileId/targetIds/tokensExpr/`
  const requestParameters = { ...parameters, profileId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addUserAlert = (targetObjectId, parameters) => {
  const url = `${PREFIX}profileManager/addUserAlert/profileId/message/location/platformId/tokensExpr/`
  const profileId = targetObjectId
  const requestParameters = { ...parameters, profileId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateUserAlert = (targetObjectId, parameters) => {
  const url = `${PREFIX}profileManager/updateUserAlertProperties/profileId/id/message/location/tokensExpr/`
  const profileId = targetObjectId
  const requestParameters = { ...parameters, profileId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeUserAlertList = (targetObjectId, parameters) => {
  const url = `${PREFIX}profileManager/removeUserAlertList/profileId/userAlertIds/tokensExpr/`
  const requestParameters = { ...parameters, profileId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}


const ProfileService = { view,
  load,
  addTarget,
  addUserAlert,
  updateTarget,
  updateUserAlert,
  removeTargetList,
  removeUserAlertList,
  requestCandidatePlatform,
  transferToAnotherPlatform }
export default ProfileService

