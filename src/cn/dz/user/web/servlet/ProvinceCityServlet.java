package cn.dz.user.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 基于XML，以POST方式，完成省份-城市二级下拉联动
 * 
 * @author Administrator
 */
@WebServlet("/ProvinceCityServlet")
public class ProvinceCityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String province = request.getParameter("province");

		System.out.println("Servlet里面的值:" + province);

		HttpSession session = request.getSession();
		session.setAttribute("province", province);

		// 通知AJAX异步对象，服务器响应的数据为xml格式的
		response.setContentType("text/xml;charset=UTF-8");
		// 获取字符输出流
		PrintWriter pw = response.getWriter();
		pw.write("<?xml version='1.0' encoding='UTF-8'?>");
		pw.write("<root>");

		if ("安徽".equals(province)) {
			pw.write("<city>宣城</city>");
			pw.write("<city>芜湖</city>");
			pw.write("<city>马鞍山</city>");

		} else if ("上海".equals(province)) {
			pw.write("<city>闵行区</city>");
			pw.write("<city>黄浦区</city>");
			pw.write("<city>浦东区</city>");
			pw.write("<city>普陀区</city>");
		}
		pw.write("</root>");
		pw.flush();
		pw.close();
		String city = request.getParameter("city");
		session.setAttribute("city", city);
		System.out.println("Servlet里面的值:" + city);

	}

}
