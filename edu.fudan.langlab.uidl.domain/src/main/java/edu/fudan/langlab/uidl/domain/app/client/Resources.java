package edu.fudan.langlab.uidl.domain.app.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;

public interface Resources extends ClientBundle {

	public static final Resources INSTANCE = GWT.create(Resources.class);

	@Source("App.css")
	@CssResource.NotStrict
	CssResource css();
	
}
