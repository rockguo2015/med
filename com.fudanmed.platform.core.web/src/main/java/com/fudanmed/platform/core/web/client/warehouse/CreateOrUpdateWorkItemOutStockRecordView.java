package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.domain.proxy.RCRepairTaskProxy;
import com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.fudanmed.platform.core.web.client.warehouse.CreateOrUpdateWorkItemOutStockRecordPresenterView;
import com.fudanmed.platform.core.web.client.warehouse.WorkItemOutStockRecordForm;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductWarehouseStorageSummary;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemOutStockRecord;
import com.google.gwt.editor.client.HasEditorErrors;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.uniquesoft.gwt.client.ClientUi;
import com.uniquesoft.gwt.client.common.RequestHandler2;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.IHasSize;
import com.uniquesoft.gwt.client.common.widgets.IHasTitle;
import com.uniquesoft.gwt.client.common.widgets.Size;
import edu.fudan.langlab.gxt.client.component.form.Validations;
import edu.fudan.langlab.gxt.client.validation.ErrorNotifierViewer;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.security.client.Securities;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;

public class CreateOrUpdateWorkItemOutStockRecordView extends ErrorNotifierViewer implements CreateOrUpdateWorkItemOutStockRecordPresenterView, IHasSize, IHasTitle {
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
  private WorkItemOutStockRecordForm form;
  
  public void initialize() {
    
    VerticalLayoutContainer _VLayout = this.widgets.VLayout();
    final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
        public void apply(final VerticalLayoutContainer it) {
          Widget _asWidget = CreateOrUpdateWorkItemOutStockRecordView.this.form.asWidget();
          int _minus = (-1);
          VerticalLayoutData _VLayoutData = CreateOrUpdateWorkItemOutStockRecordView.this.widgets.VLayoutData(1, _minus, 10);
          it.add(_asWidget, _VLayoutData);
        }
      };
    VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
    ClientUi.operator_add(this, _doubleArrow);
    final Procedure2<String,RCWarehouseProxy> _function_1 = new Procedure2<String,RCWarehouseProxy>() {
        public void apply(final String sid, final RCWarehouseProxy store) {
          
          productSidEnteredRequestHandler.execute(sid,store);
          
        }
      };
    this.form.setProductSidSelectedHandler(_function_1);
  }
  
  public UIWorkItemOutStockRecord getValue() {
    UIWorkItemOutStockRecord _value = this.form.getValue();
    return _value;
  }
  
  public HasEditorErrors mapField(final String errorKey) {
    HasEditorErrors _mapToErrorEditor = Validations.mapToErrorEditor(this.form, errorKey);
    return _mapToErrorEditor;
  }
  
  public void clearErrors() {
    Validations.clearErrors(this.form);
  }
  
  public void setValue(final UIWorkItemOutStockRecord value) {
    this.form.setValue(value);
  }
  
  public Size getSize() {
    Size _size = new Size(810, 550);
    return _size;
  }
  
  public String getTitle() {
    return "\u5DE5\u5355\u9886\u6599";
  }
  
  public void setWorkItemTask(final RCWorkItemTaskProxy workItem, final RCRepairTaskProxy repairTask) {
    this.form.workItem.setValue(workItem);
    String _name = repairTask.getName();
    this.form.reportSid.setValue(_name);
  }
  
  public void setSourceWarehouseContext(final RCEmployeeProxy employee, final Procedure1<? super Void> notifier) {
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          CreateOrUpdateWorkItemOutStockRecordView.this.form.sourceStore.selectFirst();
          RCWarehouseProxy _value = CreateOrUpdateWorkItemOutStockRecordView.this.form.sourceStore.getValue();
          CreateOrUpdateWorkItemOutStockRecordView.this.form.setSourceWarehouse(_value);
          notifier.apply(null);
        }
      };
    this.form.setSourceWarehouseContext(employee, _function);
  }
  
  public void setProductSummary(final UIProductWarehouseStorageSummary productSummary) {
    this.form.setProductSummary(productSummary);
  }
  
  private RequestHandler2<String,RCWarehouseProxy> productSidEnteredRequestHandler;
  
  public void productSidEntered(final RequestHandler2<String,RCWarehouseProxy> requestHandler) {
    this.productSidEnteredRequestHandler = requestHandler;
  }
}
