package com.fudanmed.platform.core.deliver.impl;

import com.fudanmed.platform.core.deliver.DLCheckOrganization;
import com.fudanmed.platform.core.deliver.DLDeliverPatientCheckCategory;
import com.fudanmed.platform.core.deliver.DLInHospitalLocation;
import com.fudanmed.platform.core.deliver.DLInHospitalPatient;
import com.fudanmed.platform.core.deliver.DLPatientCheckDeliver;
import com.fudanmed.platform.core.deliver.DLPatientDeliverMethod;
import com.fudanmed.platform.core.deliver.impl.DLCheckOrganizationImpl;
import com.fudanmed.platform.core.deliver.impl.DLDeliverPatientCheckCategoryImpl;
import com.fudanmed.platform.core.deliver.impl.DLDeliverSubjectImpl;
import com.fudanmed.platform.core.deliver.impl.DLInHospitalLocationImpl;
import com.fudanmed.platform.core.deliver.impl.DLInHospitalPatientImpl;
import com.fudanmed.platform.core.deliver.impl.DLPatientDeliverMethodImpl;
import com.fudanmed.platform.core.deliver.proxy.DLPatientCheckDeliverProxy;
import com.google.common.base.Objects;
import com.uniquesoft.uidl.validation.Validates;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("DLPATIENTCHECKDELIVER_TYPE")
public class DLPatientCheckDeliverImpl extends DLDeliverSubjectImpl implements DLPatientCheckDeliver {
  public DLPatientCheckDeliverImpl() {
    super();
  }
  
  @JoinColumn(name = "patient_id")
  @ManyToOne(targetEntity = DLInHospitalPatientImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private DLInHospitalPatient patient;
  
  public DLInHospitalPatient getPatient() {
    return this.patient;
  }
  
  public DLPatientCheckDeliver setPatient(final DLInHospitalPatient patient) {
    this.patient = patient;
    return this;			
    
  }
  
  @JoinColumn(name = "location_id")
  @ManyToOne(targetEntity = DLInHospitalLocationImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private DLInHospitalLocation location;
  
  public DLInHospitalLocation getLocation() {
    return this.location;
  }
  
  public DLPatientCheckDeliver setLocation(final DLInHospitalLocation location) {
    this.location = location;
    return this;			
    
  }
  
  private String bedNumber;
  
  public String getBedNumber() {
    return this.bedNumber;
  }
  
  public DLPatientCheckDeliver setBedNumber(final String bedNumber) {
    this.bedNumber = bedNumber;
    return this;			
    
  }
  
  @JoinColumn(name = "checkOrganization_id")
  @ManyToOne(targetEntity = DLCheckOrganizationImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private DLCheckOrganization checkOrganization;
  
  public DLCheckOrganization getCheckOrganization() {
    return this.checkOrganization;
  }
  
  public DLPatientCheckDeliver setCheckOrganization(final DLCheckOrganization checkOrganization) {
    this.checkOrganization = checkOrganization;
    return this;			
    
  }
  
  @JoinColumn(name = "checkType_id")
  @ManyToOne(targetEntity = DLDeliverPatientCheckCategoryImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private DLDeliverPatientCheckCategory checkType;
  
  public DLDeliverPatientCheckCategory getCheckType() {
    return this.checkType;
  }
  
  public DLPatientCheckDeliver setCheckType(final DLDeliverPatientCheckCategory checkType) {
    this.checkType = checkType;
    return this;			
    
  }
  
  @JoinColumn(name = "deliverMethod_id")
  @ManyToOne(targetEntity = DLPatientDeliverMethodImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private DLPatientDeliverMethod deliverMethod;
  
  public DLPatientDeliverMethod getDeliverMethod() {
    return this.deliverMethod;
  }
  
  public DLPatientCheckDeliver setDeliverMethod(final DLPatientDeliverMethod deliverMethod) {
    this.deliverMethod = deliverMethod;
    return this;			
    
  }
  
  public String getEntityName() {
    String _entityName = this.patient.getEntityName();
    return _entityName;
  }
  
  public void checkInvariant() {
    super.checkInvariant();
    boolean _notEquals = (!Objects.equal(this.patient, null));
    Validates.Assert(_notEquals, "\u5FC5\u987B\u8BBE\u7F6E\u8FD0\u9001\u75C5\u4EBA");
    boolean _notEquals_1 = (!Objects.equal(this.checkOrganization, null));
    Validates.Assert(_notEquals_1, "\u5FC5\u987B\u8BBE\u7F6E\u68C0\u67E5\u79D1\u5BA4");
    boolean _notEquals_2 = (!Objects.equal(this.location, null));
    Validates.Assert(_notEquals_2, "\u5FC5\u987B\u8BBE\u7F6E\u75C5\u533A");
  }
  
  public static DLPatientCheckDeliver create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.deliver.DLPatientCheckDeliver dLPatientCheckDeliver = new com.fudanmed.platform.core.deliver.impl.DLPatientCheckDeliverImpl(
    );
    objectFactory.create(dLPatientCheckDeliver);
    return dLPatientCheckDeliver;			
    
  }
  
  public DLPatientCheckDeliverProxy toProxy() {
    com.fudanmed.platform.core.deliver.proxy.DLPatientCheckDeliverProxy proxy = new com.fudanmed.platform.core.deliver.proxy.DLPatientCheckDeliverProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
