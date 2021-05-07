package mvc.models;

import java.sql.SQLException;

public interface ScheduleDAO {
	boolean insertSchedule(ScheduleDTO scheduleDTO) throws SQLException;
}
