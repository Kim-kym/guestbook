<%@ page import="learnbyteaching.guestbook.dao.GuestBookDaoImpl"%>
<%@ page import="learnbyteaching.guestbook.dao.GuestBookDao"%>
<%@ page language="java" 
		contentType="text/html; charset=UTF-8"
    	pageEncoding="UTF-8"%>
<%
ServletContext context = getServletContext();
String dbUser = context.getInitParameter("dbUser");
String dbPass = context.getInitParameter("dbPass");

Integer no = Integer.valueOf(request.getParameter("no"));
String password = request.getParameter("password"); 

GuestBookDao dao = new GuestBookDaoImpl(dbUser, dbPass);
dao.delete(no, password);

response.sendRedirect("list.jsp");
%>