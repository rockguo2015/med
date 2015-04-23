package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.proxy.RCDeviceTypeCategoryProxy;
import com.fudanmed.platform.core.web.shared.device.UIDeviceType;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.uniquesoft.gwt.client.ClientUi;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.form.GXTFormComponent;
import edu.fudan.langlab.gxt.client.component.form.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.IntegerValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.IntegerValueProviderFactory.IntegerItem;
import edu.fudan.langlab.gxt.client.component.form.factory.ReadonlyItem;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory.TextItem;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.gxt.client.widget.WidgetExtensions;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class DeviceTypeForm extends GXTFormComponent<UIDeviceType> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public ReadonlyItem<RCDeviceTypeCategoryProxy> category;
  
  public TextItem name;
  
  public IntegerItem depreciationYears;
  
  public TextItem code;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  @Inject
  private IntegerValueProviderFactory integerValueProviderFactory;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  private UIDeviceType value = new UIDeviceType();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();category = defaultObjectSelectorFactory.createAsReadonlyItem("category","设备大类");
    widgetsRegistory.put("category",category);
    name = stringValueProviderFactory.createAsTextItem("name","名称");
    widgetsRegistory.put("name",name);
    depreciationYears = integerValueProviderFactory.createAsIntegerItem("depreciationYears","折旧年限");
    widgetsRegistory.put("depreciationYears",depreciationYears);
    code = stringValueProviderFactory.createAsTextItem("code","类型编码");
    widgetsRegistory.put("code",code);
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
  
  public UIDeviceType getValueAsNew() {
    UIDeviceType value = new UIDeviceType();
    value.setCategory(category.getValue());
    value.setName(name.getValue());
    value.setDepreciationYears(depreciationYears.getValue());
    value.setCode(code.getValue());
    return value;
  }
  
  public UIDeviceType doGetValue() {
    
    value.setCategory(category.getValue());
    value.setName(name.getValue());
    value.setDepreciationYears(depreciationYears.getValue());
    value.setCode(code.getValue());
    return value;
  }
  
  public UIDeviceType getValue(final UIDeviceType copyValue) {
    
    copyValue.setCategory(category.getValue());
    copyValue.setName(name.getValue());
    copyValue.setDepreciationYears(depreciationYears.getValue());
    copyValue.setCode(code.getValue());
    return copyValue;
  }
  
  protected DeviceTypeForm doSetValue(final UIDeviceType value) {
    this.value = value;
    category.setValue(value.getCategory());
    name.setValue(value.getName());
    depreciationYears.setValue(value.getDepreciationYears());
    code.setValue(value.getCode());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)category,(ICanAsWidget)name,(ICanAsWidget)depreciationYears,(ICanAsWidget)code
    					);
  }
  
  public Widget asWidget() {
    final Function1<Void,VerticalLayoutContainer> _function = new Function1<Void,VerticalLayoutContainer>() {
        public VerticalLayoutContainer apply(final Void it) {
          VerticalLayoutContainer _VLayout = DeviceTypeForm.this.widgets.VLayout();
          final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
              public void apply(final VerticalLayoutContainer it) {
                FieldLabel _asWidget = DeviceTypeForm.this.category.asWidget();
                WidgetExtensions.<FieldLabel>addFill(it, _asWidget);
                FieldLabel _asWidget_1 = DeviceTypeForm.this.code.asWidget();
                WidgetExtensions.<FieldLabel>addFill(it, _asWidget_1);
                FieldLabel _asWidget_2 = DeviceTypeForm.this.name.asWidget();
                WidgetExtensions.<FieldLabel>addFill(it, _asWidget_2);
                FieldLabel _asWidget_3 = DeviceTypeForm.this.depreciationYears.asWidget();
                WidgetExtensions.<FieldLabel>addFill(it, _asWidget_3);
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
