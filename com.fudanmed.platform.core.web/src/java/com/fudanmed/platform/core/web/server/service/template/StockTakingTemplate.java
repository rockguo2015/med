package com.fudanmed.platform.core.web.server.service.template;

import com.fudanmed.platform.core.common.RCSystemParameter;
import com.fudanmed.platform.core.warehouse.RCProduceSpecificationUnit;
import com.fudanmed.platform.core.warehouse.RCProductSpecification;
import com.fudanmed.platform.core.warehouse.RCStockTakingItem;
import com.fudanmed.platform.core.warehouse.RCStockTakingList;
import com.fudanmed.platform.core.warehouse.RCStockTakingRecord;
import com.fudanmed.platform.core.warehouse.RCWarehouse;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class StockTakingTemplate {
  public static String template(final RCStockTakingList stockTaking, final RCSystemParameter parameter) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<html> ");
    _builder.newLine();
    _builder.append("<head> ");
    _builder.newLine();
    _builder.append("<title>\u76D8\u70B9\u5355</title> ");
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
    _builder.append("width:22cm;/*\u53EA\u6709\u8FD9\u4E2A\u548C\u62A5\u4FEE\u5355\u8BBE\u7F6E\u7684\u4E0D\u540C*/");
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
    _builder.append("\u5DE5\u7A0B\u4ED3\u5E93\u76D8\u70B9\u5355</h2>");
    _builder.newLineIfNotEmpty();
    _builder.append("<table> ");
    _builder.newLine();
    _builder.append("<tr> ");
    _builder.newLine();
    _builder.append("<td width=\"10%\" class=\"tdlabel tdleft tdbottom\">\u76D8\u70B9\u5355\u53F7:</td>");
    _builder.newLine();
    _builder.append("<td width=\"25%\" class=\"tdcontent\">");
    RCStockTakingRecord _stockTakingRecord = stockTaking.getStockTakingRecord();
    String _sid = _stockTakingRecord==null?(String)null:_stockTakingRecord.getSid();
    _builder.append(_sid, "");
    _builder.append("</td> ");
    _builder.newLineIfNotEmpty();
    _builder.append("<td width=\"10%\" class=\"tdlabel tdleft tdbottom\">\u76D8\u70B9\u4ED3\u5E93:</td> ");
    _builder.newLine();
    _builder.append("<td width=\"25%\" class=\"tdcontent\">");
    RCWarehouse _warehouse = stockTaking.getWarehouse();
    String _entityName = _warehouse.getEntityName();
    _builder.append(_entityName, "");
    _builder.append("</td> ");
    _builder.newLineIfNotEmpty();
    _builder.append("<td width=\"10%\" class=\"tdlabel tdleft tdbottom\">\u76D8\u70B9\u65F6\u95F4:</td> ");
    _builder.newLine();
    _builder.append("<td width=\"20%\" class=\"tdcontent\">");
    SimpleDateFormat _simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date _date = stockTaking.getDate();
    String _format = _simpleDateFormat.format(_date);
    _builder.append(_format, "");
    _builder.append("</td> ");
    _builder.newLineIfNotEmpty();
    _builder.append("</tr> ");
    _builder.newLine();
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
    _builder.append("<th width=\"15%\" >\u6750\u6599\u540D\u79F0</td>");
    _builder.newLine();
    _builder.append("<th width=\"20%\" >\u6761\u7801</td>  ");
    _builder.newLine();
    _builder.append("<th width=\"10%\" >\u89C4\u683C</td>");
    _builder.newLine();
    _builder.append("<th width=\"10%\" >\u5355\u4F4D</td> ");
    _builder.newLine();
    _builder.append("<th width=\"10%\" class=\"tdright\">\u8D26\u8F7D\u6570</td> ");
    _builder.newLine();
    _builder.append("<th width=\"10%\" >\u5B9E\u76D8\u6570</td> ");
    _builder.newLine();
    _builder.append("<th width=\"10%\" >\u5DEE\u5F02</td> ");
    _builder.newLine();
    _builder.append("<th width=\"15%\" >\u5907\u6CE8</td> ");
    _builder.newLine();
    _builder.append("</tr> ");
    _builder.newLine();
    _builder.append("</thead>");
    _builder.newLine();
    _builder.append("<tbody>");
    _builder.newLine();
    {
      Collection<RCStockTakingItem> _items = stockTaking.getItems();
      for(final RCStockTakingItem item : _items) {
        _builder.append("<tr>");
        _builder.newLine();
        _builder.append("<td>");
        RCProductSpecification _productSpec = item.getProductSpec();
        String _entityName_1 = _productSpec.getEntityName();
        _builder.append(_entityName_1, "");
        _builder.append("</td> ");
        _builder.newLineIfNotEmpty();
        _builder.append("<td>");
        RCProductSpecification _productSpec_1 = item.getProductSpec();
        String _sid_1 = _productSpec_1.getSid();
        _builder.append(_sid_1, "");
        _builder.append("</td> ");
        _builder.newLineIfNotEmpty();
        _builder.append("<td>");
        RCProductSpecification _productSpec_2 = item.getProductSpec();
        String _typeDesc = _productSpec_2.getTypeDesc();
        _builder.append(_typeDesc, "");
        _builder.append("</td> ");
        _builder.newLineIfNotEmpty();
        _builder.append("<td>");
        RCProductSpecification _productSpec_3 = item.getProductSpec();
        RCProduceSpecificationUnit _unit = _productSpec_3.getUnit();
        String _entityName_2 = _unit==null?(String)null:_unit.getEntityName();
        _builder.append(_entityName_2, "");
        _builder.append("</td> ");
        _builder.newLineIfNotEmpty();
        _builder.append("<td class=\"tdright\">");
        Integer _realQuantity = item.getRealQuantity();
        _builder.append(_realQuantity, "");
        _builder.append("</td> ");
        _builder.newLineIfNotEmpty();
        _builder.append("<td>&nbsp;</td> ");
        _builder.newLine();
        _builder.append("<td>&nbsp;</td> ");
        _builder.newLine();
        _builder.append("<td>&nbsp;</td> ");
        _builder.newLine();
        _builder.append("</tr>  ");
        _builder.newLine();
      }
    }
    _builder.append("</toby>");
    _builder.newLine();
    _builder.append("</table>");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    _builder.append("<table>");
    _builder.newLine();
    _builder.append("<tr> ");
    _builder.newLine();
    _builder.append("<td width=\"40%\" class=\"tdlabel tdleft tdbottom\">&nbsp;</td>");
    _builder.newLine();
    _builder.append("<td width=\"12%\" class=\"tdlabel tdleft tdbottom\">\u76D8\u70B9\u5458:</td> ");
    _builder.newLine();
    _builder.append("<td width=\"18%\" class=\"tdcontent\">&nbsp;</td> ");
    _builder.newLine();
    _builder.append("<td width=\"12%\" class=\"tdlabel tdleft tdbottom\">\u4ED3\u5E93\u7BA1\u7406\u5458:</td> ");
    _builder.newLine();
    _builder.append("<td width=\"18%\" class=\"tdcontent\">&nbsp;</td>  ");
    _builder.newLine();
    _builder.append("</tr> ");
    _builder.newLine();
    _builder.append("</table>");
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
    _builder.append("\t");
    _builder.newLine();
    return _builder.toString();
  }
}
