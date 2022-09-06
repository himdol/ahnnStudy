package com.example.springstudy.service.memo;

import com.example.springstudy.constants.ExceptionConstants;
import com.example.springstudy.dto.MemoDto;
import com.example.springstudy.entity.memo.MemoEntity;
import com.example.springstudy.repository.memo.MemoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemoService implements ExceptionConstants {

    private MemoRepository memoRepository;

    private ExceptionConstants exceptionConstants;

    public MemoService(MemoRepository memoRepository){
        this.memoRepository = memoRepository;
    }

    public long getCount(){
        return memoRepository.count();
    }

    public List<MemoEntity> findAll(){ return memoRepository.findAll();}

    public MemoDto findById(MemoDto memoDto) throws Exception {

        MemoEntity findEntityByMemoSeq = memoRepository.findById(
                                                    MemoEntity.builder()
                                                            .memoSeq(memoDto.getMemoSeq())
                                                            .build()
                                                            .getMemoSeq())
                                            .orElseThrow(() -> new Exception("memoEntityByMemoSeq :: " + NO_VALUE));

        return MemoDto.builderFromEntity(findEntityByMemoSeq);
    }

    public MemoDto save(MemoDto memoDto) {

        MemoEntity afterSaveMemoEntity = memoRepository.save(MemoEntity.builderFromDto(memoDto));
        return MemoDto.builderFromEntity(afterSaveMemoEntity);
    }
}
