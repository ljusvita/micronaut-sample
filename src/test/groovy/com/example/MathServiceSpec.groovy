// MathService의 실제 비즈니스 로직을 테스트하는 클래스입니다.
// 실제 MathServiceImpl을 사용하여 제곱 연산이 올바르게 동작하는지 검증합니다.
package com.example

import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import spock.lang.Specification
import spock.lang.Unroll

@MicronautTest
class MathServiceSpec extends Specification {

    @Inject
    MathServiceImpl mathService

    // 실제 제곱 연산이 올바르게 동작하는지 테스트
    @Unroll
    void "should compute square of #num correctly"() {
        when:
        def result = mathService.compute(num)

        then:
        result == expected

        where:
        num | expected
        2   | 4
        3   | 9
        5   | 25
        10  | 100
        0   | 0
        -2  | 4
    }

    // 경계값 테스트
    void "should handle edge cases"() {
        when:
        def result = mathService.compute(input)

        then:
        result == expected

        where:
        input | expected
        1     | 1
        -1    | 1
        0     | 0
    }
} 