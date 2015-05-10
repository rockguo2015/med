package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCDevicePMSpecificationProxy;
import com.fudanmed.platform.core.web.client.device.CreateOrUpdateDevicePMPlanPresenter;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.command.BaseContextAwareSingleObjectCommand;
import com.uniquesoft.gwt.shared.command.IContextConsumer;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class CreateDevicePMPlanCommand extends BaseContextAwareSingleObjectCommand<RCDevicePMSpecificationProxy> implements IContextConsumer<RCDevicePMSpecificationProxy> {
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "新建";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.CreateDevicePMPlanCommand";
  }
  
  public boolean requireCheck() {
    return false;
  }
  
  public void execute(final RCDevicePMSpecificationProxy value) {
    CreateOrUpdateDevicePMPlanPresenter _get = this.createOrUpdateDevicePMPlanPresenter.get();
    final Procedure1<CreateOrUpdateDevicePMPlanPresenter> _function = new Procedure1<CreateOrUpdateDevicePMPlanPresenter>() {
        public void apply(final CreateOrUpdateDevicePMPlanPresenter it) {
          it.popup(it);
        }
      };
    _get.setup4Create(value, new IPresenterInitiazerNotifier<CreateOrUpdateDevicePMPlanPresenter>() {
        public void done(CreateOrUpdateDevicePMPlanPresenter presenter) {
          _function.apply(presenter);
        }
    });
  }
  
  @Inject
  private Provider<CreateOrUpdateDevicePMPlanPresenter> createOrUpdateDevicePMPlanPresenter;
}
