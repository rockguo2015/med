package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCPMWorkItemProxy;
import com.fudanmed.platform.core.device.pm.proxy.RCPMWorkItemWorkerAssignmentProxy;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItemWorkerAssignment;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.device.CreateOrUpdatePMWorkItemWorkerAssignmentPresenterService")
public interface CreateOrUpdatePMWorkItemWorkerAssignmentPresenterService extends RemoteService {
  public abstract UIPMWorkItemWorkerAssignment loadValue(final RCPMWorkItemWorkerAssignmentProxy pvalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void updateValue(final UIPMWorkItemWorkerAssignment uivalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void createValue(final RCPMWorkItemProxy parent, final UIPMWorkItemWorkerAssignment uivalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract RCOrganizationProxy loadTeamOrg4WorkItem(final RCPMWorkItemProxy value) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract RCOrganizationProxy loadTeamOrg4Assignment(final RCPMWorkItemWorkerAssignmentProxy value) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
