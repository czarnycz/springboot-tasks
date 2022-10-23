package com.codecool.spingboot_tasks.request_counter.service;

import com.codecool.spingboot_tasks.request_counter.model.Statistics;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class RequestCountStatsService {

    public static String GET = "GET";
    public static String POST = "POST";
    public static String PUT = "PUT";
    public static String DELETE = "DELETE";
    public static String PATCH = "PATCH";
    /*
     * Map holding statistics of methods execution. key is method name: GET,PUT etc.
     * value is and integer number representing number of executions
     */
    private final Map<String, Integer> stats = new HashMap<>();

//    @PostConstruct
//    public void init(){
//        stats.put(GET,0);
//        stats.put(POST,0);
//        stats.put(PUT,0);
//        stats.put(DELETE,0);
//        stats.put(PATCH,0);
//        System.out.println("obiekt bedzie utworzony");
//    }

    public void increaseCounter(String method) throws Exception {
        {
            Integer currentValue = stats.getOrDefault(method,0);
            currentValue++;
            stats.put(method, currentValue);
        }
    }

    public List<Statistics> getStatistics() {
        List<Statistics> result = new LinkedList<>();

        for(String key: stats.keySet()){
            result.add(new Statistics(key, stats.get(key)));
        }

        return result;
    }
}