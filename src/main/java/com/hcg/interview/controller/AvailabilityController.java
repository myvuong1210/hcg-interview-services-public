package com.hcg.interview.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcg.interview.model.DataResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("public")
public class AvailabilityController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/api/availability")
    public ResponseEntity<DataResponse> invokeAvailability(@RequestParam String startDate, @RequestParam String endDate) throws JsonProcessingException {
        DataResponse dataResponse = new DataResponse();
        String availabilityUrl = "http://localhost:8081/api/availability";
        String result = restTemplate.getForObject(availabilityUrl + "?startDate={startDate}&endDate={endDate}", String.class, startDate, endDate);
        ObjectMapper objectMapper = new ObjectMapper();
        Object data = objectMapper.readValue(result, Object.class);
        dataResponse.setData(data);
        return new ResponseEntity<>(dataResponse, HttpStatus.OK);
    }
}
