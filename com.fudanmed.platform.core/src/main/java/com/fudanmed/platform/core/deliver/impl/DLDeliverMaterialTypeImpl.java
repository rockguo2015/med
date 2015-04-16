package com.fudanmed.platform.core.deliver.impl;

import com.fudanmed.platform.core.deliver.DLDeliverMaterialCategory;
import com.fudanmed.platform.core.deliver.DLDeliverMaterialType;
import com.fudanmed.platform.core.deliver.impl.DLDeliverMaterialCategoryImpl;
import com.fudanmed.platform.core.deliver.proxy.DLDeliverMaterialTypeProxy;
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
@DiscriminatorValue("DLDELIVERMATERIALTYPE_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "dldelivermaterialtype")
public class DLDeliverMaterialTypeImpl extends BaseModelObject implements DLDeliverMaterialType {
  public DLDeliverMaterialTypeImpl() {
    super();
  }
  
  private String name;
  
  public String getName() {
    return this.name;
  }
  
  public DLDeliverMaterialType setName(final String name) {
    this.name = name;
    return this;			
    
  }
  
  @JoinColumn(name = "category_id")
  @ManyToOne(targetEntity = DLDeliverMaterialCategoryImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private DLDeliverMaterialCategory category;
  
  public DLDeliverMaterialCategory getCategory() {
    return this.category;
  }
  
  public DLDeliverMaterialType setCategory(final DLDeliverMaterialCategory category) {
    this.category = category;
    return this;			
    
  }
  
  private String comment;
  
  public String getComment() {
    return this.comment;
  }
  
  public DLDeliverMaterialType setComment(final String comment) {
    this.comment = comment;
    return this;			
    
  }
  
  private String unit;
  
  public String getUnit() {
    return this.unit;
  }
  
  public DLDeliverMaterialType setUnit(final String unit) {
    this.unit = unit;
    return this;			
    
  }
  
  public String getEntityName() {
    return this.name;
  }
  
  public static DLDeliverMaterialType create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.deliver.DLDeliverMaterialType dLDeliverMaterialType = new com.fudanmed.platform.core.deliver.impl.DLDeliverMaterialTypeImpl(
    );
    objectFactory.create(dLDeliverMaterialType);
    return dLDeliverMaterialType;			
    
  }
  
  public DLDeliverMaterialTypeProxy toProxy() {
    com.fudanmed.platform.core.deliver.proxy.DLDeliverMaterialTypeProxy proxy = new com.fudanmed.platform.core.deliver.proxy.DLDeliverMaterialTypeProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
