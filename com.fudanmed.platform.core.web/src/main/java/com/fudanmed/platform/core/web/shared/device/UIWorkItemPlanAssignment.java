package com.fudanmed.platform.core.web.shared.device;

import com.fudanmed.platform.core.device.pm.proxy.RCDevicePMTypeProxy;
import com.fudanmed.platform.core.device.pm.proxy.RCWorkItemPlanAssignmentProxy;
import com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy;
import com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy;
import com.fudanmed.platform.core.web.shared.device.UIDevicePMPlanStatus;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import java.util.Date;

public class UIWorkItemPlanAssignment extends GWTEntity {
  private String sid;
  
  public String getSid() {
    return this.sid;
  }
  
  public void setSid(final String sid) {
    this.sid = sid;
  }
  
  public final static String P_Sid = "sid";
  
  public static IObjectFieldAccessor<UIWorkItemPlanAssignment,String> SidAccessor = new IObjectFieldAccessor<UIWorkItemPlanAssignment,String>(){
    				public String getValue(UIWorkItemPlanAssignment object){
    					return object.getSid();
    				}
    				public void setValue(UIWorkItemPlanAssignment object,String value){
    					object.setSid(value);
    				}
    			};
  
  private String name;
  
  public String getName() {
    return this.name;
  }
  
  public void setName(final String name) {
    this.name = name;
  }
  
  public final static String P_Name = "name";
  
  public static IObjectFieldAccessor<UIWorkItemPlanAssignment,String> NameAccessor = new IObjectFieldAccessor<UIWorkItemPlanAssignment,String>(){
    				public String getValue(UIWorkItemPlanAssignment object){
    					return object.getName();
    				}
    				public void setValue(UIWorkItemPlanAssignment object,String value){
    					object.setName(value);
    				}
    			};
  
  private String specification;
  
  public String getSpecification() {
    return this.specification;
  }
  
  public void setSpecification(final String specification) {
    this.specification = specification;
  }
  
  public final static String P_Specification = "specification";
  
  public static IObjectFieldAccessor<UIWorkItemPlanAssignment,String> SpecificationAccessor = new IObjectFieldAccessor<UIWorkItemPlanAssignment,String>(){
    				public String getValue(UIWorkItemPlanAssignment object){
    					return object.getSpecification();
    				}
    				public void setValue(UIWorkItemPlanAssignment object,String value){
    					object.setSpecification(value);
    				}
    			};
  
  private RCOnsitePositionProxy location;
  
  public RCOnsitePositionProxy getLocation() {
    return this.location;
  }
  
  public void setLocation(final RCOnsitePositionProxy location) {
    this.location = location;
  }
  
  public final static String P_Location = "location";
  
  public static IObjectFieldAccessor<UIWorkItemPlanAssignment,RCOnsitePositionProxy> LocationAccessor = new IObjectFieldAccessor<UIWorkItemPlanAssignment,RCOnsitePositionProxy>(){
    				public com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy getValue(UIWorkItemPlanAssignment object){
    					return object.getLocation();
    				}
    				public void setValue(UIWorkItemPlanAssignment object,com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy value){
    					object.setLocation(value);
    				}
    			};
  
  private RCDeviceTypeProxy deviceType;
  
  public RCDeviceTypeProxy getDeviceType() {
    return this.deviceType;
  }
  
  public void setDeviceType(final RCDeviceTypeProxy deviceType) {
    this.deviceType = deviceType;
  }
  
  public final static String P_DeviceType = "deviceType";
  
  public static IObjectFieldAccessor<UIWorkItemPlanAssignment,RCDeviceTypeProxy> DeviceTypeAccessor = new IObjectFieldAccessor<UIWorkItemPlanAssignment,RCDeviceTypeProxy>(){
    				public com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy getValue(UIWorkItemPlanAssignment object){
    					return object.getDeviceType();
    				}
    				public void setValue(UIWorkItemPlanAssignment object,com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy value){
    					object.setDeviceType(value);
    				}
    			};
  
  private Date planDate;
  
  public Date getPlanDate() {
    return this.planDate;
  }
  
  public void setPlanDate(final Date planDate) {
    this.planDate = planDate;
  }
  
  public final static String P_PlanDate = "planDate";
  
  public static IObjectFieldAccessor<UIWorkItemPlanAssignment,Date> PlanDateAccessor = new IObjectFieldAccessor<UIWorkItemPlanAssignment,Date>(){
    				public java.util.Date getValue(UIWorkItemPlanAssignment object){
    					return object.getPlanDate();
    				}
    				public void setValue(UIWorkItemPlanAssignment object,java.util.Date value){
    					object.setPlanDate(value);
    				}
    			};
  
  private RCDevicePMTypeProxy pmType;
  
  public RCDevicePMTypeProxy getPmType() {
    return this.pmType;
  }
  
  public void setPmType(final RCDevicePMTypeProxy pmType) {
    this.pmType = pmType;
  }
  
  public final static String P_PmType = "pmType";
  
  public static IObjectFieldAccessor<UIWorkItemPlanAssignment,RCDevicePMTypeProxy> PmTypeAccessor = new IObjectFieldAccessor<UIWorkItemPlanAssignment,RCDevicePMTypeProxy>(){
    				public com.fudanmed.platform.core.device.pm.proxy.RCDevicePMTypeProxy getValue(UIWorkItemPlanAssignment object){
    					return object.getPmType();
    				}
    				public void setValue(UIWorkItemPlanAssignment object,com.fudanmed.platform.core.device.pm.proxy.RCDevicePMTypeProxy value){
    					object.setPmType(value);
    				}
    			};
  
  private Integer intervalInDays;
  
  public Integer getIntervalInDays() {
    return this.intervalInDays;
  }
  
  public void setIntervalInDays(final Integer intervalInDays) {
    this.intervalInDays = intervalInDays;
  }
  
  public final static String P_IntervalInDays = "intervalInDays";
  
  public static IObjectFieldAccessor<UIWorkItemPlanAssignment,Integer> IntervalInDaysAccessor = new IObjectFieldAccessor<UIWorkItemPlanAssignment,Integer>(){
    				public Integer getValue(UIWorkItemPlanAssignment object){
    					return object.getIntervalInDays();
    				}
    				public void setValue(UIWorkItemPlanAssignment object,Integer value){
    					object.setIntervalInDays(value);
    				}
    			};
  
  private String pmComment;
  
  public String getPmComment() {
    return this.pmComment;
  }
  
  public void setPmComment(final String pmComment) {
    this.pmComment = pmComment;
  }
  
  public final static String P_PmComment = "pmComment";
  
  public static IObjectFieldAccessor<UIWorkItemPlanAssignment,String> PmCommentAccessor = new IObjectFieldAccessor<UIWorkItemPlanAssignment,String>(){
    				public String getValue(UIWorkItemPlanAssignment object){
    					return object.getPmComment();
    				}
    				public void setValue(UIWorkItemPlanAssignment object,String value){
    					object.setPmComment(value);
    				}
    			};
  
  private UIDevicePMPlanStatus smstatus;
  
  public UIDevicePMPlanStatus getSmstatus() {
    return this.smstatus;
  }
  
  public void setSmstatus(final UIDevicePMPlanStatus smstatus) {
    this.smstatus = smstatus;
  }
  
  public final static String P_Smstatus = "smstatus";
  
  public static IObjectFieldAccessor<UIWorkItemPlanAssignment,UIDevicePMPlanStatus> SmstatusAccessor = new IObjectFieldAccessor<UIWorkItemPlanAssignment,UIDevicePMPlanStatus>(){
    				public com.fudanmed.platform.core.web.shared.device.UIDevicePMPlanStatus getValue(UIWorkItemPlanAssignment object){
    					return object.getSmstatus();
    				}
    				public void setValue(UIWorkItemPlanAssignment object,com.fudanmed.platform.core.web.shared.device.UIDevicePMPlanStatus value){
    					object.setSmstatus(value);
    				}
    			};
  
  public RCWorkItemPlanAssignmentProxy toProxy() {
    return (RCWorkItemPlanAssignmentProxy)super.toProxy();
    
  }
}
