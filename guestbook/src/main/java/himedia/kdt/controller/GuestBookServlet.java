package himedia.kdt.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import learnbyteaching.guestbook.dao.GuestBookDao;
import learnbyteaching.guestbook.dao.GuestBookDaoImpl;
import learnbyteaching.guestbook.vo.BookVo;

@WebServlet(name="guestbook", urlPatterns="/gb")
public class GuestBookServlet extends BaseServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String actionName = req.getParameter("a");
		
		//	a-from -> from.jsp로 요청 제어권 이전 
		if ("deleteform".equals(actionName)) {
			RequestDispatcher rd = getServletContext()
					.getRequestDispatcher("/WEB-INF/views/form.jsp");
			rd.forward(req, resp);
		} else if ("deletefrom".equals(actionName)) {
			GuestBookDao dao = new GuestBookDaoImpl(dbUser, dbPass);
			Integer no = Integer.valueOf(req.getParameter("no"));
			String password = String.valueOf(req.getParameter("password"));
			
			dao.delete(no, password);
			
			//	게시물 홈으로 Redirect
			resp.sendRedirect(req.getContextPath() + "/gb");
		} else {
			//	DAO로부터 데이터 객체를 불러옴 
			GuestBookDao dao = new GuestBookDaoImpl(dbUser, dbPass);
			List<BookVo> list = dao.getList();
			//	요청에 속성으로 추가
			req.setAttribute("list", list);
			
			//	목록 표시 페이지 list.jsp로 요청을 전달
			RequestDispatcher rd = getServletContext()
					.getRequestDispatcher("/WEB-INF/views/index.jsp");
			rd.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		String content = req.getParameter("content");
		
		GuestBookDao dao = new GuestBookDaoImpl(dbUser, dbPass);
		BookVo vo = new BookVo(name, password, content);
		
		boolean success = dao.insert(vo);
		
		if(success) {
			System.out.println("INSERT SUCCESS!");
		} else {
			System.out.println("INSERT FAILED!"); 
		}
		
		//	목록 페이지로 리다이렉트
		resp.sendRedirect(req.getContextPath() + "/gb");
	}
}
