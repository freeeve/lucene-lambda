package lucenelambda;

/**
 * POJO for amazon fine food review.
 * Eventually we'll want to generalize the other classes but for now we'll use this
 * as the only kind of document we'll index/return as search result.
 */
public class FineFoodReview {
    private String id;
    private String productId;
    private String userId;
    private String profileName;
    private String helpfulnessNumerator;
    private String helpfulnessDenominator;
    private String score;
    private String time;
    private String summary;
    private String text;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getHelpfulnessNumerator() {
        return helpfulnessNumerator;
    }

    public void setHelpfulnessNumerator(String helpfulnessNumerator) {
        this.helpfulnessNumerator = helpfulnessNumerator;
    }

    public String getHelpfulnessDenominator() {
        return helpfulnessDenominator;
    }

    public void setHelpfulnessDenominator(String helpfulnessDenominator) {
        this.helpfulnessDenominator = helpfulnessDenominator;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    // TODO add csv fields
    // Id,ProductId,UserId,ProfileName,HelpfulnessNumerator,HelpfulnessDenominator,Score,Time,Summary,Text
    //hashmap
    //get array list from GetObject

    /*
    HashMap<String, List<String>> food = new HashMap<String, List<Integer>>();
    ArrayList<String> begin = new ArrayList<String>();
    File file = new File("review.csv.txt"); 
    Scanner sc = new Scanner(file); 
     
    while (sc.hasNextLine()) 
    {
        String str[] = sc.split(",");
        //al = Arrays.asList(str);//other option
        for(int i = 0; i < str.length(); i++);
        {
            begin.add(str[i]);
        }
        //can use a for loop to put split array into arraylist form
    } 
    for(int i = 0; i < 10; i++)
    {
        ArrayList<String> end = new ArrayList<String>();
        for(int j = 0 + i; j < begin.size(); j+=10)
        {
            end.add(begin[j]);
        }
        food.put(i,end);
    }
    */

}


