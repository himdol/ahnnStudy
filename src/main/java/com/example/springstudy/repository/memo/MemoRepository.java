package com.example.springstudy.repository.memo;

import com.example.springstudy.entity.memo.MemoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemoRepository extends JpaRepository<MemoEntity, Long> {

    List<MemoEntity> findAll();

    @Override
    Optional<MemoEntity> findById(Long aLong);

    @Override
    <S extends MemoEntity> S save(S entity);
}
