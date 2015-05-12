package com.fudanmed.platform.core.web.server.service.deliver;

import com.fudanmed.platform.core.deliver.DLCenterlizedDeliverTask;
import com.fudanmed.platform.core.web.shared.deliver.UICenterlizedDeliverTask4Patient;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.deliver.CenterlizedDeliverTask4PatientMapper")
public class CenterlizedDeliverTask4PatientMapper extends AbstractEntityMapper<UICenterlizedDeliverTask4Patient,DLCenterlizedDeliverTask> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public DLCenterlizedDeliverTask loadEntityById(final Long id) {
    return entities.get(DLCenterlizedDeliverTask.class,id);
  }
  
  public DLCenterlizedDeliverTask create() {
    return entities.create(DLCenterlizedDeliverTask.class);
  }
  
  public void copyToEntity(final UICenterlizedDeliverTask4Patient from, final DLCenterlizedDeliverTask to) {
    to.setVersion(from.getVersion());
    to.getPlanDateTime().setPlanDate(convertService.toValue(java.util.Date.class,from.getPlanDate()));
    to.getPlanDateTime().setPlanTime(convertService.toValue(java.util.Date.class,from.getPlanTime()));
    
  }
  
  public UICenterlizedDeliverTask4Patient copyFromEntity(final UICenterlizedDeliverTask4Patient result, final DLCenterlizedDeliverTask entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setVersion(entity.getVersion());
    result.setProxy(entity.toProxy());
    result.setClazzName(entity.getClass().getName());
    if(entity. getPlanDateTime()  != null )
    	result.setPlanDate(convertService.toValue(java.util.Date.class,entity.getPlanDateTime().getPlanDate()));
    if(entity. getPlanDateTime()  != null )
    	result.setPlanTime(convertService.toValue(java.util.Date.class,entity.getPlanDateTime().getPlanTime()));
    return result;
    
  }
  
  public UICenterlizedDeliverTask4Patient buildFrom(final DLCenterlizedDeliverTask entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.deliver.UICenterlizedDeliverTask4Patient result = new com.fudanmed.platform.core.web.shared.deliver.UICenterlizedDeliverTask4Patient();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UICenterlizedDeliverTask4Patient.class;
  }
  
  public Class<?> getEntityClass() {
    return DLCenterlizedDeliverTask.class;
  }
}
