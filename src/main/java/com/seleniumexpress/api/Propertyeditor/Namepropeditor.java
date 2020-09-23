package com.seleniumexpress.api.Propertyeditor;

import java.beans.PropertyEditorSupport;

public class Namepropeditor extends PropertyEditorSupport {
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		String caps=text.toUpperCase();
		 setValue(caps);
	}

}
