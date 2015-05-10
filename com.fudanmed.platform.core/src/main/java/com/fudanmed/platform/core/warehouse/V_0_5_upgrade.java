package com.fudanmed.platform.core.warehouse;

import com.fudanmed.platform.core.common.RCEBoardMessage;
import com.fudanmed.platform.core.common.RCSequenceConfig;
import com.fudanmed.platform.core.common.RCSequenceService;
import com.fudanmed.platform.core.common.RCSystemParameter;
import com.fudanmed.platform.core.common.RCSystemParameterService;
import com.fudanmed.platform.core.common.impl.RCEBoardMessageImpl;
import com.fudanmed.platform.core.deliver.DLInHospitalPatient;
import com.fudanmed.platform.core.deliver.impl.DLInHospitalPatientImpl;
import com.fudanmed.platform.core.device.RCDeviceTypeCategory;
import com.fudanmed.platform.core.domain.RCFaultType;
import com.fudanmed.platform.core.domain.RCMaintenamceType;
import com.fudanmed.platform.core.domain.RCOnsitePosition;
import com.fudanmed.platform.core.measure.RCElectricMeasureDeviceType;
import com.fudanmed.platform.core.measure.RCGasMeasureDeviceType;
import com.fudanmed.platform.core.measure.RCPhasedElectricMeasureDeviceType;
import com.fudanmed.platform.core.measure.RCWaterMeasureDeviceType;
import com.fudanmed.platform.core.measure.impl.RCElectricMeasureDeviceTypeImpl;
import com.fudanmed.platform.core.measure.impl.RCGasMeasureDeviceTypeImpl;
import com.fudanmed.platform.core.measure.impl.RCPhasedElectricMeasureDeviceTypeImpl;
import com.fudanmed.platform.core.measure.impl.RCWaterMeasureDeviceTypeImpl;
import com.fudanmed.platform.core.warehouse.RCProductCategory;
import com.fudanmed.platform.core.warehouse.RCProductSpecification;
import com.fudanmed.platform.core.warehouse.RCProductType;
import edu.fudan.langlab.domain.organization.Party;
import edu.fudan.langlab.domain.security.AppFunction;
import edu.fudan.langlab.domain.security.impl.AppFunctionImpl;
import edu.fudan.langlab.domain.updater.IUpgrader;
import edu.fudan.langlab.domain.updater.UpdateServie;
import edu.fudan.mylang.pf.BaseService;
import edu.fudan.mylang.pf.IGenericQuery;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("V_0_5_upgrade")
public class V_0_5_upgrade extends BaseService implements IUpgrader {
  @Autowired
  private RCSystemParameterService systemParameterService;
  
  @Autowired
  private RCSequenceService sequenceService;
  
  public void measureDevices() {RCWaterMeasureDeviceType rCWaterMeasureDeviceType=RCWaterMeasureDeviceTypeImpl.create(getObjectFactory());
    final Procedure1<RCWaterMeasureDeviceType> _function = new Procedure1<RCWaterMeasureDeviceType>() {
        public void apply(final RCWaterMeasureDeviceType it) {
          it.setName("\u6C34\u8868");
        }
      };
    ObjectExtensions.<RCWaterMeasureDeviceType>operator_doubleArrow(rCWaterMeasureDeviceType, _function);RCGasMeasureDeviceType rCGasMeasureDeviceType=RCGasMeasureDeviceTypeImpl.create(getObjectFactory());
    final Procedure1<RCGasMeasureDeviceType> _function_1 = new Procedure1<RCGasMeasureDeviceType>() {
        public void apply(final RCGasMeasureDeviceType it) {
          it.setName("\u6C14\u8868");
        }
      };
    ObjectExtensions.<RCGasMeasureDeviceType>operator_doubleArrow(rCGasMeasureDeviceType, _function_1);RCElectricMeasureDeviceType rCElectricMeasureDeviceType=RCElectricMeasureDeviceTypeImpl.create(getObjectFactory());
    final Procedure1<RCElectricMeasureDeviceType> _function_2 = new Procedure1<RCElectricMeasureDeviceType>() {
        public void apply(final RCElectricMeasureDeviceType it) {
          it.setName("\u7535\u8868");
        }
      };
    ObjectExtensions.<RCElectricMeasureDeviceType>operator_doubleArrow(rCElectricMeasureDeviceType, _function_2);RCPhasedElectricMeasureDeviceType rCPhasedElectricMeasureDeviceType=RCPhasedElectricMeasureDeviceTypeImpl.create(getObjectFactory());
    final Procedure1<RCPhasedElectricMeasureDeviceType> _function_3 = new Procedure1<RCPhasedElectricMeasureDeviceType>() {
        public void apply(final RCPhasedElectricMeasureDeviceType it) {
          it.setName("\u5CF0\u8C37\u7535\u8868");
        }
      };
    ObjectExtensions.<RCPhasedElectricMeasureDeviceType>operator_doubleArrow(rCPhasedElectricMeasureDeviceType, _function_3);
  }
  
  public void eboardMessage() {RCEBoardMessage rCEBoardMessage=RCEBoardMessageImpl.create(getObjectFactory());
    final Procedure1<RCEBoardMessage> _function = new Procedure1<RCEBoardMessage>() {
        public void apply(final RCEBoardMessage it) {
          it.setMessage("\u7CFB\u7EDF\u6D4B\u8BD5\u901A\u77E5");
        }
      };
    ObjectExtensions.<RCEBoardMessage>operator_doubleArrow(rCEBoardMessage, _function);
  }
  
  public void eboardRefreshInterval() {
    RCSystemParameter _systemParameter = this.systemParameterService.getSystemParameter();
    _systemParameter.setEboardRefreshInterval(Integer.valueOf(10));
  }
  
  public void improveDeviceInput() {AppFunction appFunction=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.deviceManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.UploadDeviceCommand");
          it.setName("\u8BBE\u5907\u5BFC\u5165");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction, _function);AppFunction appFunction_1=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_1 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.deviceManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.ExportDeviceCommand");
          it.setName("\u8BBE\u5907\u5BFC\u51FA");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_1, _function_1);AppFunction appFunction_2=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_2 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.deviceManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.device.DeviceManagementPresenter.duplicateRequest");
          it.setName("\u590D\u5236\u8BBE\u5907");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_2, _function_2);
  }
  
  public void additionalEmployeeFunctions() {AppFunction appFunction=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.employeeManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.organization.EmployeeManagementPresenter.modifyDepartment");
          it.setName("\u90E8\u95E8\u53D8\u52A8");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction, _function);AppFunction appFunction_1=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_1 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.employeeManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.organization.EmployeeManagementPresenter.leaveJobRequest");
          it.setName("\u5458\u5DE5\u79BB\u804C");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_1, _function_1);AppFunction appFunction_2=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_2 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.employeeManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.organization.EmployeeManagementPresenter.resumeJobRequest");
          it.setName("\u5458\u5DE5\u590D\u804C");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_2, _function_2);
  }
  
  public void AppFunctions() {AppFunction appFunction=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setFunctionId("com.fudanmed.platform.core.app");
          it.setName("APP\u529F\u80FD");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction, _function);AppFunction appFunction_1=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_1 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.app");
          it.setFunctionId("com.fudanmed.platform.core.app.measurement");
          it.setName("\u6284\u8868\u7BA1\u7406");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_1, _function_1);AppFunction appFunction_2=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_2 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.app");
          it.setFunctionId("com.fudanmed.platform.core.app.workitem");
          it.setName("\u5DE5\u5355\u7BA1\u7406");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_2, _function_2);AppFunction appFunction_3=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_3 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.app");
          it.setFunctionId("com.fudanmed.platform.core.app.system");
          it.setName("\u7CFB\u7EDF\u7BA1\u7406");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_3, _function_3);
  }
  
  public void DeviceDocumentAndPictureFunctions() {AppFunction appFunction=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.deviceManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.CreateDeviceDocumentStorageCommand");
          it.setName("\u4E0A\u4F20\u8BBE\u5907\u6587\u6863");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction, _function);AppFunction appFunction_1=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_1 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.deviceManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.UpdateDeviceDocumentStorageCommand");
          it.setName("\u4FEE\u6539\u8BBE\u5907\u6587\u6863");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_1, _function_1);AppFunction appFunction_2=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_2 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.deviceManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.DeleteDeviceDocumentStorageCommand");
          it.setName("\u5220\u9664\u8BBE\u5907\u6587\u6863");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_2, _function_2);AppFunction appFunction_3=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_3 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.deviceManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.CreateDevicePictureCommand");
          it.setName("\u4E0A\u4F20\u8BBE\u5907\u56FE\u7247");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_3, _function_3);AppFunction appFunction_4=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_4 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.deviceManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.UpdateDevicePictureCommand");
          it.setName("\u4FEE\u6539\u8BBE\u5907\u56FE\u7247");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_4, _function_4);AppFunction appFunction_5=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function_5 = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.deviceManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.DeleteDevicePictureCommand");
          it.setName("\u5220\u9664\u8BBE\u5907\u56FE\u7247");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction_5, _function_5);
  }
  
  public void cancelReportFunction() {AppFunction appFunction=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.repairReportManagementPresenter");
          it.setFunctionId("com.fudanmed.platform.core.web.client.project.RepairTaskManagementPresenter.cancelRequest");
          it.setName("\u53D6\u6D88\u62A5\u4FEE");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction, _function);
  }
  
  public void eboardFunction() {AppFunction appFunction=AppFunctionImpl.create(getObjectFactory());
    final Procedure1<AppFunction> _function = new Procedure1<AppFunction>() {
        public void apply(final AppFunction it) {
          it.setParentFunctionId("com.fudanmed.platform.core.web.basic");
          it.setFunctionId("edu.fudan.langlab.uidl.domain.app.eboardPresenter");
          it.setName("\u7535\u5B50\u5C4F");
        }
      };
    ObjectExtensions.<AppFunction>operator_doubleArrow(appFunction, _function);
  }
  
  public void SimplePyWithLetterOrDigit() {IGenericQuery<Party> query=getObjectFactory().createGenericQuery(Party.class,"select e1 from edu.fudan.langlab.domain.organization.impl.PartyImpl as e1   where  e1.active = 1      ");
    Collection<Party> _list = query.list();
    final Procedure1<Party> _function = new Procedure1<Party>() {
        public void apply(final Party it) {
          it.setSimplePy("");
        }
      };
    IterableExtensions.<Party>forEach(_list, _function);IGenericQuery<RCDeviceTypeCategory> query_1=getObjectFactory().createGenericQuery(RCDeviceTypeCategory.class,"select e2 from com.fudanmed.platform.core.device.impl.RCDeviceTypeCategoryImpl as e2   where  e2.active = 1      ");
    Collection<RCDeviceTypeCategory> _list_1 = query_1.list();
    final Procedure1<RCDeviceTypeCategory> _function_1 = new Procedure1<RCDeviceTypeCategory>() {
        public void apply(final RCDeviceTypeCategory it) {
          it.setSimplePy("");
        }
      };
    IterableExtensions.<RCDeviceTypeCategory>forEach(_list_1, _function_1);IGenericQuery<RCFaultType> query_2=getObjectFactory().createGenericQuery(RCFaultType.class,"select e3 from com.fudanmed.platform.core.domain.impl.RCFaultTypeImpl as e3   where  e3.active = 1      ");
    Collection<RCFaultType> _list_2 = query_2.list();
    final Procedure1<RCFaultType> _function_2 = new Procedure1<RCFaultType>() {
        public void apply(final RCFaultType it) {
          it.setSimplePy("");
        }
      };
    IterableExtensions.<RCFaultType>forEach(_list_2, _function_2);IGenericQuery<RCMaintenamceType> query_3=getObjectFactory().createGenericQuery(RCMaintenamceType.class,"select e4 from com.fudanmed.platform.core.domain.impl.RCMaintenamceTypeImpl as e4   where  e4.active = 1      ");
    Collection<RCMaintenamceType> _list_3 = query_3.list();
    final Procedure1<RCMaintenamceType> _function_3 = new Procedure1<RCMaintenamceType>() {
        public void apply(final RCMaintenamceType it) {
          it.setSimplePy("");
        }
      };
    IterableExtensions.<RCMaintenamceType>forEach(_list_3, _function_3);IGenericQuery<RCOnsitePosition> query_4=getObjectFactory().createGenericQuery(RCOnsitePosition.class,"select e5 from com.fudanmed.platform.core.domain.impl.RCOnsitePositionImpl as e5   where  e5.active = 1      ");
    Collection<RCOnsitePosition> _list_4 = query_4.list();
    final Procedure1<RCOnsitePosition> _function_4 = new Procedure1<RCOnsitePosition>() {
        public void apply(final RCOnsitePosition it) {
          it.setSimplePy("");
        }
      };
    IterableExtensions.<RCOnsitePosition>forEach(_list_4, _function_4);IGenericQuery<RCProductCategory> query_5=getObjectFactory().createGenericQuery(RCProductCategory.class,"select e6 from com.fudanmed.platform.core.warehouse.impl.RCProductCategoryImpl as e6   where  e6.active = 1      ");
    Collection<RCProductCategory> _list_5 = query_5.list();
    final Procedure1<RCProductCategory> _function_5 = new Procedure1<RCProductCategory>() {
        public void apply(final RCProductCategory it) {
          it.setSimplePy("");
        }
      };
    IterableExtensions.<RCProductCategory>forEach(_list_5, _function_5);IGenericQuery<RCProductSpecification> query_6=getObjectFactory().createGenericQuery(RCProductSpecification.class,"select e7 from com.fudanmed.platform.core.warehouse.impl.RCProductSpecificationImpl as e7   where  e7.active = 1      ");
    Collection<RCProductSpecification> _list_6 = query_6.list();
    final Procedure1<RCProductSpecification> _function_6 = new Procedure1<RCProductSpecification>() {
        public void apply(final RCProductSpecification it) {
          it.setSimplePy("");
        }
      };
    IterableExtensions.<RCProductSpecification>forEach(_list_6, _function_6);IGenericQuery<RCProductType> query_7=getObjectFactory().createGenericQuery(RCProductType.class,"select e8 from com.fudanmed.platform.core.warehouse.impl.RCProductTypeImpl as e8   where  e8.active = 1      ");
    Collection<RCProductType> _list_7 = query_7.list();
    final Procedure1<RCProductType> _function_7 = new Procedure1<RCProductType>() {
        public void apply(final RCProductType it) {
          it.setSimplePy("");
        }
      };
    IterableExtensions.<RCProductType>forEach(_list_7, _function_7);
  }
  
  public void initDLInHospitalPatient() {DLInHospitalPatient dLInHospitalPatient=DLInHospitalPatientImpl.create(getObjectFactory());
    final Procedure1<DLInHospitalPatient> _function = new Procedure1<DLInHospitalPatient>() {
        public void apply(final DLInHospitalPatient it) {
          it.setSid("0000001");
          it.setName("pname1");
        }
      };
    ObjectExtensions.<DLInHospitalPatient>operator_doubleArrow(dLInHospitalPatient, _function);DLInHospitalPatient dLInHospitalPatient_1=DLInHospitalPatientImpl.create(getObjectFactory());
    final Procedure1<DLInHospitalPatient> _function_1 = new Procedure1<DLInHospitalPatient>() {
        public void apply(final DLInHospitalPatient it) {
          it.setSid("0000002");
          it.setName("pname2");
        }
      };
    ObjectExtensions.<DLInHospitalPatient>operator_doubleArrow(dLInHospitalPatient_1, _function_1);DLInHospitalPatient dLInHospitalPatient_2=DLInHospitalPatientImpl.create(getObjectFactory());
    final Procedure1<DLInHospitalPatient> _function_2 = new Procedure1<DLInHospitalPatient>() {
        public void apply(final DLInHospitalPatient it) {
          it.setSid("0000003");
          it.setName("pname3");
        }
      };
    ObjectExtensions.<DLInHospitalPatient>operator_doubleArrow(dLInHospitalPatient_2, _function_2);
  }
  
  public void initCtaskSequence() {
    RCSequenceConfig _computeConfig = this.sequenceService.computeConfig();
    _computeConfig.setCenterilzedTaskSequence(Integer.valueOf(0));
  }
  
  @Autowired
  private UpdateServie updateService;
  
  public void doUpgrade() {
    if (updateService.canPerformUpdate("V_0_5_upgrade", "V_0_5", "measureDevices")) {
    	measureDevices();
    	updateService.updaterCommited("V_0_5_upgrade", "V_0_5", "measureDevices");
    }
    if (updateService.canPerformUpdate("V_0_5_upgrade", "V_0_5", "eboardMessage")) {
    	eboardMessage();
    	updateService.updaterCommited("V_0_5_upgrade", "V_0_5", "eboardMessage");
    }
    if (updateService.canPerformUpdate("V_0_5_upgrade", "V_0_5", "eboardRefreshInterval")) {
    	eboardRefreshInterval();
    	updateService.updaterCommited("V_0_5_upgrade", "V_0_5", "eboardRefreshInterval");
    }
    if (updateService.canPerformUpdate("V_0_5_upgrade", "V_0_5", "improveDeviceInput")) {
    	improveDeviceInput();
    	updateService.updaterCommited("V_0_5_upgrade", "V_0_5", "improveDeviceInput");
    }
    if (updateService.canPerformUpdate("V_0_5_upgrade", "V_0_5", "additionalEmployeeFunctions")) {
    	additionalEmployeeFunctions();
    	updateService.updaterCommited("V_0_5_upgrade", "V_0_5", "additionalEmployeeFunctions");
    }
    if (updateService.canPerformUpdate("V_0_5_upgrade", "V_0_5", "AppFunctions")) {
    	AppFunctions();
    	updateService.updaterCommited("V_0_5_upgrade", "V_0_5", "AppFunctions");
    }
    if (updateService.canPerformUpdate("V_0_5_upgrade", "V_0_5", "DeviceDocumentAndPictureFunctions")) {
    	DeviceDocumentAndPictureFunctions();
    	updateService.updaterCommited("V_0_5_upgrade", "V_0_5", "DeviceDocumentAndPictureFunctions");
    }
    if (updateService.canPerformUpdate("V_0_5_upgrade", "V_0_5", "cancelReportFunction")) {
    	cancelReportFunction();
    	updateService.updaterCommited("V_0_5_upgrade", "V_0_5", "cancelReportFunction");
    }
    if (updateService.canPerformUpdate("V_0_5_upgrade", "V_0_5", "eboardFunction")) {
    	eboardFunction();
    	updateService.updaterCommited("V_0_5_upgrade", "V_0_5", "eboardFunction");
    }
    if (updateService.canPerformUpdate("V_0_5_upgrade", "V_0_5", "SimplePyWithLetterOrDigit")) {
    	SimplePyWithLetterOrDigit();
    	updateService.updaterCommited("V_0_5_upgrade", "V_0_5", "SimplePyWithLetterOrDigit");
    }
    if (updateService.canPerformUpdate("V_0_5_upgrade", "V_0_5", "initDLInHospitalPatient")) {
    	initDLInHospitalPatient();
    	updateService.updaterCommited("V_0_5_upgrade", "V_0_5", "initDLInHospitalPatient");
    }
    if (updateService.canPerformUpdate("V_0_5_upgrade", "V_0_5", "initCtaskSequence")) {
    	initCtaskSequence();
    	updateService.updaterCommited("V_0_5_upgrade", "V_0_5", "initCtaskSequence");
    }
    
  }
}
