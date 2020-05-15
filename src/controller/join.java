package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.MemberDAO;
import db.MemberDTO;

/**
 * Servlet implementation class join
 */
@WebServlet("/join")
public class join extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public join() {
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
		String name = request.getParameter("iname");
		
		MemberDTO m = new MemberDTO();
		m.setId(id);
		m.setPwd(pwd);
		m.setName(name);
		
		MemberDAO mDAO = MemberDAO.getInstance();
		MemberDTO user = mDAO.getOne(m);
		
		String view = "list";
		
		if(user!=null) {
			System.out.println("아이디 NO :(");
		} else {
			if(mDAO.insert(m)) {
				System.out.println("회원가입 :)");
				
				request.setAttribute("joinUser", user);
			}
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
