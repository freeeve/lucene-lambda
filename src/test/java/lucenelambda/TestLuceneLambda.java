package lucenelambda;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class TestLuceneLambda {
    @Test
    public void TestLuceneLambda() {
        LuceneLambda luceneLambda = new LuceneLambda();
        LuceneLambdaRequest request = new LuceneLambdaRequest();
        request.setIndexPath("testdata/testindex");
        request.setLocal(true);
        request.setQuery("cherry");
        LuceneLambdaResponse response = luceneLambda.handleRequest(request, LuceneLambdaUtils.generateContext());
        // expect to get result count of 1
        assertEquals(1, response.getData().size());
        for (FineFoodReview review : response.getData()) {
            System.out.println("got result" + review.getText());
            if (!review.getText().contains("cherry")) {
                fail();
            }
        }
    }
}