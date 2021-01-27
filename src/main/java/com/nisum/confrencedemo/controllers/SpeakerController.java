package com.nisum.confrencedemo.controllers;

import com.nisum.confrencedemo.models.Speaker;
import com.nisum.confrencedemo.repositiories.SpeakerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/speakers")
public class SpeakerController {

    @Autowired
    private SpeakerRepository speakerRepository;

    @GetMapping
    public List<Speaker> list(){
        return speakerRepository.findAll();
    }

    @GetMapping("{id}")
    public Speaker get(@PathVariable(name = "id")  Long speakerId){
        return speakerRepository.getOne(speakerId);
    }

    @PostMapping
    public Speaker create(@RequestBody Speaker speaker){
        return speakerRepository.saveAndFlush(speaker);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable(name = "id") Long speakerId){
        speakerRepository.deleteById(speakerId);
    }

    @PutMapping("{id}")
    public Speaker update(@PathVariable(name = "id") Long speakerId, @RequestBody Speaker speaker){
        Speaker currentSpeaker = speakerRepository.getOne(speakerId);
        BeanUtils.copyProperties(speaker, currentSpeaker, "speakerId");
        return speakerRepository.saveAndFlush(currentSpeaker);
    }

}