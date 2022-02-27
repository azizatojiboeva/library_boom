package uz.elmurodov.spring_boot.dto.base;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class GenericDto implements Dto {
    private Long id;
}
