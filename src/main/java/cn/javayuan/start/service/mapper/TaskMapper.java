package cn.javayuan.start.service.mapper;

import cn.javayuan.start.domain.*;
import cn.javayuan.start.service.dto.TaskDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Task} and its DTO {@link TaskDTO}.
 */
@Mapper(componentModel = "spring", uses = {JobMapper.class})
public interface TaskMapper extends EntityMapper<TaskDTO, Task> {

    @Mapping(source = "job.id", target = "jobId")
    @Mapping(source = "job.jobTitle", target = "jobTitle")
    TaskDTO toDto(Task task);

    @Mapping(source = "jobId", target = "job")
    Task toEntity(TaskDTO taskDTO);

    default Task fromId(Long id) {
        if (id == null) {
            return null;
        }
        Task task = new Task();
        task.setId(id);
        return task;
    }
}
