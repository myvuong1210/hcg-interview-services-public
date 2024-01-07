package com.hcg.interview.controller;

import com.hcg.interview.dto.BookingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/public")
public class BookingController {
    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/api/booking")
    public ResponseEntity<String> invokeBooking(@RequestBody BookingDTO bookingDTO) {
        String bookingUrl = "http://localhost:8082/api/booking";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<BookingDTO> requestEntity = new HttpEntity<>(bookingDTO, headers);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(bookingUrl, requestEntity, String.class);
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            System.out.println("Request successful!");
        } else {
            System.out.println("Request failed with status code: " + responseEntity.getStatusCode());
        }
        return responseEntity;
    }

    @PostMapping("/api/change-booking/{bookingId}/change-dates")
    public ResponseEntity<String> invokeChangeBooking(@RequestBody BookingDTO bookingDTO) {
        String bookingUrl = "http://localhost:8082/api/change-booking/{bookingId}/change-dates";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<BookingDTO> requestEntity = new HttpEntity<>(bookingDTO, headers);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(bookingUrl, requestEntity, String.class);
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            System.out.println("Request successful!");
        } else {
            System.out.println("Request failed with status code: " + responseEntity.getStatusCode());
        }
        return responseEntity;
    }

    @DeleteMapping("/api/cancel-booking/{bookingNumber}")
    public ResponseEntity<String> invokeCancelBooking(@RequestBody BookingDTO bookingDTO) {
        String bookingUrl = "http://localhost:8082/api/cancel-booking/{bookingNumber}";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<BookingDTO> requestEntity = new HttpEntity<>(bookingDTO, headers);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(bookingUrl, requestEntity, String.class);
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            System.out.println("Request successful!");
        } else {
            System.out.println("Request failed with status code: " + responseEntity.getStatusCode());
        }
        return responseEntity;
    }
}
