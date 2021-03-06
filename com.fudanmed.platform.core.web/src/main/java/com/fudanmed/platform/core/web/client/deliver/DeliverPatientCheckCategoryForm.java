package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLDeliverPatientCheckCategoryProxy;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverPatientCheckCategory;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.form.GXTFormComponent;
import edu.fudan.langlab.gxt.client.component.form.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.ReadonlyItem;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory.TextItem;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.gxt.client.widget.WidgetExtensions;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class DeliverPatientCheckCategoryForm extends GXTFormComponent<UIDeliverPatientCheckCategory> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public TextItem code;
  
  public TextItem name;
  
  public ReadonlyItem<DLDeliverPatientCheckCategoryProxy> parentCategory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  private UIDeliverPatientCheckCategory value = new UIDeliverPatientCheckCategory();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();code = stringValueProviderFactory.createAsTextItem("code","代码");
    widgetsRegistory.put("code",code);
    name = stringValueProviderFactory.createAsTextItem("name","名称");
    widgetsRegistory.put("name",name);
    parentCategory = defaultObjectSelectorFactory.createAsReadonlyItem("parentCategory","父类别");
    widgetsRegistory.put("parentCategory",parentCategory);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIDeliverPatientCheckCategory getValueAsNew() {
    UIDeliverPatientCheckCategory value = new UIDeliverPatientCheckCategory();
    value.setCode(code.getValue());
    value.setName(name.getValue());
    value.setParentCategory(parentCategory.getValue());
    return value;
  }
  
  public UIDeliverPatientCheckCategory doGetValue() {
    
    value.setCode(code.getValue());
    value.setName(name.getValue());
    value.setParentCategory(parentCategory.getValue());
    return value;
  }
  
  public UIDeliverPatientCheckCategory getValue(final UIDeliverPatientCheckCategory copyValue) {
    
    copyValue.setCode(code.getValue());
    copyValue.setName(name.getValue());
    copyValue.setParentCategory(parentCategory.getValue());
    return copyValue;
  }
  
  protected DeliverPatientCheckCategoryForm doSetValue(final UIDeliverPatientCheckCategory value) {
    this.value = value;
    code.setValue(value.getCode());
    name.setValue(value.getName());
    parentCategory.setValue(value.getParentCategory());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)code,(ICanAsWidget)name,(ICanAsWidget)parentCategory
    					);
  }
  
  public Widget createWidget() {
    VerticalLayoutContainer _VLayout = this.widgets.VLayout();
    final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
        public void apply(final VerticalLayoutContainer it) {
          FieldLabel _asWidget = DeliverPatientCheckCategoryForm.this.parentCategory.asWidget();
          WidgetExtensions.<FieldLabel>addFill(it, _asWidget);
          FieldLabel _asWidget_1 = DeliverPatientCheckCategoryForm.this.code.asWidget();
          WidgetExtensions.<FieldLabel>addFill(it, _asWidget_1);
          FieldLabel _asWidget_2 = DeliverPatientCheckCategoryForm.this.name.asWidget();
          WidgetExtensions.<FieldLabel>addFill(it, _asWidget_2);
        }
      };
    VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
    return _doubleArrow;
  }
}
