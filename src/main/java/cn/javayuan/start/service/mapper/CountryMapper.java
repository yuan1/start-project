package cn.javayuan.start.service.mapper;

import cn.javayuan.start.domain.*;
import cn.javayuan.start.service.dto.CountryDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Country} and its DTO {@link CountryDTO}.
 */
@Mapper(componentModel = "spring", uses = {RegionMapper.class})
public interface CountryMapper extends EntityMapper<CountryDTO, Country> {

    @Mapping(source = "region.id", target = "regionId")
    @Mapping(source = "region.regionName", target = "regionName")
    CountryDTO toDto(Country country);

    @Mapping(source = "regionId", target = "region")
    @Mapping(target = "departments", ignore = true)
    Country toEntity(CountryDTO countryDTO);

    default Country fromId(Long id) {
        if (id == null) {
            return null;
        }
        Country country = new Country();
        country.setId(id);
        return country;
    }
}
