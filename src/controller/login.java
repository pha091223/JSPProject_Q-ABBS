package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.MemberDAO;
import db.MemberDTO;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("iid");
		String pwd = request.getParameter("ipwd");
		
		MemberDTO m = new MemberDTO();
		m.setId(id);
		m.setPwd(pwd);
		
		MemberDAO mDAO = MemberDAO.getInstance();
		MemberDTO now = mDAO.getOne(m);
		
		HttpSession session = request.getSession();
		
		String view = null;
		
		if(now!=null) {
			System.out.println("로그인 :)");
			
			session.setAttribute("id", id);
			session.setAttribute("name", now.getName());
			
			request.setAttribute("loginChk", 1);
			
			view = "list";
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
		} else {
			System.out.println("로그인 :(");
			
			request.setAttribute("loginChk", 0);
			
			view = "login_form.jsp";
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
