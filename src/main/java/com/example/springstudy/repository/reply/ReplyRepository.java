package com.example.springstudy.repository.reply;

import com.example.springstudy.entity.reply.ReplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReplyRepository extends JpaRepository<ReplyEntity, Integer> {

    @Query(value = "SELECT * from REPLY where SEQ =:#{#paramReply.seq}", nativeQuery = true)
    List<ReplyEntity> testSelectNumberOne(@Param("paramReply") ReplyEntity paramReply);

}
