package mvc.service;

import mvc.models.ScheduleDTO;

public interface ScheduleService {

	boolean insertSchedule(ScheduleDTO scheduleDTO) throws Exception;
}
