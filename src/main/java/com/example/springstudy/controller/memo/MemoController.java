package com.example.springstudy.controller.memo;

import com.example.springstudy.dto.MemoDto;
import com.example.springstudy.entity.memo.MemoEntity;
import com.example.springstudy.service.memo.MemoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemoController {

    private MemoService memoService;

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
        return memoService.findById(memoDto);
    }

}
