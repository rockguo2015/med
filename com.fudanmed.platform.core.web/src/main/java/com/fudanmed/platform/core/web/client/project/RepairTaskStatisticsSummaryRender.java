package com.fudanmed.platform.core.web.client.project;

import java.util.Map;

import com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatisticData;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.widget.core.client.grid.SummaryRenderer;

public class RepairTaskStatisticsSummaryRender implements SummaryRenderer<UIRepairTaskStatisticData> {

	@Override
	public SafeHtml render(
			Number value,
			Map<ValueProvider<? super UIRepairTaskStatisticData, ?>, Number> data) {
		if(value!=null)
			return SafeHtmlUtils.fromTrustedString(value.toString());
		else return SafeHtmlUtils.fromTrustedString("");
	}

}
