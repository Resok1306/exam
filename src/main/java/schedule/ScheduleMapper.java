package schedule;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ScheduleMapper {

	public User findById(int id);

	public void save(User external);

}
