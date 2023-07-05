package com.study.group.controller;


import com.study.group.entity.check_in;
import com.study.group.service.CheckinService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequiredArgsConstructor
public class GroupConrtoller {

    private final CheckinService checkinService;

    @GetMapping("/checkin/write")
    public String checkinWriteForm() {
        return "checkinwrite";
    }

    @PostMapping("/checkin/writepro")
    public String checkinWritePro(check_in checkin, Model model) {
        checkinService.write(checkin);

        model.addAttribute("message", "체크인 작성이 완료되었습니다.");
        model.addAttribute("searchUrl", "/checkin/list");

        return "message";
    }

    @GetMapping("/checkin/list")
    public String checkinlist(Model model, @PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable, String searchKeyword) {

        Page<check_in> list = null;

        if(searchKeyword == null) {
            list = checkinService.checkinList(pageable);
        }
        else {
            list = checkinService.checkinSearchList(searchKeyword, pageable);
        }


        int nowPage = list.getPageable().getPageNumber() + 1;
        int startPage = Math.max(nowPage - 4, 1);
        int endPage = Math.min(nowPage + 5, list.getTotalPages());

        model.addAttribute("list", list);
        model.addAttribute("nowPage", nowPage);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        return "checkinlist";
    }

    @GetMapping("/checkin/view") //localhost:8080/checkin/view?id=1
    public String checkinview(Model model, Integer id){
        model.addAttribute("checkin", checkinService.checkinview(id));
        return "checkinview";
    }

    @GetMapping("/checkin/delete")
    public String checkindelete(Integer id, Model model){
        checkinService.checkindelete(id);

        model.addAttribute("message", "체크인 정보 삭제가 완료되었습니다.");
        model.addAttribute("searchUrl", "/checkin/list");

        return "message";
    }


    @GetMapping("/checkin/modify/{id}")
    public String checkinmodify(@PathVariable("id") Integer id, Model model){
        model.addAttribute("checkin", checkinService.checkinview(id));
        return "checkinmodify";
    }

    @PostMapping("/checkin/update/{id}")
    public String checkinUpdate(@PathVariable("id") Integer id, check_in checkin, Model model){
        check_in checkinTemp = checkinService.checkinview(id);
        checkinTemp.setUser_id(checkin.getUser_id());
        checkinTemp.setCategory(checkin.getCategory());
        checkinTemp.setDay(checkin.getDay());
        checkinTemp.setWeek(checkin.getWeek());

        checkinService.write(checkinTemp);

        model.addAttribute("message", "체크인 정보 수정이 완료되었습니다.");
        model.addAttribute("searchUrl", "/checkin/list");


        return "message";
    }
}
