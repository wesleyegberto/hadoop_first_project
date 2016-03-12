import java.io.*;
import java.util.*;
 
public class SimpleWordCounter {
    private PrintWriter outputFile;
    private Map<String, Integer> counter = new LinkedHashMap<>();
    
    public SimpleWordCounter() throws IOException {
		outputFile = new PrintWriter(new FileOutputStream("word_count_result.txt"));
	}
    
    private void map (String file) throws IOException {
        Scanner sc = new Scanner(new BufferedInputStream(new FileInputStream(file)));
        String line = "";
        
        while (sc.hasNextLine()) {
            line = sc.nextLine();
            StringTokenizer tokens = new StringTokenizer(line);
            while(tokens.hasMoreTokens()){
                emitIntermediate(tokens.nextToken(), "1");
            }
		}
		sc.close();
		
		saveResult();
		
		outputFile.flush();
		outputFile.close();
    }
 
    private void emitIntermediate (String w, String um) {
    	String key = w.replaceAll("([\\.,\\[\\]\\(\\):;<>\\*\\?!_-[\"]])+", "").toLowerCase();

    	if(counter.containsKey(key)) {
    		counter.put(key, counter.get(key) + 1);
    	} else {
			counter.put(key, 1);
		}
    }
    
    private void saveResult() {
		for(Map.Entry<String, Integer> entry : counter.entrySet()) {
			outputFile.print(entry.getKey());
			outputFile.print(" ");
			outputFile.println(entry.getValue());
		}
    }
     
    public static void main(String[] args) throws IOException  {
    	if(args == null || args.length == 0)
    		throw new IllegalStateException("Arquivo invalido");
        new SimpleWordCounter().map(args[0]);
    }
}
