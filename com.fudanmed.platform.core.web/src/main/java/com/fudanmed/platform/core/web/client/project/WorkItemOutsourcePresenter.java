package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy;
import com.fudanmed.platform.core.web.client.project.WorkItemOutsourcePresenterServiceAsync;
import com.fudanmed.platform.core.web.client.project.WorkItemOutsourcePresenterView;
import com.fudanmed.platform.core.web.shared.project.WorkItemOutsourceData;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.CommitResultNotifier;
import com.uniquesoft.gwt.client.common.CommitablePresenter;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class WorkItemOutsourcePresenter extends WorkbenchAbstractPresenter<WorkItemOutsourcePresenterView> implements CommitablePresenter {
  @Inject
  protected WorkItemOutsourcePresenterServiceAsync _service;
  
  @Inject
  public WorkItemOutsourcePresenter(final WorkItemOutsourcePresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private RCWorkItemTaskProxy context;
  
  public void setup(final RCWorkItemTaskProxy context, final Procedure1<? super WorkItemOutsourcePresenter> postInit) {
    
    this.context = context;
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<String> _function = new Procedure1<String>() {
              public void apply(final String it) {
                getView().setComment(it);
                
                postInit.apply(WorkItemOutsourcePresenter.this);
              }
            };
          AsyncCallback<String> _onSuccess = WorkItemOutsourcePresenter.this.<String>onSuccess(_function);
          _service.getComment(context, _onSuccess);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void performCommit(final CommitResultNotifier notifier) {
    
    WorkItemOutsourcePresenterView _view = this.getView();
    WorkItemOutsourceData _value = _view.getValue();
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.project.WorkItemTasksChangedEvent());
          eventBus.fireEvent(new com.fudanmed.platform.core.web.client.project.GroupTasksChangedEvent());
          
          notifier.success();
        }
      };
    AsyncCallback<Void> _onSuccess = this.<Void>onSuccess(_function);
    _service.commit(this.context, _value, _onSuccess);
  }
  
  private Collection<HandlerRegistration> _regs_ = com.google.common.collect.Lists.newArrayList();;
  
  public void doUnbind() {
    for(HandlerRegistration reg : _regs_){
    	reg.removeHandler();
    }				
    
  }
  
  protected void doBind() {
    
  }
}
