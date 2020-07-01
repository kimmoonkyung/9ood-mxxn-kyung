package com.fire.moon.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Posts {

    /*
        @Entity
        -> 테이블과 링크될 클래스.
        -> 기본값으로 클래스의 카멜케이스 이름을 언더스코어 네이밍(_)으로 테이블 이름을 매칭한다.
        -> ex) SalesManger.java -> sales_manager table
        -> **Entity 클래스에서는 절대 Setter 메소드를 만들지 않는다.

        @Id
        -> 해당 테이블의 PK 필드를 나타냄.

        @GeneratedValue
        -> PK의 생성 규칙을 나타냄.
        -> 스프링부트 2.0에서는 GenerationType.IDENTITY 옵션을 추가해야만 auto_increment가 된다.
        -> 스프링 부트 2.0 버전과 1.5 버전의 차이는 https://jojoldu.tistory.com/295 에서 참고.

        @Column
        -> 테이블의 칼럼을 나타내며 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 컬럼이 된다.
        -> 사용하는 이유는, 기본 값 외에 추가로 변경이 필요한 옵션이 있으면 사용한다.
        -> 문자열의 경우 VARCHAR(255)가 기본 값인데, 사이즈를 500으로 늘리고 싶거나(ex:title), 타입을 TEXT로 변경하고 싶거나(ex:content)등의 경우에 사용함.

        PS.
        웬만하면 Entity의 PK는 Long타입의 Auto_increment를 추천함(MySQL 기준으로 이렇게 하면 bigint 타입이 됨).
        주민등록번호와 같이 비즈니스상 유니크 키나, 여러키를 조합한 복합키로 PK를 잡을 경우 난감한 상황이 종종 발생.
        (1) FK를 맺을 때 다른 테이블에서 복합키 전부를 갖고 있거나, 중간 테이블을 하나 더 둬야 하는 상황이 발생.
        (2) 인덱스에 좋은 영향을 끼치지 못함.
        (3) 유니크한 조건이 변경될 경우 PK 전체를 수정해야 하는 일이 발생.
        * 주민등록번호, 복합키 등은 유니크 키로 별도로 추가하는것을 추천.

        @NoArgsConstructor
        -> 기본 생성자 자동 추가
        -> public Posts() {}와 같은 효과

        @Getter
        -> 클래스 내 모든 필드의 Getter 메소드를 자동 생성

        @Builder
        -> 해당 클래스의 빌더 패턴 클래스를 생성
        -> 생성자 상단에 선언 시 생성자에 포함 된 빌드만 빌더에 포함.
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
