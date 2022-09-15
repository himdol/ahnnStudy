package com.example.springstudy.repository.reply;

import com.example.springstudy.entity.reply.ReplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReplyRepository extends JpaRepository<ReplyEntity, Integer> {

    @Query(value = "SELECT a.SEQ from REPLY a where a.SEQ = seq",nativeQuery = true)
    ReplyEntity testSelectNumberOne(int seq);


//    @Query(value = "select * from Account where DATETIMESTAMP >= :dateFrom  AND DATETIMESTAMP < :DATE_FORMAT(curdate(), '%d/%m/%Y')", nativeQuery = true)
//    List<Account> findByDate(@Param("dateFrom") String dateFrom);
//
//    @Query(value = "select * from Account where DATETIMESTAMP >= :dateFrom  AND DATETIMESTAMP < DATE_FORMAT(curdate(), '%d/%m/%Y')", nativeQuery = true)
//    List<Account> findByDate(@Param("dateFrom") String dateFrom);


}
