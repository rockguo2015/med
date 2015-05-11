package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.client.deliver.CenterlizedDeliverTask4PatientForm;
import com.fudanmed.platform.core.web.client.deliver.CreateOrUpdateCenterlizedDeliverTask4PatientPresenterView;
import com.fudanmed.platform.core.web.shared.deliver.UICenterlizedDeliverTask4Patient;
import com.fudanmed.platform.core.web.shared.deliver.UIPatientCheckDeliver;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.uniquesoft.gwt.client.ClientUi;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.IHasSize;
import com.uniquesoft.gwt.client.common.widgets.IHasTitle;
import com.uniquesoft.gwt.client.common.widgets.Size;
import edu.fudan.langlab.gxt.client.component.form.FormViewerImpl;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.security.client.Securities;
import java.util.Collection;

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
    
    Widget _asWidget = this.form.asWidget();
    VerticalLayoutContainer _DialogContent = this.widgets.DialogContent(_asWidget);
    ClientUi.operator_add(this, _DialogContent);
  }
  
  public Collection<UIPatientCheckDeliver> getPatientDeliverList() {
    Collection<UIPatientCheckDeliver> _patientDeliverList = this.form.getPatientDeliverList();
    return _patientDeliverList;
  }
}
