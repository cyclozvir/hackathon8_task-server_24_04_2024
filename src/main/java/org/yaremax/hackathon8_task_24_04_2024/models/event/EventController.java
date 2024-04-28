package org.yaremax.hackathon8_task_24_04_2024.models.event;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

//TODO: add resolve event endpoint
@RestController
@RequestMapping("/api/v1/events")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class EventController {
    private final EventService eventService;

    @GetMapping
    public ResponseEntity<List<EventEntityInfo>> getAllEvents() {
        return ResponseEntity.ok(eventService.getAllEventsInfos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventEntityInfo> getEventById(@PathVariable Long id) {
        return ResponseEntity.ok(eventService.getEventInfoById(id));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<EventEntity>> getEventsByUser(@PathVariable Long userId) {
        List<EventEntity> events = eventService.getEventsByUser(userId);
        return ResponseEntity.ok(events);
    }

    @PostMapping
    public ResponseEntity<String> createEvent(Authentication authentication,
                                              @RequestBody EventDto eventDto) {
        eventService.createEvent(eventDto, authentication.getName());
        return ResponseEntity.ok("Success");
    }
}
