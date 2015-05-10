package com.fudanmed.platform.core.web.client.chart;

import com.google.common.base.Objects;
import com.sencha.gxt.chart.client.chart.Chart;
import com.sencha.gxt.chart.client.chart.Chart.Position;
import com.sencha.gxt.chart.client.chart.axis.CategoryAxis;
import com.sencha.gxt.chart.client.chart.axis.NumericAxis;
import com.sencha.gxt.chart.client.chart.series.BarSeries;
import com.sencha.gxt.chart.client.draw.Gradient;
import com.sencha.gxt.chart.client.draw.RGB;
import com.sencha.gxt.chart.client.draw.sprite.TextSprite;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ListStore;
import edu.fudan.langlab.gxt.client.component.KeyProvider;
import java.util.Collection;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class BarChart<T extends Object> {
  private String xTitle;
  
  private String yTitle;
  
  private Chart<T> chart = null;
  
  public BarChart(final String xTitle, final String yTitle) {
    this.xTitle = xTitle;
    this.yTitle = yTitle;
  }
  
  protected ListStore store = new Function0<ListStore>() {
    public ListStore apply() {
      KeyProvider<T> _keyProvider = new KeyProvider<T>();
      ListStore<T> _listStore = new ListStore<T>(_keyProvider);
      return _listStore;
    }
  }.apply();
  
  public void setObjects(final Collection<T> objects) {
    this.store.clear();
    this.store.addAll(objects);
    this.chart.redrawChart();
  }
  
  public Chart<T> asWidget() {
    boolean _notEquals = (!Objects.equal(this.chart, null));
    if (_notEquals) {
      return this.chart;
    }
    Chart<T> _chart = new Chart<T>();
    this.chart = _chart;
    this.chart.setStore(this.store);
    this.chart.setAnimated(true);
    Gradient _gradient = new Gradient("backgroundGradient", 0);
    final Gradient background = _gradient;
    RGB _rGB = new RGB("#ffffff");
    background.addStop(0, _rGB);
    RGB _rGB_1 = new RGB("#eaf1f8");
    background.addStop(100, _rGB_1);
    this.chart.addGradient(background);
    this.chart.setBackground(background);
    NumericAxis<T> _numericAxis = new NumericAxis<T>();
    final Procedure1<NumericAxis<T>> _function = new Procedure1<NumericAxis<T>>() {
        public void apply(final NumericAxis<T> it) {
          it.setPosition(Position.BOTTOM);
          List<ValueProvider<? super T,? extends Number>> _fields = it.getFields();
          _fields.add(BarChart.this.numberAxisProvider);
          TextSprite _textSprite = new TextSprite(BarChart.this.xTitle);
          it.setTitleConfig(_textSprite);
          it.setDisplayGrid(true);
          BarChart.this.chart.addAxis(it);
        }
      };
    ObjectExtensions.<NumericAxis<T>>operator_doubleArrow(_numericAxis, _function);
    CategoryAxis<T,String> _categoryAxis = new CategoryAxis<T,String>();
    final Procedure1<CategoryAxis<T,String>> _function_1 = new Procedure1<CategoryAxis<T,String>>() {
        public void apply(final CategoryAxis<T,String> it) {
          it.setPosition(Position.LEFT);
          it.setField(BarChart.this.categoryAxisProvider);
          TextSprite _textSprite = new TextSprite(BarChart.this.yTitle);
          it.setTitleConfig(_textSprite);
          BarChart.this.chart.addAxis(it);
        }
      };
    ObjectExtensions.<CategoryAxis<T,String>>operator_doubleArrow(_categoryAxis, _function_1);
    BarSeries<T> _barSeries = new BarSeries<T>();
    final Procedure1<BarSeries<T>> _function_2 = new Procedure1<BarSeries<T>>() {
        public void apply(final BarSeries<T> it) {
          it.setYAxisPosition(Position.BOTTOM);
          it.addYField(BarChart.this.numberAxisProvider);
          RGB _rGB = new RGB(148, 174, 10);
          it.addColor(_rGB);
          it.setHighlighting(true);
          BarChart.this.chart.addSeries(it);
        }
      };
    ObjectExtensions.<BarSeries<T>>operator_doubleArrow(_barSeries, _function_2);
    return this.chart;
  }
  
  private ValueProvider<T,String> categoryAxisProvider;
  
  private ValueProvider<T,? extends Number> numberAxisProvider;
  
  public ValueProvider<T,String> setCategoryAxisProvider(final ValueProvider<T,String> categoryAxisProvider) {
    ValueProvider<T,String> _categoryAxisProvider = this.categoryAxisProvider = categoryAxisProvider;
    return _categoryAxisProvider;
  }
  
  public ValueProvider<T,? extends Number> setNumberAxisProvider(final ValueProvider<T,? extends Number> numberAxisProvider) {
    ValueProvider<T,? extends Number> _numberAxisProvider = this.numberAxisProvider = numberAxisProvider;
    return _numberAxisProvider;
  }
}
