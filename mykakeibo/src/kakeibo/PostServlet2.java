package kakeibo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 入力フォームの内容を投稿するサーブレット
 */
@WebServlet(name = "postf", urlPatterns = {"/postf"})
public class PostServlet2 extends HttpServlet {

	protected void doGet(HttpServletRequest request,
						 HttpServletResponse response)
			throws ServletException, IOException {
		perform(request, response);
	}

	protected void doPost(HttpServletRequest request,
						  HttpServletResponse response)
			throws ServletException, IOException {
		perform(request, response);
	}

	protected void perform(HttpServletRequest request,
						   HttpServletResponse response)
			throws ServletException, IOException {
		String fx_name = request.getParameter("fx_name");
		String fx_cost = request.getParameter("fx_cost");
		Topic topic = new Topic();
		topic.setFxName(fx_name);
		topic.setFxCost(fx_cost);
		KakeiboController ctrl = KakeiboController.getInstance();
		ctrl.postFixed(topic);
		response.sendRedirect("http://localhost:8080/mykakeibo/Wizard02.jsp");
	}
}
