// MathService를 Mocking하여 MathController의 /math/compute 엔드포인트 동작을 검증하는 테스트입니다.
// HTTP 요청을 통해 MathController가 MathService와 올바르게 협력하는지 확인합니다.
package com.example

import io.micronaut.http.HttpRequest
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.annotation.MockBean
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import spock.lang.Specification
import spock.lang.Unroll

import jakarta.inject.Inject

@MicronautTest
class MathCollaboratorSpec extends Specification {

    @Inject
    MathService mathService;

    @Inject
    @Client('/')
    HttpClient client;

    // HTTP 엔드포인트를 통한 MathService 협력 테스트
    @Unroll
    void "should compute #num to #square via HTTP endpoint"() {
        when:
        Integer result = client.toBlocking().retrieve(HttpRequest.GET('/math/compute/10'), Integer)

        then:
        1 * mathService.compute(10) >> Math.pow(num, 2)
        result == square

        where:
        num | square
        2   | 4
        3   | 9
    }

    // 실제 MathServiceImpl 대신 Mock 객체를 사용하도록 설정
    @MockBean(MathServiceImpl)
    MathService mathService() {
        Mock(MathService)
    }
}
