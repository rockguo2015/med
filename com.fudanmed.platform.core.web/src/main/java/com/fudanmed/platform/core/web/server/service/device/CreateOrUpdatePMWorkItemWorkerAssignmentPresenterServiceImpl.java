package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.device.pm.RCPMWorkItem;
import com.fudanmed.platform.core.device.pm.RCPMWorkItemWorkerAssignment;
import com.fudanmed.platform.core.device.pm.proxy.RCPMWorkItemProxy;
import com.fudanmed.platform.core.device.pm.proxy.RCPMWorkItemWorkerAssignmentProxy;
import com.fudanmed.platform.core.domain.RCMaintenanceTeam;
import com.fudanmed.platform.core.domain.RCOrganization;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.client.device.CreateOrUpdatePMWorkItemWorkerAssignmentPresenterService;
import com.fudanmed.platform.core.web.server.service.device.PMWorkItemWorkerAssignmentMapper;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItemWorkerAssignment;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.device.CreateOrUpdatePMWorkItemWorkerAssignmentPresenterService")
@Transactional
public class CreateOrUpdatePMWorkItemWorkerAssignmentPresenterServiceImpl extends BaseService implements CreateOrUpdatePMWorkItemWorkerAssignmentPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private PMWorkItemWorkerAssignmentMapper mapper;
  
  public UIPMWorkItemWorkerAssignment loadValue(final RCPMWorkItemWorkerAssignmentProxy pvalue) throws SessionTimeOutException, ValidationException {
    RCPMWorkItemWorkerAssignment _resolved= null;
    if(pvalue!=null) _resolved=(com.fudanmed.platform.core.device.pm.RCPMWorkItemWorkerAssignment)com.uniquesoft.uidl.extensions.ModelObjects.resolve(pvalue, entities);
    
    UIPMWorkItemWorkerAssignment _transform = this.mapper.transform( _resolved);
    return _transform;
  }
  
  public void updateValue(final UIPMWorkItemWorkerAssignment uivalue) throws SessionTimeOutException, ValidationException {
    RCPMWorkItemWorkerAssignment _resolved= null;
    if(uivalue!=null) _resolved=(com.fudanmed.platform.core.device.pm.RCPMWorkItemWorkerAssignment)com.uniquesoft.uidl.extensions.ModelObjects.resolve(uivalue, entities);
    
    this.mapper.transform(uivalue,  _resolved);
  }
  
  public void createValue(final RCPMWorkItemProxy parent, final UIPMWorkItemWorkerAssignment uivalue) throws SessionTimeOutException, ValidationException {
    RCPMWorkItem _resolved= null;
    if(parent!=null) _resolved=(com.fudanmed.platform.core.device.pm.RCPMWorkItem)com.uniquesoft.uidl.extensions.ModelObjects.resolve(parent, entities);
    
    final Procedure1<RCPMWorkItemWorkerAssignment> _function = new Procedure1<RCPMWorkItemWorkerAssignment>() {
        public void apply(final RCPMWorkItemWorkerAssignment it) {
          CreateOrUpdatePMWorkItemWorkerAssignmentPresenterServiceImpl.this.mapper.transform(uivalue, it);
        }
      };
     _resolved.assignWorker(_function);
  }
  
  public RCOrganizationProxy loadTeamOrg4WorkItem(final RCPMWorkItemProxy value) throws SessionTimeOutException, ValidationException {
    RCPMWorkItem _resolved= null;
    if(value!=null) _resolved=(com.fudanmed.platform.core.device.pm.RCPMWorkItem)com.uniquesoft.uidl.extensions.ModelObjects.resolve(value, entities);
    
    RCMaintenanceTeam _team =  _resolved.getTeam();
    RCOrganization _organization = _team.getOrganization();
    RCOrganizationProxy _proxy = _organization.toProxy();
    return _proxy;
  }
  
  public RCOrganizationProxy loadTeamOrg4Assignment(final RCPMWorkItemWorkerAssignmentProxy value) throws SessionTimeOutException, ValidationException {
    RCPMWorkItemWorkerAssignment _resolved= null;
    if(value!=null) _resolved=(com.fudanmed.platform.core.device.pm.RCPMWorkItemWorkerAssignment)com.uniquesoft.uidl.extensions.ModelObjects.resolve(value, entities);
    
    RCPMWorkItem _workitem =  _resolved.getWorkitem();
    RCMaintenanceTeam _team = _workitem.getTeam();
    RCOrganization _organization = _team.getOrganization();
    RCOrganizationProxy _proxy = _organization.toProxy();
    return _proxy;
  }
}
