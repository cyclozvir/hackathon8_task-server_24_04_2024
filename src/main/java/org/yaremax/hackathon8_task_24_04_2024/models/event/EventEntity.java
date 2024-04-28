package org.yaremax.hackathon8_task_24_04_2024.models.event;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.yaremax.hackathon8_task_24_04_2024.models.category.Category;
import org.yaremax.hackathon8_task_24_04_2024.models.tag.Tag;
import org.yaremax.hackathon8_task_24_04_2024.models.user.UserEntity;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "events")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "creator_id", nullable = false)
    private UserEntity creator;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private LocalDate created_at;

    @Column(nullable = true)
    private LocalDate deadline;

    @ManyToMany
    @JoinTable(
            name = "event_categories",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories;

    @ManyToMany
    @JoinTable(
            name = "event_tags",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<Tag> tags;

    @Column(nullable = true)
    private String location;

    @Column(nullable = true)
    private String recipientDetails;

    @Column(nullable = false)
    private String contactDetails;

    // TODO: add resolved
}
