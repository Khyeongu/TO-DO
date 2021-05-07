package mvc.controllers;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.fx.AbstractController;
import mvc.fx.ModelAndView;
import mvc.models.ScheduleDTO;
import mvc.service.ScheduleService;
import mvc.service.ScheduleServiceImpl;

public class ScheduleInsertAction extends AbstractController {
	ScheduleService scheduleService = ScheduleServiceImpl.getInstance();

	@Override
	public ModelAndView handleRquestInternal(HttpServletRequest request, HttpServletResponse response) {
		Date startDate = Date.valueOf(request.getParameter("startDate"));
		Date endDate = Date.valueOf(request.getParameter("endDate"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int memberNo = Integer.parseInt(request.getParameter("memberNo"));
		
		ScheduleDTO scheduleDTO = new ScheduleDTO();
		scheduleDTO.setStart_date(startDate);
		scheduleDTO.setEnd_date(endDate);
		scheduleDTO.setTitle(title);
		scheduleDTO.setContent(content);
		scheduleDTO.setMember_no(memberNo);
		
		ModelAndView mav = new ModelAndView();
		try {
			boolean pass;
			pass=scheduleService.insertSchedule(scheduleDTO);
			if(pass) {
				mav.setViewName("redirect:scheduleList");
				return mav;
			}
		}catch(Exception e) {
			e.printStackTrace();
			mav.setViewName("redirect:scheduleInsert");
			return mav;
		}
		return null;
	}

}
