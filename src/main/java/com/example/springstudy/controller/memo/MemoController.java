package com.example.springstudy.controller.memo;

import com.example.springstudy.constants.ExceptionConstants;
import com.example.springstudy.dto.MemoDto;
import com.example.springstudy.entity.memo.MemoEntity;
import com.example.springstudy.service.memo.MemoService;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class MemoController implements ExceptionConstants {

    private MemoService memoService;

    private ExceptionConstants exceptionConstants;

    public MemoController(MemoService memoService) {
        this.memoService = memoService;
    }

    @GetMapping("/api/count")
    public long getCount(){
        return memoService.getCount();
    }

    @GetMapping("/api/index")
    public List<MemoEntity> findAll(){
        return memoService.findAll();
    }

    @PostMapping("/api/detail")
    public MemoDto findById(@RequestBody MemoDto memoDto) throws Exception {
        if (memoDto.getMemoSeq() != 0) {
            return memoService.findById(memoDto);
        } else {
            return MemoDto.builder()
                    .memoSeq(0)
                    .memoTitle("실패")
                    .memoContent("SEQ 번호가 맞지않습니다.")
                    .build();
        }
    }

    @GetMapping("/api/modify")
    public MemoDto save(@RequestBody @Valid MemoDto memoDto){
        return memoService.save(memoDto);
    }

    @GetMapping("/test")
    public void test(@RequestBody MemoDto d){
        //TEST 목적 : json 으로 받아올 때 ObjectUtils 의 isEmpty를 사용하면 값이 없어도 True 반환 왜?
        if(Boolean.FALSE.equals(ObjectUtils.isEmpty(d))){
            System.out.println("찍히니?");
        }
    }



}
