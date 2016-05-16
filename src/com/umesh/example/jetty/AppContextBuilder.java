package com.umesh.example.jetty;

import org.eclipse.jetty.webapp.WebAppContext;


public class AppContextBuilder {

	private WebAppContext webAppContext;

	public WebAppContext buildWebAppContext() {
		String classpath = JettyServer.class.getProtectionDomain()
				.getCodeSource().getLocation().toString();
		System.out.println(classpath);
		classpath = classpath.replace("file:", "");
		System.out.println(classpath);
		webAppContext = new WebAppContext();
		System.out.println(webAppContext + "/WEB-INF/web.xml");
		webAppContext.setDescriptor(webAppContext + "/WEB-INF/web.xml");
		webAppContext.setResourceBase(classpath);
		webAppContext.setContextPath("/");
		return webAppContext;
	}
}