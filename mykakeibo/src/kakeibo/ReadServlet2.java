package kakeibo;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "toFixed", urlPatterns = "/toFixed")
public class ReadServlet2 extends HttpServlet {

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
		KakeiboController ctrl = KakeiboController.getInstance();
		List<Topic> fixed = ctrl.getFixed();
		Topic totalFxCost = ctrl.getTotalFxCost();
		fixed.add(totalFxCost);
		request.setAttribute("fixed", fixed);
		request.getRequestDispatcher("/fixed.jsp").
			forward(request, response);
	}

}
