// 이 테스트는 Micronaut 애플리케이션이 정상적으로 구동되는지 확인하는 기본 테스트입니다.
// EmbeddedApplication 빈이 정상적으로 주입되고, 애플리케이션이 실행 중임을 검증합니다.
package com.example

import io.micronaut.runtime.EmbeddedApplication
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import spock.lang.Specification
import jakarta.inject.Inject

@MicronautTest
class DemoSpec extends Specification {

    @Inject
    EmbeddedApplication<?> application

    // 애플리케이션이 정상적으로 실행 중인지 확인
    void 'test it works'() {
        expect:
        application.running
    }
}
