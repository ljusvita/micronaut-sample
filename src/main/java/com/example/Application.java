/* (C) 2025 */
package com.example;

import io.micronaut.runtime.Micronaut;

public class Application {

  /**
   * 애플리케이션의 메인 메서드 Micronaut 프레임워크를 시작하고 애플리케이션을 실행합니다.
   *
   * @param args 명령행 인수
   */
  public static void main(String[] args) {
    Micronaut.run(Application.class, args);
  }
}
