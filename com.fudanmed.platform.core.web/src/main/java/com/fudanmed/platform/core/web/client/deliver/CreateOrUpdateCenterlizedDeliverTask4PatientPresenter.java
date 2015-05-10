package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLCenterlizedDeliverTaskProxy;
import com.fudanmed.platform.core.web.client.deliver.CreateOrUpdateCenterlizedDeliverTask4PatientPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.deliver.CreateOrUpdateCenterlizedDeliverTask4PatientPresenterView;
import com.fudanmed.platform.core.web.shared.deliver.UICenterlizedDeliverTask4Patient;
import com.fudanmed.platform.core.web.shared.deliver.UIPatientCheckDeliver;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.CommitResultNotifier;
import com.uniquesoft.gwt.client.common.CommitablePresenter;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class CreateOrUpdateCenterlizedDeliverTask4PatientPresenter extends WorkbenchAbstractPresenter<CreateOrUpdateCenterlizedDeliverTask4PatientPresenterView> implements CommitablePresenter {
  @Inject
  protected CreateOrUpdateCenterlizedDeliverTask4PatientPresenterServiceAsync _service;
  
  @Inject
  public CreateOrUpdateCenterlizedDeliverTask4PatientPresenter(final CreateOrUpdateCenterlizedDeliverTask4PatientPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private Procedure1<? super CommitResultNotifier> commiter;
  
  public void setup4Create(final IPresenterInitiazerNotifier<CreateOrUpdateCenterlizedDeliverTask4PatientPresenter> _notifier) {
    
    final Procedure1<CommitResultNotifier> _function = new Procedure1<CommitResultNotifier>() {
        public void apply(final CommitResultNotifier notifier) {
          CreateOrUpdateCenterlizedDeliverTask4PatientPresenterView _view = CreateOrUpdateCenterlizedDeliverTask4PatientPresenter.this.getView();
          UICenterlizedDeliverTask4Patient _value = _view.getValue();
          CreateOrUpdateCenterlizedDeliverTask4PatientPresenterView _view_1 = CreateOrUpdateCenterlizedDeliverTask4PatientPresenter.this.getView();
          Collection<UIPatientCheckDeliver> _patientDeliverList = _view_1.getPatientDeliverList();
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.deliver.CenterlizedDeliverTasksChangedEvent());
                
                notifier.success();
              }
            };
          AsyncCallback<Void> _onSuccess = CreateOrUpdateCenterlizedDeliverTask4PatientPresenter.this.<Void>onSuccess(_function);
          _service.createValue(_value, _patientDeliverList, _onSuccess);
        }
      };
    this.commiter = _function;
    final Procedure1<Void> _function_1 = new Procedure1<Void>() {
        public void apply(final Void it) {_notifier.done(CreateOrUpdateCenterlizedDeliverTask4PatientPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function_1.apply(v);
        }
    });
  }
  
  public void setup4Update(final DLCenterlizedDeliverTaskProxy value, final IPresenterInitiazerNotifier<CreateOrUpdateCenterlizedDeliverTask4PatientPresenter> _notifier) {
    
    final Procedure1<CommitResultNotifier> _function = new Procedure1<CommitResultNotifier>() {
        public void apply(final CommitResultNotifier notifier) {
          CreateOrUpdateCenterlizedDeliverTask4PatientPresenterView _view = CreateOrUpdateCenterlizedDeliverTask4PatientPresenter.this.getView();
          UICenterlizedDeliverTask4Patient _value = _view.getValue();
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.deliver.CenterlizedDeliverTasksChangedEvent());
                
                notifier.success();
              }
            };
          AsyncCallback<Void> _onSuccess = CreateOrUpdateCenterlizedDeliverTask4PatientPresenter.this.<Void>onSuccess(_function);
          _service.updateValue(_value, _onSuccess);
        }
      };
    this.commiter = _function;
    final Procedure1<Void> _function_1 = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<UICenterlizedDeliverTask4Patient> _function = new Procedure1<UICenterlizedDeliverTask4Patient>() {
              public void apply(final UICenterlizedDeliverTask4Patient it) {
                CreateOrUpdateCenterlizedDeliverTask4PatientPresenterView _view = CreateOrUpdateCenterlizedDeliverTask4PatientPresenter.this.getView();
                _view.setValue(it);_notifier.done(CreateOrUpdateCenterlizedDeliverTask4PatientPresenter.this);
              }
            };
          AsyncCallback<UICenterlizedDeliverTask4Patient> _onSuccess = CreateOrUpdateCenterlizedDeliverTask4PatientPresenter.this.<UICenterlizedDeliverTask4Patient>onSuccess(_function);
          _service.loadValue(value, _onSuccess);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function_1.apply(v);
        }
    });
  }
  
  public void performCommit(final CommitResultNotifier notifier) {
    
    this.commiter.apply(notifier);
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
