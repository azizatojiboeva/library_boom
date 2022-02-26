package uz.elmurodov.spring_boot.entity.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable implements BaseEntity, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    protected Long id;

    @CreatedDate
    @CreationTimestamp
    @Column(name = "created_at", columnDefinition = "TIMESTAMP default NOW()")
    private LocalDateTime createdAt;

    @CreatedBy
    @Column(name = "created_by", columnDefinition = "bigint default 1")
    private Long createdBy;

    @LastModifiedDate
    @UpdateTimestamp
    private LocalDateTime updatedAt;


    @LastModifiedBy
    @Column(name = "updated_by",columnDefinition = "bigint default 1")
    private Long updatedBy;

    @Column(name = "is_deleted", nullable = true, columnDefinition = "boolean default false")
    private boolean deleted=false;



}