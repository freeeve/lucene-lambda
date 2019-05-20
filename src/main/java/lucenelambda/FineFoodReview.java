package lucenelambda;

/**
 * POJO for amazon fine food review.
 * Eventually we'll want to generalize the other classes but for now we'll use this
 * as the only kind of document we'll index/return as search result.
 */
public class FineFoodReview {
    
    // TODO add csv fields
    // Id,ProductId,UserId,ProfileName,HelpfulnessNumerator,HelpfulnessDenominator,Score,Time,Summary,Text
    //hashmap
    //get array list from GetObject
    
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
    
}


