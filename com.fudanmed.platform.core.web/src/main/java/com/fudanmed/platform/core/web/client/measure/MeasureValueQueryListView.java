package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCMeasureDeviceProxy;
import com.fudanmed.platform.core.measure.proxy.RCMeasureDeviceTypeProxy;
import com.fudanmed.platform.core.web.client.measure.MeasureValueCriteriaForm;
import com.fudanmed.platform.core.web.client.measure.MeasureValueListGrid;
import com.fudanmed.platform.core.web.client.measure.MeasureValueQueryListPresenterView;
import com.fudanmed.platform.core.web.shared.measure.UIMeasureValue;
import com.fudanmed.platform.core.web.shared.measure.UIMeasureValueCriteria;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.uniquesoft.gwt.client.ClientUi;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.client.common.action.ActionExtensions;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.pager.Extensions;
import com.uniquesoft.gwt.client.common.widgets.pager.IPager;
import com.uniquesoft.gwt.client.common.widgets.pager.IPager.GotoPageHandler;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import edu.fudan.langlab.common.client.widget.GWTAbstractView;
import edu.fudan.langlab.gxt.client.component.grid.SGroupingGrid;
import edu.fudan.langlab.gxt.client.widget.HTMLTagsExt;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTD;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTR;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTable;
import edu.fudan.langlab.security.client.Securities;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;

public class MeasureValueQueryListView extends GWTAbstractView implements MeasureValueQueryListPresenterView {
  @Inject
  private IWidgetFactory widgets;
  
  public void initialize(final IPostInitializeAction postInitialize) {
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(
    	com.google.common.collect.Lists.newArrayList(listGrid,criteriaForm),
    	new com.uniquesoft.gwt.client.common.async.IPostInitializeAction(){
    
    	public void initializeFinished(Void v) {
    		initialize();
    		postInitialize.initializeFinished(null);
    	}
    });
    
  }
  
  @Inject
  private Securities securities;
  
  @Inject
  private EventBus eventBus;
  
  @Inject
  private MeasureValueListGrid listGrid;
  
  @Inject
  private MeasureValueCriteriaForm criteriaForm;
  
  private IPager pager;
  
  private Widget con;
  
  public Widget asWidget() {
    return this.con;
  }
  
  public void initialize() {
    
    this.listGrid.asWidget();
    VerticalLayoutContainer _VLayout = this.widgets.VLayout();
    final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
        public void apply(final VerticalLayoutContainer it) {
          PlainHTMLTable _TABLE = HTMLTagsExt.TABLE();
          final Procedure1<PlainHTMLTable> _function = new Procedure1<PlainHTMLTable>() {
              public void apply(final PlainHTMLTable it) {
                PlainHTMLTR _tr = HTMLTagsExt.tr(it);
                final Procedure1<PlainHTMLTR> _function = new Procedure1<PlainHTMLTR>() {
                    public void apply(final PlainHTMLTR it) {
                      PlainHTMLTD _td = HTMLTagsExt.td(it);
                      final Procedure1<PlainHTMLTD> _function = new Procedure1<PlainHTMLTD>() {
                          public void apply(final PlainHTMLTD it) {
                            FieldLabel _asWidget = MeasureValueQueryListView.this.criteriaForm.measureDateFrom.asWidget();
                            ClientUi.operator_add(it, _asWidget);
                          }
                        };
                      ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                      PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                      final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
                          public void apply(final PlainHTMLTD it) {
                            FieldLabel _asWidget = MeasureValueQueryListView.this.criteriaForm.measureDateTo.asWidget();
                            ClientUi.operator_add(it, _asWidget);
                          }
                        };
                      ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_1, _function_1);
                      PlainHTMLTD _td_2 = HTMLTagsExt.td(it);
                      final Procedure1<PlainHTMLTD> _function_2 = new Procedure1<PlainHTMLTD>() {
                          public void apply(final PlainHTMLTD it) {
                            TextButton _TextButton = MeasureValueQueryListView.this.widgets.TextButton("\u67E5\u627E");
                            final Procedure1<TextButton> _function = new Procedure1<TextButton>() {
                                public void apply(final TextButton it) {
                                  it.setWidth("80px");
                                  final Procedure1<SelectEvent> _function = new Procedure1<SelectEvent>() {
                                      public void apply(final SelectEvent it) {
                                        UIMeasureValueCriteria _value = MeasureValueQueryListView.this.criteriaForm.getValue();
                                        UIMeasureValueCriteria _withPagerInfo = Extensions.<UIMeasureValueCriteria>withPagerInfo(_value, MeasureValueQueryListView.this.pager);
                                        final Procedure1<UIMeasureValueCriteria> _function = new Procedure1<UIMeasureValueCriteria>() {
                                            public void apply(final UIMeasureValueCriteria it) {
                                              it.setPage(Integer.valueOf(1));
                                            }
                                          };
                                        UIMeasureValueCriteria _doubleArrow = ObjectExtensions.<UIMeasureValueCriteria>operator_doubleArrow(_withPagerInfo, _function);
                                        filterRequestRequestHandler.execute(_doubleArrow);
                                        
                                      }
                                    };
                                  it.addSelectHandler(new SelectHandler() {
                                      public void onSelect(SelectEvent event) {
                                        _function.apply(event);
                                      }
                                  });
                                }
                              };
                            TextButton _doubleArrow = ObjectExtensions.<TextButton>operator_doubleArrow(_TextButton, _function);
                            ClientUi.operator_add(it, _doubleArrow);
                          }
                        };
                      ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_2, _function_2);
                    }
                  };
                ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr, _function);
              }
            };
          PlainHTMLTable _doubleArrow = ObjectExtensions.<PlainHTMLTable>operator_doubleArrow(_TABLE, _function);
          it.add(_doubleArrow);
          IPager<UIMeasureValue> _createPager = edu.fudan.langlab.gxt.client.pager.Extensions.<UIMeasureValue>createPager(MeasureValueQueryListView.this.listGrid);
          final Procedure1<IPager<UIMeasureValue>> _function_1 = new Procedure1<IPager<UIMeasureValue>>() {
              public void apply(final IPager<UIMeasureValue> it) {
                final Procedure2<Integer,Integer> _function = new Procedure2<Integer,Integer>() {
                    public void apply(final Integer pageNum, final Integer recordsPerPage) {
                      UIMeasureValueCriteria _value = MeasureValueQueryListView.this.criteriaForm.getValue();
                      UIMeasureValueCriteria _withPagerInfo = Extensions.<UIMeasureValueCriteria>withPagerInfo(_value, MeasureValueQueryListView.this.pager);
                      final Procedure1<UIMeasureValueCriteria> _function = new Procedure1<UIMeasureValueCriteria>() {
                          public void apply(final UIMeasureValueCriteria it) {
                            it.setPage(Integer.valueOf(pageNum));
                            it.setPageSize(Integer.valueOf(recordsPerPage));
                          }
                        };
                      UIMeasureValueCriteria _doubleArrow = ObjectExtensions.<UIMeasureValueCriteria>operator_doubleArrow(_withPagerInfo, _function);
                      filterRequestRequestHandler.execute(_doubleArrow);
                      
                    }
                  };
                it.setPagerHandler(new GotoPageHandler() {
                    public void gotoPage(int pageNum,int recordsPerPage) {
                      _function.apply(pageNum,recordsPerPage);
                    }
                });
              }
            };
          IPager<UIMeasureValue> _doubleArrow_1 = ObjectExtensions.<IPager<UIMeasureValue>>operator_doubleArrow(_createPager, _function_1);
          MeasureValueQueryListView.this.pager = _doubleArrow_1;
          SGroupingGrid<UIMeasureValue> _asWidget = MeasureValueQueryListView.this.listGrid.asWidget();
          VerticalLayoutData _VLayoutData = MeasureValueQueryListView.this.widgets.VLayoutData(1, 1);
          it.add(_asWidget, _VLayoutData);
          Widget _asWidget_1 = MeasureValueQueryListView.this.pager.asWidget();
          it.add(_asWidget_1);
        }
      };
    VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
    this.con = _doubleArrow;
  }
  
  public void showResults(final IPagedResult<UIMeasureValue> results) {
    this.pager.pageLoaded(results);
  }
  
  public void refresh() {
    int _activePage = this.pager.getActivePage();
    this.pager.gotoPage(_activePage);
  }
  
  public void setMeasureDevice(final RCMeasureDeviceProxy device) {
    this.criteriaForm.device.setValue(device);
    UIMeasureValueCriteria _value = this.criteriaForm.getValue();
    UIMeasureValueCriteria _withPagerInfo = Extensions.<UIMeasureValueCriteria>withPagerInfo(_value, this.pager);
    final Procedure1<UIMeasureValueCriteria> _function = new Procedure1<UIMeasureValueCriteria>() {
        public void apply(final UIMeasureValueCriteria it) {
          it.setPage(Integer.valueOf(1));
        }
      };
    UIMeasureValueCriteria _doubleArrow = ObjectExtensions.<UIMeasureValueCriteria>operator_doubleArrow(_withPagerInfo, _function);
    filterRequestRequestHandler.execute(_doubleArrow);
    
  }
  
  public void setMeasureDeviceType(final RCMeasureDeviceTypeProxy deviceType) {
    this.criteriaForm.deviceType.setValue(deviceType);
    UIMeasureValueCriteria _value = this.criteriaForm.getValue();
    UIMeasureValueCriteria _withPagerInfo = Extensions.<UIMeasureValueCriteria>withPagerInfo(_value, this.pager);
    final Procedure1<UIMeasureValueCriteria> _function = new Procedure1<UIMeasureValueCriteria>() {
        public void apply(final UIMeasureValueCriteria it) {
          it.setPage(Integer.valueOf(1));
        }
      };
    UIMeasureValueCriteria _doubleArrow = ObjectExtensions.<UIMeasureValueCriteria>operator_doubleArrow(_withPagerInfo, _function);
    filterRequestRequestHandler.execute(_doubleArrow);
    
  }
  
  public ActionContext<UIMeasureValue> getActionContext() {
    ActionContext<UIMeasureValue> _createActionContext = ActionExtensions.<UIMeasureValue>createActionContext(this.listGrid);
    return _createActionContext;
  }
  
  private RequestHandler1<UIMeasureValueCriteria> filterRequestRequestHandler;
  
  public void filterRequest(final RequestHandler1<UIMeasureValueCriteria> requestHandler) {
    this.filterRequestRequestHandler = requestHandler;
  }
}
