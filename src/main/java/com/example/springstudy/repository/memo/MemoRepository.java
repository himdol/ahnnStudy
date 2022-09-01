package com.example.springstudy.repository.memo;

import com.example.springstudy.dto.MemoDto;
import com.example.springstudy.entity.memo.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemoRepository extends JpaRepository<Memo, Long> {

    List<Memo> findAll();

    MemoDto findMemoByMemoSeq(int memoSeq);
}
