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

    @Unroll
    void "should compute #num to #square"() {
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

    @MockBean(MathServiceImpl)
    MathService mathService() {
        Mock(MathService)
    }
}
