package cn.dz.user.web.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.dz.user.domain.User;
import cn.dz.user.service.UserException;
import cn.dz.user.service.UserService;
import cn.itcast.commons.CommonUtils;

/**
 * @author Day
 * 在service加上查询，然后servlet调用此方法，其它和ajax一样 Servlet implementation class
 * RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 请求编码(POST)
		request.setCharacterEncoding("utf-8");
		// 响应编码
		response.setContentType("text/html;charset=utf-8");
		// 依赖UserService
		UserService userService = new UserService();

		/*
		 * 封装表单数据
		 */
		// 表单属性的名称要和User里面的属性名称相同，一句话封装 很方便
		User form = CommonUtils.toBean(request.getParameterMap(), User.class);

		/*
		 * 添加新任务（表单校验） 1.创建一个Map，用来装载所有的表单错误信息 在校验过程中，如果失败，向map添加错误信息，其中key为表单字段名称
		 * 2.校验之后，查看map长度是否大于0，如果大于0，说明有错误信息，就是有错误
		 * >保存map到request域中，保存form到request中，转发到register.jsp
		 * 
		 * 3.如果map为空，说明没有错误信息，向下执行
		 */

		Map<String, String> errors = new HashMap<String, String>();

		HttpSession hs = request.getSession();
		String userProvince = (String) hs.getAttribute("province");
		String userCity = (String) hs.getAttribute("city");
		// System.out.println("从request取到的值："+province1);
		form.setProvince(userProvince);
		form.setCity(userCity);

		String username = form.getUsername();
		if (username == null || username.trim().isEmpty()) {
			errors.put("username", "用户名不能为空！");
		} else if (username.length() < 3 || username.length() > 15) {
			errors.put("username", "用户名长度必须在3~15之间！");
		}

		String password = form.getPassword();
		if (password == null || password.trim().isEmpty()) {
			errors.put("password", "密码不能为空！");
		} else if (password.length() < 3 || password.length() > 15) {
			errors.put("password", "密码长度必须在3~15之间！");
		}

		String sessionVerifyCode = (String) request.getSession().getAttribute("session_vcode");
		String verifyCode = form.getVerifyCode();
		if (verifyCode == null || verifyCode.trim().isEmpty()) {
			errors.put("verifyCode", "验证码不能为空！");
		} else if (verifyCode.length() != 4) {
			errors.put("verifyCode", "验证码长度必须为4");
		} else if (!verifyCode.equalsIgnoreCase(sessionVerifyCode)) {
			errors.put("verifyCode", "验证码错误");
		}
		/*
		 * 判断map是否为空，不为空，说明存在错误
		 */
		if (errors != null && errors.size() > 0) {
			request.setAttribute("errors", errors);
			request.setAttribute("user", form);
			request.getRequestDispatcher("/user/register.jsp").forward(request, response);
			return;
		}

		/*
		 * 2.调用userService的register方法，传递form过去 3.得到异常：获取异常信息，保存到request域，转发到register.jsp
		 * 4.没有异常，输出注册成功
		 */
		try {
			userService.register(form);
			response.getWriter().print("<h1>注册成功</h1><a href='" + request.getContextPath() + "/user/login.jsp" + "'>点击登录</a>");
			System.out.println("成功");
		} catch (UserException e) {
			// 获取异常信息，保存到request域
			request.setAttribute("msg", e.getMessage());
			// 还要保存表单数据到request域中
			request.setAttribute("user", form);
			// 转发到register.jsp
			request.getRequestDispatcher("/user/register.jsp").forward(request, response);
			System.out.println("失败");
		}
	}

}
