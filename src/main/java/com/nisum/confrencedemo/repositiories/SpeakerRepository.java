package com.nisum.confrencedemo.repositiories;

import com.nisum.confrencedemo.models.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakerRepository extends JpaRepository<Speaker, Long> {

}
