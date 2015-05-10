package edu.fudan.langlab.uidl.domain.app.client;

import com.google.gwt.resources.client.ImageResource;

public class WorkbenchCategoryImpl implements WorkbenchPartCategory {

	private String categoryId;
	private String categoryName;
	private ImageResource image;

	public WorkbenchCategoryImpl(String id, String name, ImageResource image){
		this.categoryId = id;
		this.categoryName = name;
		this.image = image;
	}
	public WorkbenchCategoryImpl(String id, String name){
		this.categoryId = id;
		this.categoryName = name;
		this.image = null;
	}
	
	@Override
	public String getCategoryId() {
		return categoryId;
	}

	@Override
	public String getCategoryName() {
		return categoryName;
	}
	
	@Override
	public ImageResource getImage() {
		return image;
	}

}
