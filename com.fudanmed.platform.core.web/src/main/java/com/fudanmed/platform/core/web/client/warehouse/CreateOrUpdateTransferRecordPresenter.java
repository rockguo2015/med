package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCTransferRecordProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.fudanmed.platform.core.web.client.warehouse.CreateOrUpdateTransferRecordPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.warehouse.CreateOrUpdateTransferRecordPresenterView;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductWarehouseStorageSummary;
import com.fudanmed.platform.core.web.shared.warehouse.UITransferRecord;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.CommitResultNotifier;
import com.uniquesoft.gwt.client.common.CommitablePresenter;
import com.uniquesoft.gwt.client.common.RequestHandler2;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.print.Print;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class CreateOrUpdateTransferRecordPresenter extends WorkbenchAbstractPresenter<CreateOrUpdateTransferRecordPresenterView> implements CommitablePresenter {
  @Inject
  protected CreateOrUpdateTransferRecordPresenterServiceAsync _service;
  
  @Inject
  public CreateOrUpdateTransferRecordPresenter(final CreateOrUpdateTransferRecordPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private boolean used4Update;
  
  public void setup4Create(final Procedure1<? super CreateOrUpdateTransferRecordPresenter> postInitializer) {
    
    this.used4Update = false;
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<RCEmployeeProxy> _function = new Procedure1<RCEmployeeProxy>() {
              public void apply(final RCEmployeeProxy it) {
                CreateOrUpdateTransferRecordPresenterView _view = CreateOrUpdateTransferRecordPresenter.this.getView();
                final Procedure1<Void> _function = new Procedure1<Void>() {
                    public void apply(final Void it) {
                      postInitializer.apply(CreateOrUpdateTransferRecordPresenter.this);
                    }
                  };
                _view.setSourceWarehouseContext(it, _function);
              }
            };
          AsyncCallback<RCEmployeeProxy> _onSuccess = CreateOrUpdateTransferRecordPresenter.this.<RCEmployeeProxy>onSuccess(_function);
          _service.getCurrentUser(_onSuccess);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setup4Update(final RCTransferRecordProxy value, final Procedure1<? super CreateOrUpdateTransferRecordPresenter> postInitializer) {
    
    this.used4Update = true;
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<UITransferRecord> _function = new Procedure1<UITransferRecord>() {
              public void apply(final UITransferRecord it) {
                CreateOrUpdateTransferRecordPresenterView _view = CreateOrUpdateTransferRecordPresenter.this.getView();
                _view.setValue(it);
                postInitializer.apply(CreateOrUpdateTransferRecordPresenter.this);
              }
            };
          AsyncCallback<UITransferRecord> _onSuccess = CreateOrUpdateTransferRecordPresenter.this.<UITransferRecord>onSuccess(_function);
          _service.loadValue(value, _onSuccess);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void view_productSidEnteredExecution(final String sid, final RCWarehouseProxy store) {
    
    final Procedure1<UIProductWarehouseStorageSummary> _function = new Procedure1<UIProductWarehouseStorageSummary>() {
        public void apply(final UIProductWarehouseStorageSummary it) {
          CreateOrUpdateTransferRecordPresenterView _view = CreateOrUpdateTransferRecordPresenter.this.getView();
          _view.setProductSummary(it);
        }
      };
    AsyncCallback<UIProductWarehouseStorageSummary> _onSuccess = this.<UIProductWarehouseStorageSummary>onSuccess(_function);
    _service.getProductSummaryByProductSid(sid, store, _onSuccess);
  }
  
  public void performCommit(final CommitResultNotifier notifier) {
    
    if (this.used4Update) {
      CreateOrUpdateTransferRecordPresenterView _view = this.getView();
      UITransferRecord _value = _view.getValue();
      final Procedure1<Void> _function = new Procedure1<Void>() {
          public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.warehouse.ProductStoreTransactionsChangedEvent());
            eventBus.fireEvent(new com.fudanmed.platform.core.web.client.warehouse.TransferRecordsChangedEvent());
            eventBus.fireEvent(new com.fudanmed.platform.core.web.client.warehouse.ProductWarehouseStorageSummarysChangedEvent());
            
            notifier.success();
          }
        };
      AsyncCallback<Void> _onSuccess = this.<Void>onSuccess(_function);
      _service.updateValue(_value, _onSuccess);
    } else {
      CreateOrUpdateTransferRecordPresenterView _view_1 = this.getView();
      UITransferRecord _value_1 = _view_1.getValue();
      final Procedure1<RCTransferRecordProxy> _function_1 = new Procedure1<RCTransferRecordProxy>() {
          public void apply(final RCTransferRecordProxy record) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.warehouse.ProductStoreTransactionsChangedEvent());
            eventBus.fireEvent(new com.fudanmed.platform.core.web.client.warehouse.TransferRecordsChangedEvent());
            eventBus.fireEvent(new com.fudanmed.platform.core.web.client.warehouse.ProductWarehouseStorageSummarysChangedEvent());
            
            CreateOrUpdateTransferRecordPresenterView _view = CreateOrUpdateTransferRecordPresenter.this.getView();
            UITransferRecord _value = _view.getValue();
            Boolean _print = _value.getPrint();
            if ((_print).booleanValue()) {
              final Procedure1<String> _function = new Procedure1<String>() {
                  public void apply(final String html) {
                    Print.it(html);
                  }
                };
              AsyncCallback<String> _onSuccess = CreateOrUpdateTransferRecordPresenter.this.<String>onSuccess(_function);
              _service.generatePrintContents(record, _onSuccess);
            }
            notifier.success();
          }
        };
      AsyncCallback<RCTransferRecordProxy> _onSuccess_1 = this.<RCTransferRecordProxy>onSuccess(_function_1);
      _service.createValue(_value_1, _onSuccess_1);
    }
  }
  
  private Collection<HandlerRegistration> _regs_ = com.google.common.collect.Lists.newArrayList();;
  
  public void doUnbind() {
    for(HandlerRegistration reg : _regs_){
    	reg.removeHandler();
    }				
    
  }
  
  protected void doBind() {
    getView().productSidEntered(new RequestHandler2<String,RCWarehouseProxy>(){
    			
    			public void execute(String sid,RCWarehouseProxy store){
    				view_productSidEnteredExecution(sid,store);
    			}
    			
    		});
    
  }
}
