package com.fudanmed.platform.core.web.server.service.deliver;

import com.fudanmed.platform.core.deliver.DLPatientCheckDeliver;
import com.fudanmed.platform.core.web.server.service.deliver.PatientCheckDeliverValidator;
import com.fudanmed.platform.core.web.shared.deliver.UIPatientCheckDeliver;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.deliver.PatientCheckDeliverMapper")
public class PatientCheckDeliverMapper extends AbstractEntityMapper<UIPatientCheckDeliver,DLPatientCheckDeliver> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public DLPatientCheckDeliver loadEntityById(final Long id) {
    return entities.get(DLPatientCheckDeliver.class,id);
  }
  
  public DLPatientCheckDeliver create() {
    return entities.create(DLPatientCheckDeliver.class);
  }
  
  @Autowired
  private PatientCheckDeliverValidator validator;
  
  public void copyToEntity(final UIPatientCheckDeliver from, final DLPatientCheckDeliver to) {
    java.util.Collection<com.uniquesoft.gwt.shared.validation.ValidationErrorItem> errors = validator.validate(from);
    if(errors.size()!=0)throw new com.uniquesoft.gwt.shared.validation.ValidationException(errors);					
    to.setVersion(from.getVersion());
    to.setPatient(convertService.toValue(com.fudanmed.platform.core.deliver.DLInHospitalPatient.class,from.getPatient()));
    to.setCheckOrganization(convertService.toValue(com.fudanmed.platform.core.deliver.DLCheckOrganization.class,from.getCheckOrganization()));
    to.setCheckType(convertService.toValue(com.fudanmed.platform.core.deliver.DLDeliverPatientCheckType.class,from.getCheckType()));
    to.setDeliverMethod(convertService.toValue(com.fudanmed.platform.core.deliver.DLPatientDeliverMethod.class,from.getDeliverMethod()));
    to.setEmergency(convertService.toValue(com.fudanmed.platform.core.deliver.DLDeliverEmergency.class,from.getEmergency()));
    
  }
  
  public UIPatientCheckDeliver copyFromEntity(final UIPatientCheckDeliver result, final DLPatientCheckDeliver entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setVersion(entity.getVersion());
    result.setProxy(entity.toProxy());
    result.setClazzName(entity.getClass().getName());
    result.setPatient(convertService.toValue(com.fudanmed.platform.core.deliver.proxy.DLInHospitalPatientProxy.class,entity.getPatient()));
    result.setCheckOrganization(convertService.toValue(com.fudanmed.platform.core.deliver.proxy.DLCheckOrganizationProxy.class,entity.getCheckOrganization()));
    result.setCheckType(convertService.toValue(com.fudanmed.platform.core.deliver.proxy.DLDeliverPatientCheckTypeProxy.class,entity.getCheckType()));
    result.setDeliverMethod(convertService.toValue(com.fudanmed.platform.core.deliver.proxy.DLPatientDeliverMethodProxy.class,entity.getDeliverMethod()));
    result.setEmergency(convertService.toValue(com.fudanmed.platform.core.deliver.proxy.DLDeliverEmergencyProxy.class,entity.getEmergency()));
    return result;
    
  }
  
  public UIPatientCheckDeliver buildFrom(final DLPatientCheckDeliver entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.deliver.UIPatientCheckDeliver result = new com.fudanmed.platform.core.web.shared.deliver.UIPatientCheckDeliver();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIPatientCheckDeliver.class;
  }
  
  public Class<?> getEntityClass() {
    return DLPatientCheckDeliver.class;
  }
}
