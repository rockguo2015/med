package com.fudanmed.platform.core.deliver.impl;

import com.fudanmed.platform.core.deliver.DLDeliverPatientCheckCategory;
import com.fudanmed.platform.core.deliver.proxy.DLDeliverPatientCheckCategoryProxy;
import edu.fudan.mylang.pf.BaseModelObject;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.DiscriminatorOptions;

@Entity
@DiscriminatorValue("DLDELIVERPATIENTCHECKCATEGORY_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "dldeliverpatientcheckcategory")
public class DLDeliverPatientCheckCategoryImpl extends BaseModelObject implements DLDeliverPatientCheckCategory {
  public DLDeliverPatientCheckCategoryImpl() {
    super();
  }
  
  public DLDeliverPatientCheckCategoryImpl(final DLDeliverPatientCheckCategory parentCategory) {
    super();
    this.parentCategory = parentCategory;
  }
  
  private String name;
  
  public String getName() {
    return this.name;
  }
  
  public DLDeliverPatientCheckCategory setName(final String name) {
    this.name = name;
    return this;			
    
  }
  
  @JoinColumn(name = "parentCategory_id")
  @ManyToOne(targetEntity = DLDeliverPatientCheckCategoryImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private DLDeliverPatientCheckCategory parentCategory;
  
  public DLDeliverPatientCheckCategory getParentCategory() {
    return this.parentCategory;
  }
  
  public DLDeliverPatientCheckCategory setParentCategory(final DLDeliverPatientCheckCategory parentCategory) {
    this.parentCategory = parentCategory;
    return this;			
    
  }
  
  @OneToMany(targetEntity = DLDeliverPatientCheckCategoryImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE }, mappedBy = "parentCategory")
  private Collection<DLDeliverPatientCheckCategory> subCategories = new java.util.ArrayList<com.fudanmed.platform.core.deliver.DLDeliverPatientCheckCategory>();;
  
  public Collection<DLDeliverPatientCheckCategory> getSubCategories() {
    return this.subCategories;
  }
  
  public DLDeliverPatientCheckCategory createAndAddtoSubCategories() {
    getSubCategories().size();
    com.fudanmed.platform.core.deliver.DLDeliverPatientCheckCategory dLDeliverPatientCheckCategory = new com.fudanmed.platform.core.deliver.impl.DLDeliverPatientCheckCategoryImpl(this);
    getObjectFactory().create(dLDeliverPatientCheckCategory);
    getSubCategories().add(dLDeliverPatientCheckCategory);
    return dLDeliverPatientCheckCategory;
    
  }
  
  public DLDeliverPatientCheckCategory removeAllSubCategories() {
    for(DLDeliverPatientCheckCategory obj : this.subCategories){
    	getObjectFactory().delete(obj);
    }
    this.subCategories.clear();
    return this;	
    
  }
  
  public DLDeliverPatientCheckCategory removeFromSubCategories(final DLDeliverPatientCheckCategory dLDeliverPatientCheckCategory) {
    this.subCategories.remove(dLDeliverPatientCheckCategory);
    getObjectFactory().delete(dLDeliverPatientCheckCategory);
    return this;
    
  }
  
  public String getEntityName() {
    return this.name;
  }
  
  public static DLDeliverPatientCheckCategory create(final DLDeliverPatientCheckCategory parentCategory, final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.deliver.DLDeliverPatientCheckCategory dLDeliverPatientCheckCategory = new com.fudanmed.platform.core.deliver.impl.DLDeliverPatientCheckCategoryImpl(
    	parentCategory
    );
    objectFactory.create(dLDeliverPatientCheckCategory);
    return dLDeliverPatientCheckCategory;			
    
  }
  
  public DLDeliverPatientCheckCategoryProxy toProxy() {
    com.fudanmed.platform.core.deliver.proxy.DLDeliverPatientCheckCategoryProxy proxy = new com.fudanmed.platform.core.deliver.proxy.DLDeliverPatientCheckCategoryProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
