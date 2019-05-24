package lucenelambda;

/**
 * POJO for lucene query request.
 */
public class LuceneLambdaRequest {
    private String query;
    private boolean local;
    private String indexPath;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
