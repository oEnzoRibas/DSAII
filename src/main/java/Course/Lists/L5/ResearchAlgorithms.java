package Course.Lists.L5;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
import java.util.Collections;

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
    boolean sequentialSearch(ArrayList<String> names, String name){
	    for (String str : names){
		    if ( str.equalsIgnoreCase(name) ) return true;
	    }
	    return false;
    }

    boolean binarySearch(ArrayList<String> names, String name){
	    int p1 =0;
	    int p2 = names.size();
	    int meio ;


	    Collections.sort(names);

	    while (p1 < p2){
		    meio = (p1+p2)/2;
            int compareTo = names.get(meio).compareTo(name);
            System.out.println(compareTo);

		    if (names.get(meio).equalsIgnoreCase(name)){
			    return true;
		    }else if( compareTo < 0 ){
			    p1 = meio +1;
		    }else if (compareTo > 0){
			    p2 = meio-1;
		    }
	    }
	    return false;
    }


    public static void main(String[] args){

	    ArrayList<String> names = new ArrayList<String>();

	    names.add("enzo");
	    names.add("joao");
	    names.add("joao2");
	    names.add("joao2212");
	    names.add("joao22222");
	    names.add("joao212");
	    names.add("joao211111");




	    ResearchAlgorithms ra = new ResearchAlgorithms();

        System.out.println(ra.binarySearch(names, "joao"));

		


		}
	
}
