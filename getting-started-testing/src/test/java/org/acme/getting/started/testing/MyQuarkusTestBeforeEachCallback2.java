package org.acme.getting.started.testing;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.callback.QuarkusTestBeforeEachCallback;
import io.quarkus.test.junit.callback.QuarkusTestMethodContext;

@QuarkusTest
public class MyQuarkusTestBeforeEachCallback2 implements QuarkusTestBeforeEachCallback {

    @Override
    public void beforeEach(QuarkusTestMethodContext context) {
        System.out.println("Executing1 " + context.getTestMethod());
    }
}