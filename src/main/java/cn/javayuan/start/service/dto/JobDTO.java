package cn.javayuan.start.service.dto;
import java.time.Instant;
import java.io.Serializable;
import java.util.Objects;
import cn.javayuan.start.domain.enumeration.JobStatus;

/**
 * A DTO for the {@link cn.javayuan.start.domain.Job} entity.
 */
public class JobDTO implements Serializable {

    private Long id;

    private String jobTitle;

    private String description;

    private Long minSalary;

    private Long maxSalary;

    private Instant deliveryDate;

    private Instant startDate;

    private Instant endDate;

    private JobStatus status;


    private Long employeeId;
    private String employeeName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(Long minSalary) {
        this.minSalary = minSalary;
    }

    public Long getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(Long maxSalary) {
        this.maxSalary = maxSalary;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Instant getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Instant deliveryDate) {
        this.deliveryDate = deliveryDate;
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

    public JobStatus getStatus() {
        return status;
    }

    public void setStatus(JobStatus status) {
        this.status = status;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        JobDTO jobDTO = (JobDTO) o;
        if (jobDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), jobDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "JobDTO{" +
            "id=" + getId() +
            ", jobTitle='" + getJobTitle() + "'" +
            ", description='" + getDescription() + "'" +
            ", minSalary=" + getMinSalary() +
            ", maxSalary=" + getMaxSalary() +
            ", deliveryDate='" + getDeliveryDate() + "'" +
            ", startDate='" + getStartDate() + "'" +
            ", endDate='" + getEndDate() + "'" +
            ", status='" + getStatus() + "'" +
            ", employee=" + getEmployeeId() +
            ", employeeName='" + getEmployeeName() + '\'' +
            "}";
    }
}
