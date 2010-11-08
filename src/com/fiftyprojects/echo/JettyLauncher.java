package com.fiftyprojects.echo;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;




public class JettyLauncher {
    public static void main(String[] args) throws Exception {
    	Server server = new Server( args.length > 0 ? Integer.parseInt(args[0]) : 8888 );
        
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);
 
        context.addServlet(new ServletHolder(new EchoServlet()),"/*");
 
        server.start();
        server.join();
    }
}
