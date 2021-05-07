package mvc.service;

import mvc.models.MemberDAO;
import mvc.models.MemberDTO;
import mvc.models.ScheduleDTO;

public interface MemberService {
	boolean insertMember(MemberDTO memberDTO) throws Exception;
	
	MemberDTO loginMember(MemberDTO memberDTO) throws Exception;
	
}
