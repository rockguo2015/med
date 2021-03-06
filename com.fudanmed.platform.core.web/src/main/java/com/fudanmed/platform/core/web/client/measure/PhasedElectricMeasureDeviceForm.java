package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.web.shared.measure.UIPhasedElectricMeasureDevice;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.uniquesoft.gwt.client.ClientUi;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.form.GXTFormComponent;
import edu.fudan.langlab.gxt.client.component.form.factory.DoubleValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.DoubleValueProviderFactory.DoubleItem;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory.TextItem;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.gxt.client.widget.WidgetExtensions;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class PhasedElectricMeasureDeviceForm extends GXTFormComponent<UIPhasedElectricMeasureDevice> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public TextItem sid;
  
  public TextItem name;
  
  public TextItem location;
  
  public DoubleItem factor;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  @Inject
  private DoubleValueProviderFactory doubleValueProviderFactory;
  
  private UIPhasedElectricMeasureDevice value = new UIPhasedElectricMeasureDevice();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();sid = stringValueProviderFactory.createAsTextItem("sid","编号");
    widgetsRegistory.put("sid",sid);
    name = stringValueProviderFactory.createAsTextItem("name","名称");
    widgetsRegistory.put("name",name);
    location = stringValueProviderFactory.createAsTextItem("location","安装位置");
    widgetsRegistory.put("location",location);
    factor = doubleValueProviderFactory.createAsDoubleItem("factor","变比");
    widgetsRegistory.put("factor",factor);
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
  
  public UIPhasedElectricMeasureDevice getValueAsNew() {
    UIPhasedElectricMeasureDevice value = new UIPhasedElectricMeasureDevice();
    value.setSid(sid.getValue());
    value.setName(name.getValue());
    value.setLocation(location.getValue());
    value.setFactor(factor.getValue());
    return value;
  }
  
  public UIPhasedElectricMeasureDevice doGetValue() {
    
    value.setSid(sid.getValue());
    value.setName(name.getValue());
    value.setLocation(location.getValue());
    value.setFactor(factor.getValue());
    return value;
  }
  
  public UIPhasedElectricMeasureDevice getValue(final UIPhasedElectricMeasureDevice copyValue) {
    
    copyValue.setSid(sid.getValue());
    copyValue.setName(name.getValue());
    copyValue.setLocation(location.getValue());
    copyValue.setFactor(factor.getValue());
    return copyValue;
  }
  
  protected PhasedElectricMeasureDeviceForm doSetValue(final UIPhasedElectricMeasureDevice value) {
    this.value = value;
    sid.setValue(value.getSid());
    name.setValue(value.getName());
    location.setValue(value.getLocation());
    factor.setValue(value.getFactor());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)sid,(ICanAsWidget)name,(ICanAsWidget)location,(ICanAsWidget)factor
    					);
  }
  
  public Widget asWidget() {
    final Function1<Void,VerticalLayoutContainer> _function = new Function1<Void,VerticalLayoutContainer>() {
        public VerticalLayoutContainer apply(final Void it) {
          VerticalLayoutContainer _VLayout = PhasedElectricMeasureDeviceForm.this.widgets.VLayout();
          final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
              public void apply(final VerticalLayoutContainer it) {
                FieldLabel _asWidget = PhasedElectricMeasureDeviceForm.this.sid.asWidget();
                WidgetExtensions.<FieldLabel>addFill(it, _asWidget);
                FieldLabel _asWidget_1 = PhasedElectricMeasureDeviceForm.this.name.asWidget();
                WidgetExtensions.<FieldLabel>addFill(it, _asWidget_1);
                FieldLabel _asWidget_2 = PhasedElectricMeasureDeviceForm.this.location.asWidget();
                WidgetExtensions.<FieldLabel>addFill(it, _asWidget_2);
                FieldLabel _asWidget_3 = PhasedElectricMeasureDeviceForm.this.factor.asWidget();
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
