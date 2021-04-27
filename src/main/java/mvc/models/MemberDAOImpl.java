package mvc.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAOImpl implements MemberDAO{
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
	public void insertMember(MemberDTO memberDTO) throws SQLException {
		StringBuffer sql = new StringBuffer();
		sql.append("call insert_member(?, ?, ?)");
		
		try (Connection conn = dataSource.getConnection();
				 PreparedStatement ps = conn.prepareStatement(sql.toString())){
				ps.setString(1, memberDTO.getId());
				ps.setString(2, memberDTO.getPw());
				ps.setString(3, memberDTO.getName());
				ps.executeUpdate();			
			}
		
	}

}
