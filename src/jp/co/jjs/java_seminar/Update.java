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
@WebServlet("/update")
public class Update extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Resource(name = "jdbc/crud")
    private DataSource ds;
    private int flag = 0;
    private String sql;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
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
        process(request, response);

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        process(request, response);
    }

    private void process(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        sql = "UPDATE BOOKSHELF SET ";
        check("title", request);
        check("isbn", request);
        check("author", request);
        check("publisher", request);
        check("price", request);
        sql += " WHERE TITLE='" + request.getParameter("oldtitle") + "'";
        RequestDispatcher dispatcher = request
                .getRequestDispatcher("WEB-INF/jsp/complete.jsp");
        try (Connection con = ds.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.execute();

        } catch (SQLException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }
        dispatcher.forward(request, response);
    }

    private void check(String param, HttpServletRequest request) {

        if (request.getParameter(param + "c") != null) {
            if (flag == 1) {
                sql += ",";
            }
            if (param.equals("price")) {
                sql += param.toUpperCase() + "=" + request.getParameter(param);
            } else {
                sql += param.toUpperCase() + "='" + request.getParameter(param) + "'";
            }
            flag = 1;
        }
    }

}
