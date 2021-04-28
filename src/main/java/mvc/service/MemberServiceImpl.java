package mvc.service;

import mvc.models.MemberDAO;
import mvc.models.MemberDAOImpl;
import mvc.models.MemberDTO;

public class MemberServiceImpl implements MemberService{
	private static final MemberService memberService = new MemberServiceImpl();
	private MemberDAO memberDAO = MemberDAOImpl.getInstance();
	
	private MemberServiceImpl() {
		
	}
	
	public static MemberService getInstance() {
		return memberService;
	}

	@Override
	public boolean insertMember(MemberDTO memberDTO) throws Exception {
		return memberDAO.insertMember(memberDTO);
	}

	@Override
	public boolean loginMember(MemberDTO memberDTO) throws Exception {
		return memberDAO.loginCheck(memberDTO);
	}

}
