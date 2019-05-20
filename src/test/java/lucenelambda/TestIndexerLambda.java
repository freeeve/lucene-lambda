package lucenelambda;

import org.junit.Test;

public class TestIndexerLambda {
    @Test
    public void TestIndexerLambda() {
        IndexerLambda lambda = new IndexerLambda();
        IndexerLambdaRequest request = new IndexerLambdaRequest();
        IndexerLambdaResponse response = lambda.handleRequest(request, LuceneLambdaUtils.generateContext());
        // log output of response / assert test cases
    }
}