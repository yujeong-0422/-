package com.study.group.service;

import com.study.group.entity.checkin;
import com.study.group.repository.CheckinRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CheckinService {


    private final CheckinRepository checkinRepository;

    public void write(checkin checkin) {
        checkinRepository.save(checkin);
    }
}
