package jp.co.jjs.java_seminar;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Add
 */
@WebServlet("/jump")
public class Jump extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Jump() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    process(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    process(request,response);
	}

    private void process(HttpServletRequest request,
            HttpServletResponse response)throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String mode = request.getParameter("mode");
        RequestDispatcher dispatcher;
        if(mode.equals("登録")){
            dispatcher = request.getRequestDispatcher("WEB-INF/jsp/add.jsp");
        }
        else if(mode.equals("編集")){
            dispatcher = request.getRequestDispatcher("WEB-INF/jsp/update.jsp");
        }
        else{
            dispatcher = request.getRequestDispatcher("WEB-INF/jsp/delete.jsp");
        }
        dispatcher.forward(request, response);
    }

}
