package com.fudanmed.platform.core.warehouse.impl;

import com.fudanmed.platform.core.warehouse.RCOutStockRecord;
import com.fudanmed.platform.core.warehouse.RCOutStockTransaction;
import com.fudanmed.platform.core.warehouse.RCProductStorage;
import com.fudanmed.platform.core.warehouse.impl.RCOutStockRecordImpl;
import com.fudanmed.platform.core.warehouse.impl.RCProductStoreTransactionImpl;
import com.fudanmed.platform.core.warehouse.proxy.RCOutStockTransactionProxy;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("RCOUTSTOCKTRANSACTION_TYPE")
public class RCOutStockTransactionImpl extends RCProductStoreTransactionImpl implements RCOutStockTransaction {
  public RCOutStockTransactionImpl() {
    super();
  }
  
  public RCOutStockTransactionImpl(final RCProductStorage productStorage) {
    super( productStorage);
    
  }
  
  @JoinColumn(name = "outStockRecord_id")
  @ManyToOne(targetEntity = RCOutStockRecordImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCOutStockRecord outStockRecord;
  
  public RCOutStockRecord getOutStockRecord() {
    return this.outStockRecord;
  }
  
  public RCOutStockTransaction setOutStockRecord(final RCOutStockRecord outStockRecord) {
    this.outStockRecord = outStockRecord;
    return this;			
    
  }
  
  public String getEventRecordSid() {
    String _sid = this.outStockRecord.getSid();
    return _sid;
  }
  
  public String getTransactionTypeDesc() {
    return "\u51FA\u5E93";
  }
  
  public static RCOutStockTransaction create(final RCProductStorage productStorage, final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.warehouse.RCOutStockTransaction rCOutStockTransaction = new com.fudanmed.platform.core.warehouse.impl.RCOutStockTransactionImpl(
    	productStorage
    );
    objectFactory.create(rCOutStockTransaction);
    return rCOutStockTransaction;			
    
  }
  
  public RCOutStockTransactionProxy toProxy() {
    com.fudanmed.platform.core.warehouse.proxy.RCOutStockTransactionProxy proxy = new com.fudanmed.platform.core.warehouse.proxy.RCOutStockTransactionProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
