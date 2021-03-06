package com.fudanmed.platform.core.web.shared.warehouse;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import com.uniquesoft.gwt.shared.common.pager.IPagedCriteria;
import java.util.Date;

public class UIInStockRecordCriteria implements IsSerializable, IPagedCriteria {
  private String sid;
  
  public String getSid() {
    return this.sid;
  }
  
  public void setSid(final String sid) {
    this.sid = sid;
  }
  
  public final static String P_Sid = "sid";
  
  public static IObjectFieldAccessor<UIInStockRecordCriteria,String> SidAccessor = new IObjectFieldAccessor<UIInStockRecordCriteria,String>(){
    				public String getValue(UIInStockRecordCriteria object){
    					return object.getSid();
    				}
    				public void setValue(UIInStockRecordCriteria object,String value){
    					object.setSid(value);
    				}
    			};
  
  private Date dateFrom;
  
  public Date getDateFrom() {
    return this.dateFrom;
  }
  
  public void setDateFrom(final Date dateFrom) {
    this.dateFrom = dateFrom;
  }
  
  public final static String P_DateFrom = "dateFrom";
  
  public static IObjectFieldAccessor<UIInStockRecordCriteria,Date> DateFromAccessor = new IObjectFieldAccessor<UIInStockRecordCriteria,Date>(){
    				public java.util.Date getValue(UIInStockRecordCriteria object){
    					return object.getDateFrom();
    				}
    				public void setValue(UIInStockRecordCriteria object,java.util.Date value){
    					object.setDateFrom(value);
    				}
    			};
  
  private Date dateTo;
  
  public Date getDateTo() {
    return this.dateTo;
  }
  
  public void setDateTo(final Date dateTo) {
    this.dateTo = dateTo;
  }
  
  public final static String P_DateTo = "dateTo";
  
  public static IObjectFieldAccessor<UIInStockRecordCriteria,Date> DateToAccessor = new IObjectFieldAccessor<UIInStockRecordCriteria,Date>(){
    				public java.util.Date getValue(UIInStockRecordCriteria object){
    					return object.getDateTo();
    				}
    				public void setValue(UIInStockRecordCriteria object,java.util.Date value){
    					object.setDateTo(value);
    				}
    			};
  
  private Integer page;
  
  public Integer getPage() {
    return this.page;
  }
  
  public void setPage(final Integer page) {
    this.page = page;
  }
  
  private Integer pageSize;
  
  public Integer getPageSize() {
    return this.pageSize;
  }
  
  public void setPageSize(final Integer pageSize) {
    this.pageSize = pageSize;
  }
}
