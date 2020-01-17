package contracts.greeting

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description("""
Represents a successful greeting scenario without params
""")
    request {
        method 'Get'
        url '/greeting'
        headers {
            contentType(applicationJson())
        }
    }
    response {
        status OK()
        body(

                id: $(anyNumber()),
                content: "Hello, World!",
                template: "Hello, %s!"

			)
        headers {
            contentType(applicationJson())
        }
    }
}