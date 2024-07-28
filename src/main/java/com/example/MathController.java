package com.example;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/math")
public class MathController {

    MathService mathService;

    public MathController(MathService mathService) {
        this.mathService = mathService;
    }

    @Get(uri = "/compute/{number}", processes = MediaType.TEXT_PLAIN)
    String compute(Integer number) {
        return mathService.compute(number).toString();
    }
}
