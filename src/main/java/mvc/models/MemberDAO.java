package mvc.models;

import java.sql.SQLException;

public interface MemberDAO {
	void insertMember(MemberDTO memberDTO) throws SQLException;
}
