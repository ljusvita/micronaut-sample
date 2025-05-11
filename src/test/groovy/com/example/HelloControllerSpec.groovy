package com.example

import io.micronaut.http.HttpRequest
import io.micronaut.http.MediaType
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import spock.lang.Specification

@MicronautTest
class HelloControllerSpec extends Specification {

    @Inject
    @Client("/")
    HttpClient client

    def "test hello endpoint returns correct response"() {
        given: "a request to the hello endpoint"
        def request = HttpRequest.GET("/hello").accept(MediaType.APPLICATION_JSON)

        when: "the request is executed"
        def response = client.toBlocking().retrieve(request)

        then: "the response is not null and contains the expected message"
        response != null
        response == "Hello World"
    }
} 