package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.client.project.ComplaintForm;
import com.fudanmed.platform.core.web.client.project.CreateOrUpdateComplaintPresenterView;
import com.fudanmed.platform.core.web.shared.project.UIComplaint;
import com.google.gwt.editor.client.HasEditorErrors;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.uniquesoft.gwt.client.ClientUi;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.IHasSize;
import com.uniquesoft.gwt.client.common.widgets.IHasTitle;
import com.uniquesoft.gwt.client.common.widgets.Size;
import edu.fudan.langlab.gxt.client.component.form.Validations;
import edu.fudan.langlab.gxt.client.validation.ErrorNotifierViewer;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.security.client.Securities;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class CreateOrUpdateComplaintView extends ErrorNotifierViewer implements CreateOrUpdateComplaintPresenterView, IHasSize, IHasTitle {
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
  private ComplaintForm form;
  
  public void initialize() {
    
    VerticalLayoutContainer _VLayout = this.widgets.VLayout();
    final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
        public void apply(final VerticalLayoutContainer it) {
          Widget _asWidget = CreateOrUpdateComplaintView.this.form.asWidget();
          int _minus = (-1);
          VerticalLayoutData _VLayoutData = CreateOrUpdateComplaintView.this.widgets.VLayoutData(1, _minus, 10);
          it.add(_asWidget, _VLayoutData);
        }
      };
    VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
    ClientUi.operator_add(this, _doubleArrow);
  }
  
  public UIComplaint getValue() {
    UIComplaint _value = this.form.getValue();
    return _value;
  }
  
  public HasEditorErrors mapField(final String errorKey) {
    HasEditorErrors _mapToErrorEditor = Validations.mapToErrorEditor(this.form, errorKey);
    return _mapToErrorEditor;
  }
  
  public void clearErrors() {
    Validations.clearErrors(this.form);
  }
  
  public void setValue(final UIComplaint value) {
    this.form.setValue(value);
  }
  
  public Size getSize() {
    Size _size = new Size(300, 200);
    return _size;
  }
  
  public String getTitle() {
    return "\u6295\u8BC9";
  }
}
