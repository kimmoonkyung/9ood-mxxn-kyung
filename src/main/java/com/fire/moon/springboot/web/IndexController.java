package com.fire.moon.springboot.web;


import com.fire.moon.springboot.config.auth.LoginUser;
import com.fire.moon.springboot.config.auth.dto.SessionUser;
import com.fire.moon.springboot.service.posts.PostsService;
import com.fire.moon.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    /*
        IndexController는 화면용이다.
        **ApiController와 헷갈리지 않기.

        (SessionUser) httpSession.getAttribute("user")
        -> 앞서 작성된 CustomOAuth2UserService에서 로그인 성공 시 세션에 SessionUser를 저장하도록 구성.
        -> 즉, 로그인 성공 시 httpSession.getAttribute("user")에서 값을 가져올 수 있다.

        if (user != null)
        -> 세션에 저장된 값이 있을 때만 model에 userName으로 등록한다.
        -> 세션에 저장된 값이 없으면 model엔 아무런 값이 없는 상태이니 로그인 버튼이 보인다.

        @LoginUser SessionUser user
        -> 기존에 (User) httpSession.getAttribute("user")로 가져오던 세션 정보값이 @LoginUser 어노테이션으로 개선
        -> 이제는 어느 컨트롤러든지 @LoginUser만 사용하면 세션 정보를 가져올 수 있다.

    */

    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        model.addAttribute("posts", postsService.findAllDesc());

        //SessionUser user = (SessionUser) httpSession.getAttribute("user"); // *@LoginUser 추가 후 주석처리.

        if (user != null) {
            model.addAttribute("userName", user.getName());
        }

        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);
        return "posts-update";
    }



}
