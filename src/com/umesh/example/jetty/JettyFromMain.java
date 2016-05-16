package com.umesh.example.jetty;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;


public class JettyFromMain {

	public static void main(String[] args) {
		ContextHandlerCollection contexts = new ContextHandlerCollection();
		contexts.setHandlers(new Handler[] { new AppContextBuilder()
				.buildWebAppContext() });
		final JettyServer jettyServer = new JettyServer();
		jettyServer.setHandler(contexts);
		try {
			jettyServer.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
