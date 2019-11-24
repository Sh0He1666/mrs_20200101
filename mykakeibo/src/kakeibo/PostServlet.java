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
@WebServlet(name = "post", urlPatterns = {"/post"})
public class PostServlet extends HttpServlet {

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
		String genre = request.getParameter("genre");
		String prname = request.getParameter("prname");
		String cost = request.getParameter("cost");
		Topic topic = new Topic();
		topic.setGenre(genre);
		topic.setPrname(prname);
		topic.setPrcost(cost);
		KakeiboController ctrl = KakeiboController.getInstance();
		ctrl.postTopic(topic);
		response.sendRedirect("http://localhost:8080/mykakeibo/Wizard01.jsp");
	}
}
