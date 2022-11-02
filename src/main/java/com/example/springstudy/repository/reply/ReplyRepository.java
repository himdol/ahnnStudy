package com.example.springstudy.repository.reply;

import com.example.springstudy.entity.reply.ReplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ReplyRepository extends JpaRepository<ReplyEntity, Integer> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO REPLY (ref,seq, high_seq, dir_seq, reply_writer, reply_comment, del_yn, created_by, created_date, modified_by, modified_date) values (:#{#paramReply.ref},:#{#paramReply.seq}, :#{#paramReply.highSeq},:#{#paramReply.dirSeq},:#{#paramReply.replyWriter}, :#{#paramReply.replyComment}, :#{#paramReply.delYn}, :#{#paramReply.createBy}, :#{#paramReply.createDate}, :#{#paramReply.modifiedBy}, :#{#paramReply.modifiedDate});", nativeQuery = true)
    int saveReply(@Param("paramReply") ReplyEntity paramReply);
    List<ReplyEntity> findAllByHighSeqOrderByRefAscDirSeqAsc(Integer integers);

    @Modifying
    @Transactional
    @Query("UPDATE REPLY r SET r.replyComment = :#{#paramReply.replyComment} where r.seq = :#{#paramReply.seq}")
    int updateReply(@Param("paramReply") ReplyEntity paramReply);

    @Transactional
    int deleteBySeq(Integer integer);
}
