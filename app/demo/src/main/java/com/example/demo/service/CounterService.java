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

    @Value("${nginx.proxy}")
    private String envHost;

    private CounterRepository counterRepository;

    @Autowired
    public CounterService(CounterRepository counterRepository, Environment environment) {
        this.counterRepository = counterRepository;
    }

    public String getCounter() {
        Counter counter = findOne();
        counter.setTimesVisited(counter.getTimesVisited() + 1);
        counter = counterRepository.save(counter);
        return "Times visited: " + counter.getTimesVisited() + "<br/>Env variable: " + envVariable + "<br/>HOST: " + envHost;
    }

    public Counter findOne() {
        Counter counter = counterRepository.findById(1L).orElse(null);

        if (counter == null) {
            counter = new Counter(0);
            counterRepository.save(counter);
        }

        return counter;
    }

}
