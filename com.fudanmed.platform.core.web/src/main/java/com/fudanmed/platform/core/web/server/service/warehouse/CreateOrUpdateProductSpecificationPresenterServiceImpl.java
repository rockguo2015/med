package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.warehouse.RCProductSpecification;
import com.fudanmed.platform.core.warehouse.proxy.RCProductSpecificationProxy;
import com.fudanmed.platform.core.web.client.warehouse.CreateOrUpdateProductSpecificationPresenterService;
import com.fudanmed.platform.core.web.server.service.warehouse.ProductSpecificationMapper;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecification;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.warehouse.CreateOrUpdateProductSpecificationPresenterService")
@Transactional
public class CreateOrUpdateProductSpecificationPresenterServiceImpl extends BaseService implements CreateOrUpdateProductSpecificationPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private ProductSpecificationMapper mapper;
  
  public UIProductSpecification loadValue(final RCProductSpecificationProxy pvalue) throws SessionTimeOutException, ValidationException {
    RCProductSpecification _resolved= null;
    if(pvalue!=null) _resolved=(com.fudanmed.platform.core.warehouse.RCProductSpecification)com.uniquesoft.uidl.extensions.ModelObjects.resolve(pvalue, entities);
    
    UIProductSpecification _transform = this.mapper.transform( _resolved);
    return _transform;
  }
  
  public void updateValue(final UIProductSpecification uivalue) throws SessionTimeOutException, ValidationException {
    RCProductSpecification _resolved= null;
    if(uivalue!=null) _resolved=(com.fudanmed.platform.core.warehouse.RCProductSpecification)com.uniquesoft.uidl.extensions.ModelObjects.resolve(uivalue, entities);
    
    this.mapper.transform(uivalue,  _resolved);
  }
  
  public void createValue(final UIProductSpecification uivalue) throws SessionTimeOutException, ValidationException {
    RCProductSpecification value = this.entities.<RCProductSpecification>create(RCProductSpecification.class);
    this.mapper.transform(uivalue, value);
  }
}
