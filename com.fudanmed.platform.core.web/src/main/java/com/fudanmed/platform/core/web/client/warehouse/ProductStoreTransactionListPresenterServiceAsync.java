package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCProductStorageProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCProductWarehouseStorageSummaryProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductStoreTransaction;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface ProductStoreTransactionListPresenterServiceAsync {
  public abstract void loadProductStoreTransactionList(final RCProductStorageProxy context, final AsyncCallback<Collection<UIProductStoreTransaction>> callback);
  
  public abstract void loadProductStoreTransactionList4Summary(final RCProductWarehouseStorageSummaryProxy context, final AsyncCallback<Collection<UIProductStoreTransaction>> callback);
}
