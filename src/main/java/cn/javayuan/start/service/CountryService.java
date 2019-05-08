package cn.javayuan.start.service;

import cn.javayuan.start.service.dto.CountryDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link cn.javayuan.start.domain.Country}.
 */
public interface CountryService {

    /**
     * Save a country.
     *
     * @param countryDTO the entity to save.
     * @return the persisted entity.
     */
    CountryDTO save(CountryDTO countryDTO);

    /**
     * Get all the countries.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<CountryDTO> findAll(Pageable pageable);


    /**
     * Get the "id" country.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<CountryDTO> findOne(Long id);

    /**
     * Delete the "id" country.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
