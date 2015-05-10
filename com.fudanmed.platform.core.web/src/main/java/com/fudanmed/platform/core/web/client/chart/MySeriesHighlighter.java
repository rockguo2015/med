package com.fudanmed.platform.core.web.client.chart;

import com.sencha.gxt.chart.client.chart.series.SeriesHighlighter;
import com.sencha.gxt.chart.client.draw.Color;
import com.sencha.gxt.chart.client.draw.RGB;
import com.sencha.gxt.chart.client.draw.sprite.RectangleSprite;
import com.sencha.gxt.chart.client.draw.sprite.Sprite;

@SuppressWarnings("all")
public class MySeriesHighlighter implements SeriesHighlighter {
  public void highlight(final Sprite sprite) {
    if ((sprite instanceof RectangleSprite)) {
      final RectangleSprite bar = ((RectangleSprite) sprite);
      RGB _rGB = new RGB(85, 85, 204);
      bar.setStroke(_rGB);
      bar.setStrokeWidth(3);
      RGB _rGB_1 = new RGB("#a2b5ca");
      bar.setFill(_rGB_1);
      bar.redraw();
    }
  }
  
  public void unHighlight(final Sprite sprite) {
    if ((sprite instanceof RectangleSprite)) {
      final RectangleSprite bar = ((RectangleSprite) sprite);
      bar.setStroke(Color.NONE);
      bar.setStrokeWidth(0);
      RGB _rGB = new RGB(148, 174, 10);
      bar.setFill(_rGB);
      bar.redraw();
    }
  }
}
