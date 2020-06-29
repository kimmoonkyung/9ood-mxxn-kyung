package com.fire.moon.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class HelloResponseDto {

    /*
        @Getter
        -> 선언된 모든 필드의 get 메소드를 생성 해줌.

        @RequiredArgsConstructor
        -> 선언된 모든 final 필드가 포함된 생성자를 생성 해줌.
        -> final이 없는 필드는 생성ㅅ자에 포함되지 않는다.
    */


    private final String name;
    private final int amount;

}
