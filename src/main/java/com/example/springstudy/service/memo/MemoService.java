package com.example.springstudy.service.memo;

import com.example.springstudy.dto.MemoDto;
import com.example.springstudy.entity.memo.Memo;
import com.example.springstudy.repository.memo.MemoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemoService {

    private MemoRepository memoRepository;

    public MemoService(MemoRepository memoRepository){
        this.memoRepository = memoRepository;
    }

    public long getCount(){
        return memoRepository.count();
    }

    public List<Memo> findAll(){ return memoRepository.findAll();}

    public MemoDto findByMemoSeq(MemoDto memoDto){
        //todo:: Entity와 DTO 의 간의 변환작업
        return memoRepository.findMemoByMemoSeq(memoDto.getMemoSeq());
    }
}
