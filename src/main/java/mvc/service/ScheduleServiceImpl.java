package mvc.service;

import mvc.models.ScheduleDAO;
import mvc.models.ScheduleDAOImpl;
import mvc.models.ScheduleDTO;

public class ScheduleServiceImpl implements ScheduleService {
	private static final ScheduleService scheduleService = new ScheduleServiceImpl();
	private ScheduleDAO scheduleDAO = ScheduleDAOImpl.getInstance();

	private ScheduleServiceImpl() {
		
	}

	@Override
	public boolean insertSchedule(ScheduleDTO scheduleDTO) throws Exception {

		return scheduleDAO.insertSchedule(scheduleDTO);
	}

	public static ScheduleService getInstance() {
		return scheduleService;
	}
}
