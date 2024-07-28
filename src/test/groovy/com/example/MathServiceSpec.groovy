package com.example

import io.micronaut.test.annotation.MockBean
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import spock.lang.Specification
import spock.lang.Unroll

@MicronautTest
class MathServiceSpec extends Specification {

    @Inject
    MathService mathService

    @Unroll("#num 곱하기 4 를 출력해야함")
    void "should compute #num times 4"() {
        when:
        def result = mathService.compute(num)

        then:
        mathService.compute(num) >> num * 4
        result == expected

        where:
        num | expected
        2 | 8
        3 | 12
    }

    @Unroll
    void "should compute #num to #square"() {
        when:
        def result = mathService.compute(num)

        then:
        1 * mathService.compute(num) >> Math.pow(num, 2)
        result == square

        where:
        num | square
        2 | 4
        3 | 9
    }

    @MockBean(MathServiceImpl)
    MathService mathService() {
        Mock(MathService)
    }
}
