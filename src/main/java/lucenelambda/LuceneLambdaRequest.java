package lucenelambda;

/**
 * POJO for lucene query request.
 */
public class LuceneLambdaRequest {
    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    private String query;
}
