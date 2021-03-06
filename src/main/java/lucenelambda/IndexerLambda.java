package lucenelambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Date;//all the way to here
import java.util.List;
import java.util.zip.GZIPInputStream;

import org.apache.lucene.analysis.Analyzer;//new from here 
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.LongPoint;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;//to here
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

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
        final String indexDir = indexerLambdaRequest.getIndexPath();
        try {
            IndexWriter writer = createWriter(indexDir);//new
            InputStream inputStream = null;
            if (indexerLambdaRequest.isLocal()) {
                System.out.println("handling local read:" + indexerLambdaRequest.getInputPath());
                inputStream = new FileInputStream(indexerLambdaRequest.getInputPath());
            } else {
                System.out.println("handling s3 read:" + indexerLambdaRequest.getInputPath());
                // TODO add s3 handling
            }
            int count = 0;
            //Getting the elements one by one: Iterable
            GZIPInputStream zippedInputStream = new GZIPInputStream(inputStream);
            Reader in = new InputStreamReader(zippedInputStream);
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.withHeader("Id", "ProductId", "UserId", "ProfileName", "HelpfulnessNumerator", "HelpfulnessDenominator", "Score", "Time", "Summary", "Text").parse(in);
            List<Document> documents = new ArrayList<>();
            for (CSVRecord record : records) {
                String id = record.get("Id");
                String productId = record.get("ProductId");
                String userId = record.get("UserId");
                String profileName = record.get("ProfileName");
                String helpfulnessNumerator = record.get("HelpfulnessNumerator");
                String helpfulnessDenominator = record.get("HelpfulnessDenominator");
                String score = record.get("Score");
                String time = record.get("Time");
                String summary = record.get("Summary");
                String text = record.get("Text");
                count++;

                Document document = new Document();
                document.add(new StringField("id", id, Field.Store.YES));
                document.add(new TextField("productId", productId, Field.Store.YES));
                document.add(new TextField("userId", userId, Field.Store.YES));
                document.add(new TextField("profileName", profileName, Field.Store.YES));
                document.add(new TextField("productId", productId, Field.Store.YES));
                document.add(new TextField("userId", userId, Field.Store.YES));
                document.add(new TextField("profileName", profileName, Field.Store.YES));
                document.add(new TextField("helpfulnessNumerator", helpfulnessNumerator, Field.Store.YES));
                document.add(new TextField("helpfulnessDenominator", helpfulnessDenominator, Field.Store.YES));
                document.add(new TextField("score", score, Field.Store.YES));
                document.add(new TextField("time", time, Field.Store.YES));
                document.add(new TextField("summary", summary, Field.Store.YES));
                document.add(new TextField("text", text, Field.Store.YES));
                documents.add(document);
            }
            writer.deleteAll();
            writer.addDocuments(documents);
            writer.commit();
            writer.close();
            return new IndexerLambdaResponse();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        // 1b. parse csv
        // see reader example: https://www.baeldung.com/apache-commons-csv

        // 2. "index" fine food review objects in lucene (can be combined with 1, maybe)
        // see examples: https://lucene.apache.org/core/8_1_0/demo/index.html#IndexFiles

        // 3. zip up resulting files / write index to s3 as zip
        // see example: http://www.java67.com/2016/12/how-to-create-zip-file-in-java-zipentry-example.html
        return new IndexerLambdaResponse();
    }

    private static IndexWriter createWriter(String indexPath) throws IOException {
        FSDirectory dir = FSDirectory.open(Paths.get(indexPath));
        IndexWriterConfig config = new IndexWriterConfig(new StandardAnalyzer());
        IndexWriter writer = new IndexWriter(dir, config);
        return writer;
    }
}
