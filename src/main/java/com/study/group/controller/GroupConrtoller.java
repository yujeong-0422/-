package com.study.group.controller;


import com.study.group.entity.checkin;
import com.study.group.service.CheckinService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class GroupConrtoller {

    private final CheckinService checkinService;

    @GetMapping("/checkin/write")
    public String checkinWriteForm() {
        return "checkinwrite";
    }

    @PostMapping("/checkin/writepro")
    public String checkinWritePro(checkin checkin) {
        checkinService.write(checkin);
        return "";
    }

    @GetMapping("/checkin/list")
    public String checkinlist() {
        return "checkinlist";
    }
}
