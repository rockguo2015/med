package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLDeliverPatientCheckCategoryProxy;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverPatientCheckTypeCriteria;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.form.GXTFormComponent;
import edu.fudan.langlab.gxt.client.component.form.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.ReadonlyItem;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory.TextItem;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class DeliverPatientCheckTypeCriteriaForm extends GXTFormComponent<UIDeliverPatientCheckTypeCriteria> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public TextItem info;
  
  public ReadonlyItem<DLDeliverPatientCheckCategoryProxy> category;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  private UIDeliverPatientCheckTypeCriteria value = new UIDeliverPatientCheckTypeCriteria();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();info = stringValueProviderFactory.createAsEscapedTextItem("info","检查项目信息");
    widgetsRegistory.put("info",info);
    category = defaultObjectSelectorFactory.createAsReadonlyItem("category","检查项目大类");
    widgetsRegistory.put("category",category);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIDeliverPatientCheckTypeCriteria getValueAsNew() {
    UIDeliverPatientCheckTypeCriteria value = new UIDeliverPatientCheckTypeCriteria();
    value.setInfo(info.getValue());
    value.setCategory(category.getValue());
    return value;
  }
  
  public UIDeliverPatientCheckTypeCriteria doGetValue() {
    
    value.setInfo(info.getValue());
    value.setCategory(category.getValue());
    return value;
  }
  
  public UIDeliverPatientCheckTypeCriteria getValue(final UIDeliverPatientCheckTypeCriteria copyValue) {
    
    copyValue.setInfo(info.getValue());
    copyValue.setCategory(category.getValue());
    return copyValue;
  }
  
  protected DeliverPatientCheckTypeCriteriaForm doSetValue(final UIDeliverPatientCheckTypeCriteria value) {
    this.value = value;
    info.setValue(value.getInfo());
    category.setValue(value.getCategory());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)info,(ICanAsWidget)category
    					);
  }
}
