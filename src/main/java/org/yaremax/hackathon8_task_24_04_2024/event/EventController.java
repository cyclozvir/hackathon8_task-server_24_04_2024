package org.yaremax.hackathon8_task_24_04_2024.event;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//TODO: add resolve event endpoint
@RestController
@RequestMapping("/api/v1/events")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class EventController {
    private final EventService eventService;

    @GetMapping
    public ResponseEntity<List<EventEntity>> getAllEvents() {
        List<EventEntity> events = eventService.getAllEvents();
        return ResponseEntity.ok(events);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<EventEntity>> getEventsByUser(@PathVariable Long userId) {
        List<EventEntity> events = eventService.getEventsByUser(userId);
        return ResponseEntity.ok(events);
    }

    @PostMapping
    public ResponseEntity<String> createEvent(@RequestBody EventDto eventDto) {
        eventService.createEvent(eventDto);
        return ResponseEntity.ok("Success");
    }
}
