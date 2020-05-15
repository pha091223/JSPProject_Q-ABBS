package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.BoardDAO;
import db.BoardDTO;

/**
 * Servlet implementation class write_input
 */
@WebServlet("/write_input")
public class write_input extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public write_input() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		String write_name = (String)session.getAttribute("name");
		
		System.out.println(write_name);
		
		String write_id = request.getParameter("iid");
		String title = request.getParameter("ititle");
		String text = request.getParameter("icontent");
		String write_pwd = request.getParameter("ipwd");
		
		BoardDTO b = new BoardDTO();
		b.setName(write_name);
		b.setId(write_id);
		b.setTitle(title);
		b.setText(text);
		b.setPwd(write_pwd);
		
		BoardDAO bDAO = BoardDAO.getInstance();
		
		if(bDAO.insert(b)) {
			System.out.println("글쓰기 OK :)");
			
			String view = "list";
			
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
