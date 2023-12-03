import java.io.FileReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        
        int total = 0;
        try{
            FileReader fr = new FileReader(args[0]);
            Scanner sc = new Scanner(fr);
            
            while(sc.hasNextLine()){
            String line = sc.nextLine();
            total += extractNumberFromString(line);
            }

            sc.close();
            fr.close();
        }
        catch(Exception e){
            System.out.println(e);
            System.exit(1);
        }
        finally{
            System.out.println(total);
        }

        long endTime = System.nanoTime();
        long duration = (endTime - startTime)/1000000;
        System.out.println("Running time: " + Long.toString(duration) + "ms");
        
    }

    protected static int extractNumberFromString(String string){
        String[] filterWords = {"one","two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};
        
        
        for(int number = 1;number<=filterWords.length;number++){
            // When replacing a word with a number, keep the first and last characters of the word.
            string = string.replaceAll(filterWords[number-1], filterWords[number-1].charAt(0)+Integer.toString(number)+filterWords[number-1].charAt(filterWords[number-1].length()-1));
        }
        
        string = string.replaceAll("[^\\d]","");

        String finalNumber = new String();
        if(string.length()==1){
            finalNumber += string.charAt(0);
            finalNumber += string.charAt(0);
        }
        else{
            finalNumber += string.charAt(0);
            finalNumber += string.charAt(string.length()-1);
        }
        
        return Integer.parseInt(finalNumber);
    }
}