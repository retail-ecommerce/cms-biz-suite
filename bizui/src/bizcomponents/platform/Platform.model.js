

import pathToRegexp from 'path-to-regexp'
import { routerRedux } from 'dva/router'
import { notification } from 'antd'
import GlobalComponents from '../../custcomponents';
import appLocaleName from '../../common/Locale.tool'
import modeltool from '../../utils/modeltool'
const {setupModel,hasError,handleClientError,handleServerError,keepValueWithKeySuffix}=modeltool

const notifySuccess=(userContext)=>{

	notification.success({
        message: appLocaleName(userContext,'Success'),
        description: appLocaleName(userContext,'Success'),
      })

}


export default {

  namespace: '_platform',

  state: {},

  subscriptions: {
    
    setup({ dispatch, history }) { 
      history.listen((location) => {
      	const modelName = 'platform'
      	const parameter = {dispatch,history,location,modelName}
        //console.log("setupModel",setupModel,typeof(setupModel))
      	setupModel(parameter)

      })
    },
  },
  effects: {
    *view({ payload }, { call, put, select }) { 
    
      const cachedData = yield select(state => state._platform)
      //if the data in the cache, just show it, there is no delay
      const link = payload.pathname
      //if the data in the cache, just show it, there is no delay
      if(cachedData.class){
        //yield put({ type: 'breadcrumb/gotoLink', payload: { displayName:cachedData.displayName,link }} )
        yield put({ type: 'updateState', payload: cachedData })
        
        if(payload.useCache){
        	return //use cache for returning page
        }
        
      }else{
        yield put({ type: 'showLoading', payload })
      }
      
      const {PlatformService} = GlobalComponents;
      const data = yield call(PlatformService.view, payload.id)
      
      const displayName = payload.displayName||data.displayName
      
      
      yield put({ type: 'breadcrumb/gotoLink', payload: { displayName,link }} )
      

      yield put({ type: 'updateState', payload: data })
    },
    *load({ payload }, { call, put }) { 
      const {PlatformService} = GlobalComponents;
      //yield put({ type: 'showLoading', payload })
      const data = yield call(PlatformService.load, payload.id, payload.parameters)
      const newPlayload = { ...payload, ...data }
      
      console.log('this is the data id: ', data.id)
      yield put({ type: 'updateState', payload: newPlayload })
    },
    
    *doJob({ payload }, { call, put }) { 
      const userContext = null
      const {TaskService} = GlobalComponents;
      //yield put({ type: 'showLoading', payload })      
      const {serviceNameToCall, id, parameters} = payload;
      if(!serviceNameToCall){
      	handleClientError(appLocaleName(userContext,'ServiceNotRegistered'))
      	return;
      }
      "react/dva_object_model.jsp"
      
      const data = yield call(serviceNameToCall, id, parameters)
      if(handleServerError(data)){
      	return
      }
      const newPlayload = { ...payload, ...data }
      
      console.log('this is the data id: ', data.id)
      yield put({ type: 'updateState', payload: newPlayload })
    },
       
    
    
    *gotoCreateForm({ payload }, { put }) {
      const { id, role } = payload
      yield put(routerRedux.push(`/platform/${id}/list/${role}CreateForm`))
    },
    *gotoUpdateForm({ payload }, { put }) {
      const { id, role, selectedRows, currentUpdateIndex } = payload
      const state = { id, role, selectedRows, currentUpdateIndex }
      const location = { pathname: `/platform/${id}/list/${role}UpdateForm`, state }
      yield put(routerRedux.push(location))
    },
    *goback({ payload }, { put }) {
      const { id, type,listName } = payload
      yield put(routerRedux.push(`/platform/${id}/list/${type}List/${listName}`))
    },




    *addAlertBar({ payload }, { call, put }) {
      const userContext = null
      const {PlatformService} = GlobalComponents;

      const { id, role, parameters, continueNext } = payload
      console.log('get form parameters', parameters)
      const data = yield call(PlatformService.addAlertBar, id, parameters)
      if (hasError(data)) {
        handleServerError(data)
        return
      }
      const newPlayload = { ...payload, ...data }
      yield put({ type: 'updateState', payload: newPlayload })
      // yield put(routerRedux.push(`/platform/${id}/list/${role}CreateForm'))
      notifySuccess(userContext)
      if (continueNext) {
        return
      }
      const partialList = true
      const newState = {...data, partialList}
      const location = { pathname: `/platform/${id}/list/\AlertBarList/Alert Bar+${appLocaleName(userContext,'List')}`, state: newState }
      yield put(routerRedux.push(location))
    },
    *updateAlertBar({ payload }, { call, put }) {
      const userContext = null
      const {PlatformService} = GlobalComponents;      
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload
      console.log('get form parameters', parameters)
      const data = yield call(PlatformService.updateAlertBar, id, parameters)
      if (hasError(data)) {
        handleServerError(data)
        return
      }
      const partialList = true
      
      const newPlayload = { ...payload, ...data, selectedRows, currentUpdateIndex,partialList }
      yield put({ type: 'updateState', payload: newPlayload })
      notifySuccess(userContext)
      
      if (continueNext) {
        return
      }
      const location = { pathname: `/platform/${id}/list/\AlertBarList/Alert Bar列表`, state: newPlayload }
      yield put(routerRedux.push(location))
    },
    *gotoNextAlertBarUpdateRow({ payload }, { call, put }) {
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload
      const newPlayload = { ...payload, selectedRows, currentUpdateIndex }
      yield put({ type: 'updateState', payload: newPlayload })
    },
    *removeAlertBarList({ payload }, { call, put }) {
     const userContext = null
      const {PlatformService} = GlobalComponents; 
      const { id, role, parameters, continueNext } = payload
      console.log('get form parameters', parameters)
      const data = yield call(PlatformService.removeAlertBarList, id, parameters)
      if (hasError(data)) {
        handleServerError(data)
        return
      }
      const newPlayload = { ...payload, ...data }

      yield put({ type: 'updateState', payload: newPlayload })
      notifySuccess(userContext)
    },




    *addBanner({ payload }, { call, put }) {
      const userContext = null
      const {PlatformService} = GlobalComponents;

      const { id, role, parameters, continueNext } = payload
      console.log('get form parameters', parameters)
      const data = yield call(PlatformService.addBanner, id, parameters)
      if (hasError(data)) {
        handleServerError(data)
        return
      }
      const newPlayload = { ...payload, ...data }
      yield put({ type: 'updateState', payload: newPlayload })
      // yield put(routerRedux.push(`/platform/${id}/list/${role}CreateForm'))
      notifySuccess(userContext)
      if (continueNext) {
        return
      }
      const partialList = true
      const newState = {...data, partialList}
      const location = { pathname: `/platform/${id}/list/\BannerList/Banner+${appLocaleName(userContext,'List')}`, state: newState }
      yield put(routerRedux.push(location))
    },
    *updateBanner({ payload }, { call, put }) {
      const userContext = null
      const {PlatformService} = GlobalComponents;      
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload
      console.log('get form parameters', parameters)
      const data = yield call(PlatformService.updateBanner, id, parameters)
      if (hasError(data)) {
        handleServerError(data)
        return
      }
      const partialList = true
      
      const newPlayload = { ...payload, ...data, selectedRows, currentUpdateIndex,partialList }
      yield put({ type: 'updateState', payload: newPlayload })
      notifySuccess(userContext)
      
      if (continueNext) {
        return
      }
      const location = { pathname: `/platform/${id}/list/\BannerList/Banner列表`, state: newPlayload }
      yield put(routerRedux.push(location))
    },
    *gotoNextBannerUpdateRow({ payload }, { call, put }) {
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload
      const newPlayload = { ...payload, selectedRows, currentUpdateIndex }
      yield put({ type: 'updateState', payload: newPlayload })
    },
    *removeBannerList({ payload }, { call, put }) {
     const userContext = null
      const {PlatformService} = GlobalComponents; 
      const { id, role, parameters, continueNext } = payload
      console.log('get form parameters', parameters)
      const data = yield call(PlatformService.removeBannerList, id, parameters)
      if (hasError(data)) {
        handleServerError(data)
        return
      }
      const newPlayload = { ...payload, ...data }

      yield put({ type: 'updateState', payload: newPlayload })
      notifySuccess(userContext)
    },




    *addProfile({ payload }, { call, put }) {
      const userContext = null
      const {PlatformService} = GlobalComponents;

      const { id, role, parameters, continueNext } = payload
      console.log('get form parameters', parameters)
      const data = yield call(PlatformService.addProfile, id, parameters)
      if (hasError(data)) {
        handleServerError(data)
        return
      }
      const newPlayload = { ...payload, ...data }
      yield put({ type: 'updateState', payload: newPlayload })
      // yield put(routerRedux.push(`/platform/${id}/list/${role}CreateForm'))
      notifySuccess(userContext)
      if (continueNext) {
        return
      }
      const partialList = true
      const newState = {...data, partialList}
      const location = { pathname: `/platform/${id}/list/\ProfileList/Profile+${appLocaleName(userContext,'List')}`, state: newState }
      yield put(routerRedux.push(location))
    },
    *updateProfile({ payload }, { call, put }) {
      const userContext = null
      const {PlatformService} = GlobalComponents;      
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload
      console.log('get form parameters', parameters)
      const data = yield call(PlatformService.updateProfile, id, parameters)
      if (hasError(data)) {
        handleServerError(data)
        return
      }
      const partialList = true
      
      const newPlayload = { ...payload, ...data, selectedRows, currentUpdateIndex,partialList }
      yield put({ type: 'updateState', payload: newPlayload })
      notifySuccess(userContext)
      
      if (continueNext) {
        return
      }
      const location = { pathname: `/platform/${id}/list/\ProfileList/Profile列表`, state: newPlayload }
      yield put(routerRedux.push(location))
    },
    *gotoNextProfileUpdateRow({ payload }, { call, put }) {
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload
      const newPlayload = { ...payload, selectedRows, currentUpdateIndex }
      yield put({ type: 'updateState', payload: newPlayload })
    },
    *removeProfileList({ payload }, { call, put }) {
     const userContext = null
      const {PlatformService} = GlobalComponents; 
      const { id, role, parameters, continueNext } = payload
      console.log('get form parameters', parameters)
      const data = yield call(PlatformService.removeProfileList, id, parameters)
      if (hasError(data)) {
        handleServerError(data)
        return
      }
      const newPlayload = { ...payload, ...data }

      yield put({ type: 'updateState', payload: newPlayload })
      notifySuccess(userContext)
    },




    *addTarget({ payload }, { call, put }) {
      const userContext = null
      const {PlatformService} = GlobalComponents;

      const { id, role, parameters, continueNext } = payload
      console.log('get form parameters', parameters)
      const data = yield call(PlatformService.addTarget, id, parameters)
      if (hasError(data)) {
        handleServerError(data)
        return
      }
      const newPlayload = { ...payload, ...data }
      yield put({ type: 'updateState', payload: newPlayload })
      // yield put(routerRedux.push(`/platform/${id}/list/${role}CreateForm'))
      notifySuccess(userContext)
      if (continueNext) {
        return
      }
      const partialList = true
      const newState = {...data, partialList}
      const location = { pathname: `/platform/${id}/list/\TargetList/Target+${appLocaleName(userContext,'List')}`, state: newState }
      yield put(routerRedux.push(location))
    },
    *updateTarget({ payload }, { call, put }) {
      const userContext = null
      const {PlatformService} = GlobalComponents;      
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload
      console.log('get form parameters', parameters)
      const data = yield call(PlatformService.updateTarget, id, parameters)
      if (hasError(data)) {
        handleServerError(data)
        return
      }
      const partialList = true
      
      const newPlayload = { ...payload, ...data, selectedRows, currentUpdateIndex,partialList }
      yield put({ type: 'updateState', payload: newPlayload })
      notifySuccess(userContext)
      
      if (continueNext) {
        return
      }
      const location = { pathname: `/platform/${id}/list/\TargetList/Target列表`, state: newPlayload }
      yield put(routerRedux.push(location))
    },
    *gotoNextTargetUpdateRow({ payload }, { call, put }) {
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload
      const newPlayload = { ...payload, selectedRows, currentUpdateIndex }
      yield put({ type: 'updateState', payload: newPlayload })
    },
    *removeTargetList({ payload }, { call, put }) {
     const userContext = null
      const {PlatformService} = GlobalComponents; 
      const { id, role, parameters, continueNext } = payload
      console.log('get form parameters', parameters)
      const data = yield call(PlatformService.removeTargetList, id, parameters)
      if (hasError(data)) {
        handleServerError(data)
        return
      }
      const newPlayload = { ...payload, ...data }

      yield put({ type: 'updateState', payload: newPlayload })
      notifySuccess(userContext)
    },




    *addUserAlert({ payload }, { call, put }) {
      const userContext = null
      const {PlatformService} = GlobalComponents;

      const { id, role, parameters, continueNext } = payload
      console.log('get form parameters', parameters)
      const data = yield call(PlatformService.addUserAlert, id, parameters)
      if (hasError(data)) {
        handleServerError(data)
        return
      }
      const newPlayload = { ...payload, ...data }
      yield put({ type: 'updateState', payload: newPlayload })
      // yield put(routerRedux.push(`/platform/${id}/list/${role}CreateForm'))
      notifySuccess(userContext)
      if (continueNext) {
        return
      }
      const partialList = true
      const newState = {...data, partialList}
      const location = { pathname: `/platform/${id}/list/\UserAlertList/User Alert+${appLocaleName(userContext,'List')}`, state: newState }
      yield put(routerRedux.push(location))
    },
    *updateUserAlert({ payload }, { call, put }) {
      const userContext = null
      const {PlatformService} = GlobalComponents;      
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload
      console.log('get form parameters', parameters)
      const data = yield call(PlatformService.updateUserAlert, id, parameters)
      if (hasError(data)) {
        handleServerError(data)
        return
      }
      const partialList = true
      
      const newPlayload = { ...payload, ...data, selectedRows, currentUpdateIndex,partialList }
      yield put({ type: 'updateState', payload: newPlayload })
      notifySuccess(userContext)
      
      if (continueNext) {
        return
      }
      const location = { pathname: `/platform/${id}/list/\UserAlertList/User Alert列表`, state: newPlayload }
      yield put(routerRedux.push(location))
    },
    *gotoNextUserAlertUpdateRow({ payload }, { call, put }) {
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload
      const newPlayload = { ...payload, selectedRows, currentUpdateIndex }
      yield put({ type: 'updateState', payload: newPlayload })
    },
    *removeUserAlertList({ payload }, { call, put }) {
     const userContext = null
      const {PlatformService} = GlobalComponents; 
      const { id, role, parameters, continueNext } = payload
      console.log('get form parameters', parameters)
      const data = yield call(PlatformService.removeUserAlertList, id, parameters)
      if (hasError(data)) {
        handleServerError(data)
        return
      }
      const newPlayload = { ...payload, ...data }

      yield put({ type: 'updateState', payload: newPlayload })
      notifySuccess(userContext)
    },

  },
  
  reducers: {
    updateState(state, action) {
      const payload = { ...action.payload, loading: true }
      const valueToKeep = keepValueWithKeySuffix(state,"Parameters") 
      return { ...valueToKeep, ...payload}
    },
    showLoading(state, action) {
      // const loading=true
      const payload = { ...action.payload, loading: true }
      const valueToKeep = keepValueWithKeySuffix(state,"Parameters") 
      return { ...valueToKeep, ...payload}
    },
  },
}

