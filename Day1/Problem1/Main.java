import java.io.FileReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int total = 0;
        try{
            FileReader fr = new FileReader("./input.txt");
            Scanner sc = new Scanner(fr);
            
            while(sc.hasNextLine()){
            String line = sc.nextLine();
            total += extractNumberFromString(2,line);
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
        
    }

    protected static int extractNumberFromString(int digits, String string){
        string = string.replaceAll("[^\\d]","");
        //System.out.println(string);
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