package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCWorkItemPlanAssignmentProxy;
import com.fudanmed.platform.core.web.client.device.RemoveWorkItemPlanAssignmentCommandServiceAsync;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.box.ConfirmMessageBox;
import com.uniquesoft.gwt.client.common.command.BaseContextAwareMultiObjectCommand;
import com.uniquesoft.gwt.shared.command.IContextConsumer;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.List;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class RemoveWorkItemPlanAssignmentCommand extends BaseContextAwareMultiObjectCommand<RCWorkItemPlanAssignmentProxy> implements IContextConsumer<RCWorkItemPlanAssignmentProxy> {
  @Inject
  protected RemoveWorkItemPlanAssignmentCommandServiceAsync _service;
  
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "移除维保设备";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.RemoveWorkItemPlanAssignmentCommand";
  }
  
  public boolean requireCheck() {
    return false;
  }
  
  public void execute(final Iterable<RCWorkItemPlanAssignmentProxy> value) {
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          List<RCWorkItemPlanAssignmentProxy> _list = IterableExtensions.<RCWorkItemPlanAssignmentProxy>toList(value);
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.device.PMWorkItemsChangedEvent());
                
              }
            };
          AsyncCallback<Void> _onSuccess = RemoveWorkItemPlanAssignmentCommand.this.<Void>onSuccess(_function);
          _service.removeAssignment(_list, _onSuccess);
        }
      };
    ConfirmMessageBox _ConfirmMessageBox = this.widgets.ConfirmMessageBox("\u786E\u8BA4", "\u786E\u8BA4\u79FB\u9664", _function);
    _ConfirmMessageBox.show();
  }
}
