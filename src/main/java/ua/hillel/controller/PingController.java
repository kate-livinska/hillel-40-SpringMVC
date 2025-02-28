package ua.hillel.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ping")
public class PingController {

    @GetMapping(produces = MediaType.TEXT_PLAIN_VALUE)
    public @ResponseBody
    String getHealth() {
        return "OK";
    }
}
