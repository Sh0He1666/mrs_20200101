package kakeibo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "toBottom", urlPatterns = "/toBottom")
public class ReadServlet3 extends HttpServlet {

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
		Topic totalCost1 = ctrl.getMsTotalVariableCost();
		Topic totalCost2 = ctrl.getTotalFxCost();
		Topic topic = new Topic();
		topic.setTotalVariableCost(totalCost1.getTotalVariableCost());
		topic.setTotalFxCost(totalCost2.getTotalFxCost());
		request.setAttribute("topic", topic);
		request.getRequestDispatcher("/bottom.jsp").
			forward(request, response);
	}

}
