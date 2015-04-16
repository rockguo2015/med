package com.fudanmed.platform.core.deliver;

import com.fudanmed.platform.core.deliver.DLDeliverMaterialCategory;
import com.fudanmed.platform.core.deliver.impl.DLDeliverMaterialTypeImpl;
import com.fudanmed.platform.core.deliver.proxy.DLDeliverMaterialTypeProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;
import edu.fudan.mylang.pf.INamedModelObject;

@EntityImplementation(implementBy = DLDeliverMaterialTypeImpl.class)
public interface DLDeliverMaterialType extends IModelObject, INamedModelObject {
  public abstract String getName();
  
  public abstract DLDeliverMaterialType setName(final String name);
  
  public abstract DLDeliverMaterialCategory getCategory();
  
  public abstract DLDeliverMaterialType setCategory(final DLDeliverMaterialCategory category);
  
  public abstract String getComment();
  
  public abstract DLDeliverMaterialType setComment(final String comment);
  
  public abstract String getUnit();
  
  public abstract DLDeliverMaterialType setUnit(final String unit);
  
  public abstract String getEntityName();
  
  public abstract DLDeliverMaterialTypeProxy toProxy();
}
