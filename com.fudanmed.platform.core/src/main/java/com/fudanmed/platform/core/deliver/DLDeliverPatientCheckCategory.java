package com.fudanmed.platform.core.deliver;

import com.fudanmed.platform.core.deliver.impl.DLDeliverPatientCheckCategoryImpl;
import com.fudanmed.platform.core.deliver.proxy.DLDeliverPatientCheckCategoryProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;
import edu.fudan.mylang.pf.INamedModelObject;
import java.util.Collection;

@EntityImplementation(implementBy = DLDeliverPatientCheckCategoryImpl.class)
public interface DLDeliverPatientCheckCategory extends IModelObject, INamedModelObject {
  public abstract String getName();
  
  public abstract DLDeliverPatientCheckCategory setName(final String name);
  
  public abstract DLDeliverPatientCheckCategory getParentCategory();
  
  public abstract DLDeliverPatientCheckCategory setParentCategory(final DLDeliverPatientCheckCategory parentCategory);
  
  public abstract Collection<DLDeliverPatientCheckCategory> getSubCategories();
  
  public abstract DLDeliverPatientCheckCategory createAndAddtoSubCategories();
  
  public abstract DLDeliverPatientCheckCategory removeFromSubCategories(final DLDeliverPatientCheckCategory dLDeliverPatientCheckCategory);
  
  public abstract DLDeliverPatientCheckCategory removeAllSubCategories();
  
  public abstract String getEntityName();
  
  public abstract DLDeliverPatientCheckCategoryProxy toProxy();
}
