package uz.elmurodov.spring_boot.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;
import uz.elmurodov.spring_boot.dto.organization.OrganizationCreateDto;
import uz.elmurodov.spring_boot.dto.organization.OrganizationDto;
import uz.elmurodov.spring_boot.entity.organization.Organization;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface OrganizationMapper {

    /**
     * need to ignore logo from target
     *
     * @param dto
     * @return
     */
    @Mapping(target = "logo", ignore = true)
    Organization fromCreateDto(OrganizationCreateDto dto);

    List<OrganizationDto> toDto(List<Organization> organizations);

    OrganizationDto toDto(Organization organizations);

}
