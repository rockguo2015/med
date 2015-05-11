package com.fudanmed.platform.core.web.shared.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLCheckOrganizationProxy;
import com.fudanmed.platform.core.deliver.proxy.DLDeliverEmergencyProxy;
import com.fudanmed.platform.core.deliver.proxy.DLDeliverPatientCheckTypeProxy;
import com.fudanmed.platform.core.deliver.proxy.DLInHospitalPatientProxy;
import com.fudanmed.platform.core.deliver.proxy.DLPatientCheckDeliverProxy;
import com.fudanmed.platform.core.deliver.proxy.DLPatientDeliverMethodProxy;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

public class UIPatientCheckDeliver extends GWTEntity {
  private DLInHospitalPatientProxy patient;
  
  public DLInHospitalPatientProxy getPatient() {
    return this.patient;
  }
  
  public void setPatient(final DLInHospitalPatientProxy patient) {
    this.patient = patient;
  }
  
  public final static String P_Patient = "patient";
  
  public static IObjectFieldAccessor<UIPatientCheckDeliver,DLInHospitalPatientProxy> PatientAccessor = new IObjectFieldAccessor<UIPatientCheckDeliver,DLInHospitalPatientProxy>(){
    				public com.fudanmed.platform.core.deliver.proxy.DLInHospitalPatientProxy getValue(UIPatientCheckDeliver object){
    					return object.getPatient();
    				}
    				public void setValue(UIPatientCheckDeliver object,com.fudanmed.platform.core.deliver.proxy.DLInHospitalPatientProxy value){
    					object.setPatient(value);
    				}
    			};
  
  private DLCheckOrganizationProxy checkOrganization;
  
  public DLCheckOrganizationProxy getCheckOrganization() {
    return this.checkOrganization;
  }
  
  public void setCheckOrganization(final DLCheckOrganizationProxy checkOrganization) {
    this.checkOrganization = checkOrganization;
  }
  
  public final static String P_CheckOrganization = "checkOrganization";
  
  public static IObjectFieldAccessor<UIPatientCheckDeliver,DLCheckOrganizationProxy> CheckOrganizationAccessor = new IObjectFieldAccessor<UIPatientCheckDeliver,DLCheckOrganizationProxy>(){
    				public com.fudanmed.platform.core.deliver.proxy.DLCheckOrganizationProxy getValue(UIPatientCheckDeliver object){
    					return object.getCheckOrganization();
    				}
    				public void setValue(UIPatientCheckDeliver object,com.fudanmed.platform.core.deliver.proxy.DLCheckOrganizationProxy value){
    					object.setCheckOrganization(value);
    				}
    			};
  
  private DLDeliverPatientCheckTypeProxy checkType;
  
  public DLDeliverPatientCheckTypeProxy getCheckType() {
    return this.checkType;
  }
  
  public void setCheckType(final DLDeliverPatientCheckTypeProxy checkType) {
    this.checkType = checkType;
  }
  
  public final static String P_CheckType = "checkType";
  
  public static IObjectFieldAccessor<UIPatientCheckDeliver,DLDeliverPatientCheckTypeProxy> CheckTypeAccessor = new IObjectFieldAccessor<UIPatientCheckDeliver,DLDeliverPatientCheckTypeProxy>(){
    				public com.fudanmed.platform.core.deliver.proxy.DLDeliverPatientCheckTypeProxy getValue(UIPatientCheckDeliver object){
    					return object.getCheckType();
    				}
    				public void setValue(UIPatientCheckDeliver object,com.fudanmed.platform.core.deliver.proxy.DLDeliverPatientCheckTypeProxy value){
    					object.setCheckType(value);
    				}
    			};
  
  private DLPatientDeliverMethodProxy deliverMethod;
  
  public DLPatientDeliverMethodProxy getDeliverMethod() {
    return this.deliverMethod;
  }
  
  public void setDeliverMethod(final DLPatientDeliverMethodProxy deliverMethod) {
    this.deliverMethod = deliverMethod;
  }
  
  public final static String P_DeliverMethod = "deliverMethod";
  
  public static IObjectFieldAccessor<UIPatientCheckDeliver,DLPatientDeliverMethodProxy> DeliverMethodAccessor = new IObjectFieldAccessor<UIPatientCheckDeliver,DLPatientDeliverMethodProxy>(){
    				public com.fudanmed.platform.core.deliver.proxy.DLPatientDeliverMethodProxy getValue(UIPatientCheckDeliver object){
    					return object.getDeliverMethod();
    				}
    				public void setValue(UIPatientCheckDeliver object,com.fudanmed.platform.core.deliver.proxy.DLPatientDeliverMethodProxy value){
    					object.setDeliverMethod(value);
    				}
    			};
  
  private DLDeliverEmergencyProxy emergency;
  
  public DLDeliverEmergencyProxy getEmergency() {
    return this.emergency;
  }
  
  public void setEmergency(final DLDeliverEmergencyProxy emergency) {
    this.emergency = emergency;
  }
  
  public final static String P_Emergency = "emergency";
  
  public static IObjectFieldAccessor<UIPatientCheckDeliver,DLDeliverEmergencyProxy> EmergencyAccessor = new IObjectFieldAccessor<UIPatientCheckDeliver,DLDeliverEmergencyProxy>(){
    				public com.fudanmed.platform.core.deliver.proxy.DLDeliverEmergencyProxy getValue(UIPatientCheckDeliver object){
    					return object.getEmergency();
    				}
    				public void setValue(UIPatientCheckDeliver object,com.fudanmed.platform.core.deliver.proxy.DLDeliverEmergencyProxy value){
    					object.setEmergency(value);
    				}
    			};
  
  public DLPatientCheckDeliverProxy toProxy() {
    return (DLPatientCheckDeliverProxy)super.toProxy();
    
  }
}
