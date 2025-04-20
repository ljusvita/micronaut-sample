/* (C) 2025 */
package com.example;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/math")
public class MathController {

  private final MathService mathService;

  public MathController(MathService mathService) {
    this.mathService = mathService;
  }

  @Get(uri = "/compute/{number}", processes = MediaType.APPLICATION_JSON)
  Integer compute(Integer number) {
    return mathService.compute(number);
  }
}
