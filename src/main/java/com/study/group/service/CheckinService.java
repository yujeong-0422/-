package com.study.group.service;

import com.study.group.entity.check_in;
import com.study.group.repository.CheckinRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CheckinService {


    private final CheckinRepository checkinRepository;

    public void write(check_in checkin) {
        checkinRepository.save(checkin);
    }

    public Page<check_in> checkinList(Pageable pageable) {
        return checkinRepository.findAll(pageable);
    }

    public check_in checkinview(Integer id){
        return checkinRepository.findById(id).get();
    }

    public Page<check_in> checkinSearchList(String searchKeyword, Pageable pageable){
        return checkinRepository.findByCategoryContaining(searchKeyword, pageable);
    }



    public void checkindelete(Integer id) {
        checkinRepository.deleteById(id);
    }
}
