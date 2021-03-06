package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.warehouse.RCProductStoreTransaction;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductStoreTransaction;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.warehouse.ProductStoreTransactionMapper")
public class ProductStoreTransactionMapper extends AbstractEntityMapper<UIProductStoreTransaction,RCProductStoreTransaction> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public RCProductStoreTransaction loadEntityById(final Long id) {
    return entities.get(RCProductStoreTransaction.class,id);
  }
  
  public RCProductStoreTransaction create() {
    return entities.create(RCProductStoreTransaction.class);
  }
  
  public void copyToEntity(final UIProductStoreTransaction from, final RCProductStoreTransaction to) {
    to.setVersion(from.getVersion());
    
  }
  
  public UIProductStoreTransaction copyFromEntity(final UIProductStoreTransaction result, final RCProductStoreTransaction entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setVersion(entity.getVersion());
    result.setProxy(entity.toProxy());
    result.setClazzName(entity.getClass().getName());
    result.setEventRecordSid(convertService.toValue(java.lang.String.class,entity.getEventRecordSid()));
    result.setTransactionTypeDesc(convertService.toValue(java.lang.String.class,entity.getTransactionTypeDesc()));
    result.setDate(convertService.toValue(java.util.Date.class,entity.getDate()));
    result.setQuantity(convertService.toValue(java.lang.Integer.class,entity.getQuantity()));
    result.setOperator(convertService.toValue(com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy.class,entity.getOperator()));
    return result;
    
  }
  
  public UIProductStoreTransaction buildFrom(final RCProductStoreTransaction entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.warehouse.UIProductStoreTransaction result = new com.fudanmed.platform.core.web.shared.warehouse.UIProductStoreTransaction();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIProductStoreTransaction.class;
  }
  
  public Class<?> getEntityClass() {
    return RCProductStoreTransaction.class;
  }
}
