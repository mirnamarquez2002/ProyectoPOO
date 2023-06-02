import java.util.Scanner;
import java.util.ArrayList;
//import polynomial_pkg.*; -> importing the whole package
import polynomial_pkg.Polynomial; //Importing Polynomial class from polynomial_pkg

public class Main {

    public static void main(String[] args){

        //Reading info
        Scanner stdin = new Scanner(System.in);
        Integer degree = stdin.nextInt();
        String trash = stdin.nextLine();
        String coeff = stdin.nextLine();
        //Adding a new set of variables read from input
        Integer degree2 = stdin.nextInt();
        String moretrash = stdin.nextLine();
        String coeff2 = stdin.nextLine();
        Integer evalNumb = stdin.nextInt();
        stdin.close();

        //We split both coeff and coeff2
        //Spliting coeff
        String[] coeffSeparated = coeff.split(" ");
        ArrayList<Integer> finalCoeff = new ArrayList<Integer>();
        int i;
        for(i=0;i<coeffSeparated.length;i++){
            finalCoeff.add(Integer.valueOf(coeffSeparated[i]));
        }
        Polynomial arreglo1 = new Polynomial(finalCoeff,degree);

        //Spliting coeff 2, we reuse both coeffSeparated and finalCoeff
        coeffSeparated = coeff2.split(" ");
        finalCoeff = new ArrayList<Integer>();
        for(i=0;i<coeffSeparated.length;i++){
            finalCoeff.add(Integer.valueOf(coeffSeparated[i]));
        }
        Polynomial arreglo2 = new Polynomial(finalCoeff,degree2);

        //Filling spaces with zeros if the grade is bigger than the # of elements on the array
        arreglo1.fillSpacesPolyArray(); // filling blank spaces for Polynomial polyArray (Array 1)
        arreglo2.fillSpacesPolyArray();

        //Creating a Polynomial addedArraysP (new instance)
        Polynomial addedArraysP = arreglo1.add(arreglo2);
        addedArraysP.printString();
        System.out.print(addedArraysP.evaluate(evalNumb));

        System.out.println("");
        
        Polynomial substractedArraysP = arreglo1.substract(arreglo2);
        substractedArraysP.printString();
        System.out.print(substractedArraysP.evaluate(evalNumb));
    }
}
