package org.yaremax.hackathon8_task_24_04_2024.models.event;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.yaremax.hackathon8_task_24_04_2024.exceptions.ResourceNotFoundException;
import org.yaremax.hackathon8_task_24_04_2024.models.category.Category;
import org.yaremax.hackathon8_task_24_04_2024.models.tag.Tag;
import org.yaremax.hackathon8_task_24_04_2024.models.user.UserEntity;
import org.yaremax.hackathon8_task_24_04_2024.util.ReferenceService;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {
    private final EventRepository eventRepository;
    private final ReferenceService referenceService;

    public List<EventEntityInfo> getAllEventsInfos() {
        return eventRepository.findAllProjectedBy();
    }

    public List<EventEntity> getEventsByUser(Long creator_id) {
        UserEntity userReference = referenceService.getUserReferenceById(creator_id);
        return eventRepository.findByCreator(userReference);
    }

    public void createEvent(EventDto eventDto, String email) {
        UserEntity userReference = referenceService.getUserReferenceByEmail(email);

        List<Category> categories = eventDto.categoryIds().stream()
                .map(referenceService::getCategoryReferenceById)
                .toList();

        List<Tag> tags = eventDto.tagIds().stream()
                .map(referenceService::getTagReferenceById)
                .toList();

        EventEntity event = EventEntity.builder()
                .creator(userReference)
                .title(eventDto.title())
                .description(eventDto.description())
                .created_at(LocalDate.now())
                .deadline(eventDto.deadline())
                .location(eventDto.location())
                .recipientDetails(eventDto.recipientDetails())
                .contactDetails(eventDto.contactDetails())
                .categories(categories)
                .tags(tags)
                .build();

        eventRepository.saveAndFlush(event);
    }

    public EventEntityInfo getEventInfoById(Long id) {
        return eventRepository.findProjectionById(id)
                .orElseThrow(() ->new ResourceNotFoundException("ніц"));
    }
}
