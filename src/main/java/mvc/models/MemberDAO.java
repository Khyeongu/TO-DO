package mvc.models;

import java.sql.SQLException;

public interface MemberDAO {
	boolean insertMember(MemberDTO memberDTO) throws SQLException;
	
	MemberDTO loginCheck(MemberDTO memberDTO) throws SQLException;
}
