package com.fudanmed.platform.core.warehouse.events;

import com.fudanmed.platform.core.warehouse.RCWorkItemReturnStockRecord;
import com.fudanmed.platform.core.warehouse.events.RCWorkItemReturnStockRecordEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.warehouse.events.RCWorkItemReturnStockRecordEventsManager")
public class RCWorkItemReturnStockRecordEventsManager extends EntityEventsManager<RCWorkItemReturnStockRecord> {
  @Autowired(required = false)
  private Collection<RCWorkItemReturnStockRecordEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCWorkItemReturnStockRecordEventsListener> getListeners() {
    return listeners;
  }
}
