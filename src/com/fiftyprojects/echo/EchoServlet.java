package com.fiftyprojects.echo;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.*;

public class EchoServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		allRequests(req,resp);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		allRequests(req,resp);
	}

	public void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		allRequests(req,resp);
	}
	public void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		allRequests(req,resp);
	}
	
	public void allRequests(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException, IOException{
		resp.setContentType(req.getParameter("type") != null ? req.getParameter("type") : "text/plain");
		if(req.getParameter("echo") != null){
			resp.getWriter().print(req.getParameter("echo"));
		} else {
			resp.getWriter().println("Echo Server");
			resp.getWriter().println("Path: "+req.getRequestURI());
			resp.getWriter().print("\nHeaders:\n"+getHeaderStr(req));
			resp.getWriter().print("\nParameters:\n"+getDataStr(req.getParameterMap()));
		}
		resp.setStatus( req.getParameter("status") != null ? Integer.parseInt(req.getParameter("status")) : HttpServletResponse.SC_OK );	
	}
	

	public static String getHeaderStr(HttpServletRequest req) {
		String headers = "";
		req.getHeaderNames();
		for (Enumeration e = req.getHeaderNames() ; e.hasMoreElements() ;) {
			String element = (String) e.nextElement();
			String value = req.getHeader(element);
			headers = headers + element + ": " + value + "\n";
		}
		return headers;
	}
	
	public static String getDataStr(Map<String, String[]> map) throws UnsupportedEncodingException {
        String data = "";
        for (Entry<String, String[]> entry : map.entrySet()) {
            String name = entry.getKey();
            String[] values = entry.getValue();
            for(int i=0;i<values.length;i++){
            	data = data + name + ": " + values[i] +"\n";
            }
        }
        return data;
	}
}
