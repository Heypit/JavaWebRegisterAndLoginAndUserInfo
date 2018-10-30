package cn.dz.user.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dz.user.domain.Page;
import cn.dz.user.service.PageService;
import cn.dz.user.service.PageServiceImpl;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet({ "/HomeServlet", "/home" })
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		System.out.println("doGet!!!");
		PageService service = new PageServiceImpl();
		int currentPage = 1;
		int count = 10;
		String value = request.getParameter("page");
		if (value != null && !"".equals(value)) {
			currentPage = Integer.parseInt(value);
		}

		Page page = service.findPage(currentPage, count);
		request.setAttribute("page", page);
		request.getRequestDispatcher("/user/page.jsp?page=" + currentPage).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
