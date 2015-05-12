package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.shared.deliver.UIInHospitalPatient;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.grid.GXTGridComponent;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class InHospitalPatientListGrid extends GXTGridComponent<UIInHospitalPatient> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  private UIInHospitalPatient value = new UIInHospitalPatient();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIInHospitalPatient getValueAsNew() {
    UIInHospitalPatient value = new UIInHospitalPatient();
    return value;
  }
  
  public UIInHospitalPatient doGetValue() {
    
    return value;
  }
  
  public UIInHospitalPatient getValue(final UIInHospitalPatient copyValue) {
    
    return copyValue;
  }
  
  protected InHospitalPatientListGrid doSetValue(final UIInHospitalPatient value) {
    this.value = value;
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					);
  }
}
