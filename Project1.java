import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * This program reads an AUTOSAR file and sorts the <CONTAINER> elements
 * alphabetically by their <SHORT-NAME> elements. The sorted elements are then
 * written to a new file with the suffix "_mod.arxml".
 */
public class Project1 {
    
    public static void main(String[] args) throws Exception{
        
        // Check if the input file is an AUTOSAR file
        if(!(args[0].matches(".*.arxml"))){
            throw new NotVaildAutosarFileException();
        }
   
        // Open the input file
        File ex = new File(args[0]);
        
        // Check if the input file is empty
        if(ex.length() == 0){
            throw new EmptyAutosarFileException();
        }
         
        int temp=0;
        ArrayList<String> tempStored = new ArrayList<>();
        
        // Read the input file line by line and store it in an ArrayList
        try(Scanner input = new Scanner(ex)){
            while(input.hasNext()){
                tempStored.add(input.nextLine());
            }
        }
        
        // Calculate the number of <CONTAINER> elements in the input file
        int counter = (tempStored.size()-3)/4;
        Container[] containers = new Container[counter];
        
        // Extract <CONTAINER> elements and store them in an array of Container objects
        for(int i = 2; i< tempStored.size()-2; i+=4){
            containers[temp] = new Container(tempStored.get(i), tempStored.get(i+1), tempStored.get(i+2), tempStored.get(i+3));
            temp++;
        }
        
        // Sort the array of Container objects by their <SHORT-NAME> elements
        Arrays.sort(containers);
        
        // Create a new file with the sorted <CONTAINER> elements
        File ex_new = new File(args[0].substring(0, args[0].length()-6).concat("_mod.arxml"));
        try(PrintWriter newFile = new PrintWriter(ex_new)){
            newFile.println(tempStored.get(0));
            newFile.println(tempStored.get(1));
            for(int i = 0; i<containers.length; i++){
                newFile.println(containers[i].getHeadContainer());
                newFile.println(containers[i].getShortName());
                newFile.println(containers[i].getLongName());
                newFile.println(containers[i].getFootContainer());
            }
            newFile.println(tempStored.get(tempStored.size()-1));
        }  
    }
}
/**
 * A class representing a <CONTAINER> element in an AUTOSAR file
 */
class Container implements Comparable<Container>{
   private String headContainer; // The head container of the current container
   private String shortName; // The short name of the current container
   private String longName; // The long name of the current container
   private String footContainer; // The foot container of the current container
   
   // Constructor that initializes the member variables of the class
   public Container(String headContainer, String shortName, String longName,String footContainer){
       this.headContainer = headContainer;
       this.shortName = shortName;
       this.longName = longName;
       this.footContainer = footContainer;
   }
   
   // Getter for the head container of the current container
   public String getHeadContainer(){
       return headContainer;
   }

   // Getter for the short name of the current container
    public String getShortName() {
        return shortName;
    }

    // Getter for the long name of the current container
    public String getLongName() {
        return longName;
    }

    // Getter for the foot container of the current container
    public String getFootContainer() {
        return footContainer;
    }
  
    // Implementation of the Comparable interface to enable sorting of Container objects based on their short name
    @Override
    public int compareTo(Container o) {
        return this.shortName.compareTo(o.shortName);
    }
}

// Custom exception class to be thrown when the given file is not a valid AUTOSAR file
class NotVaildAutosarFileException extends Exception{
    public NotVaildAutosarFileException(){
        super("NotVaildAutosarFileException");
    }
}

// Custom exception class to be thrown when the given AUTOSAR file is empty
class EmptyAutosarFileException extends RuntimeException{
    public EmptyAutosarFileException(){
        super("EmptyAutosarFileException");
    }
}