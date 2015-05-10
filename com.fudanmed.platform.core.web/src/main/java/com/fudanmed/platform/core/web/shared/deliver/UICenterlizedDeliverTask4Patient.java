package com.fudanmed.platform.core.web.shared.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLCenterlizedDeliverTaskProxy;
import com.fudanmed.platform.core.web.shared.deliver.UIPatientCheckDeliver;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import java.util.Collection;
import java.util.Date;

public class UICenterlizedDeliverTask4Patient extends GWTEntity {
  private Date planDate;
  
  public Date getPlanDate() {
    return this.planDate;
  }
  
  public void setPlanDate(final Date planDate) {
    this.planDate = planDate;
  }
  
  public final static String P_PlanDate = "planDate";
  
  public static IObjectFieldAccessor<UICenterlizedDeliverTask4Patient,Date> PlanDateAccessor = new IObjectFieldAccessor<UICenterlizedDeliverTask4Patient,Date>(){
    				public java.util.Date getValue(UICenterlizedDeliverTask4Patient object){
    					return object.getPlanDate();
    				}
    				public void setValue(UICenterlizedDeliverTask4Patient object,java.util.Date value){
    					object.setPlanDate(value);
    				}
    			};
  
  private Date planTime;
  
  public Date getPlanTime() {
    return this.planTime;
  }
  
  public void setPlanTime(final Date planTime) {
    this.planTime = planTime;
  }
  
  public final static String P_PlanTime = "planTime";
  
  public static IObjectFieldAccessor<UICenterlizedDeliverTask4Patient,Date> PlanTimeAccessor = new IObjectFieldAccessor<UICenterlizedDeliverTask4Patient,Date>(){
    				public java.util.Date getValue(UICenterlizedDeliverTask4Patient object){
    					return object.getPlanTime();
    				}
    				public void setValue(UICenterlizedDeliverTask4Patient object,java.util.Date value){
    					object.setPlanTime(value);
    				}
    			};
  
  private Collection<UIPatientCheckDeliver> patients = com.google.common.collect.Lists.newArrayList();
  
  public Collection<UIPatientCheckDeliver> getPatients() {
    return this.patients;
  }
  
  public void setPatients(final Collection<UIPatientCheckDeliver> patients) {
    this.patients = patients;
  }
  
  public final static String P_Patients = "patients";
  
  public static IObjectFieldAccessor<UICenterlizedDeliverTask4Patient,Collection<UIPatientCheckDeliver>> PatientsAccessor = new IObjectFieldAccessor<UICenterlizedDeliverTask4Patient,Collection<UIPatientCheckDeliver>>(){
    				public java.util.Collection<com.fudanmed.platform.core.web.shared.deliver.UIPatientCheckDeliver> getValue(UICenterlizedDeliverTask4Patient object){
    					return object.getPatients();
    				}
    				public void setValue(UICenterlizedDeliverTask4Patient object,java.util.Collection<com.fudanmed.platform.core.web.shared.deliver.UIPatientCheckDeliver> value){
    					object.setPatients(value);
    				}
    			};
  
  public DLCenterlizedDeliverTaskProxy toProxy() {
    return (DLCenterlizedDeliverTaskProxy)super.toProxy();
    
  }
}
