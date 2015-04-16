package com.fudanmed.platform.core.web.shared.device;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

public class BatchInitializePMPlanData implements IsSerializable {
  private Integer year;
  
  public Integer getYear() {
    return this.year;
  }
  
  public void setYear(final Integer year) {
    this.year = year;
  }
  
  public final static String P_Year = "year";
  
  public static IObjectFieldAccessor<BatchInitializePMPlanData,Integer> YearAccessor = new IObjectFieldAccessor<BatchInitializePMPlanData,Integer>(){
    				public Integer getValue(BatchInitializePMPlanData object){
    					return object.getYear();
    				}
    				public void setValue(BatchInitializePMPlanData object,Integer value){
    					object.setYear(value);
    				}
    			};
}
