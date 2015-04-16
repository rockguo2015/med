package com.fudanmed.platform.core.deliver;

import com.fudanmed.platform.core.deliver.DLGender;
import com.fudanmed.platform.core.deliver.impl.DLInHospitalPatientImpl;
import com.fudanmed.platform.core.deliver.proxy.DLInHospitalPatientProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;
import edu.fudan.mylang.pf.INamedModelObject;

@EntityImplementation(implementBy = DLInHospitalPatientImpl.class)
public interface DLInHospitalPatient extends IModelObject, INamedModelObject {
  public abstract String getSid();
  
  public abstract DLInHospitalPatient setSid(final String sid);
  
  public abstract String getName();
  
  public abstract DLInHospitalPatient setName(final String name);
  
  public abstract Integer getAge();
  
  public abstract DLInHospitalPatient setAge(final Integer age);
  
  public abstract DLGender getGender();
  
  public abstract DLInHospitalPatient setGender(final DLGender gender);
  
  public abstract String getEntityName();
  
  public abstract DLInHospitalPatientProxy toProxy();
}
