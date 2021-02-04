package com.enterprise.calculator;

import com.enterprise.modal.Application;
import com.enterprise.modal.Enterprise;
import com.enterprise.modal.Language;
import com.enterprise.modal.User;
import com.enterprise.visitor.Visitor;

public class CalculateJavaApps implements Visitor {
	
	private int value = 0;

	@Override
	public int visit(Enterprise enterprise) {
		return 0;
	}

	@Override
	public int visit(Application application) {
		if (application.getLanguage() == Language.JAVA) {
			value++;
		}
		return value;
	}

	@Override
	public int visit(User user) {
		return 0;
	}

	public int getValue() {
		return value;
	}

   
}
