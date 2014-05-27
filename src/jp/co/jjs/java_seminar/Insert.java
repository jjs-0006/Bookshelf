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

import book.Book;

/**
 * Servlet implementation class Insert
 */
@WebServlet("/insert")
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;


    @Resource(name = "jdbc/crud")
    private DataSource ds;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Insert() {
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
        Book book = new Book();
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String isbn = request.getParameter("isbn");
        String author = request.getParameter("author");
        String publisher = request.getParameter("publisher");
        int price = Integer.parseInt(request.getParameter("price"));
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/complete.jsp");

        try (Connection con = ds.getConnection();
                PreparedStatement ps = con
                        .prepareStatement("INSERT INTO BOOKSHELF VALUES(?,?,?,?,?,?)")) {
            ps.setInt(1, id);
            ps.setString(2, title);
            ps.setString(3, isbn);
            ps.setString(4, author);
            ps.setString(5, publisher);
            ps.setInt(6, price);
            ps.execute();

        } catch (SQLException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }
        dispatcher.forward(request, response);
    }

}
