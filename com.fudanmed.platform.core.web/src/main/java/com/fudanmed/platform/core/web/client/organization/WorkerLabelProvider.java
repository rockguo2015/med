package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.web.shared.project.UIWorker;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ILabelProvider;

public class WorkerLabelProvider implements ILabelProvider<UIWorker> {

	@Override
	public String getLabel(UIWorker value) {
		return value.getName() + '[' + (value.getCardNumber() == null ? "" : value
				.getCardNumber()) + ']' +(value.getIsBusy()?"*":"");
	}

}
