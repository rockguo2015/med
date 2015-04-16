package com.fudanmed.platform.core.deliver.impl;

import com.fudanmed.platform.core.deliver.DLDeliverPatientCheckCategory;
import com.fudanmed.platform.core.deliver.DLDeliverPatientCheckType;
import com.fudanmed.platform.core.deliver.impl.DLDeliverPatientCheckCategoryImpl;
import com.fudanmed.platform.core.deliver.proxy.DLDeliverPatientCheckTypeProxy;
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
@DiscriminatorValue("DLDELIVERPATIENTCHECKTYPE_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "dldeliverpatientchecktype")
public class DLDeliverPatientCheckTypeImpl extends BaseModelObject implements DLDeliverPatientCheckType {
  public DLDeliverPatientCheckTypeImpl() {
    super();
  }
  
  private String name;
  
  public String getName() {
    return this.name;
  }
  
  public DLDeliverPatientCheckType setName(final String name) {
    this.name = name;
    return this;			
    
  }
  
  @JoinColumn(name = "category_id")
  @ManyToOne(targetEntity = DLDeliverPatientCheckCategoryImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private DLDeliverPatientCheckCategory category;
  
  public DLDeliverPatientCheckCategory getCategory() {
    return this.category;
  }
  
  public DLDeliverPatientCheckType setCategory(final DLDeliverPatientCheckCategory category) {
    this.category = category;
    return this;			
    
  }
  
  private Integer performence;
  
  public Integer getPerformence() {
    return this.performence;
  }
  
  public DLDeliverPatientCheckType setPerformence(final Integer performence) {
    this.performence = performence;
    return this;			
    
  }
  
  private Integer timeLimitation;
  
  public Integer getTimeLimitation() {
    return this.timeLimitation;
  }
  
  public DLDeliverPatientCheckType setTimeLimitation(final Integer timeLimitation) {
    this.timeLimitation = timeLimitation;
    return this;			
    
  }
  
  private String comment;
  
  public String getComment() {
    return this.comment;
  }
  
  public DLDeliverPatientCheckType setComment(final String comment) {
    this.comment = comment;
    return this;			
    
  }
  
  public String getEntityName() {
    return this.name;
  }
  
  public static DLDeliverPatientCheckType create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.deliver.DLDeliverPatientCheckType dLDeliverPatientCheckType = new com.fudanmed.platform.core.deliver.impl.DLDeliverPatientCheckTypeImpl(
    );
    objectFactory.create(dLDeliverPatientCheckType);
    return dLDeliverPatientCheckType;			
    
  }
  
  public DLDeliverPatientCheckTypeProxy toProxy() {
    com.fudanmed.platform.core.deliver.proxy.DLDeliverPatientCheckTypeProxy proxy = new com.fudanmed.platform.core.deliver.proxy.DLDeliverPatientCheckTypeProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
