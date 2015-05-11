package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemReturnStockRecord;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.uniquesoft.gwt.client.ClientUi;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.form.GXTFormComponent;
import edu.fudan.langlab.gxt.client.component.form.factory.DateValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.DateValueProviderFactory.DateReadonlyItem;
import edu.fudan.langlab.gxt.client.component.form.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.ReadonlyItem;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory.StringReadonlyItem;
import edu.fudan.langlab.gxt.client.widget.HTMLTagsExt;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTD;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTR;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTable;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class WorkItemReturnStockRecordDetailForm extends GXTFormComponent<UIWorkItemReturnStockRecord> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringReadonlyItem sid;
  
  public ReadonlyItem<RCWarehouseProxy> sourceStore;
  
  public ReadonlyItem<RCWorkItemTaskProxy> workItem;
  
  public DateReadonlyItem date;
  
  public ReadonlyItem<RCEmployeeProxy> operator;
  
  public StringReadonlyItem comment;
  
  public StringReadonlyItem reportSid;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  private UIWorkItemReturnStockRecord value = new UIWorkItemReturnStockRecord();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();sid = stringValueProviderFactory.createAsReadonlyItem("sid","退料单号");
    widgetsRegistory.put("sid",sid);
    sourceStore = defaultObjectSelectorFactory.createAsReadonlyItem("sourceStore","入库仓库");
    widgetsRegistory.put("sourceStore",sourceStore);
    workItem = defaultObjectSelectorFactory.createAsReadonlyItem("workItem","工单号");
    widgetsRegistory.put("workItem",workItem);
    date = dateValueProviderFactory.createAsReadonlyItem("date","退料日期");
    widgetsRegistory.put("date",date);
    operator = defaultObjectSelectorFactory.createAsReadonlyItem("operator","操作员");
    widgetsRegistory.put("operator",operator);
    comment = stringValueProviderFactory.createAsReadonlyItem("comment","备注");
    widgetsRegistory.put("comment",comment);
    reportSid = stringValueProviderFactory.createAsReadonlyItem("reportSid","报修单号");
    widgetsRegistory.put("reportSid",reportSid);
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
  
  public UIWorkItemReturnStockRecord getValueAsNew() {
    UIWorkItemReturnStockRecord value = new UIWorkItemReturnStockRecord();
    value.setSid(sid.getValue());
    value.setSourceStore(sourceStore.getValue());
    value.setWorkItem(workItem.getValue());
    value.setDate(date.getValue());
    value.setOperator(operator.getValue());
    value.setComment(comment.getValue());
    value.setReportSid(reportSid.getValue());
    return value;
  }
  
  public UIWorkItemReturnStockRecord doGetValue() {
    
    value.setSid(sid.getValue());
    value.setSourceStore(sourceStore.getValue());
    value.setWorkItem(workItem.getValue());
    value.setDate(date.getValue());
    value.setOperator(operator.getValue());
    value.setComment(comment.getValue());
    value.setReportSid(reportSid.getValue());
    return value;
  }
  
  public UIWorkItemReturnStockRecord getValue(final UIWorkItemReturnStockRecord copyValue) {
    
    copyValue.setSid(sid.getValue());
    copyValue.setSourceStore(sourceStore.getValue());
    copyValue.setWorkItem(workItem.getValue());
    copyValue.setDate(date.getValue());
    copyValue.setOperator(operator.getValue());
    copyValue.setComment(comment.getValue());
    copyValue.setReportSid(reportSid.getValue());
    return copyValue;
  }
  
  protected WorkItemReturnStockRecordDetailForm doSetValue(final UIWorkItemReturnStockRecord value) {
    this.value = value;
    sid.setValue(value.getSid());
    sourceStore.setValue(value.getSourceStore());
    workItem.setValue(value.getWorkItem());
    date.setValue(value.getDate());
    operator.setValue(value.getOperator());
    comment.setValue(value.getComment());
    reportSid.setValue(value.getReportSid());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)sid,(ICanAsWidget)sourceStore,(ICanAsWidget)workItem,(ICanAsWidget)date,(ICanAsWidget)operator,(ICanAsWidget)comment,(ICanAsWidget)reportSid
    					);
  }
  
  public Widget asWidget() {
    final Function1<Void,PlainHTMLTable> _function = new Function1<Void,PlainHTMLTable>() {
        public PlainHTMLTable apply(final Void it) {
          PlainHTMLTable _TABLE = HTMLTagsExt.TABLE();
          final Procedure1<PlainHTMLTable> _function = new Procedure1<PlainHTMLTable>() {
              public void apply(final PlainHTMLTable it) {
                PlainHTMLTR _tr = HTMLTagsExt.tr(it);
                final Procedure1<PlainHTMLTR> _function = new Procedure1<PlainHTMLTR>() {
                    public void apply(final PlainHTMLTR it) {
                      PlainHTMLTD _td = HTMLTagsExt.td(it);
                      final Procedure1<PlainHTMLTD> _function = new Procedure1<PlainHTMLTD>() {
                          public void apply(final PlainHTMLTD it) {
                            FieldLabel _asWidget = WorkItemReturnStockRecordDetailForm.this.reportSid.asWidget();
                            ClientUi.operator_add(it, _asWidget);
                          }
                        };
                      ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                      PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                      final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
                          public void apply(final PlainHTMLTD it) {
                            FieldLabel _asWidget = WorkItemReturnStockRecordDetailForm.this.sid.asWidget();
                            ClientUi.operator_add(it, _asWidget);
                          }
                        };
                      ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_1, _function_1);
                      PlainHTMLTD _td_2 = HTMLTagsExt.td(it);
                      final Procedure1<PlainHTMLTD> _function_2 = new Procedure1<PlainHTMLTD>() {
                          public void apply(final PlainHTMLTD it) {
                            FieldLabel _asWidget = WorkItemReturnStockRecordDetailForm.this.workItem.asWidget();
                            ClientUi.operator_add(it, _asWidget);
                          }
                        };
                      ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_2, _function_2);
                    }
                  };
                ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr, _function);
                PlainHTMLTR _tr_1 = HTMLTagsExt.tr(it);
                final Procedure1<PlainHTMLTR> _function_1 = new Procedure1<PlainHTMLTR>() {
                    public void apply(final PlainHTMLTR it) {
                      PlainHTMLTD _td = HTMLTagsExt.td(it);
                      final Procedure1<PlainHTMLTD> _function = new Procedure1<PlainHTMLTD>() {
                          public void apply(final PlainHTMLTD it) {
                            FieldLabel _asWidget = WorkItemReturnStockRecordDetailForm.this.sourceStore.asWidget();
                            ClientUi.operator_add(it, _asWidget);
                          }
                        };
                      ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                      PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                      final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
                          public void apply(final PlainHTMLTD it) {
                            FieldLabel _asWidget = WorkItemReturnStockRecordDetailForm.this.date.asWidget();
                            ClientUi.operator_add(it, _asWidget);
                          }
                        };
                      ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_1, _function_1);
                      PlainHTMLTD _td_2 = HTMLTagsExt.td(it);
                      final Procedure1<PlainHTMLTD> _function_2 = new Procedure1<PlainHTMLTD>() {
                          public void apply(final PlainHTMLTD it) {
                            FieldLabel _asWidget = WorkItemReturnStockRecordDetailForm.this.operator.asWidget();
                            ClientUi.operator_add(it, _asWidget);
                          }
                        };
                      ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_2, _function_2);
                    }
                  };
                ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr_1, _function_1);
              }
            };
          PlainHTMLTable _doubleArrow = ObjectExtensions.<PlainHTMLTable>operator_doubleArrow(_TABLE, _function);
          return _doubleArrow;
        }
      };
    Widget _lazy = ClientUi.<Widget>lazy(this.con, _function);
    Widget _con = this.con = _lazy;
    return _con;
  }
  
  private Widget con;
}
