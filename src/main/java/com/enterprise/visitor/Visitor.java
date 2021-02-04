package com.enterprise.visitor;

import com.enterprise.modal.Application;
import com.enterprise.modal.Enterprise;
import com.enterprise.modal.User;

public interface Visitor {
	int visit(Enterprise enterprise);
	int visit(Application application);
	int visit(User user);
}
