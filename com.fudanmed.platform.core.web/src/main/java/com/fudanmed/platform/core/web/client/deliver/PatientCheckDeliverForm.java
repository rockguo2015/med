package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLCheckOrganizationProxy;
import com.fudanmed.platform.core.deliver.proxy.DLDeliverEmergencyProxy;
import com.fudanmed.platform.core.deliver.proxy.DLDeliverPatientCheckTypeProxy;
import com.fudanmed.platform.core.deliver.proxy.DLInHospitalPatientProxy;
import com.fudanmed.platform.core.deliver.proxy.DLPatientDeliverMethodProxy;
import com.fudanmed.platform.core.web.client.deliver.CheckOrgContentProvider;
import com.fudanmed.platform.core.web.client.deliver.DeliverEmergencyContentProvider;
import com.fudanmed.platform.core.web.client.deliver.DeliverPatientCheckTypeContentProvider;
import com.fudanmed.platform.core.web.client.deliver.InHospitalPatientContentProvider;
import com.fudanmed.platform.core.web.client.deliver.PatientDeliverMethodContentProvider;
import com.fudanmed.platform.core.web.shared.deliver.UIPatientCheckDeliver;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.uniquesoft.gwt.client.ClientUi;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.form.GXTFormComponent;
import edu.fudan.langlab.gxt.client.component.form.factory.ComboBoxSelector;
import edu.fudan.langlab.gxt.client.component.form.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.gxt.client.widget.WidgetExtensions;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class PatientCheckDeliverForm extends GXTFormComponent<UIPatientCheckDeliver> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public ComboBoxSelector<DLInHospitalPatientProxy> patient;
  
  @Inject
  public InHospitalPatientContentProvider patientContentProvider;
  
  public ComboBoxSelector<DLCheckOrganizationProxy> checkOrganization;
  
  @Inject
  public CheckOrgContentProvider checkOrganizationContentProvider;
  
  public ComboBoxSelector<DLDeliverPatientCheckTypeProxy> checkType;
  
  @Inject
  public DeliverPatientCheckTypeContentProvider checkTypeContentProvider;
  
  public ComboBoxSelector<DLPatientDeliverMethodProxy> deliverMethod;
  
  @Inject
  public PatientDeliverMethodContentProvider deliverMethodContentProvider;
  
  public ComboBoxSelector<DLDeliverEmergencyProxy> emergency;
  
  @Inject
  public DeliverEmergencyContentProvider emergencyContentProvider;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  private UIPatientCheckDeliver value = new UIPatientCheckDeliver();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();patient = defaultObjectSelectorFactory.createAsComboBoxItem("patient","病人");
    _initializerSupports.add(patientContentProvider);
    patient.setContentProvider(patientContentProvider);
    widgetsRegistory.put("patient",patient);
    checkOrganization = defaultObjectSelectorFactory.createAsComboBoxItem("checkOrganization","检查科室");
    checkOrganization.setContentProvider(checkOrganizationContentProvider);
    widgetsRegistory.put("checkOrganization",checkOrganization);
    checkType = defaultObjectSelectorFactory.createAsComboBoxItem("checkType","检查项目");
    _initializerSupports.add(checkTypeContentProvider);
    checkType.setContentProvider(checkTypeContentProvider);
    widgetsRegistory.put("checkType",checkType);
    deliverMethod = defaultObjectSelectorFactory.createAsComboBoxItem("deliverMethod","接送方式");
    _initializerSupports.add(deliverMethodContentProvider);
    deliverMethod.setContentProvider(deliverMethodContentProvider);
    widgetsRegistory.put("deliverMethod",deliverMethod);
    emergency = defaultObjectSelectorFactory.createAsComboBoxItem("emergency","紧急度");
    _initializerSupports.add(emergencyContentProvider);
    emergency.setContentProvider(emergencyContentProvider);
    widgetsRegistory.put("emergency",emergency);
    if(con instanceof com.uniquesoft.gwt.client.common.async.IInitializerSupport){
    							_initializerSupports.add((com.uniquesoft.gwt.client.common.async.IInitializerSupport)con);
    						}IPostInitializeAction postAction = new IPostInitializeAction() {
    								
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
  
  protected PatientCheckDeliverForm doSetValue(final UIPatientCheckDeliver value) {
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
  
  public Widget asWidget() {
    final Function1<Void,VerticalLayoutContainer> _function = new Function1<Void,VerticalLayoutContainer>() {
        public VerticalLayoutContainer apply(final Void it) {
          VerticalLayoutContainer _VLayout = PatientCheckDeliverForm.this.widgets.VLayout();
          final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
              public void apply(final VerticalLayoutContainer it) {
                FieldLabel _asWidget = PatientCheckDeliverForm.this.patient.asWidget();
                WidgetExtensions.<FieldLabel>addFill(it, _asWidget);
                FieldLabel _asWidget_1 = PatientCheckDeliverForm.this.checkOrganization.asWidget();
                WidgetExtensions.<FieldLabel>addFill(it, _asWidget_1);
                FieldLabel _asWidget_2 = PatientCheckDeliverForm.this.checkType.asWidget();
                WidgetExtensions.<FieldLabel>addFill(it, _asWidget_2);
                FieldLabel _asWidget_3 = PatientCheckDeliverForm.this.deliverMethod.asWidget();
                WidgetExtensions.<FieldLabel>addFill(it, _asWidget_3);
                FieldLabel _asWidget_4 = PatientCheckDeliverForm.this.emergency.asWidget();
                WidgetExtensions.<FieldLabel>addFill(it, _asWidget_4);
              }
            };
          VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
          return _doubleArrow;
        }
      };
    Widget _lazy = ClientUi.<Widget>lazy(this.con, _function);
    Widget _con = this.con = _lazy;
    return _con;
  }
  
  private Widget con;
}
