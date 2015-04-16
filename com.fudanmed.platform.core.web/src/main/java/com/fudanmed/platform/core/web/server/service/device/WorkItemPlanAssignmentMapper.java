package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.device.pm.RCWorkItemPlanAssignment;
import com.fudanmed.platform.core.web.shared.device.UIWorkItemPlanAssignment;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.device.WorkItemPlanAssignmentMapper")
public class WorkItemPlanAssignmentMapper extends AbstractEntityMapper<UIWorkItemPlanAssignment,RCWorkItemPlanAssignment> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public RCWorkItemPlanAssignment loadEntityById(final Long id) {
    return entities.get(RCWorkItemPlanAssignment.class,id);
  }
  
  public RCWorkItemPlanAssignment create() {
    return entities.create(RCWorkItemPlanAssignment.class);
  }
  
  public void copyToEntity(final UIWorkItemPlanAssignment from, final RCWorkItemPlanAssignment to) {
    to.setVersion(from.getVersion());
    
  }
  
  public UIWorkItemPlanAssignment copyFromEntity(final UIWorkItemPlanAssignment result, final RCWorkItemPlanAssignment entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setVersion(entity.getVersion());
    result.setProxy(entity.toProxy());
    result.setClazzName(entity.getClass().getName());
    if(entity. getPlan()  != null &&entity. getPlan().getSpec()  != null &&entity. getPlan().getSpec().getDevice()  != null )
    	result.setSid(convertService.toValue(java.lang.String.class,entity.getPlan().getSpec().getDevice().getSid()));
    if(entity. getPlan()  != null &&entity. getPlan().getSpec()  != null &&entity. getPlan().getSpec().getDevice()  != null )
    	result.setName(convertService.toValue(java.lang.String.class,entity.getPlan().getSpec().getDevice().getName()));
    if(entity. getPlan()  != null &&entity. getPlan().getSpec()  != null &&entity. getPlan().getSpec().getDevice()  != null )
    	result.setSpecification(convertService.toValue(java.lang.String.class,entity.getPlan().getSpec().getDevice().getSpecification()));
    if(entity. getPlan()  != null &&entity. getPlan().getSpec()  != null &&entity. getPlan().getSpec().getDevice()  != null )
    	result.setLocation(convertService.toValue(com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy.class,entity.getPlan().getSpec().getDevice().getLocation()));
    if(entity. getPlan()  != null &&entity. getPlan().getSpec()  != null &&entity. getPlan().getSpec().getDevice()  != null )
    	result.setDeviceType(convertService.toValue(com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy.class,entity.getPlan().getSpec().getDevice().getDeviceType()));
    if(entity. getPlan()  != null &&entity. getPlan().getSpec()  != null )
    	result.setPmType(convertService.toValue(com.fudanmed.platform.core.device.pm.proxy.RCDevicePMTypeProxy.class,entity.getPlan().getSpec().getPmType()));
    if(entity. getPlan()  != null &&entity. getPlan().getSpec()  != null )
    	result.setIntervalInDays(convertService.toValue(java.lang.Integer.class,entity.getPlan().getSpec().getIntervalInDays()));
    if(entity. getPlan()  != null )
    	result.setPlanDate(convertService.toValue(java.util.Date.class,entity.getPlan().getPlanDate()));
    if(entity. getPlan()  != null &&entity. getPlan().getSpec()  != null )
    	result.setPmComment(convertService.toValue(java.lang.String.class,entity.getPlan().getSpec().getDescription()));
    if(entity. getPlan()  != null )
    	result.setSmstatus(convertService.toValue(com.fudanmed.platform.core.web.shared.device.UIDevicePMPlanStatus.class,entity.getPlan().getStatus()));
    return result;
    
  }
  
  public UIWorkItemPlanAssignment buildFrom(final RCWorkItemPlanAssignment entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.device.UIWorkItemPlanAssignment result = new com.fudanmed.platform.core.web.shared.device.UIWorkItemPlanAssignment();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIWorkItemPlanAssignment.class;
  }
  
  public Class<?> getEntityClass() {
    return RCWorkItemPlanAssignment.class;
  }
}
