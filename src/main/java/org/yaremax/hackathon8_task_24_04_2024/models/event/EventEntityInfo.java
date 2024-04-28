package org.yaremax.hackathon8_task_24_04_2024.models.event;

import java.time.LocalDate;
import java.util.List;

/**
 * Projection for {@link EventEntity}
 */
public interface EventEntityInfo {
    Long getId();

    String getTitle();

    String getDescription();

    LocalDate getCreated_at();

    LocalDate getDeadline();

    String getLocation();

    String getRecipientDetails();

    String getContactDetails();

    List<CategoryInfo> getCategories();

    List<TagInfo> getTags();

    /**
     * Projection for {@link org.yaremax.hackathon8_task_24_04_2024.models.category.Category}
     */
    interface CategoryInfo {
        Long getId();

        String getName();
    }

    /**
     * Projection for {@link org.yaremax.hackathon8_task_24_04_2024.models.tag.Tag}
     */
    interface TagInfo {
        Long getId();

        String getName();
    }
}