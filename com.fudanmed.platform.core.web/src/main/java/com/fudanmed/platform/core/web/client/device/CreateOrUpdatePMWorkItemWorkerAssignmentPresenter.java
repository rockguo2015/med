package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCPMWorkItemProxy;
import com.fudanmed.platform.core.device.pm.proxy.RCPMWorkItemWorkerAssignmentProxy;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.client.device.CreateOrUpdatePMWorkItemWorkerAssignmentPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.device.CreateOrUpdatePMWorkItemWorkerAssignmentPresenterView;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItemWorkerAssignment;
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

public class CreateOrUpdatePMWorkItemWorkerAssignmentPresenter extends WorkbenchAbstractPresenter<CreateOrUpdatePMWorkItemWorkerAssignmentPresenterView> implements CommitablePresenter {
  @Inject
  protected CreateOrUpdatePMWorkItemWorkerAssignmentPresenterServiceAsync _service;
  
  @Inject
  public CreateOrUpdatePMWorkItemWorkerAssignmentPresenter(final CreateOrUpdatePMWorkItemWorkerAssignmentPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private boolean used4Update;
  
  private RCPMWorkItemProxy parent;
  
  public void setup4Create(final RCPMWorkItemProxy parent, final Procedure1<? super CreateOrUpdatePMWorkItemWorkerAssignmentPresenter> postInitializer) {
    
    this.used4Update = false;
    this.parent = parent;
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<RCOrganizationProxy> _function = new Procedure1<RCOrganizationProxy>() {
              public void apply(final RCOrganizationProxy it) {
                CreateOrUpdatePMWorkItemWorkerAssignmentPresenterView _view = CreateOrUpdatePMWorkItemWorkerAssignmentPresenter.this.getView();
                final Procedure1<Void> _function = new Procedure1<Void>() {
                    public void apply(final Void it) {
                      postInitializer.apply(CreateOrUpdatePMWorkItemWorkerAssignmentPresenter.this);
                    }
                  };
                _view.setTeam(it, _function);
              }
            };
          AsyncCallback<RCOrganizationProxy> _onSuccess = CreateOrUpdatePMWorkItemWorkerAssignmentPresenter.this.<RCOrganizationProxy>onSuccess(_function);
          _service.loadTeamOrg4WorkItem(parent, _onSuccess);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setup4Update(final RCPMWorkItemWorkerAssignmentProxy value, final Procedure1<? super CreateOrUpdatePMWorkItemWorkerAssignmentPresenter> postInitializer) {
    
    this.used4Update = true;
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<RCOrganizationProxy> _function = new Procedure1<RCOrganizationProxy>() {
              public void apply(final RCOrganizationProxy it) {
                CreateOrUpdatePMWorkItemWorkerAssignmentPresenterView _view = CreateOrUpdatePMWorkItemWorkerAssignmentPresenter.this.getView();
                final Procedure1<Void> _function = new Procedure1<Void>() {
                    public void apply(final Void it) {
                      final Procedure1<UIPMWorkItemWorkerAssignment> _function = new Procedure1<UIPMWorkItemWorkerAssignment>() {
                          public void apply(final UIPMWorkItemWorkerAssignment it) {
                            CreateOrUpdatePMWorkItemWorkerAssignmentPresenterView _view = CreateOrUpdatePMWorkItemWorkerAssignmentPresenter.this.getView();
                            _view.setValue(it);
                            postInitializer.apply(CreateOrUpdatePMWorkItemWorkerAssignmentPresenter.this);
                          }
                        };
                      AsyncCallback<UIPMWorkItemWorkerAssignment> _onSuccess = CreateOrUpdatePMWorkItemWorkerAssignmentPresenter.this.<UIPMWorkItemWorkerAssignment>onSuccess(_function);
                      _service.loadValue(value, _onSuccess);
                    }
                  };
                _view.setTeam(it, _function);
              }
            };
          AsyncCallback<RCOrganizationProxy> _onSuccess = CreateOrUpdatePMWorkItemWorkerAssignmentPresenter.this.<RCOrganizationProxy>onSuccess(_function);
          _service.loadTeamOrg4WorkItem(CreateOrUpdatePMWorkItemWorkerAssignmentPresenter.this.parent, _onSuccess);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void performCommit(final CommitResultNotifier notifier) {
    
    if (this.used4Update) {
      CreateOrUpdatePMWorkItemWorkerAssignmentPresenterView _view = this.getView();
      UIPMWorkItemWorkerAssignment _value = _view.getValue();
      final Procedure1<Void> _function = new Procedure1<Void>() {
          public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.device.PMWorkItemWorkerAssignmentsChangedEvent());
            
            notifier.success();
          }
        };
      AsyncCallback<Void> _onSuccess = this.<Void>onSuccess(_function);
      _service.updateValue(_value, _onSuccess);
    } else {
      CreateOrUpdatePMWorkItemWorkerAssignmentPresenterView _view_1 = this.getView();
      UIPMWorkItemWorkerAssignment _value_1 = _view_1.getValue();
      final Procedure1<Void> _function_1 = new Procedure1<Void>() {
          public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.device.PMWorkItemsChangedEvent());
            
            notifier.success();
          }
        };
      AsyncCallback<Void> _onSuccess_1 = this.<Void>onSuccess(_function_1);
      _service.createValue(this.parent, _value_1, _onSuccess_1);
    }
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
