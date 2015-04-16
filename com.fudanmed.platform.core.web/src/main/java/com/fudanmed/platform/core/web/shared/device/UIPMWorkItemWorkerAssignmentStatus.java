package com.fudanmed.platform.core.web.shared.device;

import com.uniquesoft.gwt.shared.datatype.IUIDLEnum;

public enum UIPMWorkItemWorkerAssignmentStatus implements IUIDLEnum<UIPMWorkItemWorkerAssignmentStatus> {
  finished,

  pending,

  planed;
  
  public String toString() {
    switch(this){
    case finished:
    	return "已完成";
    case pending:
    	return "挂起";
    case planed:
    	return "新建";
    	default:
    		return name();
    }
  }
  
  public UIPMWorkItemWorkerAssignmentStatus fromString(final String value) {
    if( "已完成".equals(value))
    	return finished;
    if( "挂起".equals(value))
    	return pending;
    if( "新建".equals(value))
    	return planed;
    	return null;			
    
  }
}
