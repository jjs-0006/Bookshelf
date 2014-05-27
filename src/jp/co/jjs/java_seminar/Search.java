package jp.co.jjs.java_seminar;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
 * Servlet implementation class Search
 */
@WebServlet("/search")
public class Search extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Resource(name = "jdbc/crud")
    private DataSource ds;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        process(request,response);

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        process(request,response);
    }

    private void process(HttpServletRequest request,
            HttpServletResponse response)throws ServletException, IOException{
        int count = 0;
        String result = "";
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        ArrayList<Book> books = new ArrayList<>();

        String title = request.getParameter("title");
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/result.jsp");

        try (Connection con = ds.getConnection();
                PreparedStatement ps = con
                        .prepareStatement("SELECT * FROM BOOKSHELF WHERE TITLE LIKE '%" + title +  "%'")) {

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Book book = new Book();
                    book.setId(rs.getInt("ID"));
                    book.setTitle(rs.getString("TITLE"));
                    book.setIsbn(rs.getString("ISBN"));
                    book.setAuthor(rs.getString("AUTHOR"));
                    book.setPublisher(rs.getString("PUBLISHER"));
                    book.setPrice(rs.getInt("PRICE"));

                    result += rs.getInt("ID") + " " +  rs.getString("TITLE") + " " + rs.getString("ISBN") + " "
                            + rs.getString("AUTHOR") + " " + rs.getString("PUBLISHER") + " " + rs.getInt("PRICE") + "<br>";
                    count++;
                    books.add(book);

                }
                if(count==0){
                    result = "そんなものはない";
                }
            }

        } catch (SQLException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }
        request.setAttribute("books", books);
        request.setAttribute("count", count);
        request.setAttribute("result", result);
        dispatcher.forward(request, response);
    }

}
