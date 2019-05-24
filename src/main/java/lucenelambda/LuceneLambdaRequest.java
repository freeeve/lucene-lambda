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

    public boolean isLocal() {
        return local;
    }

    public void setLocal(boolean local) {
        this.local = local;
    }

    public String getIndexPath() {
        return indexPath;
    }

    public void setIndexPath(String indexPath) {
        this.indexPath = indexPath;
    }
}
