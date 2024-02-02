package org.example;

import static context.TestContext.CONTEXT;

public abstract class AbstractSteps {

    public final String baseUrl = "https://apitest.com";
    static final String userId = "86f530af-fc74-464d-8839-cac0e7a43b66";
    static final String username = "newUseradd";
    static final String password = "NEW#string3456";

    public context.TestContext testContext() {
        return CONTEXT;
    }
}