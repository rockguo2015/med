package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.shared.device.UIPrimaryType;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.grid.GXTGridComponent;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory.StringColumn;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class PrimaryTypeList extends GXTGridComponent<UIPrimaryType> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringColumn<UIPrimaryType> name;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIPrimaryType value = new UIPrimaryType();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();name = stringValueProviderFactory.createAsStringColumn("name","name",UIPrimaryType.NameAccessor);
    widgetsRegistory.put("name",name);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIPrimaryType getValueAsNew() {
    UIPrimaryType value = new UIPrimaryType();
    value.setName(name.getValue());
    return value;
  }
  
  public UIPrimaryType doGetValue() {
    
    value.setName(name.getValue());
    return value;
  }
  
  public UIPrimaryType getValue(final UIPrimaryType copyValue) {
    
    copyValue.setName(name.getValue());
    return copyValue;
  }
  
  protected PrimaryTypeList doSetValue(final UIPrimaryType value) {
    this.value = value;
    name.setValue(value.getName());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)name
    					);
  }
}
