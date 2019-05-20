package lucenelambda;

import org.junit.Test;

class TestIndexerLambda {
    @Test
    private void TestIndexerLambda() {
        IndexerLambda lambda = new IndexerLambda();
        IndexerLambdaRequest request = new IndexerLambdaRequest();
        IndexerLambdaResponse response = lambda.handleRequest(request, LuceneLambdaUtils.generateContext());
        // log output of response / assert test cases
    }
}