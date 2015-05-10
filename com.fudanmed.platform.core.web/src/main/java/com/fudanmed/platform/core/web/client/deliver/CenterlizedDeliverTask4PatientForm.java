package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.client.deliver.PatientCheckDeliverForm;
import com.fudanmed.platform.core.web.client.deliver.PatientCheckDeliverListGrid;
import com.fudanmed.platform.core.web.shared.deliver.UICenterlizedDeliverTask4Patient;
import com.fudanmed.platform.core.web.shared.deliver.UIPatientCheckDeliver;
import com.google.common.base.Function;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.FieldSet;
import com.uniquesoft.gwt.client.ClientUi;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import com.uniquesoft.gwt.shared.extensions.IterableExtensions2;
import edu.fudan.langlab.gxt.client.component.form.GXTFormComponent;
import edu.fudan.langlab.gxt.client.component.form.factory.DateValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.DateValueProviderFactory.DateItem;
import edu.fudan.langlab.gxt.client.component.form.factory.DateValueProviderFactory.TimeItem;
import edu.fudan.langlab.gxt.client.component.form.factory.DefaultObjectsSelectorFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.DefaultObjectsSelectorFactory.ListGridBasedItemsProvider;
import edu.fudan.langlab.gxt.client.widget.HTMLTagsExt;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTD;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTR;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTable;
import edu.fudan.langlab.gxt.client.widget.WidgetExtensions;
import java.util.Collection;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class CenterlizedDeliverTask4PatientForm extends GXTFormComponent<UICenterlizedDeliverTask4Patient> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public DateItem planDate;
  
  public TimeItem planTime;
  
  public ListGridBasedItemsProvider<UIPatientCheckDeliver> patients;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  @Inject
  private DefaultObjectsSelectorFactory defaultObjectsSelectorFactory;
  
  private UICenterlizedDeliverTask4Patient value = new UICenterlizedDeliverTask4Patient();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();planDate = dateValueProviderFactory.createAsDateItem("planDate","计划日期");
    widgetsRegistory.put("planDate",planDate);
    planTime = dateValueProviderFactory.createAsTimeItem("planTime","计划时间");
    widgetsRegistory.put("planTime",planTime);
    patients = defaultObjectsSelectorFactory.createAsListGridBasedItem("patients","检查项目列表",this.patientCheckDeliverListGrid);
    widgetsRegistory.put("patients",patients);
    if(patientCheckDeliverListGrid instanceof com.uniquesoft.gwt.client.common.async.IInitializerSupport){
    							_initializerSupports.add((com.uniquesoft.gwt.client.common.async.IInitializerSupport)patientCheckDeliverListGrid);
    						}if(patientCheckDeliverForm instanceof com.uniquesoft.gwt.client.common.async.IInitializerSupport){
    							_initializerSupports.add((com.uniquesoft.gwt.client.common.async.IInitializerSupport)patientCheckDeliverForm);
    						}IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UICenterlizedDeliverTask4Patient getValueAsNew() {
    UICenterlizedDeliverTask4Patient value = new UICenterlizedDeliverTask4Patient();
    value.setPlanDate(planDate.getValue());
    value.setPlanTime(planTime.getValue());
    value.setPatients(patients.getValue());
    return value;
  }
  
  public UICenterlizedDeliverTask4Patient doGetValue() {
    
    value.setPlanDate(planDate.getValue());
    value.setPlanTime(planTime.getValue());
    value.setPatients(patients.getValue());
    return value;
  }
  
  public UICenterlizedDeliverTask4Patient getValue(final UICenterlizedDeliverTask4Patient copyValue) {
    
    copyValue.setPlanDate(planDate.getValue());
    copyValue.setPlanTime(planTime.getValue());
    copyValue.setPatients(patients.getValue());
    return copyValue;
  }
  
  protected CenterlizedDeliverTask4PatientForm doSetValue(final UICenterlizedDeliverTask4Patient value) {
    this.value = value;
    planDate.setValue(value.getPlanDate());
    planTime.setValue(value.getPlanTime());
    patients.setValue(value.getPatients());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)planDate,(ICanAsWidget)planTime,(ICanAsWidget)patients
    					);
  }
  
  public Widget createWidget() {
    VerticalLayoutContainer _xblockexpression = null;
    {
      final Function1<Void,UIPatientCheckDeliver> _function = new Function1<Void,UIPatientCheckDeliver>() {
          public UIPatientCheckDeliver apply(final Void it) {
            UIPatientCheckDeliver _valueAsNew = CenterlizedDeliverTask4PatientForm.this.patientCheckDeliverForm.getValueAsNew();
            return _valueAsNew;
          }
        };
      this.patients.setObjectCreater(new Function<Void,UIPatientCheckDeliver>() {
          public UIPatientCheckDeliver apply(Void arg0) {
            return _function.apply(arg0);
          }
      });
      VerticalLayoutContainer _VLayout = this.widgets.VLayout();
      final Procedure1<VerticalLayoutContainer> _function_1 = new Procedure1<VerticalLayoutContainer>() {
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
                              FieldLabel _asWidget = CenterlizedDeliverTask4PatientForm.this.patientCheckDeliverForm.patient.asWidget();
                              ClientUi.operator_add(it, _asWidget);
                            }
                          };
                        ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                        PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                        final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
                            public void apply(final PlainHTMLTD it) {
                              FieldLabel _asWidget = CenterlizedDeliverTask4PatientForm.this.patientCheckDeliverForm.emergency.asWidget();
                              ClientUi.operator_add(it, _asWidget);
                            }
                          };
                        ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_1, _function_1);
                      }
                    };
                  ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr, _function);
                  PlainHTMLTR _tr_1 = HTMLTagsExt.tr(it);
                  final Procedure1<PlainHTMLTR> _function_1 = new Procedure1<PlainHTMLTR>() {
                      public void apply(final PlainHTMLTR it) {
                        PlainHTMLTD _td = HTMLTagsExt.td(it);
                        final Procedure1<PlainHTMLTD> _function = new Procedure1<PlainHTMLTD>() {
                            public void apply(final PlainHTMLTD it) {
                              FieldLabel _asWidget = CenterlizedDeliverTask4PatientForm.this.planDate.asWidget();
                              ClientUi.operator_add(it, _asWidget);
                            }
                          };
                        ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                        PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                        final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
                            public void apply(final PlainHTMLTD it) {
                              FieldLabel _asWidget = CenterlizedDeliverTask4PatientForm.this.planTime.asWidget();
                              ClientUi.operator_add(it, _asWidget);
                            }
                          };
                        ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_1, _function_1);
                      }
                    };
                  ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr_1, _function_1);
                }
              };
            PlainHTMLTable _doubleArrow = ObjectExtensions.<PlainHTMLTable>operator_doubleArrow(_TABLE, _function);
            WidgetExtensions.<PlainHTMLTable>addFill(it, _doubleArrow);
            FieldSet _FieldSet = CenterlizedDeliverTask4PatientForm.this.widgets.FieldSet("\u68C0\u67E5\u9879\u76EE");
            final Procedure1<FieldSet> _function_1 = new Procedure1<FieldSet>() {
                public void apply(final FieldSet it) {
                  PlainHTMLTable _TABLE = HTMLTagsExt.TABLE();
                  final Procedure1<PlainHTMLTable> _function = new Procedure1<PlainHTMLTable>() {
                      public void apply(final PlainHTMLTable it) {
                        PlainHTMLTR _tr = HTMLTagsExt.tr(it);
                        final Procedure1<PlainHTMLTR> _function = new Procedure1<PlainHTMLTR>() {
                            public void apply(final PlainHTMLTR it) {
                              PlainHTMLTD _td = HTMLTagsExt.td(it);
                              final Procedure1<PlainHTMLTD> _function = new Procedure1<PlainHTMLTD>() {
                                  public void apply(final PlainHTMLTD it) {
                                    FieldLabel _asWidget = CenterlizedDeliverTask4PatientForm.this.patientCheckDeliverForm.checkType.asWidget();
                                    ClientUi.operator_add(it, _asWidget);
                                  }
                                };
                              ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                              PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                              final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
                                  public void apply(final PlainHTMLTD it) {
                                    FieldLabel _asWidget = CenterlizedDeliverTask4PatientForm.this.patientCheckDeliverForm.checkOrganization.asWidget();
                                    ClientUi.operator_add(it, _asWidget);
                                  }
                                };
                              ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_1, _function_1);
                            }
                          };
                        ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr, _function);
                        PlainHTMLTR _tr_1 = HTMLTagsExt.tr(it);
                        final Procedure1<PlainHTMLTR> _function_1 = new Procedure1<PlainHTMLTR>() {
                            public void apply(final PlainHTMLTR it) {
                              PlainHTMLTD _td = HTMLTagsExt.td(it);
                              final Procedure1<PlainHTMLTD> _function = new Procedure1<PlainHTMLTD>() {
                                  public void apply(final PlainHTMLTD it) {
                                    FieldLabel _asWidget = CenterlizedDeliverTask4PatientForm.this.patientCheckDeliverForm.deliverMethod.asWidget();
                                    ClientUi.operator_add(it, _asWidget);
                                  }
                                };
                              ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                            }
                          };
                        ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr_1, _function_1);
                        PlainHTMLTR _tr_2 = HTMLTagsExt.tr(it);
                        final Procedure1<PlainHTMLTR> _function_2 = new Procedure1<PlainHTMLTR>() {
                            public void apply(final PlainHTMLTR it) {
                              PlainHTMLTD _td = HTMLTagsExt.td(it);
                              final Procedure1<PlainHTMLTD> _function = new Procedure1<PlainHTMLTD>() {
                                  public void apply(final PlainHTMLTD it) {
                                    it.setColSpan(3);
                                    FieldLabel _asWidget = CenterlizedDeliverTask4PatientForm.this.patients.asWidget();
                                    final Procedure1<FieldLabel> _function = new Procedure1<FieldLabel>() {
                                        public void apply(final FieldLabel it) {
                                          it.setHeight(200);
                                        }
                                      };
                                    FieldLabel _doubleArrow = ObjectExtensions.<FieldLabel>operator_doubleArrow(_asWidget, _function);
                                    ClientUi.operator_add(it, _doubleArrow);
                                  }
                                };
                              ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                            }
                          };
                        ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr_2, _function_2);
                      }
                    };
                  PlainHTMLTable _doubleArrow = ObjectExtensions.<PlainHTMLTable>operator_doubleArrow(_TABLE, _function);
                  it.setWidget(_doubleArrow);
                }
              };
            FieldSet _doubleArrow_1 = ObjectExtensions.<FieldSet>operator_doubleArrow(_FieldSet, _function_1);
            WidgetExtensions.<FieldSet>addFill(it, _doubleArrow_1);
          }
        };
      VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function_1);
      _xblockexpression = (_doubleArrow);
    }
    return _xblockexpression;
  }
  
  public Collection<UIPatientCheckDeliver> getPatientDeliverList() {
    Iterable<UIPatientCheckDeliver> _objects = this.patientCheckDeliverListGrid.getObjects();
    Collection<UIPatientCheckDeliver> _unlazy = IterableExtensions2.<UIPatientCheckDeliver>unlazy(_objects);
    return _unlazy;
  }
  
  @Inject
  private PatientCheckDeliverListGrid patientCheckDeliverListGrid;
  
  @Inject
  private PatientCheckDeliverForm patientCheckDeliverForm;
}
