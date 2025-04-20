/* (C) 2025 */
package com.example;

import jakarta.inject.Singleton;

@Singleton
public class MathServiceImpl implements MathService {

  @Override
  public Integer compute(Integer num) {
    return (int) Math.pow(num, 2);
  }
}
