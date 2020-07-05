package com.fire.moon.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {

    /*
        @MappedSuperClass
        - JPA Entity 클래스들이 BaseTimeEntity를 상속 할 경우 필드들(createDate, modifiedDate)도 컬럼으로 인식하도록 한다.

        @EntityListeners
        - BaseTimeEntity 클래스에 Auditing 기능을 포함시킨다.

        @CreatedDate
        - Entity가 생성되어 저장 될 때 시간이 자동 저장된다.

        @LastModifiedDate
        - 조회한 Entity의 값을 변경 할 때 시간이 자동 저장된다.

     */

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;

}
