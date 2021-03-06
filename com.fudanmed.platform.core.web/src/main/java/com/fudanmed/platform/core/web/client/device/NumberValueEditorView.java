package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.device.NumberValueDataForm;
import com.fudanmed.platform.core.web.client.device.NumberValueEditorPresenterView;
import com.fudanmed.platform.core.web.shared.device.NumberValueData;
import com.google.gwt.editor.client.HasEditorErrors;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.ClientUi;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.Size;
import edu.fudan.langlab.gxt.client.component.form.Validations;
import edu.fudan.langlab.gxt.client.validation.ErrorNotifierViewer;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.security.client.Securities;

public class NumberValueEditorView extends ErrorNotifierViewer implements NumberValueEditorPresenterView {
  @Inject
  private IWidgetFactory widgets;
  
  public void initialize(final IPostInitializeAction postInitialize) {
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(
    	com.google.common.collect.Lists.newArrayList(form),
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
  private NumberValueDataForm form;
  
  public void initialize() {
    
    Widget _asWidget = this.form.asWidget();
    ClientUi.operator_add(this, _asWidget);
  }
  
  public NumberValueData getValue() {
    NumberValueData _value = this.form.getValue();
    return _value;
  }
  
  public HasEditorErrors mapField(final String errorKey) {
    HasEditorErrors _mapToErrorEditor = Validations.mapToErrorEditor(this.form, errorKey);
    return _mapToErrorEditor;
  }
  
  public void clearErrors() {
    Validations.clearErrors(this.form);
  }
  
  public void setValue(final NumberValueData value) {
    this.form.setValue(value);
  }
  
  public void setValue(final Double value) {
    this.form.theValue.setValue(value);
  }
  
  public Size getSize() {
    Size _size = new Size(300, 200);
    return _size;
  }
  
  public String getTitle() {
    return "\u8BBE\u7F6E\u6570\u503C";
  }
}
