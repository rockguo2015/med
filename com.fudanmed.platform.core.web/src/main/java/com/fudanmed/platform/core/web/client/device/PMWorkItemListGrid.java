package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy;
import com.fudanmed.platform.core.domain.proxy.RCSupplierProxy;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItem;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItemStatue;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.grid.GXTGridComponent;
import edu.fudan.langlab.gxt.client.component.grid.factory.DateValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DateValueProviderFactory.DateColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectSelectorFactory.StringValueColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory.StringColumn;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class PMWorkItemListGrid extends GXTGridComponent<UIPMWorkItem> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringColumn<UIPMWorkItem> sid;
  
  public StringColumn<UIPMWorkItem> title;
  
  public DateColumn<UIPMWorkItem> assignDate;
  
  public StringValueColumn<UIPMWorkItem,RCSupplierProxy> supplier;
  
  public StringValueColumn<UIPMWorkItem,RCMaintenanceTeamProxy> team;
  
  public StringValueColumn<UIPMWorkItem,UIPMWorkItemStatue> status;
  
  public DateColumn<UIPMWorkItem> finishDate;
  
  public StringColumn<UIPMWorkItem> teamComment;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  private UIPMWorkItem value = new UIPMWorkItem();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();sid = stringValueProviderFactory.createAsStringColumn("sid","任务单号",UIPMWorkItem.SidAccessor);
    widgetsRegistory.put("sid",sid);
    title = stringValueProviderFactory.createAsStringColumn("title","名称",UIPMWorkItem.TitleAccessor);
    widgetsRegistory.put("title",title);
    assignDate = dateValueProviderFactory.createAsStringColumn("assignDate","安排执行日期",UIPMWorkItem.AssignDateAccessor);
    widgetsRegistory.put("assignDate",assignDate);
    supplier = defaultObjectSelectorFactory.createAsDefaultColumn("supplier","服务提供商",UIPMWorkItem.SupplierAccessor,Integer.valueOf(150));
    widgetsRegistory.put("supplier",supplier);
    team = defaultObjectSelectorFactory.createAsDefaultColumn("team","配合班组",UIPMWorkItem.TeamAccessor);
    widgetsRegistory.put("team",team);
    status = defaultObjectSelectorFactory.createAsDefaultColumn("status","状态",UIPMWorkItem.StatusAccessor);
    widgetsRegistory.put("status",status);
    finishDate = dateValueProviderFactory.createAsStringColumn("finishDate","完工日期",UIPMWorkItem.FinishDateAccessor);
    widgetsRegistory.put("finishDate",finishDate);
    teamComment = stringValueProviderFactory.createAsStringColumn("teamComment","班组上报信息",UIPMWorkItem.TeamCommentAccessor,Integer.valueOf(300));
    widgetsRegistory.put("teamComment",teamComment);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIPMWorkItem getValueAsNew() {
    UIPMWorkItem value = new UIPMWorkItem();
    value.setSid(sid.getValue());
    value.setTitle(title.getValue());
    value.setAssignDate(assignDate.getValue());
    value.setSupplier(supplier.getValue());
    value.setTeam(team.getValue());
    value.setStatus(status.getValue());
    value.setFinishDate(finishDate.getValue());
    value.setTeamComment(teamComment.getValue());
    return value;
  }
  
  public UIPMWorkItem doGetValue() {
    
    value.setSid(sid.getValue());
    value.setTitle(title.getValue());
    value.setAssignDate(assignDate.getValue());
    value.setSupplier(supplier.getValue());
    value.setTeam(team.getValue());
    value.setStatus(status.getValue());
    value.setFinishDate(finishDate.getValue());
    value.setTeamComment(teamComment.getValue());
    return value;
  }
  
  public UIPMWorkItem getValue(final UIPMWorkItem copyValue) {
    
    copyValue.setSid(sid.getValue());
    copyValue.setTitle(title.getValue());
    copyValue.setAssignDate(assignDate.getValue());
    copyValue.setSupplier(supplier.getValue());
    copyValue.setTeam(team.getValue());
    copyValue.setStatus(status.getValue());
    copyValue.setFinishDate(finishDate.getValue());
    copyValue.setTeamComment(teamComment.getValue());
    return copyValue;
  }
  
  protected PMWorkItemListGrid doSetValue(final UIPMWorkItem value) {
    this.value = value;
    sid.setValue(value.getSid());
    title.setValue(value.getTitle());
    assignDate.setValue(value.getAssignDate());
    supplier.setValue(value.getSupplier());
    team.setValue(value.getTeam());
    status.setValue(value.getStatus());
    finishDate.setValue(value.getFinishDate());
    teamComment.setValue(value.getTeamComment());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)sid,(ICanAsWidget)title,(ICanAsWidget)assignDate,(ICanAsWidget)supplier,(ICanAsWidget)team,(ICanAsWidget)status,(ICanAsWidget)finishDate,(ICanAsWidget)teamComment
    					);
  }
  
  public void initializeComponent() {
    this.asWidget();
    this.unForceFit();
  }
}
