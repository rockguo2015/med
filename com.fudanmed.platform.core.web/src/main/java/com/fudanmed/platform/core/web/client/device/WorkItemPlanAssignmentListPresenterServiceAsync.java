package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCPMWorkItemProxy;
import com.fudanmed.platform.core.web.shared.device.UIWorkItemPlanAssignment;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface WorkItemPlanAssignmentListPresenterServiceAsync {
  public abstract void loadWorkItemPlanAssignmentList(final RCPMWorkItemProxy context, final AsyncCallback<Collection<UIWorkItemPlanAssignment>> callback);
}
