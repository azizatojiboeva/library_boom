package uz.elmurodov.spring_boot.mapper.organization;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;
import uz.elmurodov.spring_boot.dto.organization.OrganizationCreateDto;
import uz.elmurodov.spring_boot.dto.organization.OrganizationDto;
import uz.elmurodov.spring_boot.dto.organization.OrganizationUpdateDto;
import uz.elmurodov.spring_boot.entity.organization.Organization;
import uz.elmurodov.spring_boot.mapper.base.BaseMapper;


@Mapper(componentModel = "spring")
@Component(value = "organizationMapper")
public interface OrganizationMapper extends BaseMapper<
        Organization,
        OrganizationDto,
        OrganizationCreateDto,
        OrganizationUpdateDto> , uz.elmurodov.spring_boot.mapper.base.Mapper {

    @Override
    @Mapping(target = "logo", ignore = true)
    Organization fromCreateDto(OrganizationCreateDto organizationCreateDto);



    @Override
    @Mapping(target = "logo", ignore = true)
    Organization fromUpdateDto(OrganizationUpdateDto organizationUpdateDto);
}

