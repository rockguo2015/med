package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLDeliverPatientCheckTypeProxy;
import com.fudanmed.platform.core.deliver.proxy.DLInHospitalPatientProxy;
import com.fudanmed.platform.core.web.client.deliver.CenterlizedDeliverTask4PatientForm;
import com.fudanmed.platform.core.web.client.deliver.CreateOrUpdateCenterlizedDeliverTask4PatientPresenterView;
import com.fudanmed.platform.core.web.client.deliver.InHospitalPatientForm;
import com.fudanmed.platform.core.web.client.deliver.PatientCheckDeliverForm;
import com.fudanmed.platform.core.web.shared.deliver.UICenterlizedDeliverTask4Patient;
import com.fudanmed.platform.core.web.shared.deliver.UIInHospitalPatient;
import com.fudanmed.platform.core.web.shared.deliver.UIPatientCheckDeliver;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.uniquesoft.gwt.client.ClientUi;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.IHasSize;
import com.uniquesoft.gwt.client.common.widgets.IHasTitle;
import com.uniquesoft.gwt.client.common.widgets.Size;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ValueChangedManager.ValueChangedListener;
import edu.fudan.langlab.gxt.client.component.form.FormViewerImpl;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.security.client.Securities;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class CreateOrUpdateCenterlizedDeliverTask4PatientView extends FormViewerImpl<UICenterlizedDeliverTask4Patient> implements CreateOrUpdateCenterlizedDeliverTask4PatientPresenterView, IHasSize, IHasTitle {
  @Inject
  private IWidgetFactory widgets;
  
  public void initialize(final IPostInitializeAction postInitialize) {
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(
    	com.google.common.collect.Lists.newArrayList(form),
    	new com.uniquesoft.gwt.client.common.async.IPostInitializeAction(){
    
    	public void initializeFinished(Void v) {
    		initialize();
    		postInitialize.initializeFinished(null);
    	}
    });
    
  }
  
  @Inject
  private Securities securities;
  
  @Inject
  private EventBus eventBus;
  
  @Inject
  private CenterlizedDeliverTask4PatientForm form;
  
  public CenterlizedDeliverTask4PatientForm doGetFormComponent() {
    return form;
  }
  
  public Size getSize() {
    return new com.uniquesoft.gwt.client.common.widgets.Size(800,450);
  }
  
  public String getTitle() {
    return "病人运送信息维护";
  }
  
  public void initialize() {
    
    PatientCheckDeliverForm _patientCheckDeliverForm = this.form.getPatientCheckDeliverForm();
    final Procedure1<DLDeliverPatientCheckTypeProxy> _function = new Procedure1<DLDeliverPatientCheckTypeProxy>() {
        public void apply(final DLDeliverPatientCheckTypeProxy it) {
          PatientCheckDeliverForm _patientCheckDeliverForm = CreateOrUpdateCenterlizedDeliverTask4PatientView.this.form.getPatientCheckDeliverForm();
          DLDeliverPatientCheckTypeProxy _value = _patientCheckDeliverForm.checkType.getValue();
          checkTypeChangedRequestHandler.execute(_value);
          
        }
      };
    _patientCheckDeliverForm.checkType.addValueChangedListener(new ValueChangedListener<DLDeliverPatientCheckTypeProxy>() {
        public void onValueChanged(DLDeliverPatientCheckTypeProxy value) {
          _function.apply(value);
        }
    });
    PatientCheckDeliverForm _patientCheckDeliverForm_1 = this.form.getPatientCheckDeliverForm();
    final Procedure1<DLInHospitalPatientProxy> _function_1 = new Procedure1<DLInHospitalPatientProxy>() {
        public void apply(final DLInHospitalPatientProxy it) {
          PatientCheckDeliverForm _patientCheckDeliverForm = CreateOrUpdateCenterlizedDeliverTask4PatientView.this.form.getPatientCheckDeliverForm();
          DLInHospitalPatientProxy _value = _patientCheckDeliverForm.patient.getValue();
          patientChangedRequestHandler.execute(_value);
          
        }
      };
    _patientCheckDeliverForm_1.patient.addValueChangedListener(new ValueChangedListener<DLInHospitalPatientProxy>() {
        public void onValueChanged(DLInHospitalPatientProxy value) {
          _function_1.apply(value);
        }
    });
    Widget _asWidget = this.form.asWidget();
    VerticalLayoutContainer _DialogContent = this.widgets.DialogContent(_asWidget);
    ClientUi.operator_add(this, _DialogContent);
  }
  
  public Collection<UIPatientCheckDeliver> getPatientDeliverList() {
    Collection<UIPatientCheckDeliver> _patientDeliverList = this.form.getPatientDeliverList();
    return _patientDeliverList;
  }
  
  public void setCheckOrganization(final DLDeliverPatientCheckTypeProxy checkType) {
    PatientCheckDeliverForm _patientCheckDeliverForm = this.form.getPatientCheckDeliverForm();
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
        }
      };
    _patientCheckDeliverForm.checkOrganizationContentProvider.load(checkType, _function);
  }
  
  public void showPatientDetail(final UIInHospitalPatient detail) {
    InHospitalPatientForm _patientForm = this.form.getPatientForm();
    _patientForm.setValue(detail);
  }
  
  private RequestHandler1<DLDeliverPatientCheckTypeProxy> checkTypeChangedRequestHandler;
  
  public void checkTypeChanged(final RequestHandler1<DLDeliverPatientCheckTypeProxy> requestHandler) {
    this.checkTypeChangedRequestHandler = requestHandler;
  }
  
  private RequestHandler1<DLInHospitalPatientProxy> patientChangedRequestHandler;
  
  public void patientChanged(final RequestHandler1<DLInHospitalPatientProxy> requestHandler) {
    this.patientChangedRequestHandler = requestHandler;
  }
}
