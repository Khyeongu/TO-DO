package mvc.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.fx.AbstractController;
import mvc.fx.ModelAndView;
import mvc.models.MemberDTO;
import mvc.service.MemberService;
import mvc.service.MemberServiceImpl;

public class MemberRegisterAction extends AbstractController{
	MemberService memberService = MemberServiceImpl.getInstance();

	@Override
	public ModelAndView handleRquestInternal(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId(id);
		memberDTO.setPw(pw);
		memberDTO.setName(name);
		
		ModelAndView mav = new ModelAndView();
		try {
			boolean pass;
			pass=memberService.insertMember(memberDTO);
			if(pass) {
				mav.setViewName("redirect:../todo/mainpage");
				return mav;
			}
		}catch(Exception e) {
			e.printStackTrace();
			mav.setViewName("redirect:register");
			return mav;
		}

		
		
		return null;
	}

}
