/* (C) 2025 */
package com.example;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;

@Controller("/hello")
public class HelloController {

  /**
   * Hello World 엔드포인트 GET 요청을 받아 "Hello World" 문자열을 JSON 형태로 반환합니다.
   *
   * @return "Hello World" 문자열
   */
  @Get
  @Produces(MediaType.APPLICATION_JSON)
  public String index() {
    return "Hello World";
  }
}
