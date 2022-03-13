package contracts.sbcard.findCards

import org.springframework.cloud.contract.spec.Contract

// How to write:    https://cloud.spring.io/spring-cloud-contract/2.0.x/multi/multi__contract_dsl.html

Contract.make {
    priority 1
    name("고객이 소유한 스타벅스카드 리스트 조회용 API")
    description (
            ''' 고객이 소유한 스타벅스카드 리스트를 조회하고 반환한다.
        given:
            Input
        when:
            Something happens
        then:
            Output
            '''
    )
    request {
        method GET()
        urlPath("/sbcard/v1/cards/rabbit001")
    }

    response {
        status OK()
        headers {
            contentType(applicationJson())
        }
        body([
                [
                        cardSeq     : $(regex('[0-9]{10}')),
                        cardNumber  : $(regex('[0-9]{16}')),
                        balance     : 5000,
                        customerId  : fromRequest().path(3)
                ],
                [
                        cardSeq     : $(regex('[0-9]{10}')),
                        cardNumber  : $(regex('[0-9]{16}')),
                        balance     : 100,
                        customerId  : fromRequest().path(3)
                ]
        ])
    }
}