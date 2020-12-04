package com.example.demo.service;

import com.example.demo.exceptions.NotFoundException;
import com.example.demo.model.Counter;
import com.example.demo.repository.CounterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class CounterService {

    @Value("${spring.datasource.username}")
    private String envVariable;

    private CounterRepository counterRepository;

    @Autowired
    public CounterService(CounterRepository counterRepository, Environment environment) {
        this.counterRepository = counterRepository;
    }

    public String getCounter() {
        Counter counter = findOne();
        counter.setTimesVisited(counter.getTimesVisited() + 1);
        counter = counterRepository.save(counter);
        return "Times visited: " + counter.getTimesVisited() + "<br/>Env variable: " + envVariable;
    }

    public Counter findOne() {
        return counterRepository.findById(1L)
                .orElseThrow(() -> new NotFoundException("Could not retrieve counter!"));
    }

}
