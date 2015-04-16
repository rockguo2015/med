package com.fudanmed.platform.core.deliver;

import com.fudanmed.platform.core.deliver.impl.DLDeliverMaterialCategoryImpl;
import com.fudanmed.platform.core.deliver.proxy.DLDeliverMaterialCategoryProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;
import edu.fudan.mylang.pf.INamedModelObject;
import java.util.Collection;

@EntityImplementation(implementBy = DLDeliverMaterialCategoryImpl.class)
public interface DLDeliverMaterialCategory extends IModelObject, INamedModelObject {
  public abstract String getName();
  
  public abstract DLDeliverMaterialCategory setName(final String name);
  
  public abstract DLDeliverMaterialCategory getParentCategory();
  
  public abstract DLDeliverMaterialCategory setParentCategory(final DLDeliverMaterialCategory parentCategory);
  
  public abstract Collection<DLDeliverMaterialCategory> getSubCategories();
  
  public abstract DLDeliverMaterialCategory createAndAddtoSubCategories();
  
  public abstract DLDeliverMaterialCategory removeFromSubCategories(final DLDeliverMaterialCategory dLDeliverMaterialCategory);
  
  public abstract DLDeliverMaterialCategory removeAllSubCategories();
  
  public abstract String getEntityName();
  
  public abstract DLDeliverMaterialCategoryProxy toProxy();
}
