package com.fudanmed.platform.core.warehouse.events;

import com.fudanmed.platform.core.warehouse.RCProductSpecification;
import com.fudanmed.platform.core.warehouse.events.RCProductSpecificationEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.warehouse.events.RCProductSpecificationEventsManager")
public class RCProductSpecificationEventsManager extends EntityEventsManager<RCProductSpecification> {
  @Autowired(required = false)
  private Collection<RCProductSpecificationEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<RCProductSpecificationEventsListener> getListeners() {
    return listeners;
  }
}
