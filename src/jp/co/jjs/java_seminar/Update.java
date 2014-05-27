package jp.co.jjs.java_seminar;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;

    @Resource(name = "jdbc/crud")
    private DataSource ds;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
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
        int count = 0;
        String result = "";
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String sql = "UPDATE BOOKSHELF SET ";
        int flag = 0;
        if(request.getParameter("titlec").equals("1")){
            sql += "TITLE='" + request.getParameter("title") + "' ";
            flag = 1;
        }
        if(request.getParameter("isbnc").equals("1")){
            if(flag == 1){
                sql += ",";
            }
            sql += "ISBN='" + request.getParameter("isbn") + "' ";
            flag = 1;
        }
        if(request.getParameter("authorc").equals("1")){
            if(flag == 1){
                sql += ",";
            }
            sql += "AUTHOR='" + request.getParameter("author") + "' ";
            flag = 1;
        }
        if(request.getParameter("publisherc").equals("1")){
            if(flag == 1){
                sql += ",";
            }
            sql += "PUBLISHER='" + request.getParameter("publisher") + "' ";
            flag = 1;
        }

        int price = Integer.parseInt(request.getParameter("price"));
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/complete.jsp");

        try (Connection con = ds.getConnection();
                PreparedStatement ps = con
                        .prepareStatement(sql)) {
            ps.execute();

        } catch (SQLException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }
        dispatcher.forward(request, response);
    }

}
