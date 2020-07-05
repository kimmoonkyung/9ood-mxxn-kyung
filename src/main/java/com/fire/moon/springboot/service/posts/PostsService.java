package com.fire.moon.springboot.service.posts;

import com.fire.moon.springboot.domain.posts.Posts;
import com.fire.moon.springboot.domain.posts.PostsRepository;
import com.fire.moon.springboot.web.dto.PostsResponseDto;
import com.fire.moon.springboot.web.dto.PostsSaveRequestDto;

import com.fire.moon.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {

        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById (Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 업습니다. id=" + id));
        return new PostsResponseDto(entity);
    }

}
