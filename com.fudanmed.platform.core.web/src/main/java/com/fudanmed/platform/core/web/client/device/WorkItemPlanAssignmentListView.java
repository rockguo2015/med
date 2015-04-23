package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.device.WorkItemPlanAssignmentListGrid;
import com.fudanmed.platform.core.web.client.device.WorkItemPlanAssignmentListPresenterView;
import com.fudanmed.platform.core.web.shared.device.UIWorkItemPlanAssignment;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.client.common.action.ActionExtensions;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.common.client.widget.GWTAbstractView;
import edu.fudan.langlab.gxt.client.component.grid.SGroupingGrid;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.security.client.Securities;
import java.util.Collection;
import java.util.List;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

public class WorkItemPlanAssignmentListView extends GWTAbstractView implements WorkItemPlanAssignmentListPresenterView {
  @Inject
  private IWidgetFactory widgets;
  
  public void initialize(final IPostInitializeAction postInitialize) {
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(
    	com.google.common.collect.Lists.newArrayList(listGrid),
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
  
  private Widget con;
  
  @Inject
  private WorkItemPlanAssignmentListGrid listGrid;
  
  public Widget asWidget() {
    return this.con;
  }
  
  public void initialize() {
    
    SGroupingGrid<UIWorkItemPlanAssignment> _asWidget = this.listGrid.asWidget();
    this.con = _asWidget;
  }
  
  public ActionContext<UIWorkItemPlanAssignment> getActionContext() {
    ActionContext<UIWorkItemPlanAssignment> _createActionContext = ActionExtensions.<UIWorkItemPlanAssignment>createActionContext(this.listGrid);
    return _createActionContext;
  }
  
  public Collection<UIWorkItemPlanAssignment> getSelectedValues() {
    Iterable<UIWorkItemPlanAssignment> _selectedObjects = this.listGrid.getSelectedObjects();
    List<UIWorkItemPlanAssignment> _list = IterableExtensions.<UIWorkItemPlanAssignment>toList(_selectedObjects);
    return _list;
  }
  
  public void setResults(final Collection<UIWorkItemPlanAssignment> results) {
    
    this.listGrid.setObjects(results);
  }
}
