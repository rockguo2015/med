package com.fudanmed.platform.core.deliver;

import com.fudanmed.platform.core.deliver.DLCheckOrganization;
import com.fudanmed.platform.core.deliver.DLDeliverPatientCheckCategory;
import com.fudanmed.platform.core.deliver.DLDeliverSubject;
import com.fudanmed.platform.core.deliver.DLInHospitalLocation;
import com.fudanmed.platform.core.deliver.DLInHospitalPatient;
import com.fudanmed.platform.core.deliver.DLPatientDeliverMethod;
import com.fudanmed.platform.core.deliver.impl.DLPatientCheckDeliverImpl;
import com.fudanmed.platform.core.deliver.proxy.DLPatientCheckDeliverProxy;
import edu.fudan.mylang.pf.EntityImplementation;

@EntityImplementation(implementBy = DLPatientCheckDeliverImpl.class)
public interface DLPatientCheckDeliver extends DLDeliverSubject {
  public abstract DLInHospitalPatient getPatient();
  
  public abstract DLPatientCheckDeliver setPatient(final DLInHospitalPatient patient);
  
  public abstract DLInHospitalLocation getLocation();
  
  public abstract DLPatientCheckDeliver setLocation(final DLInHospitalLocation location);
  
  public abstract String getBedNumber();
  
  public abstract DLPatientCheckDeliver setBedNumber(final String bedNumber);
  
  public abstract DLCheckOrganization getCheckOrganization();
  
  public abstract DLPatientCheckDeliver setCheckOrganization(final DLCheckOrganization checkOrganization);
  
  public abstract DLDeliverPatientCheckCategory getCheckType();
  
  public abstract DLPatientCheckDeliver setCheckType(final DLDeliverPatientCheckCategory checkType);
  
  public abstract DLPatientDeliverMethod getDeliverMethod();
  
  public abstract DLPatientCheckDeliver setDeliverMethod(final DLPatientDeliverMethod deliverMethod);
  
  public abstract String getEntityName();
  
  public abstract void checkInvariant();
  
  public abstract DLPatientCheckDeliverProxy toProxy();
}
