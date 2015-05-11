package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.entityextension.proxy.RCAttributeSlotProxy;
import com.fudanmed.platform.core.entityextension.proxy.RCExtensiableEntityProxy;
import com.fudanmed.platform.core.web.shared.device.UIAttributeSlot;
import com.fudanmed.platform.core.web.shared.device.UICompositeAttribute;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CreateCompositeTypePresenterServiceAsync {
  public abstract void loadSlotName(final RCAttributeSlotProxy slot, final AsyncCallback<String> callback);
  
  public abstract void createExtensiableEntityAttribute(final RCExtensiableEntityProxy ee, final UICompositeAttribute attribute, final AsyncCallback<UIAttributeSlot> callback);
  
  public abstract void createCompositeSlotAttribute(final RCAttributeSlotProxy slot, final UICompositeAttribute attribute, final AsyncCallback<UIAttributeSlot> callback);
}
