package com.fudanmed.platform.core.deliver;

import com.fudanmed.platform.core.deliver.DLDeliverPatientCheckCategory;
import com.fudanmed.platform.core.deliver.impl.DLDeliverPatientCheckTypeImpl;
import com.fudanmed.platform.core.deliver.proxy.DLDeliverPatientCheckTypeProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;
import edu.fudan.mylang.pf.INamedModelObject;

@EntityImplementation(implementBy = DLDeliverPatientCheckTypeImpl.class)
public interface DLDeliverPatientCheckType extends IModelObject, INamedModelObject {
  public abstract String getName();
  
  public abstract DLDeliverPatientCheckType setName(final String name);
  
  public abstract DLDeliverPatientCheckCategory getCategory();
  
  public abstract DLDeliverPatientCheckType setCategory(final DLDeliverPatientCheckCategory category);
  
  public abstract Integer getPerformence();
  
  public abstract DLDeliverPatientCheckType setPerformence(final Integer performence);
  
  public abstract Integer getTimeLimitation();
  
  public abstract DLDeliverPatientCheckType setTimeLimitation(final Integer timeLimitation);
  
  public abstract String getComment();
  
  public abstract DLDeliverPatientCheckType setComment(final String comment);
  
  public abstract String getEntityName();
  
  public abstract DLDeliverPatientCheckTypeProxy toProxy();
}
