package com.fudanmed.platform.core.web.client.chart;

import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

import com.sencha.gxt.chart.client.chart.event.SeriesSelectionEvent;
import com.sencha.gxt.chart.client.chart.event.SeriesSelectionEvent.SeriesSelectionHandler;

class TSeriesSelectionHandler<T> implements SeriesSelectionHandler<T> {
	Procedure1<? super T> listener;

	public TSeriesSelectionHandler(final Procedure1<? super T> listener) {
		this.listener = listener;
	}

	@Override
	public void onSeriesSelection(SeriesSelectionEvent<T> event) {
		listener.apply(event.getItem());

	}

}