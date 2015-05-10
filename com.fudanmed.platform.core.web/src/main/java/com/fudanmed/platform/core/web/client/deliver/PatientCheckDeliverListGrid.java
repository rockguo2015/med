package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLCheckOrganizationProxy;
import com.fudanmed.platform.core.deliver.proxy.DLDeliverEmergencyProxy;
import com.fudanmed.platform.core.deliver.proxy.DLDeliverPatientCheckTypeProxy;
import com.fudanmed.platform.core.deliver.proxy.DLInHospitalPatientProxy;
import com.fudanmed.platform.core.deliver.proxy.DLPatientDeliverMethodProxy;
import com.fudanmed.platform.core.web.shared.deliver.UIPatientCheckDeliver;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.grid.GXTGridComponent;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectSelectorFactory.StringValueColumn;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class PatientCheckDeliverListGrid extends GXTGridComponent<UIPatientCheckDeliver> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringValueColumn<UIPatientCheckDeliver,DLInHospitalPatientProxy> patient;
  
  public StringValueColumn<UIPatientCheckDeliver,DLCheckOrganizationProxy> checkOrganization;
  
  public StringValueColumn<UIPatientCheckDeliver,DLDeliverPatientCheckTypeProxy> checkType;
  
  public StringValueColumn<UIPatientCheckDeliver,DLPatientDeliverMethodProxy> deliverMethod;
  
  public StringValueColumn<UIPatientCheckDeliver,DLDeliverEmergencyProxy> emergency;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  private UIPatientCheckDeliver value = new UIPatientCheckDeliver();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();patient = defaultObjectSelectorFactory.createAsDefaultColumn("patient","病人",UIPatientCheckDeliver.PatientAccessor);
    widgetsRegistory.put("patient",patient);
    checkOrganization = defaultObjectSelectorFactory.createAsDefaultColumn("checkOrganization","检查科室",UIPatientCheckDeliver.CheckOrganizationAccessor);
    widgetsRegistory.put("checkOrganization",checkOrganization);
    checkType = defaultObjectSelectorFactory.createAsDefaultColumn("checkType","检查项目",UIPatientCheckDeliver.CheckTypeAccessor);
    widgetsRegistory.put("checkType",checkType);
    deliverMethod = defaultObjectSelectorFactory.createAsDefaultColumn("deliverMethod","接送方式",UIPatientCheckDeliver.DeliverMethodAccessor);
    widgetsRegistory.put("deliverMethod",deliverMethod);
    emergency = defaultObjectSelectorFactory.createAsDefaultColumn("emergency","紧急度",UIPatientCheckDeliver.EmergencyAccessor);
    widgetsRegistory.put("emergency",emergency);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIPatientCheckDeliver getValueAsNew() {
    UIPatientCheckDeliver value = new UIPatientCheckDeliver();
    value.setPatient(patient.getValue());
    value.setCheckOrganization(checkOrganization.getValue());
    value.setCheckType(checkType.getValue());
    value.setDeliverMethod(deliverMethod.getValue());
    value.setEmergency(emergency.getValue());
    return value;
  }
  
  public UIPatientCheckDeliver doGetValue() {
    
    value.setPatient(patient.getValue());
    value.setCheckOrganization(checkOrganization.getValue());
    value.setCheckType(checkType.getValue());
    value.setDeliverMethod(deliverMethod.getValue());
    value.setEmergency(emergency.getValue());
    return value;
  }
  
  public UIPatientCheckDeliver getValue(final UIPatientCheckDeliver copyValue) {
    
    copyValue.setPatient(patient.getValue());
    copyValue.setCheckOrganization(checkOrganization.getValue());
    copyValue.setCheckType(checkType.getValue());
    copyValue.setDeliverMethod(deliverMethod.getValue());
    copyValue.setEmergency(emergency.getValue());
    return copyValue;
  }
  
  protected PatientCheckDeliverListGrid doSetValue(final UIPatientCheckDeliver value) {
    this.value = value;
    patient.setValue(value.getPatient());
    checkOrganization.setValue(value.getCheckOrganization());
    checkType.setValue(value.getCheckType());
    deliverMethod.setValue(value.getDeliverMethod());
    emergency.setValue(value.getEmergency());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)patient,(ICanAsWidget)checkOrganization,(ICanAsWidget)checkType,(ICanAsWidget)deliverMethod,(ICanAsWidget)emergency
    					);
  }
}
