package lucenelambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import javafx.scene.image.Image;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.queryparser.flexible.core.QueryNodeException;
import org.apache.lucene.queryparser.flexible.standard.StandardQueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.FSDirectory;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

class LuceneLambda implements RequestHandler<LuceneLambdaRequest, LuceneLambdaResponse> {
    private boolean isInitialized = false;
    IndexSearcher searcher = null;

    @Override
    public LuceneLambdaResponse handleRequest(LuceneLambdaRequest luceneLambdaRequest, Context context) {
        // TODO add logging (using log4j: https://docs.aws.amazon.com/lambda/latest/dg/java-logging.html)
        if (!this.isInitialized) {
            // 0. read index into a private class variable
            IndexReader reader = null;
            try {
                reader = DirectoryReader.open(FSDirectory.open(Paths.get(luceneLambdaRequest.getIndexPath())));
            } catch (IOException e) {
                e.printStackTrace();
            }
            searcher = new IndexSearcher(reader);

            //doPagingSearch(searcher, query);
            this.isInitialized = true;
        }
        // 1. perform query
        // see examples: https://lucene.apache.org/core/8_1_0/demo/index.html#Searching_Files
        Query query = null;
        QueryParser qp = new QueryParser("summary", new StandardAnalyzer());
        try {
            query = qp.parse(luceneLambdaRequest.getQuery());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            TopDocs hits = searcher.search(query, 10);
            List<FineFoodReview> docList = new ArrayList<>();
            for (ScoreDoc scoreDoc : hits.scoreDocs) {
                FineFoodReview fineFoodReview = new FineFoodReview();
                Document doc = searcher.doc(scoreDoc.doc);
                fineFoodReview.setId(doc.getField("id").toString());
                fineFoodReview.setProductId(doc.getField("productId").toString());
                fineFoodReview.setUserId(doc.getField("userId").toString());
                fineFoodReview.setProfileName(doc.getField("profileName").toString());
                fineFoodReview.setHelpfulnessNumerator(doc.getField("helpfulnessNumerator").toString());
                fineFoodReview.setHelpfulnessDenominator(doc.getField("helpfulnessDenominator").toString());
                fineFoodReview.setScore(doc.getField("score").toString());
                fineFoodReview.setTime(doc.getField("time").toString());
                fineFoodReview.setSummary(doc.getField("summary").toString());
                fineFoodReview.setText(doc.getField("text").toString());
                docList.add(fineFoodReview);
            }
            LuceneLambdaResponse response = new LuceneLambdaResponse(docList);
            return response;
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Searching for: " + query.toString());

        return new LuceneLambdaResponse();
    }
}