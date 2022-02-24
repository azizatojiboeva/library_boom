package uz.elmurodov.spring_boot.services.organization;

import uz.elmurodov.spring_boot.criteria.GenericCriteria;
import uz.elmurodov.spring_boot.dto.organization.OrganizationCreateDto;
import uz.elmurodov.spring_boot.dto.organization.OrganizationDto;
import uz.elmurodov.spring_boot.dto.organization.OrganizationUpdateDto;
import uz.elmurodov.spring_boot.services.base.GenericCrudService;


public interface OrganizationService extends GenericCrudService<
        OrganizationDto,
        OrganizationCreateDto,
        OrganizationUpdateDto,
        GenericCriteria,
        Long> {
}
