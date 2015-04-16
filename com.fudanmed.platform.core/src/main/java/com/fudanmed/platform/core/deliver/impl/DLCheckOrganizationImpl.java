package com.fudanmed.platform.core.deliver.impl;

import com.fudanmed.platform.core.deliver.DLCheckOrganization;
import com.fudanmed.platform.core.deliver.proxy.DLCheckOrganizationProxy;
import com.fudanmed.platform.core.domain.RCOrganization;
import com.fudanmed.platform.core.domain.impl.RCOrganizationImpl;
import edu.fudan.mylang.pf.BaseModelObject;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.DiscriminatorOptions;

@Entity
@DiscriminatorValue("DLCHECKORGANIZATION_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "dlcheckorganization")
public class DLCheckOrganizationImpl extends BaseModelObject implements DLCheckOrganization {
  public DLCheckOrganizationImpl() {
    super();
  }
  
  private String name;
  
  public String getName() {
    return this.name;
  }
  
  public DLCheckOrganization setName(final String name) {
    this.name = name;
    return this;			
    
  }
  
  @JoinColumn(name = "organization_id")
  @ManyToOne(targetEntity = RCOrganizationImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCOrganization organization;
  
  public RCOrganization getOrganization() {
    return this.organization;
  }
  
  public DLCheckOrganization setOrganization(final RCOrganization organization) {
    this.organization = organization;
    return this;			
    
  }
  
  public String getEntityName() {
    String _entityName = this.organization.getEntityName();
    return _entityName;
  }
  
  public static DLCheckOrganization create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.deliver.DLCheckOrganization dLCheckOrganization = new com.fudanmed.platform.core.deliver.impl.DLCheckOrganizationImpl(
    );
    objectFactory.create(dLCheckOrganization);
    return dLCheckOrganization;			
    
  }
  
  public DLCheckOrganizationProxy toProxy() {
    com.fudanmed.platform.core.deliver.proxy.DLCheckOrganizationProxy proxy = new com.fudanmed.platform.core.deliver.proxy.DLCheckOrganizationProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
