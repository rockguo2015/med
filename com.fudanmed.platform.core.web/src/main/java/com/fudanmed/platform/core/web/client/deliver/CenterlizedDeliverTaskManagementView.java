package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.client.deliver.CenterlizedDeliverTaskDispatchCommand;
import com.fudanmed.platform.core.web.client.deliver.CenterlizedDeliverTaskManagementPresenterView;
import com.fudanmed.platform.core.web.client.deliver.CenterlizedDeliverTaskQueryListPresenter;
import com.fudanmed.platform.core.web.client.deliver.CenterlizedDeliverTaskQueryListPresenterView;
import com.fudanmed.platform.core.web.client.deliver.CreateCenterlizedDeliverTaskCommand;
import com.fudanmed.platform.core.web.shared.deliver.UICenterlizedDeliverTask;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.common.client.widget.GWTAbstractView;
import edu.fudan.langlab.gxt.client.widget.FramedPanel;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.security.client.Securities;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class CenterlizedDeliverTaskManagementView extends GWTAbstractView implements CenterlizedDeliverTaskManagementPresenterView {
  @Inject
  private IWidgetFactory widgets;
  
  public void initialize(final IPostInitializeAction postInitialize) {
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(
    	com.google.common.collect.Lists.newArrayList(centerlizedDeliverTaskDispatchCommand,createCenterlizedDeliverTaskCommand),
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
  
  private CenterlizedDeliverTaskQueryListPresenter queryListPresenter;
  
  public void setQueryListPresenter(final CenterlizedDeliverTaskQueryListPresenter queryListPresenter) {
    this.queryListPresenter = queryListPresenter;
  }
  
  private Widget con;
  
  @Inject
  private CenterlizedDeliverTaskDispatchCommand centerlizedDeliverTaskDispatchCommand;
  
  @Inject
  private CreateCenterlizedDeliverTaskCommand createCenterlizedDeliverTaskCommand;
  
  public Widget asWidget() {
    return this.con;
  }
  
  public void initialize() {
    
    CenterlizedDeliverTaskQueryListPresenterView _view = this.queryListPresenter.getView();
    final ActionContext<UICenterlizedDeliverTask> ac = _view.getActionContext();
    FramedPanel _FramedPanel = this.widgets.FramedPanel("\u4E2D\u592E\u8FD0\u9001\u7BA1\u7406");
    final Procedure1<FramedPanel> _function = new Procedure1<FramedPanel>() {
        public void apply(final FramedPanel it) {
          CenterlizedDeliverTaskQueryListPresenterView _view = CenterlizedDeliverTaskManagementView.this.queryListPresenter.getView();
          Widget _asWidget = _view.asWidget();
          it.setWidget(_asWidget);
          it.addCommand(ac, CenterlizedDeliverTaskManagementView.this.centerlizedDeliverTaskDispatchCommand);
          it.addCommand(CenterlizedDeliverTaskManagementView.this.createCenterlizedDeliverTaskCommand);
        }
      };
    FramedPanel _doubleArrow = ObjectExtensions.<FramedPanel>operator_doubleArrow(_FramedPanel, _function);
    this.con = _doubleArrow;
  }
}
