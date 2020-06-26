package com.mt.schedule.controller;

import com.mt.constants.Code;
import com.mt.pojo.Schedule;
import com.mt.pojo.dto.OrderByScheduleIdDTO;
import com.mt.schedule.service.ScheduleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

import com.mt.pojo.Result;

/**
 * Created by Yeung on 2020/5/27.
 */
@RestController
@Api(tags = "场次管理服务")
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    @GetMapping("/selectAllSchedule")
    @ApiOperation(value = "获取所有场次")
    public Object selectAllSchedule() {
        Result result = new Result(Code.OK, scheduleService.selectAllSchedule());
        return result;
    }

    @PutMapping("/updateSchedule")
    @ApiOperation(value = "更新场次信息")
    public Object updateSchedule(@RequestBody() Schedule schedule) {
        Result result = new Result(Code.OK, scheduleService.updateSchedule(schedule));
        return result;
    }

    @GetMapping("/deleteSchedule")
    @ApiOperation(value = "删除场次")
    public Object deleteScheduleById(@RequestParam("scheduleId") String scheduleId) {
        Result result = new Result(Code.OK, scheduleService.deleteScheduleById(scheduleId));
        return result;
    }

    @PostMapping("/cinema/schedule")
    @ApiOperation(value = "电影院排片上传")
    public Object insertSchedule(@RequestBody() List<Schedule> scheduleList) {
        Result result = new Result(Code.OK, scheduleService.insertSchedule(scheduleList));
        return result;
    }

    @GetMapping("/cinema/{cinemaId}/price")
    @ApiOperation(value = "电影院获取最低价格")
    public BigDecimal selectMinPriceByCinema(@PathVariable("cinemaId") Integer cinemaId) {
        return scheduleService.selectMinPriceByCinema(cinemaId);
    }

    @GetMapping("/cinema/{cinemaId}/film/{filmId}/date")
    @ApiOperation(value = "获取电影日期安排")
    public Object selectTime(@PathVariable("cinemaId") Integer cinemaId, @PathVariable("filmId") Integer filmId) {
        Result result = new Result(Code.OK, scheduleService.selectTime(cinemaId, filmId));
        return result;
    }

    @GetMapping("/cinema/{cinemaId}/film/{filmId}/schedules")
    @ApiOperation(value = "获取具体场次信息列表")
    public Object selectScheduleByTime(@PathVariable("cinemaId") Integer cinemaId, @PathVariable("filmId") Integer filmId, @RequestParam("currentTime") String currentTime) {
        Result result = new Result(Code.OK, scheduleService.selectScheduleByTime(cinemaId, filmId, currentTime));
        return result;
    }

    @GetMapping("/selectScheduleToOrder")
    @ApiOperation(value = "获取订单所需信息")
    public OrderByScheduleIdDTO selectScheduleToOrder(@RequestParam("scheduleId") String scheduleId) {
        return scheduleService.selectScheduleToOrder(scheduleId);
    }
}
