package mvc.models;

import java.sql.SQLException;

public interface MemberDAO {
	boolean insertMember(MemberDTO memberDTO) throws SQLException;
	
	boolean loginCheck(MemberDTO memberDTO) throws SQLException;
}
