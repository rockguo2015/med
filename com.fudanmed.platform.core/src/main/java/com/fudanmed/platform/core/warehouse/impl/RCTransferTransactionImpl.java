package com.fudanmed.platform.core.warehouse.impl;

import com.fudanmed.platform.core.warehouse.RCProductStorage;
import com.fudanmed.platform.core.warehouse.RCTransferRecord;
import com.fudanmed.platform.core.warehouse.RCTransferTransaction;
import com.fudanmed.platform.core.warehouse.impl.RCProductStoreTransactionImpl;
import com.fudanmed.platform.core.warehouse.impl.RCTransferRecordImpl;
import com.fudanmed.platform.core.warehouse.proxy.RCTransferTransactionProxy;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("RCTRANSFERTRANSACTION_TYPE")
public class RCTransferTransactionImpl extends RCProductStoreTransactionImpl implements RCTransferTransaction {
  public RCTransferTransactionImpl() {
    super();
  }
  
  public RCTransferTransactionImpl(final RCProductStorage productStorage) {
    super( productStorage);
    
  }
  
  @JoinColumn(name = "transferRecord_id")
  @ManyToOne(targetEntity = RCTransferRecordImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCTransferRecord transferRecord;
  
  public RCTransferRecord getTransferRecord() {
    return this.transferRecord;
  }
  
  public RCTransferTransaction setTransferRecord(final RCTransferRecord transferRecord) {
    this.transferRecord = transferRecord;
    return this;			
    
  }
  
  public String getEventRecordSid() {
    String _sid = this.transferRecord.getSid();
    return _sid;
  }
  
  public String getTransactionTypeDesc() {
    String _xifexpression = null;
    Integer _quantity = this.getQuantity();
    boolean _lessThan = ((_quantity).intValue() < 0);
    if (_lessThan) {
      _xifexpression = "\u8C03\u62E8\u51FA\u5E93";
    } else {
      _xifexpression = "\u8C03\u62E8\u5165\u5E93";
    }
    return _xifexpression;
  }
  
  public static RCTransferTransaction create(final RCProductStorage productStorage, final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.warehouse.RCTransferTransaction rCTransferTransaction = new com.fudanmed.platform.core.warehouse.impl.RCTransferTransactionImpl(
    	productStorage
    );
    objectFactory.create(rCTransferTransaction);
    return rCTransferTransaction;			
    
  }
  
  public RCTransferTransactionProxy toProxy() {
    com.fudanmed.platform.core.warehouse.proxy.RCTransferTransactionProxy proxy = new com.fudanmed.platform.core.warehouse.proxy.RCTransferTransactionProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
