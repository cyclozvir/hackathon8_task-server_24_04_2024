package org.yaremax.hackathon8_task_24_04_2024.models.event;

import java.time.LocalDate;
import java.util.List;

public record EventDto(
        Long id,
        Long creator_id,
        String title,
        String description,
        LocalDate deadline,
        String location,
        String recipientDetails,
        String contactDetails,
        List<Long> categoryIds,
        List<Long> tagIds
) {
}
