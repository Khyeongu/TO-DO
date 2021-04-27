package mvc.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.fx.AbstractController;
import mvc.fx.ModelAndView;
import mvc.models.MemberDTO;
import mvc.service.MemberService;
import mvc.service.MemberServiceImpl;

public class LoginAction extends AbstractController {
	MemberService memberService = MemberServiceImpl.getInstance();

	@Override
	public ModelAndView handleRquestInternal(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId(id);
		memberDTO.setPw(pw);
		
		ModelAndView mav = new ModelAndView();
		try {
			boolean pass;
			pass=memberService.loginMember(memberDTO);
			System.out.println(pass);
			if(pass) {
				mav.setViewName("redirect:scheduleList");
				return mav;
			}
			else {
				mav.setViewName("/WEB-INF/views/mainpage.jsp");
				return mav;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
