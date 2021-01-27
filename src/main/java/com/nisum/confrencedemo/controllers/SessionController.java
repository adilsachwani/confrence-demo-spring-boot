package com.nisum.confrencedemo.controllers;

import com.nisum.confrencedemo.models.Session;
import com.nisum.confrencedemo.repositiories.SessionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/sessions")
public class SessionController {

    @Autowired
    private SessionRepository sessionRepository;

    @GetMapping
    public List<Session> list(){
        return sessionRepository.findAll();
    }

    @GetMapping("{id}")
    public Session get(@PathVariable(name = "id") Long sessionId){
        return sessionRepository.getOne(sessionId);
    }

    @PostMapping
    public Session create(@RequestBody Session session){
        return sessionRepository.saveAndFlush(session);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable(name = "id") Long sessionId){
        sessionRepository.deleteById(sessionId);
    }

    @PutMapping("{id}")
    public Session update(@PathVariable(name = "id") Long sessionId, @RequestBody Session session){
        Session currentSession = sessionRepository.getOne(sessionId);
        BeanUtils.copyProperties(session, currentSession, "sessionId");
        return sessionRepository.saveAndFlush(currentSession);
    }

}