package com.fudanmed.platform.core.web.shared.device;

import com.uniquesoft.gwt.shared.datatype.IUIDLEnum;

public enum UIPMWorkItemStatue implements IUIDLEnum<UIPMWorkItemStatue> {
  executing,

  finished,

  planed,

  teamAssigned,

  teamFinished;
  
  public String toString() {
    switch(this){
    case planed:
    	return "新建";
    case executing:
    	return "执行中";
    case teamAssigned:
    	return "已派发";
    case teamFinished:
    	return "待结单";
    case finished:
    	return "已结单";
    	default:
    		return name();
    }
  }
  
  public UIPMWorkItemStatue fromString(final String value) {
    if( "新建".equals(value))
    	return planed;
    if( "执行中".equals(value))
    	return executing;
    if( "已派发".equals(value))
    	return teamAssigned;
    if( "待结单".equals(value))
    	return teamFinished;
    if( "已结单".equals(value))
    	return finished;
    	return null;			
    
  }
}
