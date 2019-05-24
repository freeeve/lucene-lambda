package lucenelambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

class LuceneLambda implements RequestHandler<LuceneLambdaRequest, LuceneLambdaResponse> {
    private boolean isInitialized = false;

    @Override
    public LuceneLambdaResponse handleRequest(LuceneLambdaRequest luceneLambdaRequest, Context context) {
        // TODO add logging (using log4j: https://docs.aws.amazon.com/lambda/latest/dg/java-logging.html)
        if (!this.isInitialized) {
            // 0. read index into a private class variable
            this.isInitialized = true;
        }
        // 1. perform query
        // see examples: https://lucene.apache.org/core/8_1_0/demo/index.html#Searching_Files

        return new LuceneLambdaResponse();
    }
}