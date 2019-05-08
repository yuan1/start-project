package cn.javayuan.start.service.mapper;

import cn.javayuan.start.domain.*;
import cn.javayuan.start.service.dto.DepartmentDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Department} and its DTO {@link DepartmentDTO}.
 */
@Mapper(componentModel = "spring", uses = {LocationMapper.class})
public interface DepartmentMapper extends EntityMapper<DepartmentDTO, Department> {

    @Mapping(source = "location.id", target = "locationId")
    @Mapping(source = "location.streetAddress", target = "streetAddress")
    DepartmentDTO toDto(Department department);

    @Mapping(source = "locationId", target = "location")
    @Mapping(target = "employees", ignore = true)
    Department toEntity(DepartmentDTO departmentDTO);

    default Department fromId(Long id) {
        if (id == null) {
            return null;
        }
        Department department = new Department();
        department.setId(id);
        return department;
    }
}
