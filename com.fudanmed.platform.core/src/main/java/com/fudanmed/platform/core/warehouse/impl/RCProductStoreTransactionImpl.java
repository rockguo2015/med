package com.fudanmed.platform.core.warehouse.impl;

import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.impl.RCEmployeeImpl;
import com.fudanmed.platform.core.warehouse.RCProductStorage;
import com.fudanmed.platform.core.warehouse.RCProductStoreTransaction;
import com.fudanmed.platform.core.warehouse.impl.RCProductStorageImpl;
import com.fudanmed.platform.core.warehouse.proxy.RCProductStoreTransactionProxy;
import edu.fudan.mylang.pf.BaseModelObject;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.DiscriminatorOptions;

@Entity
@DiscriminatorValue("RCPRODUCTSTORETRANSACTION_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "rcproductstoretransaction")
public abstract class RCProductStoreTransactionImpl extends BaseModelObject implements RCProductStoreTransaction {
  public RCProductStoreTransactionImpl() {
    super();
  }
  
  public RCProductStoreTransactionImpl(final RCProductStorage productStorage) {
    super();
    this.productStorage = productStorage;
  }
  
  @JoinColumn(name = "productStorage_id")
  @ManyToOne(targetEntity = RCProductStorageImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCProductStorage productStorage;
  
  public RCProductStorage getProductStorage() {
    return this.productStorage;
  }
  
  public RCProductStoreTransaction setProductStorage(final RCProductStorage productStorage) {
    this.productStorage = productStorage;
    return this;			
    
  }
  
  private Date date;
  
  public Date getDate() {
    return this.date;
  }
  
  public RCProductStoreTransaction setDate(final Date date) {
    this.date = date;
    return this;			
    
  }
  
  private Integer quantity;
  
  public Integer getQuantity() {
    return this.quantity;
  }
  
  public RCProductStoreTransaction setQuantity(final Integer quantity) {
    this.quantity = quantity;
    return this;			
    
  }
  
  @JoinColumn(name = "operator_id")
  @ManyToOne(targetEntity = RCEmployeeImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCEmployee operator;
  
  public RCEmployee getOperator() {
    return this.operator;
  }
  
  public RCProductStoreTransaction setOperator(final RCEmployee operator) {
    this.operator = operator;
    return this;			
    
  }
  
  public RCProductStoreTransactionProxy toProxy() {
    com.fudanmed.platform.core.warehouse.proxy.RCProductStoreTransactionProxy proxy = new com.fudanmed.platform.core.warehouse.proxy.RCProductStoreTransactionProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
