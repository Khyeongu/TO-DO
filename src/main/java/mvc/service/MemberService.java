package mvc.service;

import mvc.models.MemberDTO;

public interface MemberService {
	void insertMember(MemberDTO memberDTO) throws Exception;
	
	boolean loginMember(MemberDTO memberDTO) throws Exception;
}
