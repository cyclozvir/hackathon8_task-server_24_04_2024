package org.yaremax.hackathon8_task_24_04_2024.models.image;

import jakarta.persistence.*;
import lombok.*;
import org.yaremax.hackathon8_task_24_04_2024.models.category.Category;

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

    @OneToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;
}

