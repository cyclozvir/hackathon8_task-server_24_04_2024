package org.yaremax.hackathon8_task_24_04_2024.event;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.yaremax.hackathon8_task_24_04_2024.user.UserEntity;
import org.yaremax.hackathon8_task_24_04_2024.exceptions.ResourceNotFoundException;
import org.yaremax.hackathon8_task_24_04_2024.util.ReferenceService;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {
    private final EventRepository eventRepository;
    private final ReferenceService referenceService;

    public List<EventEntity> getAllEvents() {
        return eventRepository.findAll(); // TODO: filter resolved
    }

    public List<EventEntity> getEventsByUser(Long creator_id) {
        UserEntity userReference = referenceService.getUserReferenceById(creator_id);
        return eventRepository.findByCreator(userReference);  // TODO: filter resolved
    }

    public void createEvent(EventDto eventDto, String email) {
        UserEntity userReference = referenceService.getUserReferenceByEmail(email);

        EventEntity event = EventEntity.builder()
                .creator(userReference)
                .title(eventDto.title())
                .description(eventDto.description())
                .created_at(LocalDate.now())
                .build();

        eventRepository.saveAndFlush(event);
    }

    public EventEntity getEventById(Long id) {
        return eventRepository.findById(id)
                .orElseThrow(() ->new ResourceNotFoundException("ніц"));
    }
}
