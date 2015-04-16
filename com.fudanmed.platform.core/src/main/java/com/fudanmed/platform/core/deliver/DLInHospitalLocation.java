package com.fudanmed.platform.core.deliver;

import com.fudanmed.platform.core.deliver.impl.DLInHospitalLocationImpl;
import com.fudanmed.platform.core.deliver.proxy.DLInHospitalLocationProxy;
import com.fudanmed.platform.core.domain.RCOnsitePosition;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;
import edu.fudan.mylang.pf.INamedModelObject;
import java.util.Collection;

@EntityImplementation(implementBy = DLInHospitalLocationImpl.class)
public interface DLInHospitalLocation extends IModelObject, INamedModelObject {
  public abstract String getName();
  
  public abstract DLInHospitalLocation setName(final String name);
  
  public abstract Collection<RCOnsitePosition> getLocation();
  
  public abstract DLInHospitalLocation addtoLocation(final RCOnsitePosition rCOnsitePosition);
  
  public abstract DLInHospitalLocation setLocation(final Iterable<RCOnsitePosition> location);
  
  public abstract DLInHospitalLocation removeFromLocation(final RCOnsitePosition rCOnsitePosition);
  
  public abstract DLInHospitalLocation removeAllLocation();
  
  public abstract String getEntityName();
  
  public abstract DLInHospitalLocationProxy toProxy();
}
