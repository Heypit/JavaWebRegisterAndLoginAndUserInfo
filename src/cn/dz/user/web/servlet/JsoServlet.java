package cn.dz.user.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dz.user.dao.BarDao;

/**
 * Servlet implementation class JsoServlet
 */
@WebServlet("/JsoServlet")
public class JsoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String num = request.getParameter("num");
		BarDao bDao = new BarDao();
		bDao.update(name, Integer.parseInt(num));
	}

}
