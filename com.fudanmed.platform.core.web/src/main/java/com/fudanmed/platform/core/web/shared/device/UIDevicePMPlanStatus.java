package com.fudanmed.platform.core.web.shared.device;

import com.uniquesoft.gwt.shared.datatype.IUIDLEnum;

public enum UIDevicePMPlanStatus implements IUIDLEnum<UIDevicePMPlanStatus> {
  assigned,

  finished,

  planed;
  
  public String toString() {
    switch(this){
    case assigned:
    	return "已派发";
    case planed:
    	return "待派发";
    case finished:
    	return "已完成";
    	default:
    		return name();
    }
  }
  
  public UIDevicePMPlanStatus fromString(final String value) {
    if( "已派发".equals(value))
    	return assigned;
    if( "待派发".equals(value))
    	return planed;
    if( "已完成".equals(value))
    	return finished;
    	return null;			
    
  }
}
