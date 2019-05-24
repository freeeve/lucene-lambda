package lucenelambda;

import org.junit.Test;

public class TestIndexerLambda {
    @Test
    public void TestIndexerLambda() {
        IndexerLambda lambda = new IndexerLambda();
        IndexerLambdaRequest request = new IndexerLambdaRequest();
        request.setInputPath("testdata/testreviews.csv.gz");
        request.setIndexPath("testdata/testindex");
        request.setLocal(true);
        IndexerLambdaResponse response = lambda.handleRequest(request, LuceneLambdaUtils.generateContext());
        // log output of response / assert test cases
        // exercise index
    }
}