/* (C) 2025 */
package com.example;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/math")
public class MathController {

  private final MathService mathService;

  /**
   * MathController 생성자 MathService를 의존성 주입으로 받아 수학 연산을 위임합니다.
   *
   * @param mathService 수학 연산을 수행할 서비스
   */
  public MathController(MathService mathService) {
    this.mathService = mathService;
  }

  /**
   * 수학 연산 엔드포인트 URL 경로에서 숫자를 받아 MathService를 통해 연산을 수행합니다.
   *
   * @param number 계산할 숫자 (URL 경로 파라미터)
   * @return 계산 결과 (제곱값)
   */
  @Get(uri = "/compute/{number}", processes = MediaType.APPLICATION_JSON)
  Integer compute(Integer number) {
    return mathService.compute(number);
  }
}
