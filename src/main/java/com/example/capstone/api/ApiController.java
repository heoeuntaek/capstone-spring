package com.example.capstone.api;

import com.example.capstone.dto.UserDto;
import com.example.capstone.entity.Group_tbl;
import com.example.capstone.entity.Schedule;
import com.example.capstone.entity.User;
import com.example.capstone.entity.User_group;
import com.example.capstone.service.GroupService;
import com.example.capstone.service.ScheduleService;
import com.example.capstone.service.UserService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
//로깅 동작에 대한 역할을 수행할 추상 메서드를 제공
@RestController
//rest api 제공
public class ApiController {

    @Autowired
//    필요한 의존 객체의 “타입"에 해당하는 빈을 찾아 주입
    private UserService userService;

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private GroupService groupService;


    @GetMapping("/api/users")
    public List<User> findAlluser() {
        return userService.findAll();
    }

//    @GetMapping("/api/list/{user_name}")
//    public User findByUsername(@PathVariable String user_name) {
//        return userService.findByUsername(user_name);
//    }

    @GetMapping("/api/users/{user_login_id}")
    public User findById(@PathVariable Long user_login_id) {
        return userService.findbyId(user_login_id);
    }

    @GetMapping("/api/user_id/{user_login_id}")
    public User findByUserLoginid(@PathVariable String user_login_id) {
        return userService.findByUserLoginid(user_login_id);
    }


//    @GetMapping("/api/users") // 파라미터로 받음
//    public User findOne(@RequestParam(value = "id", required = false) Long id) {
//        return userService.findOne(id);
//    }

    @PostMapping("/api/users")
    public ResponseEntity<User> userRegister(@RequestBody UserDto dto) {
        User created = userService.userRegister(dto);
        return ResponseEntity.status(HttpStatus.OK).body(created);
        //오류가 났을 경우 오류 코드 반환
    }

    @PostMapping("/api/group")
    public ResponseEntity<Group_tbl> GroupRegister(@RequestBody Group_tbl group_tbl) {
        Group_tbl created = userService.GroupRegister(group_tbl);
        return ResponseEntity.status(HttpStatus.OK).body(created);
    }

    @SneakyThrows
//    Java에서 메서드 선언부에 Throws 를 정의하지 않고도, 검사 된 예외를 Throw 할 수 있도록 하는 Lombok 에서 제공하는 어노테이션입니다.
    @PostMapping("/api/login")
    public ResponseEntity<User> login(@RequestBody UserDto dto) {    //HTTP요청의 내용을 객체에 매핑하기 위해 @RequestBody 를 설정.
        User user = userService.login(dto);
        log.info("로그인 성공");
        return ResponseEntity.status(HttpStatus.OK).body(user);

    }

    //그룹생성 - UserGroup에 user_id, group_id 넣기
    @PostMapping("api/group/{user_id}")
    public ResponseEntity<User_group> CreateGroup(@PathVariable Long user_id, @RequestBody Group_tbl group_tbl) {
        User_group user_group = userService.CreateGroup(user_id, group_tbl);
        log.info("그룹생성 성공{}", user_group.toString());
        return ResponseEntity.status(HttpStatus.OK).body(user_group);

    }

    //그룹 참가- 원래 있던 그룹에 group_code를 가지고 참가
    @PatchMapping("api/group/{user_id}/{group_code}")
    public ResponseEntity<User_group> UpdateGroup(@PathVariable Long user_id, @PathVariable String group_code) {
        User_group user_group = userService.updateGroup(user_id, group_code);
        return ResponseEntity.status(HttpStatus.OK).body(user_group);
    }

    //user_id의 그룹 리스트 반환
    @GetMapping("api/group/grouplist/{user_id}")
    public ResponseEntity<List<Group_tbl>> GetGroupList(@PathVariable Long user_id) {
        List<Group_tbl> user_group = userService.GetGroupList(user_id);
        return ResponseEntity.status(HttpStatus.OK).body(user_group);
    }

    //group_id의 user 리스트 반환
    @GetMapping("api/group/userlist/{group_id}")
    public ResponseEntity<List<User>> GetUserList(@PathVariable Long group_id) {
        List<User> users = userService.GetUserList(group_id);
        log.info("userlist 조회 성공{}", users.toString());
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    //user_id의 group_id 한개 반환
    @GetMapping("api/userGroup/{user_id}/{group_id}")
    public ResponseEntity<User_group> GetuserGroup(@PathVariable Long user_id, @PathVariable Long group_id) {
        User_group user_group = userService.GetuserGroup(user_id, group_id);
        return ResponseEntity.status(HttpStatus.OK).body(user_group);
    }

    @DeleteMapping("api/userGroup/{user_id}/{group_id}")
    public ResponseEntity<User_group> DeleteuserGroup(@PathVariable Long user_id, @PathVariable Long group_id) {
        User_group user_group = userService.DeleteuserGroup(user_id, group_id);
        return ResponseEntity.status(HttpStatus.OK).body(user_group);
    }

    //스케줄

    @PostMapping("api/schedule/{user_id}")
    public ResponseEntity<Schedule> CreateSchedule(@PathVariable Long user_id, @RequestBody Schedule schedule) {
        Schedule schedulesave = scheduleService.CreateSchedule(user_id, schedule);
//        log.info("스케줄 생성 성공{}", schedulesave.toString());
        return ResponseEntity.status(HttpStatus.OK).body(schedulesave);
    }

    //스케줄 1개 리스트
    @GetMapping("api/{user_id}/{schedule_id}")
    public ResponseEntity<Schedule> GetSchedule(@PathVariable Long user_id, @PathVariable Long schedule_id) {
        Schedule schedule = scheduleService.GetSchedule(user_id, schedule_id);
        return ResponseEntity.status(HttpStatus.OK).body(schedule);
    }

    //스케줄 리스트
    @GetMapping("api/schedules/{user_id}")
    public ResponseEntity<List<Schedule>> GetScheduleList(@PathVariable Long user_id) {
        List<Schedule> schedules = scheduleService.GetScheduleList(user_id);
        log.info("스케줄 리스트 조회 성공{}", schedules.toString());
        return ResponseEntity.status(HttpStatus.OK).body(schedules);
    }

    //스케줄 공유
    @PatchMapping("api/schedule/{group_id}/{schedule_id}/{user_id}")
    public ResponseEntity<Schedule> UpdateScheduleWithGroup(@PathVariable Long group_id, @PathVariable Long schedule_id, @PathVariable Long user_id) {
        Schedule schedule = scheduleService.UpdateScheduleWithGroup(group_id, schedule_id, user_id);
        return ResponseEntity.status(HttpStatus.OK).body(schedule);
    }

    //공유스케줄 조회
    @GetMapping("api/schedule/{user_id}/{group_id}")
    public ResponseEntity<Schedule> GetScheduleWithGroup(@PathVariable Long user_id, @PathVariable Long group_id) {
        Schedule schedule = scheduleService.GetScheduleWithGroup(user_id, group_id);
        return ResponseEntity.status(HttpStatus.OK).body(schedule);
    }

    // 그룹 id로 스케줄리스트
    @GetMapping("api/schedules/group/{group_id}")
    public ResponseEntity<List<Schedule>> GetScheduleListWithGroup(@PathVariable Long group_id) {
        List<Schedule> schedules = scheduleService.GetScheduleListWithGroup(group_id);
        log.info("스케줄 리스트 조회 성공{}", schedules.toString());
        return ResponseEntity.status(HttpStatus.OK).body(schedules);
    }

    //
    @PatchMapping("api/group/matchedSchedule/{group_id}")
    public ResponseEntity<Group_tbl> UpdateMatchedSchedule(@PathVariable Long group_id, @RequestBody Group_tbl group_tbl) {
        Group_tbl group_tblsave = groupService.UpdateMatchedSchedule(group_id, group_tbl);
        log.info("그룹 조회 성공{}", group_tblsave.toString());
        return ResponseEntity.status(HttpStatus.OK).body(group_tblsave);
    }

    @GetMapping("api/group/matchedSchedule/{group_id}")
    public ResponseEntity<Group_tbl> GetMatchedSchedule(@PathVariable Long group_id) {
        Group_tbl group_tbl = groupService.GetMatchedSchedule(group_id);
        return ResponseEntity.status(HttpStatus.OK).body(group_tbl);
    }

    //스케줄 삭제
    @DeleteMapping("api/schedule/{schedule_id}")
    public ResponseEntity<Schedule> DeleteSchedule(@PathVariable Long schedule_id) {
        Schedule schedule = scheduleService.DeleteSchedule(schedule_id);
        log.info("스케줄 삭제 성공{}", schedule.toString());
        return ResponseEntity.status(HttpStatus.OK).body(schedule);
    }

}


//    @PostMapping("/api/users{id}")
//    public User create(@PathVariable Long id){
//        return userService.create(id);
//    }
//        User created = userService.create(dto);
//        return ResponseEntity.status(HttpStatus.OK).body(created);
//@PatchMapping("/api/articles/{id}")

//public ResponseEntity<User> update(@PathVariable Long id,  // responseEntity - 상태코드 실을수있음
//                                      //response Entity 에 Article이 담겨서 들어감
//                                      @RequestBody UserDto dto) {  //json 형태의 데이터가 받아짐
//
//    User updated = userService.update(id, dto);
//    return (updated != null) ?  // 비어있지 않다면
//            ResponseEntity.status(HttpStatus.OK).body(updated) :
//            ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//
//}