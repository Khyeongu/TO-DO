package mvc.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ScheduleDAOImpl implements ScheduleDAO{
	private DataSource dataSource;
	private static final ScheduleDAO scheduleDAO = new ScheduleDAOImpl();
	
	private ScheduleDAOImpl() {
		try {
			Context ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/xcimvc");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static ScheduleDAO getInstance() {
		return scheduleDAO;
	}

	@Override
	public boolean insertSchedule(ScheduleDTO scheduleDTO) throws SQLException {
		StringBuffer sql = new StringBuffer();
		sql.append("call insert_schedule(?, ?, ?, ?, ?)");

		try (Connection conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql.toString())) {
			ps.setDate(1, scheduleDTO.getStart_date());
			ps.setDate(2, scheduleDTO.getEnd_date());
			ps.setString(3, scheduleDTO.getTitle());
			ps.setString(4, scheduleDTO.getContent());
			ps.setInt(5, scheduleDTO.getMember_no());
			ps.executeUpdate();
			
			return true;
		}catch(Exception e) {
			return false;
		}
	}
}
