package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.web.shared.project.UIMaintenamceType;
import com.uniquesoft.gwt.shared.validation.ValidationErrorItem;
import com.uniquesoft.uidl.validation.IValidator;
import com.uniquesoft.uidl.validation.RuleFactory;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.project.MaintenamceTypeValidator")
public class MaintenamceTypeValidator implements IValidator<UIMaintenamceType> {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RuleFactory ruleFactory;
  
  public Collection<ValidationErrorItem> validate(final UIMaintenamceType _entity) {
    Collection<ValidationErrorItem> errors = com.google.common.collect.Lists.newArrayList();
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getCode());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("类别代码",rule.getMessage(),com.google.common.collect.Lists.newArrayList("code" )));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getName());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("类别名称",rule.getMessage(),com.google.common.collect.Lists.newArrayList("name" )));
    }
    return errors;
    
  }
}
