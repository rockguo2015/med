package com.fudanmed.platform.core.web.client.project;

import java.util.Map;

import com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatisticData;
import com.fudanmed.platform.core.web.shared.project.UIWorkItemStockRecordStatisticsData;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.widget.core.client.grid.SummaryRenderer;

public class WorkItemStockRecordCountRender implements SummaryRenderer<UIWorkItemStockRecordStatisticsData> {

	@Override
	public SafeHtml render(
			Number value,
			Map<ValueProvider<? super UIWorkItemStockRecordStatisticsData, ?>, Number> data) {
		if(value!=null)
			return SafeHtmlUtils.fromTrustedString("小计："+value.toString()+"条");
		else return SafeHtmlUtils.fromTrustedString("");
	}

}
