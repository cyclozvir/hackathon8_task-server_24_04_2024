package org.yaremax.hackathon8_task_24_04_2024.api.event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yaremax.hackathon8_task_24_04_2024.user.UserEntity;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<EventEntity, Long> {
    List<EventEntity> findByCreator(UserEntity creator);
}
