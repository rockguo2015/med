package com.fudanmed.platform.core.deliver;

import com.fudanmed.platform.core.deliver.impl.DLCheckOrganizationImpl;
import com.fudanmed.platform.core.deliver.proxy.DLCheckOrganizationProxy;
import com.fudanmed.platform.core.domain.RCOrganization;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;
import edu.fudan.mylang.pf.INamedModelObject;

@EntityImplementation(implementBy = DLCheckOrganizationImpl.class)
public interface DLCheckOrganization extends IModelObject, INamedModelObject {
  public abstract String getName();
  
  public abstract DLCheckOrganization setName(final String name);
  
  public abstract RCOrganization getOrganization();
  
  public abstract DLCheckOrganization setOrganization(final RCOrganization organization);
  
  public abstract String getEntityName();
  
  public abstract DLCheckOrganizationProxy toProxy();
}
