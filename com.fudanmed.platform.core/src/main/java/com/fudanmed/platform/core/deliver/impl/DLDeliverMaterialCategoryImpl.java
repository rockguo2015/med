package com.fudanmed.platform.core.deliver.impl;

import com.fudanmed.platform.core.deliver.DLDeliverMaterialCategory;
import com.fudanmed.platform.core.deliver.proxy.DLDeliverMaterialCategoryProxy;
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
@DiscriminatorValue("DLDELIVERMATERIALCATEGORY_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "dldelivermaterialcategory")
public class DLDeliverMaterialCategoryImpl extends BaseModelObject implements DLDeliverMaterialCategory {
  public DLDeliverMaterialCategoryImpl() {
    super();
  }
  
  public DLDeliverMaterialCategoryImpl(final DLDeliverMaterialCategory parentCategory) {
    super();
    this.parentCategory = parentCategory;
  }
  
  private String name;
  
  public String getName() {
    return this.name;
  }
  
  public DLDeliverMaterialCategory setName(final String name) {
    this.name = name;
    return this;			
    
  }
  
  @JoinColumn(name = "parentCategory_id")
  @ManyToOne(targetEntity = DLDeliverMaterialCategoryImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private DLDeliverMaterialCategory parentCategory;
  
  public DLDeliverMaterialCategory getParentCategory() {
    return this.parentCategory;
  }
  
  public DLDeliverMaterialCategory setParentCategory(final DLDeliverMaterialCategory parentCategory) {
    this.parentCategory = parentCategory;
    return this;			
    
  }
  
  @OneToMany(targetEntity = DLDeliverMaterialCategoryImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE }, mappedBy = "parentCategory")
  private Collection<DLDeliverMaterialCategory> subCategories = new java.util.ArrayList<com.fudanmed.platform.core.deliver.DLDeliverMaterialCategory>();;
  
  public Collection<DLDeliverMaterialCategory> getSubCategories() {
    return this.subCategories;
  }
  
  public DLDeliverMaterialCategory createAndAddtoSubCategories() {
    getSubCategories().size();
    com.fudanmed.platform.core.deliver.DLDeliverMaterialCategory dLDeliverMaterialCategory = new com.fudanmed.platform.core.deliver.impl.DLDeliverMaterialCategoryImpl(this);
    getObjectFactory().create(dLDeliverMaterialCategory);
    getSubCategories().add(dLDeliverMaterialCategory);
    return dLDeliverMaterialCategory;
    
  }
  
  public DLDeliverMaterialCategory removeAllSubCategories() {
    for(DLDeliverMaterialCategory obj : this.subCategories){
    	getObjectFactory().delete(obj);
    }
    this.subCategories.clear();
    return this;	
    
  }
  
  public DLDeliverMaterialCategory removeFromSubCategories(final DLDeliverMaterialCategory dLDeliverMaterialCategory) {
    this.subCategories.remove(dLDeliverMaterialCategory);
    getObjectFactory().delete(dLDeliverMaterialCategory);
    return this;
    
  }
  
  public String getEntityName() {
    return this.name;
  }
  
  public static DLDeliverMaterialCategory create(final DLDeliverMaterialCategory parentCategory, final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.deliver.DLDeliverMaterialCategory dLDeliverMaterialCategory = new com.fudanmed.platform.core.deliver.impl.DLDeliverMaterialCategoryImpl(
    	parentCategory
    );
    objectFactory.create(dLDeliverMaterialCategory);
    return dLDeliverMaterialCategory;			
    
  }
  
  public DLDeliverMaterialCategoryProxy toProxy() {
    com.fudanmed.platform.core.deliver.proxy.DLDeliverMaterialCategoryProxy proxy = new com.fudanmed.platform.core.deliver.proxy.DLDeliverMaterialCategoryProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
