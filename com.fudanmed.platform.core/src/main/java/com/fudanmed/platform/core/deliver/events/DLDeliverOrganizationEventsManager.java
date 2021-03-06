package com.fudanmed.platform.core.deliver.events;

import com.fudanmed.platform.core.deliver.DLDeliverOrganization;
import com.fudanmed.platform.core.deliver.events.DLDeliverOrganizationEventsListener;
import edu.fudan.mylang.pf.event.EntityEventsManager;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.deliver.events.DLDeliverOrganizationEventsManager")
public class DLDeliverOrganizationEventsManager extends EntityEventsManager<DLDeliverOrganization> {
  @Autowired(required = false)
  private Collection<DLDeliverOrganizationEventsListener> listeners = com.google.common.collect.Lists.newArrayList();;
  
  protected Collection<DLDeliverOrganizationEventsListener> getListeners() {
    return listeners;
  }
}
