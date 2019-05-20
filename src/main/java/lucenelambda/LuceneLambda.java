package lucenelambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

class LuceneLambda implements RequestHandler<LuceneLambdaRequest, LuceneLambdaResponse> {
    @Override
    public LuceneLambdaResponse handleRequest(LuceneLambdaRequest luceneLambdaRequest, Context context) {
        return null;
    }
}