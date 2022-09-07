package com.example.springstudy.controller.memo;

import com.example.springstudy.constants.ExceptionConstants;
import com.example.springstudy.dto.MemoDto;
import com.example.springstudy.entity.memo.MemoEntity;
import com.example.springstudy.service.memo.MemoService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class MemoRestController implements ExceptionConstants {

    private MemoService memoService;

    private ExceptionConstants exceptionConstants;

    public MemoRestController(MemoService memoService) {
        this.memoService = memoService;
    }

    @GetMapping("/api/index")
    public List<MemoEntity> findAll() {
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
    public MemoDto save(@RequestBody @Valid MemoDto memoDto) {
        return memoService.save(memoDto);
    }

    @DeleteMapping("/api/forcedel")
    public void deleteById(@RequestBody @Valid MemoDto memoDto) {
        memoService.deleteById(memoDto);
    }

}
