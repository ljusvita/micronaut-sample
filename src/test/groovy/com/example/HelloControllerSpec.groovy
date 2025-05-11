package com.example

import io.micronaut.http.HttpRequest
import io.micronaut.http.MediaType
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import spock.lang.Specification
import spock.util.concurrent.PollingConditions

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

    def "test hello endpoint returns correct response asynchronously"() {
        given: "a request to the hello endpoint and polling conditions"
        def request = HttpRequest.GET("/hello").accept(MediaType.APPLICATION_JSON)
        def conditions = new PollingConditions(timeout: 5, delay: 0.1)
        def response = null
        def error = null

        when: "the request is executed asynchronously"
        client.retrieve(request)
            .subscribe(
                { result -> response = result },
                { e -> error = e }
            )

        then: "the response is not null and contains the expected message"
        conditions.eventually {
            assert error == null
            assert response != null
            assert response == "Hello World"
        }
    }
} 