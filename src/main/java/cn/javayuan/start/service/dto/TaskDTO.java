package cn.javayuan.start.service.dto;

import io.swagger.annotations.ApiModel;

import java.time.Instant;
import java.io.Serializable;
import java.util.Objects;

import cn.javayuan.start.domain.enumeration.TaskStatus;

/**
 * A DTO for the {@link cn.javayuan.start.domain.Task} entity.
 */
@ApiModel(description = "Task entity. @author The JHipster team.")
public class TaskDTO implements Serializable {

    private Long id;

    private String title;

    private String description;

    private Instant startDate;

    private Instant endDate;

    private TaskStatus status;


    private Long jobId;
    private String jobTitle;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Instant getStartDate() {
        return startDate;
    }

    public void setStartDate(Instant startDate) {
        this.startDate = startDate;
    }

    public Instant getEndDate() {
        return endDate;
    }

    public void setEndDate(Instant endDate) {
        this.endDate = endDate;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TaskDTO taskDTO = (TaskDTO) o;
        if (taskDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), taskDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "TaskDTO{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", description='" + description + '\'' +
            ", startDate=" + startDate +
            ", endDate=" + endDate +
            ", status=" + status +
            ", jobId=" + jobId +
            ", jobTitle='" + jobTitle + '\'' +
            '}';
    }
}
