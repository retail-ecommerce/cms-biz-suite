import React from 'react'
import PropTypes from 'prop-types'
import {
  Layout,
  Menu,
  Icon,
  Avatar,
  Dropdown,
  Tag,
  message,
  Spin,
  Breadcrumb,
  AutoComplete,
  Input,Button
} from 'antd'
import DocumentTitle from 'react-document-title'
import { connect } from 'dva'
import { Link, Route, Redirect, Switch } from 'dva/router'
import moment from 'moment'
import groupBy from 'lodash/groupBy'
import { ContainerQuery } from 'react-container-query'
import classNames from 'classnames'
import styles from './Platform.app.less'
import {sessionObject} from '../../utils/utils'

import HeaderSearch from '../../components/HeaderSearch';
import NoticeIcon from '../../components/NoticeIcon';
import GlobalFooter from '../../components/GlobalFooter';


import GlobalComponents from '../../custcomponents';

import PermissionSettingService from '../../permission/PermissionSetting.service'
import appLocaleName from '../../common/Locale.tool'

const  {  filterForMenuPermission } = PermissionSettingService

const isMenuItemForDisplay = (item, targetObject, targetComponent) => {
  return true
}

const filteredMenuItems = (targetObject, targetComponent) => {
    const menuData = sessionObject('menuData')
    const isMenuItemForDisplayFunc = targetComponent.props.isMenuItemForDisplayFunc||isMenuItemForDisplay
    return menuData.subItems.filter(item=>filterForMenuPermission(item,targetObject,targetComponent)).filter(item=>isMenuItemForDisplayFunc(item,targetObject,targetComponent))
}



const { Header, Sider, Content } = Layout
const { SubMenu } = Menu

const query = {
  'screen-xs': {
    maxWidth: 575,
  },
  'screen-sm': {
    minWidth: 576,
    maxWidth: 767,
  },
  'screen-md': {
    minWidth: 768,
    maxWidth: 991,
  },
  'screen-lg': {
    minWidth: 992,
    maxWidth: 1199,
  },
  'screen-xl': {
    minWidth: 1200,
  },
}




class PlatformBizApp extends React.PureComponent {
  constructor(props) {
    super(props)
     this.state = {
      openKeys: this.getDefaultCollapsedSubMenus(props),
    }
  }

  componentDidMount() {}
  componentWillUnmount() {
    clearTimeout(this.resizeTimeout)
  }
  onCollapse = (collapsed) => {
    this.props.dispatch({
      type: 'global/changeLayoutCollapsed',
      payload: collapsed,
    })
  }

  getDefaultCollapsedSubMenus = (props) => {
    const currentMenuSelectedKeys = [...this.getCurrentMenuSelectedKeys(props)]
    currentMenuSelectedKeys.splice(-1, 1)
    if (currentMenuSelectedKeys.length === 0) {
      return ['/platform/']
    }
    return currentMenuSelectedKeys
  }
  getCurrentMenuSelectedKeys = (props) => {
    const { location: { pathname } } = props || this.props
    const keys = pathname.split('/').slice(1)
    if (keys.length === 1 && keys[0] === '') {
      return [this.menus[0].key]
    }
    return keys
  }
  
  getNavMenuItems = (targetObject) => {
  

    const menuData = sessionObject('menuData')
    const targetApp = sessionObject('targetApp')
	const {objectId}=targetApp;
  	const userContext = null
    return (
      
		  <Menu
             theme="dark"
             mode="inline"
            
             
             onOpenChange={this.handleOpenChange}
            
             defaultOpenKeys={['firstOne']}
             style={{ margin: '16px 0', width: '100%' }}
           >
           

             <Menu.Item key="dashboard">
               <Link to={`/platform/${this.props.platform.id}/dashboard`}><Icon type="dashboard" /><span>{appLocaleName(userContext,"Dashboard")}</span></Link>
             </Menu.Item>
             
		 <Menu.Item key="homepage">
               <Link to={"/home"}><Icon type="home" /><span>{appLocaleName(userContext,"Home")}</span></Link>
             </Menu.Item>
             
             
         {filteredMenuItems(targetObject,this).map((item)=>(<Menu.Item key={item.name}>
          <Link to={`/${menuData.menuFor}/${objectId}/list/${item.name}/${item.displayName}${appLocaleName(userContext,"List")}`}>
          <Icon type="bars" /><span>{item.displayName}</span>
          </Link>
        </Menu.Item>))}
       
       <Menu.Item key="preference">
               <Link to={`/platform/${this.props.platform.id}/preference`}><Icon type="setting" /><span>{appLocaleName(userContext,"Preference")}</span></Link>
             </Menu.Item>
      
           </Menu>
    )
  }
  



  getAlertBarSearch = () => {
    const {AlertBarSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "Alert Bar",
      role: "alertBar",
      data: state._platform.alertBarList,
      metaInfo: state._platform.alertBarListMetaInfo,
      count: state._platform.alertBarCount,
      currentPage: state._platform.alertBarCurrentPageNumber,
      searchFormParameters: state._platform.alertBarSearchFormParameters,
      searchParameters: {...state._platform.searchParameters},
      expandForm: state._platform.expandForm,
      loading: state._platform.loading,
      partialList: state._platform.partialList,
      owner: { type: '_platform', id: state._platform.id, 
      referenceName: 'platform', 
      listName: 'alertBarList', ref:state._platform, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(AlertBarSearch)
  }
  getAlertBarCreateForm = () => {
   	const {AlertBarCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "alertBar",
      data: state._platform.alertBarList,
      metaInfo: state._platform.alertBarListMetaInfo,
      count: state._platform.alertBarCount,
      currentPage: state._platform.alertBarCurrentPageNumber,
      searchFormParameters: state._platform.alertBarSearchFormParameters,
      loading: state._platform.loading,
      owner: { type: '_platform', id: state._platform.id, referenceName: 'platform', listName: 'alertBarList', ref:state._platform, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(AlertBarCreateForm)
  }
  
  getAlertBarUpdateForm = () => {
    const userContext = null
  	const {AlertBarUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._platform.selectedRows,
      role: "alertBar",
      currentUpdateIndex: state._platform.currentUpdateIndex,
      owner: { type: '_platform', id: state._platform.id, listName: 'alertBarList', ref:state._platform, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(AlertBarUpdateForm)
  }

  getBannerSearch = () => {
    const {BannerSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "Banner",
      role: "banner",
      data: state._platform.bannerList,
      metaInfo: state._platform.bannerListMetaInfo,
      count: state._platform.bannerCount,
      currentPage: state._platform.bannerCurrentPageNumber,
      searchFormParameters: state._platform.bannerSearchFormParameters,
      searchParameters: {...state._platform.searchParameters},
      expandForm: state._platform.expandForm,
      loading: state._platform.loading,
      partialList: state._platform.partialList,
      owner: { type: '_platform', id: state._platform.id, 
      referenceName: 'platform', 
      listName: 'bannerList', ref:state._platform, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(BannerSearch)
  }
  getBannerCreateForm = () => {
   	const {BannerCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "banner",
      data: state._platform.bannerList,
      metaInfo: state._platform.bannerListMetaInfo,
      count: state._platform.bannerCount,
      currentPage: state._platform.bannerCurrentPageNumber,
      searchFormParameters: state._platform.bannerSearchFormParameters,
      loading: state._platform.loading,
      owner: { type: '_platform', id: state._platform.id, referenceName: 'platform', listName: 'bannerList', ref:state._platform, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(BannerCreateForm)
  }
  
  getBannerUpdateForm = () => {
    const userContext = null
  	const {BannerUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._platform.selectedRows,
      role: "banner",
      currentUpdateIndex: state._platform.currentUpdateIndex,
      owner: { type: '_platform', id: state._platform.id, listName: 'bannerList', ref:state._platform, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(BannerUpdateForm)
  }

  getProfileSearch = () => {
    const {ProfileSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "Profile",
      role: "profile",
      data: state._platform.profileList,
      metaInfo: state._platform.profileListMetaInfo,
      count: state._platform.profileCount,
      currentPage: state._platform.profileCurrentPageNumber,
      searchFormParameters: state._platform.profileSearchFormParameters,
      searchParameters: {...state._platform.searchParameters},
      expandForm: state._platform.expandForm,
      loading: state._platform.loading,
      partialList: state._platform.partialList,
      owner: { type: '_platform', id: state._platform.id, 
      referenceName: 'platform', 
      listName: 'profileList', ref:state._platform, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(ProfileSearch)
  }
  getProfileCreateForm = () => {
   	const {ProfileCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "profile",
      data: state._platform.profileList,
      metaInfo: state._platform.profileListMetaInfo,
      count: state._platform.profileCount,
      currentPage: state._platform.profileCurrentPageNumber,
      searchFormParameters: state._platform.profileSearchFormParameters,
      loading: state._platform.loading,
      owner: { type: '_platform', id: state._platform.id, referenceName: 'platform', listName: 'profileList', ref:state._platform, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(ProfileCreateForm)
  }
  
  getProfileUpdateForm = () => {
    const userContext = null
  	const {ProfileUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._platform.selectedRows,
      role: "profile",
      currentUpdateIndex: state._platform.currentUpdateIndex,
      owner: { type: '_platform', id: state._platform.id, listName: 'profileList', ref:state._platform, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(ProfileUpdateForm)
  }

  getTargetSearch = () => {
    const {TargetSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "Target",
      role: "target",
      data: state._platform.targetList,
      metaInfo: state._platform.targetListMetaInfo,
      count: state._platform.targetCount,
      currentPage: state._platform.targetCurrentPageNumber,
      searchFormParameters: state._platform.targetSearchFormParameters,
      searchParameters: {...state._platform.searchParameters},
      expandForm: state._platform.expandForm,
      loading: state._platform.loading,
      partialList: state._platform.partialList,
      owner: { type: '_platform', id: state._platform.id, 
      referenceName: 'platform', 
      listName: 'targetList', ref:state._platform, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(TargetSearch)
  }
  getTargetCreateForm = () => {
   	const {TargetCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "target",
      data: state._platform.targetList,
      metaInfo: state._platform.targetListMetaInfo,
      count: state._platform.targetCount,
      currentPage: state._platform.targetCurrentPageNumber,
      searchFormParameters: state._platform.targetSearchFormParameters,
      loading: state._platform.loading,
      owner: { type: '_platform', id: state._platform.id, referenceName: 'platform', listName: 'targetList', ref:state._platform, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(TargetCreateForm)
  }
  
  getTargetUpdateForm = () => {
    const userContext = null
  	const {TargetUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._platform.selectedRows,
      role: "target",
      currentUpdateIndex: state._platform.currentUpdateIndex,
      owner: { type: '_platform', id: state._platform.id, listName: 'targetList', ref:state._platform, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(TargetUpdateForm)
  }

  getUserAlertSearch = () => {
    const {UserAlertSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "User Alert",
      role: "userAlert",
      data: state._platform.userAlertList,
      metaInfo: state._platform.userAlertListMetaInfo,
      count: state._platform.userAlertCount,
      currentPage: state._platform.userAlertCurrentPageNumber,
      searchFormParameters: state._platform.userAlertSearchFormParameters,
      searchParameters: {...state._platform.searchParameters},
      expandForm: state._platform.expandForm,
      loading: state._platform.loading,
      partialList: state._platform.partialList,
      owner: { type: '_platform', id: state._platform.id, 
      referenceName: 'platform', 
      listName: 'userAlertList', ref:state._platform, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(UserAlertSearch)
  }
  getUserAlertCreateForm = () => {
   	const {UserAlertCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "userAlert",
      data: state._platform.userAlertList,
      metaInfo: state._platform.userAlertListMetaInfo,
      count: state._platform.userAlertCount,
      currentPage: state._platform.userAlertCurrentPageNumber,
      searchFormParameters: state._platform.userAlertSearchFormParameters,
      loading: state._platform.loading,
      owner: { type: '_platform', id: state._platform.id, referenceName: 'platform', listName: 'userAlertList', ref:state._platform, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(UserAlertCreateForm)
  }
  
  getUserAlertUpdateForm = () => {
    const userContext = null
  	const {UserAlertUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._platform.selectedRows,
      role: "userAlert",
      currentUpdateIndex: state._platform.currentUpdateIndex,
      owner: { type: '_platform', id: state._platform.id, listName: 'userAlertList', ref:state._platform, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(UserAlertUpdateForm)
  }


  
  buildRouters = () =>{
  	const {PlatformDashboard} = GlobalComponents
  	const {PlatformPreference} = GlobalComponents
  	
  	
  	const routers=[
  	{path:"/platform/:id/dashboard", component: PlatformDashboard},
  	{path:"/platform/:id/preference", component: PlatformPreference},
  	
  	
  	
  	{path:"/platform/:id/list/alertBarList", component: this.getAlertBarSearch()},
  	{path:"/platform/:id/list/alertBarCreateForm", component: this.getAlertBarCreateForm()},
  	{path:"/platform/:id/list/alertBarUpdateForm", component: this.getAlertBarUpdateForm()},
   	
  	{path:"/platform/:id/list/bannerList", component: this.getBannerSearch()},
  	{path:"/platform/:id/list/bannerCreateForm", component: this.getBannerCreateForm()},
  	{path:"/platform/:id/list/bannerUpdateForm", component: this.getBannerUpdateForm()},
   	
  	{path:"/platform/:id/list/profileList", component: this.getProfileSearch()},
  	{path:"/platform/:id/list/profileCreateForm", component: this.getProfileCreateForm()},
  	{path:"/platform/:id/list/profileUpdateForm", component: this.getProfileUpdateForm()},
   	
  	{path:"/platform/:id/list/targetList", component: this.getTargetSearch()},
  	{path:"/platform/:id/list/targetCreateForm", component: this.getTargetCreateForm()},
  	{path:"/platform/:id/list/targetUpdateForm", component: this.getTargetUpdateForm()},
   	
  	{path:"/platform/:id/list/userAlertList", component: this.getUserAlertSearch()},
  	{path:"/platform/:id/list/userAlertCreateForm", component: this.getUserAlertCreateForm()},
  	{path:"/platform/:id/list/userAlertUpdateForm", component: this.getUserAlertUpdateForm()},
     	
  	
  	]
  	
  	const {extraRoutesFunc} = this.props;
	const extraRoutes = extraRoutesFunc?extraRoutesFunc():[]
    const finalRoutes = routers.concat(extraRoutes)
    
  	return (<Switch>
             {finalRoutes.map((item)=>(<Route key={item.path} path={item.path} component={item.component} />))}    
  	  	</Switch>)
  	
  
  }
 

  getPageTitle = () => {
    // const { location } = this.props
    // const { pathname } = location
    const title = 'Content Management Services'
    return title
  }
 
  handleOpenChange = (openKeys) => {
    const latestOpenKey = openKeys.find(key => this.state.openKeys.indexOf(key) === -1)
    this.setState({
      openKeys: latestOpenKey ? [latestOpenKey] : [],
    })
  }
   toggle = () => {
     const { collapsed } = this.props
     this.props.dispatch({
       type: 'global/changeLayoutCollapsed',
       payload: !collapsed,
     })
   }
    logout = () => {
   
    console.log("log out called")
    this.props.dispatch({ type: 'launcher/signOut' })
  }
   render() {
     // const { collapsed, fetchingNotices,loading } = this.props
     const { collapsed } = this.props
     const { breadcrumb }  = this.props
  
     const targetApp = sessionObject('targetApp')
     const currentBreadcrumb =sessionObject(targetApp.id)
     const userContext = null
     
     const menuProps = collapsed ? {} : {
       openKeys: this.state.openKeys,
     }
     const layout = (
     <Layout>
        <Header>
          
          <div className={styles.left}>
          <img
            src="./favicon.png"
            alt="logo"
            onClick={this.toggle}
            className={styles.logo}
          />
          {currentBreadcrumb.map((item)=>{
            return (<Link  key={item.link} to={`${item.link}`} className={styles.breadcrumbLink}> &gt;{item.name}</Link>)

          })}
         </div>
          <div className={styles.right}  >
          <Button type="primary"  icon="logout" onClick={()=>this.logout()}>
          {appLocaleName(userContext,"Exit")}</Button>
          </div>
          
        </Header>
       <Layout>
         <Sider
           trigger={null}
           collapsible
           collapsed={collapsed}
           breakpoint="md"
           onCollapse={()=>this.onCollapse(collapsed)}
           collapsedWidth={56}
           className={styles.sider}
         >

		 {this.getNavMenuItems(this.props.platform)}
		 
         </Sider>
         <Layout>
           <Content style={{ margin: '24px 24px 0', height: '100%' }}>
           
           {this.buildRouters()}
 
             
             
           </Content>
          </Layout>
        </Layout>
      </Layout>
     )
     return (
       <DocumentTitle title={this.getPageTitle()}>
         <ContainerQuery query={query}>
           {params => <div className={classNames(params)}>{layout}</div>}
         </ContainerQuery>
       </DocumentTitle>
     )
   }
}

export default connect(state => ({
  collapsed: state.global.collapsed,
  fetchingNotices: state.global.fetchingNotices,
  notices: state.global.notices,
  platform: state._platform,
  ...state,
}))(PlatformBizApp)



