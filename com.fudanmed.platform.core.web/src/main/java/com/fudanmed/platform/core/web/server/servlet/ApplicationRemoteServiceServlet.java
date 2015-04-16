package com.fudanmed.platform.core.web.server.servlet;

import com.google.gwt.user.server.rpc.RPCRequest;
import com.uniquesoft.gwt.server.service.common.SpringGwtRemoteServiceServlet;

public class ApplicationRemoteServiceServlet extends SpringGwtRemoteServiceServlet {

	private static final long serialVersionUID = -4968059048798982610L;

	@Override
	protected boolean hasLogin() {
//		return false;
		return getThreadLocalRequest().getSession().getAttribute("__userid__") != null;
	}

	
	@Override
	protected boolean requireSession(RPCRequest rpcRequest) {
//		return false;
		return !(rpcRequest.getMethod().getName().equals("login"));
	}
//	@Override
//	protected boolean requireSession(RPCRequest rpcRequest) {
//		return true;
////		return !(rpcRequest.getMethod().getName().equals("login"));
//	}
}
