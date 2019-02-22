import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}platformManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}platformManager/loadPlatform/${targetObjectId}/${parametersExpr}/`,
  })
}







const addAlertBar = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/addAlertBar/platformId/name/message/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateAlertBar = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/updateAlertBarProperties/platformId/id/name/message/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeAlertBarList = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/removeAlertBarList/platformId/alertBarIds/tokensExpr/`
  const requestParameters = { ...parameters, platformId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addBanner = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/addBanner/platformId/name/imagePath/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateBanner = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/updateBannerProperties/platformId/id/name/imagePath/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeBannerList = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/removeBannerList/platformId/bannerIds/tokensExpr/`
  const requestParameters = { ...parameters, platformId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addProfile = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/addProfile/platformId/name/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateProfile = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/updateProfileProperties/platformId/id/name/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeProfileList = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/removeProfileList/platformId/profileIds/tokensExpr/`
  const requestParameters = { ...parameters, platformId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addTarget = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/addTarget/platformId/name/profileId/bannerId/location/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateTarget = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/updateTargetProperties/platformId/id/name/location/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeTargetList = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/removeTargetList/platformId/targetIds/tokensExpr/`
  const requestParameters = { ...parameters, platformId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addUserAlert = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/addUserAlert/platformId/message/profileId/location/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateUserAlert = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/updateUserAlertProperties/platformId/id/message/location/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeUserAlertList = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/removeUserAlertList/platformId/userAlertIds/tokensExpr/`
  const requestParameters = { ...parameters, platformId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}


const PlatformService = { view,
  load,
  addAlertBar,
  addBanner,
  addProfile,
  addTarget,
  addUserAlert,
  updateAlertBar,
  updateBanner,
  updateProfile,
  updateTarget,
  updateUserAlert,
  removeAlertBarList,
  removeBannerList,
  removeProfileList,
  removeTargetList,
  removeUserAlertList }
export default PlatformService

