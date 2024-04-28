package org.yaremax.hackathon8_task_24_04_2024.models.event;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/events")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
@Api(tags = "Event Management")
public class EventController {
    private final EventService eventService;

    @ApiOperation(value = "Отримати всі події", notes = "Повертає список всіх подій")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успішно повернуто список подій"),
            @ApiResponse(code = 404, message = "Події не знайдено")
    })
    @GetMapping
    public ResponseEntity<List<EventEntityInfo>> getAllEvents() {
        return ResponseEntity.ok(eventService.getAllEventsInfos());
    }

    @ApiOperation(value = "Отримати подію за ідентифікатором", notes = "Повертає подію за заданим ідентифікатором")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успішно повернуто подію"),
            @ApiResponse(code = 404, message = "Подія не знайдена")
    })
    @GetMapping("/{id}")
    public ResponseEntity<EventEntityInfo> getEventById(@PathVariable Long id) {
        return ResponseEntity.ok(eventService.getEventInfoById(id));
    }

    @ApiOperation(value = "Отримати події за користувачем", notes = "Повертає список подій за ідентифікатором користувача")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успішно повернуто список подій"),
            @ApiResponse(code = 404, message = "Події не знайдено")
    })
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<EventEntity>> getEventsByUser(@PathVariable Long userId) {
        List<EventEntity> events = eventService.getEventsByUser(userId);
        return ResponseEntity.ok(events);
    }

    @ApiOperation(value = "Створити подію", notes = "Створює нову подію")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Подія успішно створена"),
            @ApiResponse(code = 400, message = "Неправильний запит")
    })
    @PostMapping
    public ResponseEntity<String> createEvent(Authentication authentication,
                                              @RequestBody EventDto eventDto) {
        eventService.createEvent(eventDto, authentication.getName());
        return ResponseEntity.ok("Success");
    }
}
