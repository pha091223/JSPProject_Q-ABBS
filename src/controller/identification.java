package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class identification
 */
@WebServlet("/identification")
public class identification extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public identification() {
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
		String board_id = request.getParameter("id");
		
		HttpSession session = request.getSession();
		String nowId = (String)session.getAttribute("id");
		
		String view = null;
		
		if(nowId==null) {
			System.out.println("회원전용 :(");
			
			request.setAttribute("userChk", 0);
			
			view = "list.jsp";
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);	
		} else {
			if(board_no!=null) {
				if(nowId.equals(board_id) || nowId.equals("admin")) {
					view = "content?no=" + board_no;
					
					RequestDispatcher dispatcher = request.getRequestDispatcher(view);
					dispatcher.forward(request, response);
				} else if(!nowId.equals(board_id)) {
					System.out.println("열람 권한 없음 :(");
					
					request.setAttribute("userChk", 1);
					
					view = "list.jsp";
					
					RequestDispatcher dispatcher = request.getRequestDispatcher(view);
					dispatcher.forward(request, response);
				}
			} else if(board_no==null) {
				view = "write_form.jsp";
				
				RequestDispatcher dispatcher = request.getRequestDispatcher(view);
				dispatcher.forward(request, response);	
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
