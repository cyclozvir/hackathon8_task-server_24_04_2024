package org.yaremax.hackathon8_task_24_04_2024.event;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.yaremax.hackathon8_task_24_04_2024.user.UserEntity;

import java.time.LocalDate;

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

    // TODO: add resolved
}
