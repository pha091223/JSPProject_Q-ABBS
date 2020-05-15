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

/**
 * Servlet implementation class write_delete
 */
@WebServlet("/write_delete")
public class write_delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public write_delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		String board_no = request.getParameter("no");
		String pwd = request.getParameter("ipwd");
		
		HttpSession session = request.getSession();
		String nowId = (String)session.getAttribute("id");
		
		BoardDAO bDAO = BoardDAO.getInstance();
		
		if(!nowId.equals("admin")) {
			if(bDAO.pwdChk(board_no, pwd)) {
				System.out.println("비밀번호 OK :)");
				
				if(bDAO.delete(board_no)) {
					String view = "list";
					
					RequestDispatcher dispatcher = request.getRequestDispatcher(view);
					dispatcher.forward(request, response);
					
					System.out.println("글삭제 OK :)");
				}
			} else {
				System.out.println("비밀번호 NO :(");
			}
		} else if(nowId.equals("admin")) {
			if(pwd.equals("admin")) {
				System.out.println("관리자 비밀번호 OK :)");
				
				if(bDAO.delete(board_no)) {
					String view = "list";
					
					RequestDispatcher dispatcher = request.getRequestDispatcher(view);
					dispatcher.forward(request, response);
					
					System.out.println("관리자 글삭제 OK :)");
				}
			} else {
				System.out.println("관리자 비밀번호 NO :(");
			}
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
