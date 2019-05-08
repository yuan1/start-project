package cn.javayuan.start.service.dto;
import java.time.Instant;
import java.io.Serializable;
import java.util.Objects;
import cn.javayuan.start.domain.enumeration.Language;

/**
 * A DTO for the {@link cn.javayuan.start.domain.JobHistory} entity.
 */
public class JobHistoryDTO implements Serializable {

    private Long id;

    private Instant startDate;

    private Instant endDate;

    private Language language;


    private Long jobId;
    private String jobTitle;

    private Long departmentId;
    private String departmentName;

    private Long employeeId;
    private String employeeName;

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
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

        JobHistoryDTO jobHistoryDTO = (JobHistoryDTO) o;
        if (jobHistoryDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), jobHistoryDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "JobHistoryDTO{" +
            "id=" + id +
            ", startDate=" + startDate +
            ", endDate=" + endDate +
            ", language=" + language +
            ", jobId=" + jobId +
            ", jobTitle=" + jobTitle +
            ", departmentId=" + departmentId +
            ", departmentName=" + departmentName +
            ", employeeId=" + employeeId +
            ", employeeName=" + employeeName +
            '}';
    }
}
