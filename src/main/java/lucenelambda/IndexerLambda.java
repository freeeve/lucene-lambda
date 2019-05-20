package lucenelambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class IndexerLambda implements RequestHandler<IndexerLambdaRequest, IndexerLambdaResponse> {

    @Override
    public IndexerLambdaResponse handleRequest(IndexerLambdaRequest indexerLambdaRequest, Context context) {
        return null;
    }
}
