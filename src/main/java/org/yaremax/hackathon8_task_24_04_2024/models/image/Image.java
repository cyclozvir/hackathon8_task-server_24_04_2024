package org.yaremax.hackathon8_task_24_04_2024.models.image;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "images")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class Image {

    @Id
    @GeneratedValue
    private Long id;

    @Lob
    private byte[] content;

    private String name;

    private String category;
}

