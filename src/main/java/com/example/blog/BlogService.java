package com.example.blog;

import com.example.blog.domain.Article;
import com.example.blog.dto.AddArticleRequest;
import com.example.blog.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service  // 이거 자체가 빈 등록하는 거임
public class BlogService {
    private final BlogRepository blogRepository;

    public Article save(AddArticleRequest request) {
        return blogRepository.save(request.toEntity());
    }

    public List<Article> findAll() {
        return blogRepository.findAll();
    }

    public Article findById(long id) {
        return blogRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다 : " + id));
    }

    public void delete(long id) {
        blogRepository.deleteById(id);
    }
}
