package com.VdoCipherIntegration.backend.repository;

import com.VdoCipherIntegration.backend.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video,Long> {
}
