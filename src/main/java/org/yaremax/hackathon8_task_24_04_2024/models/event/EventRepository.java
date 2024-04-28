package org.yaremax.hackathon8_task_24_04_2024.models.event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.yaremax.hackathon8_task_24_04_2024.models.user.UserEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<EventEntity, Long> {
    List<EventEntity> findByCreator(UserEntity creator);

    List<EventEntityInfo> findAllProjectedBy();

    Optional<EventEntityInfo> findProjectionById(Long eventId);

}
