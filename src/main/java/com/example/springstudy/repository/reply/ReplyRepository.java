package com.example.springstudy.repository.reply;

import com.example.springstudy.entity.reply.ReplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReplyRepository extends JpaRepository<ReplyEntity, Integer> {

    @Query("SELECT a.SEQ from REPLY a where a.SEQ =: seq")
    ReplyEntity testSelectNumberOne(int seq);


}
