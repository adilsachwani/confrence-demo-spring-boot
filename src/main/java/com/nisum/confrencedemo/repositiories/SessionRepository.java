package com.nisum.confrencedemo.repositiories;

import com.nisum.confrencedemo.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {

}
