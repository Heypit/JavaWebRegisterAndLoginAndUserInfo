package cn.dz.user.web.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dz.user.domain.User;
import cn.dz.user.service.UserException;
import cn.dz.user.service.UserService;
import cn.itcast.commons.CommonUtils;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");// 请求编码(POST)
		response.setContentType("text/html;charset=utf-8");// 响应编码
		// 依赖UserService
		UserService userService = new UserService();
		// 封装表单数据
		User form = CommonUtils.toBean(request.getParameterMap(), User.class);
		// 调用service的login方法

		/*
		 * 登录页面的校验
		 */
		Map<String, String> errors = new HashMap<String, String>();
		String username = form.getUsername();
		if (username == null || username.trim().isEmpty()) {
			errors.put("username", "用户名不能为空！");
			System.out.println("nihao");
		} else if (username.length() < 3 || username.length() > 15) {
			errors.put("username", "用户名长度必须在3~15之间！");
		}

		String password = form.getPassword();
		if (password == null || password.trim().isEmpty()) {
			errors.put("password", "密码不能为空！");
		} else if (password.length() < 3 || password.length() > 15) {
			errors.put("password", "密码长度必须在3~15之间！");
		}
		if (errors != null && errors.size() > 0) {
			request.setAttribute("errors", errors);
			request.setAttribute("user", form);
			request.getRequestDispatcher("/user/login.jsp").forward(request, response);
			return;
		}

		try {
			User user = userService.login(form);
			request.getSession().setAttribute("sessionUser", user);
//			RequestDispatcher dispatcher=request.getRequestDispatcher("/HomeServlet");
//			dispatcher.forward(request, response);
			response.sendRedirect(request.getContextPath() + "/EchartsWeb1.jsp");
			System.out.println("sessionUser:"+user.getUsername());
			System.out.println("sessionUser:" + user.getProvince() + user.getId());
		} catch (UserException e) {
			request.setAttribute("msg", e.getMessage());
			request.setAttribute("user", form);
			request.getRequestDispatcher("/user/login.jsp").forward(request, response);
		}
	}

}
