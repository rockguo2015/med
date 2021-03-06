package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy;
import com.fudanmed.platform.core.web.shared.project.WorkItemCancelPendData;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface WorkItemCancelPendPresenterServiceAsync {
  public abstract void commit(final RCWorkItemTaskProxy context, final WorkItemCancelPendData data, final AsyncCallback<Void> callback);
  
  public abstract void getComment(final RCWorkItemTaskProxy context, final AsyncCallback<String> callback);
  
  public abstract void canReport(final RCWorkItemTaskProxy context, final AsyncCallback<Boolean> callback);
}
