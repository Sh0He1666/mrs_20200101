package kakeibo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "toVariable", urlPatterns = "/toVariable")
public class ReadServlet extends HttpServlet {

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
		Topic variable = ctrl.getMsTotalVariableCost();
		Topic food = ctrl.getMsMonthlyFoodCost();
		Topic book = ctrl.getMsMonthlyBookCost();
		Topic utility = ctrl.getMsMonthlyUtilityCost();
		Topic elsec = ctrl.getMsMonthlyElseCost();
		Topic topic = new Topic();
		topic.setTotalVariableCost(variable.getTotalVariableCost());
		topic.setMonthlyFoodCost(food.getMonthlyFoodCost());
		topic.setMonthlyBookCost(book.getMonthlyBookCost());
		topic.setMonthlyUtilityCost(utility.getMonthlyUtilityCost());
		topic.setMonthlyElseCost(elsec.getMonthlyElseCost());
		request.setAttribute("topic", topic);
		request.getRequestDispatcher("/variable.jsp").
			forward(request, response);
	}

}
