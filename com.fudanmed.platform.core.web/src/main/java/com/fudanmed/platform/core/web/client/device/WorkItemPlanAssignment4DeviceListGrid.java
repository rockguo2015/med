package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCDevicePMTypeProxy;
import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy;
import com.fudanmed.platform.core.web.shared.device.UIDevicePMPlanStatus;
import com.fudanmed.platform.core.web.shared.device.UIWorkItemPlanAssignment;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.grid.GXTGridComponent;
import edu.fudan.langlab.gxt.client.component.grid.factory.DateValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DateValueProviderFactory.DateColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectSelectorFactory.StringValueColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectsSelectorFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectsSelectorFactory.CollectionListColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.IntegerValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.IntegerValueProviderFactory.IntegerColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory.StringColumn;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class WorkItemPlanAssignment4DeviceListGrid extends GXTGridComponent<UIWorkItemPlanAssignment> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringValueColumn<UIWorkItemPlanAssignment,RCDevicePMTypeProxy> pmType;
  
  public IntegerColumn<UIWorkItemPlanAssignment> intervalInDays;
  
  public DateColumn<UIWorkItemPlanAssignment> planDate;
  
  public StringValueColumn<UIWorkItemPlanAssignment,UIDevicePMPlanStatus> smstatus;
  
  public DateColumn<UIWorkItemPlanAssignment> finishDate;
  
  public StringValueColumn<UIWorkItemPlanAssignment,RCMaintenanceTeamProxy> team;
  
  public CollectionListColumn<UIWorkItemPlanAssignment,RCEmployeeProxy> workers;
  
  public StringColumn<UIWorkItemPlanAssignment> pmComment;
  
  public StringColumn<UIWorkItemPlanAssignment> comment;
  
  @Inject
  private IntegerValueProviderFactory integerValueProviderFactory;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private DefaultObjectsSelectorFactory defaultObjectsSelectorFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIWorkItemPlanAssignment value = new UIWorkItemPlanAssignment();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();pmType = defaultObjectSelectorFactory.createAsDefaultColumn("pmType","维保类别",UIWorkItemPlanAssignment.PmTypeAccessor);
    widgetsRegistory.put("pmType",pmType);
    intervalInDays = integerValueProviderFactory.createAsIntegerColumn("intervalInDays","维保周期(天)",UIWorkItemPlanAssignment.IntervalInDaysAccessor);
    widgetsRegistory.put("intervalInDays",intervalInDays);
    planDate = dateValueProviderFactory.createAsStringColumn("planDate","PM计划日期",UIWorkItemPlanAssignment.PlanDateAccessor);
    widgetsRegistory.put("planDate",planDate);
    smstatus = defaultObjectSelectorFactory.createAsDefaultColumn("smstatus","状态",UIWorkItemPlanAssignment.SmstatusAccessor);
    widgetsRegistory.put("smstatus",smstatus);
    finishDate = dateValueProviderFactory.createAsStringColumn("finishDate","完成日期",UIWorkItemPlanAssignment.FinishDateAccessor);
    widgetsRegistory.put("finishDate",finishDate);
    team = defaultObjectSelectorFactory.createAsDefaultColumn("team","检修班组",UIWorkItemPlanAssignment.TeamAccessor);
    widgetsRegistory.put("team",team);
    workers = defaultObjectsSelectorFactory.createAsStringColumn("workers","检修人",UIWorkItemPlanAssignment.WorkersAccessor);
    widgetsRegistory.put("workers",workers);
    pmComment = stringValueProviderFactory.createAsStringColumn("pmComment","维保内容",UIWorkItemPlanAssignment.PmCommentAccessor);
    widgetsRegistory.put("pmComment",pmComment);
    comment = stringValueProviderFactory.createAsStringColumn("comment","维保记录",UIWorkItemPlanAssignment.CommentAccessor);
    widgetsRegistory.put("comment",comment);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIWorkItemPlanAssignment getValueAsNew() {
    UIWorkItemPlanAssignment value = new UIWorkItemPlanAssignment();
    value.setPmType(pmType.getValue());
    value.setIntervalInDays(intervalInDays.getValue());
    value.setPlanDate(planDate.getValue());
    value.setSmstatus(smstatus.getValue());
    value.setFinishDate(finishDate.getValue());
    value.setTeam(team.getValue());
    value.setWorkers(workers.getValue());
    value.setPmComment(pmComment.getValue());
    value.setComment(comment.getValue());
    return value;
  }
  
  public UIWorkItemPlanAssignment doGetValue() {
    
    value.setPmType(pmType.getValue());
    value.setIntervalInDays(intervalInDays.getValue());
    value.setPlanDate(planDate.getValue());
    value.setSmstatus(smstatus.getValue());
    value.setFinishDate(finishDate.getValue());
    value.setTeam(team.getValue());
    value.setWorkers(workers.getValue());
    value.setPmComment(pmComment.getValue());
    value.setComment(comment.getValue());
    return value;
  }
  
  public UIWorkItemPlanAssignment getValue(final UIWorkItemPlanAssignment copyValue) {
    
    copyValue.setPmType(pmType.getValue());
    copyValue.setIntervalInDays(intervalInDays.getValue());
    copyValue.setPlanDate(planDate.getValue());
    copyValue.setSmstatus(smstatus.getValue());
    copyValue.setFinishDate(finishDate.getValue());
    copyValue.setTeam(team.getValue());
    copyValue.setWorkers(workers.getValue());
    copyValue.setPmComment(pmComment.getValue());
    copyValue.setComment(comment.getValue());
    return copyValue;
  }
  
  protected WorkItemPlanAssignment4DeviceListGrid doSetValue(final UIWorkItemPlanAssignment value) {
    this.value = value;
    pmType.setValue(value.getPmType());
    intervalInDays.setValue(value.getIntervalInDays());
    planDate.setValue(value.getPlanDate());
    smstatus.setValue(value.getSmstatus());
    finishDate.setValue(value.getFinishDate());
    team.setValue(value.getTeam());
    workers.setValue(value.getWorkers());
    pmComment.setValue(value.getPmComment());
    comment.setValue(value.getComment());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)pmType,(ICanAsWidget)intervalInDays,(ICanAsWidget)planDate,(ICanAsWidget)smstatus,(ICanAsWidget)finishDate,(ICanAsWidget)team,(ICanAsWidget)workers,(ICanAsWidget)pmComment,(ICanAsWidget)comment
    					);
  }
  
  public void initializeComponent() {
    this.asWidget();
    this.unForceFit();
  }
}
