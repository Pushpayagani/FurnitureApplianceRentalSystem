package com.rentease.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;



    import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;
import org.json.*;

    @RestController
    @CrossOrigin
    public class ChatController {

        private final String API_KEY = "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";

        @PostMapping("/chat")
        public String chat(@RequestBody String userMessage) {

            String url = "https://api.openai.com/v1/chat/completions";

            RestTemplate restTemplate = new RestTemplate();

            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", "Bearer " + API_KEY);
            headers.setContentType(MediaType.APPLICATION_JSON);

            String body = "{ \"model\": \"gpt-4o-mini\", \"messages\": [" +
                    "{\"role\":\"system\",\"content\":\"You are a furniture rental assistant\"}," +
                    "{\"role\":\"user\",\"content\":\"" + userMessage + "\"}" +
                    "]}";

            HttpEntity<String> request = new HttpEntity<>(body, headers);

            try {
                String response = restTemplate.postForObject(url, request, String.class);

                JSONObject json = new JSONObject(response);
                return json.getJSONArray("choices")
                        .getJSONObject(0)
                        .getJSONObject("message")
                        .getString("content");

            } catch (Exception e) {
                return "Server busy or API quota exceeded. Try later.";
            }
        }
    }

