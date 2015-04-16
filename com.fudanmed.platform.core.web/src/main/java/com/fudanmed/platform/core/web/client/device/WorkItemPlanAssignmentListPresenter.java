package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCPMWorkItemProxy;
import com.fudanmed.platform.core.web.client.device.WorkItemPlanAssignmentListPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.device.WorkItemPlanAssignmentListPresenterView;
import com.fudanmed.platform.core.web.shared.device.UIWorkItemPlanAssignment;
import com.google.common.base.Objects;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class WorkItemPlanAssignmentListPresenter extends WorkbenchAbstractPresenter<WorkItemPlanAssignmentListPresenterView> {
  @Inject
  protected WorkItemPlanAssignmentListPresenterServiceAsync _service;
  
  @Inject
  public WorkItemPlanAssignmentListPresenter(final WorkItemPlanAssignmentListPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private RCPMWorkItemProxy context;
  
  public void setup(final IPresenterInitiazerNotifier<WorkItemPlanAssignmentListPresenter> _notifier) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {_notifier.done(WorkItemPlanAssignmentListPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setup(final RCPMWorkItemProxy context, final IPresenterInitiazerNotifier<WorkItemPlanAssignmentListPresenter> _notifier) {
    
    this.context = context;
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          WorkItemPlanAssignmentListPresenter.this.refresh();_notifier.done(WorkItemPlanAssignmentListPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setPMWorkItem(final RCPMWorkItemProxy context) {
    
    this.context = context;
    this.refresh();
  }
  
  public void refresh() {
    
    boolean _notEquals = (!Objects.equal(this.context, null));
    if (_notEquals) {
      final Procedure1<Collection<UIWorkItemPlanAssignment>> _function = new Procedure1<Collection<UIWorkItemPlanAssignment>>() {
          public void apply(final Collection<UIWorkItemPlanAssignment> items) {
            getView().setResults(items);
            
          }
        };
      AsyncCallback<Collection<UIWorkItemPlanAssignment>> _onSuccess = this.<Collection<UIWorkItemPlanAssignment>>onSuccess(_function);
      _service.loadWorkItemPlanAssignmentList(this.context, _onSuccess);
    }
  }
  
  public void _eventbus_WorkItemPlanAssignmentsChanged() {
    
    this.refresh();
  }
  
  private Collection<HandlerRegistration> _regs_ = com.google.common.collect.Lists.newArrayList();;
  
  public void doUnbind() {
    for(HandlerRegistration reg : _regs_){
    	reg.removeHandler();
    }				
    
  }
  
  protected void doBind() {
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.device.WorkItemPlanAssignmentsChangedEvent.__type__, new com.fudanmed.platform.core.web.client.device.WorkItemPlanAssignmentsChangedHandler(){
    public void WorkItemPlanAssignmentsChanged(){
    	_eventbus_WorkItemPlanAssignmentsChanged();
    }
    }));
    
  }
}