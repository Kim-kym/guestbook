<%@page import="learnbyteaching.guestbook.vo.BookVo"%>
<%@page import="learnbyteaching.guestbook.dao.GuestBookDao"%>
<%@page import="learnbyteaching.guestbook.dao.GuestBookDaoImpl"%>
<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
ServletContext context = getServletContext();
String dbUser = context.getInitParameter("dbUser");
String dbPass = context.getInitParameter("dbPass");

GuestBookDao dao = new GuestBookDaoImpl(dbUser, dbPass);

//	폼 데이터 받아오기 
String name = request.getParameter("name");
String password = request.getParameter("password");
String content = request.getParameter("content");

BookVo vo = new BookVo(name, password, content);
dao.insert(vo);

response.sendRedirect("list.jsp");

%>

