package cn.javayuan.start.service.mapper;

import cn.javayuan.start.domain.*;
import cn.javayuan.start.service.dto.EmployeeDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Employee} and its DTO {@link EmployeeDTO}.
 */
@Mapper(componentModel = "spring", uses = {DepartmentMapper.class, UserMapper.class})
public interface EmployeeMapper extends EntityMapper<EmployeeDTO, Employee> {

    @Mapping(source = "department.id", target = "departmentId")
    @Mapping(source = "department.departmentName", target = "departmentName")
    @Mapping(source = "user.id", target = "userId")
    EmployeeDTO toDto(Employee employee);

    @Mapping(source = "departmentId", target = "department")
    @Mapping(source = "userId", target = "user")
    @Mapping(target = "jobs", ignore = true)
    Employee toEntity(EmployeeDTO employeeDTO);

    default Employee fromId(Long id) {
        if (id == null) {
            return null;
        }
        Employee employee = new Employee();
        employee.setId(id);
        return employee;
    }
}
