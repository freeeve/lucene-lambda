package lucenelambda;

import java.util.List;

/**
 * POJO for lucene query response.
 */
public class LuceneLambdaResponse {
    private List<FineFoodReview> data;
    public LuceneLambdaResponse() {
    }
    public LuceneLambdaResponse(List<FineFoodReview> data) {
        this.data = data;
    }

    public List<FineFoodReview> getData() {
        return data;
    }

    public void setData(List<FineFoodReview> data) {
        this.data = data;
    }

}
