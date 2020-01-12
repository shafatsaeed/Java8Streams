package streamsbasic;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamBasics {

	public static void main(String[] args) {
		
		// Test Case 1 - filter an array and return subset of List
		
		Integer[] intIds = { 1, 2,null, 3, 4};
	    
	    List list = Stream.of(intIds)      
	      .filter(e -> e != null)
	      .filter(e -> e > 2)
	      .collect(Collectors.toList());
	    
	    System.out.println(list);  // outputs [3, 4]
	    
		// Test case 2 - find the first number greater than 2 in an array
	    Integer firstNum = Stream.of(intIds)      
	  	      .filter(e -> e != null)
	  	      .filter(e -> e > 2)
	  	      .findFirst()
	  	      .orElse(0);
	    System.out.println(firstNum);
	    
	    //Test case 3 - convert stream back to array
	    Integer[] newIntId = Stream.of(intIds).toArray(Integer[]::new);
	    
	    //Test case 4 - Handling complex data structure with flatMap
	    List<List<String>> namesNested = Arrays.asList( 
	    	      Arrays.asList("Jeff", "Bezos"), 
	    	      Arrays.asList("Bill", "Gates"), 
	    	      Arrays.asList("Mark", "Zuckerberg"));
	    List<String> flatStream = namesNested.stream()
	    						.flatMap(Collection::stream)
	    						.collect(Collectors.toList());
	    System.out.println(flatStream) ;
	  	      

	}

}
