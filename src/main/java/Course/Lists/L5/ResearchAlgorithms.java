package Course.Lists.L5;

import java.util.ArrayList;
import java.util.Scanner;

public class ResearchAlgorithms {
    static Scanner kIn = new Scanner(System.in);

    // q1
    void addName(ArrayList<String> names){
        while(true){
            System.out.println("Inform an name to add");
            String userInput = kIn.nextLine();
            if (userInput.equalsIgnoreCase("STOP")) return;
            names.add(userInput);
        }
    }

    // q2
    public void printList(ArrayList<String> list){
        for(String str : list){
            System.out.println(str);
        }
    }

    // q3
    boolean sequentialResearch(ArrayList<String> names, String name){
        for (String str : names){
            if ( str.equalsIgnoreCase(name) ) return true;
        }
        return false;
    }




    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();

        names.add("enzo");
        names.add("enzo2");
        names.add("enzo3");
        names.add("enzo4");
        names.add("enzo5");

        ResearchAlgorithms a = new ResearchAlgorithms();

        a.printList(names);

        System.out.println(a.sequentialResearch(names,"enzo7"));
    }
}
