package dev.ramos.runnerz.run;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class RunRepository {

    private List<Run> runs = new ArrayList<>();

    List<Run> findAll(){
        return runs;
    }

    Run findById(Integer id){
        return runs.stream().filter(run -> run.id().equals(id)).findFirst().orElse(null);
    }

    @PostConstruct
    private void init(){
        runs.addAll(
            Arrays.asList(
                new Run(1, "First run", LocalDateTime.now(), LocalDateTime.now(), 1, Location.OUTDOOR),
                new Run(2, "Second run", LocalDateTime.now(), LocalDateTime.now(), 1, Location.OUTDOOR),
                new Run(3, "Third run", LocalDateTime.now(), LocalDateTime.now(), 1, Location.OUTDOOR)
            )
        );
    }
}
