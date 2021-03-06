package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.web.shared.device.UIPrimaryAttribute;
import com.uniquesoft.gwt.shared.validation.ValidationErrorItem;
import com.uniquesoft.uidl.validation.IValidator;
import com.uniquesoft.uidl.validation.RuleFactory;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.device.PrimaryAttributeValidator")
public class PrimaryAttributeValidator implements IValidator<UIPrimaryAttribute> {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RuleFactory ruleFactory;
  
  public Collection<ValidationErrorItem> validate(final UIPrimaryAttribute _entity) {
    Collection<ValidationErrorItem> errors = com.google.common.collect.Lists.newArrayList();
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getType());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("参数类型",rule.getMessage(),com.google.common.collect.Lists.newArrayList("type" )));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getAttributeName());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("参数名",rule.getMessage(),com.google.common.collect.Lists.newArrayList("attributeName" )));
    }
    return errors;
    
  }
}
