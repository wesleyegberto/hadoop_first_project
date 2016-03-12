import java.io.*;
import java.util.*;
 
public class Reducer {
    private PrintWriter outputFile;
    private Map<String, Integer> counter = new LinkedHashMap<>();
    
    public Reducer() throws IOException {
		outputFile = new PrintWriter(new FileOutputStream("reducer_result.txt"));
	}

    private void reduce() throws IOException {
        String line = "";
        String previousKey = null;
        int total = 0;
        String key;
        int value;
        Scanner sc = new Scanner(new BufferedInputStream(new FileInputStream("mapper_result.txt")));
         
        while (sc.hasNextLine()) {
            line = sc.nextLine();
            String[] linha = line.split(" ");
            key = linha[0];
            value = Integer.parseInt(linha[1]);
            emit(key, value);
        }
        
        sc.close();
        
        saveResult();
        
		outputFile.flush();
		outputFile.close();
    }
 
    private void emit(String term, int sum) throws IOException {
        if (term != null) {
			if(counter.containsKey(term)) {
				counter.put(term, counter.get(term) + 1);
			} else {
				counter.put(term, 1);
			}
        }
    }
    
    private void saveResult() {
		for(Map.Entry<String, Integer> entry : counter.entrySet()) {
			outputFile.print(entry.getKey());
			outputFile.print(" ");
			outputFile.println(entry.getValue());
		}
    }
 
    public static void main(String[] args) throws IOException {
        new Reducer().reduce();
    }
}
