package crp.kr.api.soccer.controllers;

import crp.kr.api.soccer.domains.Player;
import crp.kr.api.soccer.domains.Schedule;
import crp.kr.api.soccer.services.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * packageName: crp.kr.api.soccer.controllers
 * fileName   : ScheduleController
 * author     : 최은아
 * date       : 2022-05-09
 * desc       :
 * ================================
 * DATE          AUTHOR        NOTE
 * ================================
 * 2022-05-09    최은아       최초 생성
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/schedule")
public class ScheduleController {
    private final ScheduleService service;

    @GetMapping("/findAll")
    public List<Schedule> findAll() {
        return service.findAll();
    }

    @GetMapping("/findAll/sort")
    public List<Schedule> findAll(Sort sort) {
        return service.findAll(sort);
    }

    @GetMapping("/findAll/pageable")
    public Page<Schedule> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("/count")
    public long count() { return service.count(); }

    @DeleteMapping("/delete")
    public String delete(@RequestBody Schedule schedule) {
        return service.delete(schedule);
    }

    @PostMapping("/join")
    public String save(@RequestBody Schedule schedule) {
        return service.save(schedule);
    }

    @GetMapping("/findById/{id}")
    public Optional<Schedule> findById(@PathVariable Long id) { return service.findById(id); }

    @GetMapping("/existsById/{id}")
    public boolean existsById(@PathVariable Long id) {  return service.existsById(id); }

}
