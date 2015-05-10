package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy;
import com.fudanmed.platform.core.web.shared.project.WorkItemOutsourceData;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.project.WorkItemOutsourcePresenterService")
public interface WorkItemOutsourcePresenterService extends RemoteService {
  public abstract void commit(final RCWorkItemTaskProxy context, final WorkItemOutsourceData data) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract String getComment(final RCWorkItemTaskProxy context) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
