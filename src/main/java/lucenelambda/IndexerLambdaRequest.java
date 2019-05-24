package lucenelambda;

/**
 * POJO for indexer request.
 * For now we can leave blank, later maybe add filename to index or something.
 */
public class IndexerLambdaRequest {
    private String inputPath;
    private String indexPath;
    private boolean local;

    public String getInputPath() {
        return inputPath;
    }

    public void setInputPath(String inputPath) {
        this.inputPath = inputPath;
    }

    public String getIndexPath() {
        return indexPath;
    }

    public void setIndexPath(String indexPath) {
        this.indexPath = indexPath;
    }

    public boolean isLocal() {
        return local;
    }

    public void setLocal(boolean local) {
        this.local = local;
    }
}
