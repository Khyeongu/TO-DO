package mvc.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.fx.AbstractController;
import mvc.fx.ModelAndView;

public class ScheduleInsert extends AbstractController {

	@Override
	public ModelAndView handleRquestInternal(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(request.getParameter("selectedDate"));
		return new ModelAndView("/WEB-INF/views/scheduleInsert.jsp", "selectedDate", request.getParameter("selectedDate"));
	}
	
}
