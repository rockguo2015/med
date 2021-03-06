package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.domain.RCWorkItemTask;
import com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy;
import com.fudanmed.platform.core.web.client.project.WorkItemFollowUpPresenterService;
import com.fudanmed.platform.core.web.server.service.project.WorkItemFollowUpDataValidator;
import com.fudanmed.platform.core.web.shared.project.WorkItemFollowUpData;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import com.uniquesoft.uidl.validation.Validates;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.project.WorkItemFollowUpPresenterService")
@Transactional
public class WorkItemFollowUpPresenterServiceImpl extends BaseService implements WorkItemFollowUpPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private WorkItemFollowUpDataValidator validator;
  
  public void commit(final RCWorkItemTaskProxy context, final WorkItemFollowUpData data) throws SessionTimeOutException, ValidationException {
    Validates.<WorkItemFollowUpData>validateWith(data, this.validator);
    RCWorkItemTask _resolved= null;
    if(context!=null) _resolved=(com.fudanmed.platform.core.domain.RCWorkItemTask)com.uniquesoft.uidl.extensions.ModelObjects.resolve(context, entities);
    
    final RCWorkItemTask value =  _resolved;
    String _comment = data.getComment();
    value.setComment(_comment);
    value.followup();
  }
  
  public String getComment(final RCWorkItemTaskProxy context) throws SessionTimeOutException, ValidationException {
    RCWorkItemTask _resolved= null;
    if(context!=null) _resolved=(com.fudanmed.platform.core.domain.RCWorkItemTask)com.uniquesoft.uidl.extensions.ModelObjects.resolve(context, entities);
    
    String _comment =  _resolved.getComment();
    return _comment;
  }
}
