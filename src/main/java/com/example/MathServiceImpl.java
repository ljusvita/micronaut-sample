/* (C) 2025 */
package com.example;

import jakarta.inject.Singleton;

@Singleton
public class MathServiceImpl implements MathService {

  /**
   * 수학 연산 구현 주어진 숫자의 제곱을 계산하여 반환합니다.
   *
   * @param num 제곱을 계산할 숫자
   * @return num의 제곱값
   */
  @Override
  public Integer compute(Integer num) {
    return (int) Math.pow(num, 2);
  }
}
