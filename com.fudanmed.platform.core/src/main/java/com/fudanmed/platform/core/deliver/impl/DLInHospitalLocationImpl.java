package com.fudanmed.platform.core.deliver.impl;

import com.fudanmed.platform.core.deliver.DLInHospitalLocation;
import com.fudanmed.platform.core.deliver.proxy.DLInHospitalLocationProxy;
import com.fudanmed.platform.core.domain.RCOnsitePosition;
import com.fudanmed.platform.core.domain.impl.RCOnsitePositionImpl;
import edu.fudan.mylang.pf.BaseModelObject;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.hibernate.annotations.DiscriminatorOptions;

@Entity
@DiscriminatorValue("DLINHOSPITALLOCATION_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "dlinhospitallocation")
public class DLInHospitalLocationImpl extends BaseModelObject implements DLInHospitalLocation {
  public DLInHospitalLocationImpl() {
    super();
  }
  
  private String name;
  
  public String getName() {
    return this.name;
  }
  
  public DLInHospitalLocation setName(final String name) {
    this.name = name;
    return this;			
    
  }
  
  @ManyToMany(targetEntity = RCOnsitePositionImpl.class)
  @JoinTable(name = "m2m_dlinhospitallocation_location", joinColumns = @JoinColumn(name = "dlinhospitallocation_id") , inverseJoinColumns = @JoinColumn(name = "rCOnsitePosition_inv_id") )
  private Collection<RCOnsitePosition> location = new java.util.ArrayList<com.fudanmed.platform.core.domain.RCOnsitePosition>();;
  
  public Collection<RCOnsitePosition> getLocation() {
    return this.location;
  }
  
  public DLInHospitalLocation setLocation(final Iterable<RCOnsitePosition> location) {
    removeAllLocation();
    for(RCOnsitePosition ca : location){
    	addtoLocation(ca);
    }
    return this;		
    
  }
  
  public DLInHospitalLocation addtoLocation(final RCOnsitePosition rCOnsitePosition) {
    this.location.add(rCOnsitePosition);
    return this;
    
  }
  
  public DLInHospitalLocation removeAllLocation() {
    this.location.clear();
    return this;	
    
  }
  
  public DLInHospitalLocation removeFromLocation(final RCOnsitePosition rCOnsitePosition) {
    this.location.remove(rCOnsitePosition);
    return this;
    
  }
  
  public String getEntityName() {
    return this.name;
  }
  
  public static DLInHospitalLocation create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.deliver.DLInHospitalLocation dLInHospitalLocation = new com.fudanmed.platform.core.deliver.impl.DLInHospitalLocationImpl(
    );
    objectFactory.create(dLInHospitalLocation);
    return dLInHospitalLocation;			
    
  }
  
  public DLInHospitalLocationProxy toProxy() {
    com.fudanmed.platform.core.deliver.proxy.DLInHospitalLocationProxy proxy = new com.fudanmed.platform.core.deliver.proxy.DLInHospitalLocationProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
