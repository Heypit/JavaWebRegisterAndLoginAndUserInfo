package cn.dz.user.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dz.user.domain.User;
import cn.dz.user.service.UserException;
import cn.dz.user.service.UserService;
import cn.itcast.commons.CommonUtils;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService userService=new UserService();
		User form=CommonUtils.toBean(request.getParameterMap(), User.class);
		request.setCharacterEncoding("UTF-8");
		String username=request.getParameter("username");
		System.out.println("username="+username);
		
		response.setContentType("text/html;charst=UTF-8");
		PrintWriter pw=response.getWriter();
		String tip=null;
		try {
			tip = userService.find(form);
		} catch (UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pw.write(tip);
		pw.flush();
		pw.close();
	}

}
