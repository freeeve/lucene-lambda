package lucenelambda;

import org.junit.Test;

class TestLuceneLambda {
    @Test
    private void TestLuceneLambda() {
        LuceneLambda luceneLambda = new LuceneLambda();
        LuceneLambdaRequest request = new LuceneLambdaRequest();
        request.setQuery("test");
        LuceneLambdaResponse response = luceneLambda.handleRequest(request, LuceneLambdaUtils.generateContext());
        // log output of response / assert test cases
    }
}