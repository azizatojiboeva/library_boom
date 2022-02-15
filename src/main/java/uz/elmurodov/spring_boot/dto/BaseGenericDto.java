package uz.elmurodov.spring_boot.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BaseGenericDto implements BaseDto {
    private Long id;
}
