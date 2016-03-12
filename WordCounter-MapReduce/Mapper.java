import java.io.*;
import java.util.*;
 
public class Mapper {
    private PrintWriter outputFile;
    
    public Mapper() throws IOException {
		outputFile = new PrintWriter(new FileOutputStream("mapper_result.txt"));
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
		
		outputFile.flush();
		outputFile.close();
    }
 
    private void emitIntermediate(String w, String um) {
    	String key = w.replaceAll("([\\.,\\[\\]\\(\\):;<>\\*\\?!_-[\"]])+", "").toLowerCase();
    	outputFile.print(key);
    	outputFile.print(" ");
    	outputFile.println(um);
    }
     
    public static void main(String[] args) throws IOException  {
    	if(args == null || args.length == 0)
    		throw new IllegalStateException("Arquivo invalido");
        new Mapper().map(args[0]);
    }
}
