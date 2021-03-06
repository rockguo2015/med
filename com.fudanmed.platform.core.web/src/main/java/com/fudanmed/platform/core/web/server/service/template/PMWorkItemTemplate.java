package com.fudanmed.platform.core.web.server.service.template;

import com.fudanmed.platform.core.common.RCSystemParameter;
import com.fudanmed.platform.core.device.RCDevice;
import com.fudanmed.platform.core.device.RCDeviceType;
import com.fudanmed.platform.core.device.pm.RCDevicePMPlan;
import com.fudanmed.platform.core.device.pm.RCDevicePMSpecification;
import com.fudanmed.platform.core.device.pm.RCDevicePMType;
import com.fudanmed.platform.core.device.pm.RCPMWorkItem;
import com.fudanmed.platform.core.device.pm.RCPMWorkItemWorkerAssignment;
import com.fudanmed.platform.core.device.pm.RCWorkItemPlanAssignment;
import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.RCMaintenanceTeam;
import com.fudanmed.platform.core.domain.RCOnsitePosition;
import com.fudanmed.platform.core.domain.RCSupplier;
import com.google.common.base.Objects;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class PMWorkItemTemplate {
  public static String nullsafe(final String s) {
    String _xifexpression = null;
    boolean _equals = Objects.equal(s, null);
    if (_equals) {
      _xifexpression = "&nbsp;";
    } else {
      _xifexpression = s;
    }
    return _xifexpression;
  }
  
  public static String nullsafe(final Double s) {
    String _xifexpression = null;
    boolean _equals = Objects.equal(s, null);
    if (_equals) {
      _xifexpression = "&nbsp;";
    } else {
      String _string = s.toString();
      _xifexpression = _string;
    }
    return _xifexpression;
  }
  
  public static String nullsafe(final Integer s) {
    String _xifexpression = null;
    boolean _equals = Objects.equal(s, null);
    if (_equals) {
      _xifexpression = "&nbsp;";
    } else {
      String _string = s.toString();
      _xifexpression = _string;
    }
    return _xifexpression;
  }
  
  public static String template(final RCPMWorkItemWorkerAssignment record, final RCSystemParameter parameter) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<html> ");
    _builder.newLine();
    _builder.append("<head> ");
    _builder.newLine();
    _builder.append("<title>PM\u4EFB\u52A1\u5355</title> ");
    _builder.newLine();
    _builder.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=gb2312\"> ");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    _builder.append("<style> ");
    _builder.newLine();
    _builder.newLine();
    _builder.append("table");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("{");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("border:0px solid black;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("width:22cm;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("border-spacing:0px 7px;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("td,th{");
    _builder.newLine();
    _builder.append("color:#000000;");
    _builder.newLine();
    _builder.append("font-size: 12pt; ");
    _builder.newLine();
    _builder.append("font-family:Arial,Microsoft YaHei,SimHei,SimSun;");
    _builder.newLine();
    _builder.append("height:0.5cm;");
    _builder.newLine();
    _builder.append("padding-left:2px;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append(".tdlabel ");
    _builder.newLine();
    _builder.append("{ ");
    _builder.newLine();
    _builder.append("border-style:none; ");
    _builder.newLine();
    _builder.append("font-weight:bold;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append(".tdleft");
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("text-align:left;");
    _builder.newLine();
    _builder.append("} ");
    _builder.newLine();
    _builder.newLine();
    _builder.append(".tdright");
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("text-align:right;");
    _builder.newLine();
    _builder.append("} ");
    _builder.newLine();
    _builder.newLine();
    _builder.append(".tdcenter");
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("text-align:center;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append(".tdtop ");
    _builder.newLine();
    _builder.append("{ ");
    _builder.newLine();
    _builder.append("vertical-align:top;");
    _builder.newLine();
    _builder.append("} ");
    _builder.newLine();
    _builder.append(".tdbottom ");
    _builder.newLine();
    _builder.append("{ ");
    _builder.newLine();
    _builder.append("vertical-align:bottom;");
    _builder.newLine();
    _builder.append("} ");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    _builder.append(".tdcontent");
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("border-style:none;");
    _builder.newLine();
    _builder.append("border-bottom:1px solid #000000;");
    _builder.newLine();
    _builder.append("text-align:center;");
    _builder.newLine();
    _builder.append("vertical-align:bottom;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("thead");
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("display:table-header-group;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append(".tableLL");
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("width:22cm;");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("border:1px solid #000000;");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("border-collapse:collapse;");
    _builder.newLine();
    _builder.newLine();
    _builder.append(" ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append(".tableLL th");
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("border:1px solid #000000;");
    _builder.newLine();
    _builder.append(" ");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("padding-top:3px;");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("padding-bottom:3px;");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append(".tableLL td");
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("border:1px solid #000000;");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("padding:3px 7px 2px 7px;");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("font-size: 10pt;");
    _builder.newLine();
    _builder.newLine();
    _builder.append(" ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    _builder.append("</style> ");
    _builder.newLine();
    _builder.newLine();
    _builder.append("</head> ");
    _builder.newLine();
    _builder.newLine();
    _builder.append("<body > ");
    _builder.newLine();
    _builder.newLine();
    _builder.append("<h2 style=\"width:21cm;text-align:center;font-family:Arial,Microsoft YaHei,SimHei,SimSun;\" >");
    String _orgName = parameter.getOrgName();
    _builder.append(_orgName, "");
    _builder.append("\u8BBE\u5907PM\u4EFB\u52A1\u5355</h2>");
    _builder.newLineIfNotEmpty();
    _builder.append("<table> ");
    _builder.newLine();
    _builder.append("<tr> ");
    _builder.newLine();
    _builder.append("<td width=\"11%\" class=\"tdlabel tdleft tdbottom\">\u4EFB\u52A1\u5355\u53F7:</td>");
    _builder.newLine();
    _builder.append("<td width=\"15%\" class=\"tdcontent\">");
    RCPMWorkItem _workitem = record.getWorkitem();
    String _sid = _workitem.getSid();
    _builder.append(_sid, "");
    _builder.append("</td> ");
    _builder.newLineIfNotEmpty();
    _builder.append("<td width=\"11%\" class=\"tdlabel tdleft tdbottom\">\u6D3E\u53D1\u65E5\u671F:</td> ");
    _builder.newLine();
    _builder.append("<td width=\"20%\" class=\"tdcontent\">");
    SimpleDateFormat _simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date _assignDate = record.getAssignDate();
    String _format = _simpleDateFormat.format(_assignDate);
    _builder.append(_format, "");
    _builder.append("</td> ");
    _builder.newLineIfNotEmpty();
    _builder.append("<td width=\"11%\" class=\"tdlabel tdleft tdbottom\">\u914D\u5408\u73ED\u7EC4:</td> ");
    _builder.newLine();
    _builder.append("<td width=\"31%\" class=\"tdcontent\">");
    RCPMWorkItem _workitem_1 = record.getWorkitem();
    RCMaintenanceTeam _team = _workitem_1.getTeam();
    String _entityName = _team.getEntityName();
    _builder.append(_entityName, "");
    _builder.append("</td> ");
    _builder.newLineIfNotEmpty();
    _builder.append("</tr> ");
    _builder.newLine();
    _builder.append("<tr> ");
    _builder.newLine();
    _builder.append("<td class=\"tdlabel tdleft tdbottom\">\u6267\u884C\u65E5\u671F:</td>");
    _builder.newLine();
    _builder.append("<td class=\"tdcontent\">");
    SimpleDateFormat _simpleDateFormat_1 = new SimpleDateFormat("yyyy-MM-dd");
    Date _assignDate_1 = record.getAssignDate();
    String _format_1 = _simpleDateFormat_1.format(_assignDate_1);
    _builder.append(_format_1, "");
    _builder.append("</td> ");
    _builder.newLineIfNotEmpty();
    _builder.append("<td class=\"tdlabel tdleft tdbottom\">\u670D\u52A1\u63D0\u4F9B\u5546:</td> ");
    _builder.newLine();
    _builder.append("<td class=\"tdcontent\">");
    RCPMWorkItem _workitem_2 = record.getWorkitem();
    RCSupplier _supplier = _workitem_2.getSupplier();
    String _entityName_1 = _supplier==null?(String)null:_supplier.getEntityName();
    String _nullsafe = PMWorkItemTemplate.nullsafe(_entityName_1);
    _builder.append(_nullsafe, "");
    _builder.append("</td> ");
    _builder.newLineIfNotEmpty();
    _builder.append("<td class=\"tdlabel tdleft tdbottom\">\u7EF4\u4FDD\u4EBA\u5458:</td> ");
    _builder.newLine();
    _builder.append("<td class=\"tdcontent\">");
    Collection<RCEmployee> _workers = record.getWorkers();
    final Function1<RCEmployee,String> _function = new Function1<RCEmployee,String>() {
        public String apply(final RCEmployee it) {
          String _entityName = it.getEntityName();
          return _entityName;
        }
      };
    Iterable<String> _map = IterableExtensions.<RCEmployee, String>map(_workers, _function);
    String _join = IterableExtensions.join(_map, ",");
    _builder.append(_join, "");
    _builder.append("</td> ");
    _builder.newLineIfNotEmpty();
    _builder.append("</tr> ");
    _builder.newLine();
    _builder.append("<tr> ");
    _builder.newLine();
    _builder.append("<td class=\"tdlabel tdleft tdbottom\">\u7EF4\u4FDD\u4EFB\u52A1\u8BF4\u660E:</td>");
    _builder.newLine();
    _builder.append("<td colspan=5 class=\"tdcontent\">");
    RCPMWorkItem _workitem_3 = record.getWorkitem();
    String _description = _workitem_3.getDescription();
    _builder.append(_description, "");
    _builder.append("</td> ");
    _builder.newLineIfNotEmpty();
    _builder.append("</tr> ");
    _builder.newLine();
    _builder.append("<tr> ");
    _builder.newLine();
    _builder.append("<td class=\"tdlabel tdleft tdbottom\">\u6D3E\u5DE5\u8BF4\u660E:</td>");
    _builder.newLine();
    _builder.append("<td colspan=5 class=\"tdcontent\">");
    String _comment = record.getComment();
    _builder.append(_comment, "");
    _builder.append("</td> ");
    _builder.newLineIfNotEmpty();
    _builder.append("</tr> ");
    _builder.newLine();
    _builder.append("</table>");
    _builder.newLine();
    _builder.newLine();
    _builder.append("<table  class=\"tableLL\">");
    _builder.newLine();
    _builder.newLine();
    _builder.append("<thead>");
    _builder.newLine();
    _builder.append("<tr>");
    _builder.newLine();
    _builder.append("<th width=\"12%\" >\u8BBE\u5907\u7F16\u53F7</td>");
    _builder.newLine();
    _builder.append("<th width=\"10%\" >\u8BBE\u5907\u540D\u79F0</td>  ");
    _builder.newLine();
    _builder.append("<th width=\"10%\" >\u89C4\u683C\u578B\u53F7</td>");
    _builder.newLine();
    _builder.append("<th width=\"26%\" >\u5B89\u88C5\u5730\u70B9</td> ");
    _builder.newLine();
    _builder.append("<th width=\"10%\" >\u8BBE\u5907\u7C7B\u578B</td> ");
    _builder.newLine();
    _builder.append("<th width=\"10%\" >\u7EF4\u4FDD\u7C7B\u522B</td> ");
    _builder.newLine();
    _builder.append("<th width=\"12%\" >PM\u8BA1\u5212\u65E5\u671F</td>");
    _builder.newLine();
    _builder.append("<th width=\"10%\" >\u7EF4\u4FDD\u5468\u671F</td>  ");
    _builder.newLine();
    _builder.append("</tr> ");
    _builder.newLine();
    _builder.append("</thead>");
    _builder.newLine();
    _builder.append("<tbody>");
    _builder.newLine();
    _builder.newLine();
    {
      Collection<RCWorkItemPlanAssignment> _workItemPlanAssignments = record.getWorkItemPlanAssignments();
      for(final RCWorkItemPlanAssignment item : _workItemPlanAssignments) {
        _builder.append("<tr>");
        _builder.newLine();
        _builder.append("<td>");
        RCDevicePMPlan _plan = item.getPlan();
        RCDevicePMSpecification _spec = _plan.getSpec();
        RCDevice _device = _spec.getDevice();
        String _sid_1 = _device.getSid();
        _builder.append(_sid_1, "");
        _builder.append("</td> ");
        _builder.newLineIfNotEmpty();
        _builder.append("<td>");
        RCDevicePMPlan _plan_1 = item.getPlan();
        RCDevicePMSpecification _spec_1 = _plan_1.getSpec();
        RCDevice _device_1 = _spec_1.getDevice();
        String _entityName_2 = _device_1.getEntityName();
        _builder.append(_entityName_2, "");
        _builder.append("</td>");
        _builder.newLineIfNotEmpty();
        _builder.append("<td>");
        RCDevicePMPlan _plan_2 = item.getPlan();
        RCDevicePMSpecification _spec_2 = _plan_2.getSpec();
        RCDevice _device_2 = _spec_2.getDevice();
        String _specification = _device_2.getSpecification();
        _builder.append(_specification, "");
        _builder.append("</td> ");
        _builder.newLineIfNotEmpty();
        _builder.append("<td>");
        RCDevicePMPlan _plan_3 = item.getPlan();
        RCDevicePMSpecification _spec_3 = _plan_3.getSpec();
        RCDevice _device_3 = _spec_3.getDevice();
        RCOnsitePosition _location = _device_3.getLocation();
        String _entityName_3 = _location==null?(String)null:_location.getEntityName();
        String _nullsafe_1 = PMWorkItemTemplate.nullsafe(_entityName_3);
        _builder.append(_nullsafe_1, "");
        _builder.append("</td> ");
        _builder.newLineIfNotEmpty();
        _builder.append("<td>");
        RCDevicePMPlan _plan_4 = item.getPlan();
        RCDevicePMSpecification _spec_4 = _plan_4.getSpec();
        RCDevice _device_4 = _spec_4.getDevice();
        RCDeviceType _deviceType = _device_4.getDeviceType();
        String _entityName_4 = _deviceType.getEntityName();
        _builder.append(_entityName_4, "");
        _builder.append("</td> ");
        _builder.newLineIfNotEmpty();
        _builder.append("<td>");
        RCDevicePMPlan _plan_5 = item.getPlan();
        RCDevicePMSpecification _spec_5 = _plan_5.getSpec();
        RCDevicePMType _pmType = _spec_5.getPmType();
        String _entityName_5 = _pmType.getEntityName();
        _builder.append(_entityName_5, "");
        _builder.append("</td> ");
        _builder.newLineIfNotEmpty();
        _builder.append("<td>");
        SimpleDateFormat _simpleDateFormat_2 = new SimpleDateFormat("yyyy-MM-dd");
        RCDevicePMPlan _plan_6 = item.getPlan();
        Date _planDate = _plan_6.getPlanDate();
        String _format_2 = _simpleDateFormat_2.format(_planDate);
        _builder.append(_format_2, "");
        _builder.append("</td> ");
        _builder.newLineIfNotEmpty();
        _builder.append("<td>");
        RCDevicePMPlan _plan_7 = item.getPlan();
        RCDevicePMSpecification _spec_6 = _plan_7.getSpec();
        Integer _intervalInDays = _spec_6.getIntervalInDays();
        _builder.append(_intervalInDays, "");
        _builder.append("</td> ");
        _builder.newLineIfNotEmpty();
        _builder.append("</tr> ");
        _builder.newLine();
      }
    }
    _builder.newLine();
    _builder.append("</toby>");
    _builder.newLine();
    _builder.append("</table>");
    _builder.newLine();
    _builder.newLine();
    _builder.append("<table> ");
    _builder.newLine();
    _builder.newLine();
    _builder.append("<tr> ");
    _builder.newLine();
    _builder.append("<td width=\"11%\" >&nbsp;</td>");
    _builder.newLine();
    _builder.append("<td width=\"23%\" >&nbsp;</td> ");
    _builder.newLine();
    _builder.append("<td width=\"11%\" >&nbsp;</td> ");
    _builder.newLine();
    _builder.append("<td width=\"22%\" >&nbsp;</td> ");
    _builder.newLine();
    _builder.append("<td width=\"11%\" >&nbsp;</td> ");
    _builder.newLine();
    _builder.append("<td width=\"22%\" >&nbsp;</td> ");
    _builder.newLine();
    _builder.append("</tr> ");
    _builder.newLine();
    _builder.append("<tr> ");
    _builder.newLine();
    _builder.append("<td  class=\"tdlabel tdleft tdbottom\">\u5B8C\u5DE5\u8BF4\u660E:</td>");
    _builder.newLine();
    _builder.append("<td colspan=3 class=\"tdcontent\">&nbsp;</td> ");
    _builder.newLine();
    _builder.append("<td class=\"tdlabel tdleft tdbottom\">\u5B8C\u6210\u65F6\u95F4:</td> ");
    _builder.newLine();
    _builder.append("<td class=\"tdcontent\">&nbsp;</td> ");
    _builder.newLine();
    _builder.append("</tr> ");
    _builder.newLine();
    _builder.append("<tr> ");
    _builder.newLine();
    _builder.append("<td colspan=6 >&nbsp;</td> ");
    _builder.newLine();
    _builder.append("</tr> ");
    _builder.newLine();
    _builder.append("<tr> ");
    _builder.newLine();
    _builder.append("<td class=\"tdlabel tdleft tdbottom\">\u7EF4\u4FDD\u4EBA\u5458\uFF1A</td>");
    _builder.newLine();
    _builder.append("<td class=\"tdcontent\">&nbsp;</td> ");
    _builder.newLine();
    _builder.append("<td class=\"tdlabel tdleft tdbottom\">\u73ED\u7EC4\u957F:</td> ");
    _builder.newLine();
    _builder.append("<td class=\"tdcontent\">&nbsp;</td> ");
    _builder.newLine();
    _builder.append("<td class=\"tdlabel tdleft tdbottom\">\u7EF4\u4FDD\u4E3B\u7BA1:</td> ");
    _builder.newLine();
    _builder.append("<td class=\"tdcontent\">&nbsp;</td> ");
    _builder.newLine();
    _builder.append("</tr> ");
    _builder.newLine();
    _builder.newLine();
    _builder.append("</table>");
    _builder.newLine();
    _builder.append("<body>");
    _builder.newLine();
    _builder.append("</html>");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    _builder.append("</body> ");
    _builder.newLine();
    _builder.append("</html>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    return _builder.toString();
  }
}
