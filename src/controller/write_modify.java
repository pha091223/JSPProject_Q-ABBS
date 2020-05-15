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
 * Servlet implementation class write_modify
 */
@WebServlet("/write_modify")
public class write_modify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public write_modify() {
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
		
		String title = request.getParameter("ititle");
		String write_name = request.getParameter("iname");
		String write_id = request.getParameter("iid");
		String text = request.getParameter("icontent");
		
		BoardDAO bDAO = BoardDAO.getInstance();
		
		if(board_no.indexOf("mod")!=-1) {
			board_no = board_no.substring(0, board_no.lastIndexOf("m"));
			if(bDAO.pwdChk(board_no, pwd)) {
				System.out.println("비밀번호 OK :)");
				
				BoardDTO b = new BoardDTO();
				b.setNo(board_no);
				b.setName(write_name);
				b.setId(write_id);
				b.setTitle(title);
				b.setText(text);
				
				String view = "write_modify.jsp";
				request.setAttribute("content", b);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher(view);
				dispatcher.forward(request, response);
			} else {
				System.out.println("비밀번호 NO :(");
			}
		} else if(board_no.indexOf("mod")==-1) {
			if(bDAO.pwdChk(board_no, pwd)) {
				System.out.println("비밀번호 OK :)");
				
				if(text.length()<1) {
					System.out.println("내용없음 :(");
					response.sendRedirect("content?no=" + board_no);
				} else {
					if(bDAO.update(text, board_no)) {
						String view = "content";
						request.setAttribute("no", board_no);
						
						RequestDispatcher dispatcher = request.getRequestDispatcher(view);
						dispatcher.forward(request, response);
						
						System.out.println("수정 OK :)");
					}
				}
			} else {
				System.out.println("비밀번호 NO :(");
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