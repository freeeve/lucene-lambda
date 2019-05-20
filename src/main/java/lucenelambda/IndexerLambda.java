package lucenelambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

/**
 * Lambda class for Indexing.
 */
public class IndexerLambda implements RequestHandler<IndexerLambdaRequest, IndexerLambdaResponse> {

    @Override
    public IndexerLambdaResponse handleRequest(IndexerLambdaRequest indexerLambdaRequest, Context context) {
        // TODO add logging (using log4j: https://docs.aws.amazon.com/lambda/latest/dg/java-logging.html)
        // 1. read file from s3 (https://s3.amazonaws.com/fannie-data/lucene-lambda-test/reviews.csv.gz)
        // see example: https://docs.aws.amazon.com/AmazonS3/latest/dev/RetrievingObjectUsingJava.html
        // and combine with: https://docs.oracle.com/javase/7/docs/api/java/util/zip/GZIPInputStream.html

        // 1b. parse csv
        // see reader example: https://www.baeldung.com/apache-commons-csv

        // 2. "index" fine food review objects in lucene (can be combined with 1, maybe)
        // see examples: https://lucene.apache.org/core/8_1_0/demo/index.html#IndexFiles

        // 3. zip up resulting files / write index to s3 as zip
        // see example: http://www.java67.com/2016/12/how-to-create-zip-file-in-java-zipentry-example.html
        return new IndexerLambdaResponse();
    }
}
