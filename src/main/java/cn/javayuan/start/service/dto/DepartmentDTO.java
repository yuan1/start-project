package cn.javayuan.start.service.dto;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link cn.javayuan.start.domain.Department} entity.
 */
public class DepartmentDTO implements Serializable {

    private Long id;

    @NotNull
    private String departmentName;
    private String streetAddress;


    private Long locationId;

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    /**
     * A relationship
     */
    @ApiModelProperty(value = "A relationship")

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        DepartmentDTO departmentDTO = (DepartmentDTO) o;
        if (departmentDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), departmentDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "DepartmentDTO{" +
            "id=" + id +
            ", departmentName='" + departmentName + '\'' +
            ", streetAddress='" + streetAddress + '\'' +
            ", locationId=" + locationId +
            '}';
    }
}
