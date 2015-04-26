package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCPMWorkItemWorkerAssignmentProxy;
import com.fudanmed.platform.core.web.client.device.PMEngineerReportPresenter;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.command.BaseContextAwareSingleObjectCommand;
import com.uniquesoft.gwt.shared.command.IContextConsumer;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class PMEngineerReportCommand extends BaseContextAwareSingleObjectCommand<RCPMWorkItemWorkerAssignmentProxy> implements IContextConsumer<RCPMWorkItemWorkerAssignmentProxy> {
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "上报";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.PMEngineerReportCommand";
  }
  
  public boolean requireCheck() {
    return false;
  }
  
  public void execute(final RCPMWorkItemWorkerAssignmentProxy value) {
    PMEngineerReportPresenter _get = this.engineerReportPresenter.get();
    final Procedure1<PMEngineerReportPresenter> _function = new Procedure1<PMEngineerReportPresenter>() {
        public void apply(final PMEngineerReportPresenter it) {
          eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
          
        }
      };
    _get.setup(value, new IPresenterInitiazerNotifier<PMEngineerReportPresenter>() {
        public void done(PMEngineerReportPresenter presenter) {
          _function.apply(presenter);
        }
    });
  }
  
  @Inject
  private Provider<PMEngineerReportPresenter> engineerReportPresenter;
}
