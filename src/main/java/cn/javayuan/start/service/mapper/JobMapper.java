package cn.javayuan.start.service.mapper;

import cn.javayuan.start.domain.*;
import cn.javayuan.start.service.dto.JobDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Job} and its DTO {@link JobDTO}.
 */
@Mapper(componentModel = "spring", uses = {EmployeeMapper.class, TaskMapper.class})
public interface JobMapper extends EntityMapper<JobDTO, Job> {

    @Mapping(source = "employee.id", target = "employeeId")
    @Mapping(source = "employee.firstName", target = "employeeName")
    JobDTO toDto(Job job);

    @Mapping(source = "employeeId", target = "employee")
    Job toEntity(JobDTO jobDTO);

    default Job fromId(Long id) {
        if (id == null) {
            return null;
        }
        Job job = new Job();
        job.setId(id);
        return job;
    }
}
