package mvc.models;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAOImpl implements MemberDAO {
	private DataSource dataSource;
	private static final MemberDAO memberDAO = new MemberDAOImpl();

	private MemberDAOImpl() {
		try {
			Context ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/xcimvc");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static MemberDAO getInstance() {
		return memberDAO;
	}

	@Override
	public boolean insertMember(MemberDTO memberDTO) throws SQLException {
		StringBuffer sql = new StringBuffer();
		sql.append("call insert_member(?, ?, ?)");

		try (Connection conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql.toString())) {
			ps.setString(1, memberDTO.getId());
			ps.setString(2, memberDTO.getPw());
			ps.setString(3, memberDTO.getName());
			ps.executeUpdate();
			
			return true;
		}catch(Exception e) {
			return false;
		}

	}

	@Override
	public MemberDTO loginCheck(MemberDTO memberDTO) throws SQLException {
		String sql = "{call select_member_info(?, ?, ?, ?)}";
		MemberDTO check_memberDTO = new MemberDTO();

		try (Connection conn = dataSource.getConnection(); CallableStatement cs = conn.prepareCall(sql)) {
			cs.setString(1, memberDTO.getId());
			cs.setString(2, memberDTO.getPw());
			cs.registerOutParameter(3, java.sql.Types.NUMERIC);
			cs.registerOutParameter(4, java.sql.Types.VARCHAR);

			try {
				cs.executeQuery();
				check_memberDTO.setId(memberDTO.getId());
				check_memberDTO.setNo(cs.getInt(3));
				check_memberDTO.setName(cs.getString(4));
				if(cs.getString(3).length()!=0) {
					return check_memberDTO;
				}
				else {
					return null;
				}
			} catch (SQLException e) {
				return null;
			}

		} catch (Exception e) {
			return null;
		}
	}
}
