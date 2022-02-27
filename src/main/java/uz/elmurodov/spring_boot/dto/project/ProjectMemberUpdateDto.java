package uz.elmurodov.spring_boot.dto.project;

import uz.elmurodov.spring_boot.dto.base.GenericDto;

import javax.persistence.Column;

public class ProjectMemberUpdateDto extends GenericDto {


    public ProjectMemberUpdateDto(Long id) {
        super(id);
    }
}
