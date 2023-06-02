package polynomial_pkg;

import java.util.ArrayList;
import java.lang.Math.*;

/**
 * The Polynomial class represents a polynomial function and provides methods for evaluating, printing,
 * adding, and subtracting polynomials.
 */
public class Polynomial{

    private Integer degree;
    private ArrayList<Integer> polyArray;

    //********************Constructors

    /** Constructor for the class "Polynomial". It initializes the degree of the polynomial
    * to 0 and creates a new ArrayList called "polyArray" to store the coefficients of the
    * polynomial.
    * @param None It receives no parameters since its the main constructor of the class
    */

    public Polynomial(){
        degree = 0;
        polyArray = new ArrayList<Integer>();
    }

    /** Constructor for the class Polynomial. The constructor takes in two parameters:
    * an ArrayList of integers called a1 and an integer called k. It sets the degree of
    * the polynomial to k and initializes the polyArray ArrayList with the values from a1.
    * @param a1 The parameter a1 stores the coefficients of the polynomial in an ArrayList<Integer>.
    * @param k The parameter k is an Integer and defines the grade of the polynomial.
    */

    public Polynomial(ArrayList<Integer> a1, Integer k){
        degree = k;
        polyArray = new ArrayList<Integer>(a1);
    }

    /*********************************

    //*************Setters and getters

        /**
     * The method returns an ArrayList of integers named polyArray from the object.
     * 
     * @return An ArrayList of integers named "polyArray".
     */
    public ArrayList<Integer> getArray(){
        return polyArray;
    }

    /**
     * The method returns the degree of the object as an Integer.
     * 
     * @return An Integer value representing the degree.
     */
    public Integer getDegree(){
        return degree;
    }

    /**
     * This method sets the degree of an object.This method is a setter method that allows
     * the value of the degree variable to be updated from outside the class.
     * 
     * @param degree The parameter "degree" is an Integer type variable that is being set to the
     * instance variable "degree" of the current object. It is the degree of the polynomial. 
     */
    public void setDegree(Integer degree){
        this.degree = degree;
    }

    /**
     * This method sets the value of a private ArrayList variable called polyArray.
     * The method assigns the value of "a" to the instance variable "polyArray".
     * 
     * @param a The parameter "a" is an ArrayList of integers that represents the coefficients
     * of the polynomial.
     */
    public void setArray(ArrayList<Integer> a){
        polyArray = a;
    }

    /*********************************
    
    /**********************     Methods

    /**
     * This method fills the empty spaces in a polynomial array with zeros.
     * @param None This method receives no parameters since its purpose is to standarize the way all sets of coefficients will be stored.
     */
    public void fillSpacesPolyArray(){
        while((degree+1) != polyArray.size()){
            if ((degree+1) > polyArray.size()){
                polyArray.add(0);
            }
        }   
    }

    /**
     * This function prints out a polynomial expression based on the values stored in an ArrayList.
     * @param None This method receives no parameters since its purpose is only to print the polynomial, no changes made.
     */
    public String toString(){
        int i,k=degree,b=0,b2=0;
        //Printing if the array's lenght is more than 2
        fillSpacesPolyArray();
        if(polyArray.size()>=2){
            if (k>1){
                b=1;
                if(polyArray.get(0)>1 || polyArray.get(0)<-1){
                    System.out.print(polyArray.get(0)+"x^"+k);
                    k--;
                    b2=1;
                }else if(polyArray.get(0)==1){
                    System.out.print("x^"+k);
                    k--;
                    b2=1;
                }else if(polyArray.get(0)==-1){
                    System.out.print("-x^"+k);
                    k--;
                    b2=1;
                }else{
                    k--;
                }
                //Printing the array
                for(i=1;i<polyArray.size()-1;i++){
                    if(polyArray.get(i)!=0 && k!=0 && k!=1){
                        if (polyArray.get(i)>0){
                            System.out.print("+"+polyArray.get(i)+"x^"+k);
                        }else{
                            System.out.print(polyArray.get(i)+"x^"+k);
                        }
                        k--;
                        b2=1;
                    }else if(polyArray.get(i)==0){
                        k--;
                    }
                }
            }
            
            //polyArray.get(polyArray.size()-2) is the next to last element on the array
            if(k==1 && polyArray.get(polyArray.size()-2)>1){
                System.out.print("+"+polyArray.get(polyArray.size()-2)+"x");
                k--;
                b=1;
            }else if(k==1 && polyArray.get(polyArray.size()-2)==1 && b2==1){
                System.out.print("+x");
                k--;
                b=1;
            }else if(k==1 && polyArray.get(polyArray.size()-2)==1 && b2==0){
                System.out.print("x");
                k--;
                b=1;
            }else if(k==1 && polyArray.get(polyArray.size()-2)<-1){
                System.out.print(polyArray.get(polyArray.size()-2)+"x");
                k--;
                b=1;
            }else if(k==1 && polyArray.get(polyArray.size()-2)==-1){
                System.out.print("-x");
                k--;
                b=1;
            }
            //polyArray.get(polyArray.size()-1) is the last element on the array
            if(k==0 && polyArray.get(polyArray.size()-1)>0 && b!=0){
                System.out.print("+"+polyArray.get(polyArray.size()-1));
            }else if(k==0 && polyArray.get(polyArray.size()-1)>0 && b==0){
                System.out.print(polyArray.get(polyArray.size()-1));
            }else if(k==0 && polyArray.get(polyArray.size()-1)<0){
                System.out.print(polyArray.get(polyArray.size()-1));
            }
        }else{
            //Printing if the array's length is 1
            if (k>1){
                System.out.print(polyArray.get(0)+"x^"+k);
            }
            
            if(k==1 && polyArray.get(polyArray.size()-1)>1){
                System.out.print(polyArray.get(polyArray.size()-2)+"x");

            }else if(k==1 && polyArray.get(polyArray.size()-1)==1){
                System.out.print("x");

            }else if(k==1 && polyArray.get(polyArray.size()-1)<-1){
                System.out.print(polyArray.get(polyArray.size()-2)+"x");

            }else if(k==1 && polyArray.get(polyArray.size()-1)==-1){
                System.out.print("-x");

            }

            if(k==0){
                System.out.print(polyArray.get(polyArray.size()-1));
            }
        }
        System.out.println("");
        return "";
        
    }


    
    /** 
     * Method that returns the power of a number as an an Integer.
     * @param a The parameter a defines the base or number that will be elevated.
     * @param b The parameter b defines the power to which we will elevate a.
     * @return Integer result from elevating a to the power b.
     */

    //We did not use math.pow since it return a double number (type).
    private Integer power(Integer a,Integer b){
        Integer powerA=a,i;
        if(b ==0 ){
            return 1;
        }
        else if(b == 1){
            return a;
        }
        else{
            for(i=1;i<b;i++){
                powerA = powerA * (a);
            }
        }
        return powerA;
    }
    
    /**
     * This method evaluates a polynomial expression for a given value of x using an array of
     * coefficients and the degree of the polynomial.
     * 
     * @param x The value of x at which the polynomial needs to be evaluated.
     * @return The method is returning an Integer value which is the result of evaluating a polynomial
     * function at a given value of x.
     */
    public Integer evaluate(Integer x){
        Integer i,result=0,j=degree;
        for(i=0;i<=degree;i++){
            result = result+(polyArray.get(i)*power(x,j));
            j--;
        }
        return result;
    }

    /**
     * This function adds two polynomials represented as ArrayLists and returns a new Polynomial object
     * with the resulting sum.
     * 
     * @param array2Polynomial A Polynomial object that represents the polynomial to be added to the
     * current Polynomial object (which is represented by the "this" keyword in the code).
     * @return The method is returning a Polynomial object, specifically the sum of the Polynomial
     * object that called the method and the Polynomial object passed as a parameter.
     */
    public Polynomial add(Polynomial array2Polynomial){

        //Initializing and setting values to all variables

        //Side note: we refer to array1 to the object that calls this funtion, example:
        //arreglo1.add(arreglo2) >> Here arreglo1 is the one calling the method, so
        // arreglo1 == array1

        /*We ue setters and getters for array2Polynomial since we a reference to the object
         * but it is not the one that we accesed with the method add (we executed the method
         * with array1, so this.degree and this.polyArray refer to array1; to access the values
         * of array2Polynomial we use both setters and getters)
         */

        Integer degree2 = array2Polynomial.getDegree(), finalDegree=0;
        ArrayList<Integer> array2 = array2Polynomial.getArray();
        Integer i,diff,j;

        //Instancing polynomial type and asigning it's ArrayList to addedArrays,
        //also created here, is an aux array that will return the sum of array1 and array2

        Polynomial addedArraysP = new Polynomial();
        ArrayList<Integer> addedArrays = addedArraysP.getArray();

        if (degree > degree2){
            diff = degree-degree2;
            finalDegree = degree;
            j = diff;//j will manage the index of the array 1 (avoiding the ones already added to addedArrays during the while)
            i=0;
            while(diff != 0){
                if(addedArrays.size() == 0 && polyArray.get(i) == 0){
                    finalDegree--;
                }else{
                    addedArrays.add(polyArray.get(i));
                    i++;
                    diff--;
                }
            }
            for(i=0;i<=degree2;i++){
                if(addedArrays.size() == 0 && (polyArray.get(j)+array2.get(i)) == 0){
                    finalDegree--;
                }else{
                    addedArrays.add(polyArray.get(j)+array2.get(i));
                    j++;
                }
            }
            addedArraysP.setDegree(finalDegree);
        }else if(degree < degree2){
            finalDegree = degree2;
            diff = degree2-degree;
            j = diff;//j will manage the index of the array 2 (avoiding the ones already added to addedArrays during the while)
            i=0;
            while(diff != 0){
                if(addedArrays.size() == 0 && array2.get(i) == 0){
                    finalDegree--;
                }else{
                    addedArrays.add(array2.get(i));
                    i++;
                    diff--;
                }
            }
            for(i=0;i<=degree;i++){
                if(addedArrays.size() == 0 && (polyArray.get(i)+array2.get(j)) == 0){
                    finalDegree--;
                }else{
                    addedArrays.add(polyArray.get(i)+array2.get(j));
                    j++;
                }
            }
            addedArraysP.setDegree(finalDegree);
        }
        //both arrays have the same length
        else{
            i=0;
            finalDegree = degree;
            addedArraysP.setDegree(degree);
            for(i=0;i<=degree;i++){
                if(addedArrays.size() == 0 && (polyArray.get(i)+array2.get(i)) == 0){
                    finalDegree--;
                }else{
                    addedArrays.add(polyArray.get(i)+array2.get(i));
                }
            }
            addedArraysP.setDegree(finalDegree);
        }

        addedArraysP.setArray(addedArrays);
        return addedArraysP;
    }

    /**
     * This function subtracts two polynomials and returns the result as a new polynomial.
     * 
     * @param array2Polynomial A Polynomial object that represents the polynomial to be subtracted from
     * the current polynomial object.
     * @return The method is returning a Polynomial object that represents the result of subtracting
     * the polynomial represented by the input parameter array2Polynomial from the polynomial
     * represented by the current object.
     */
    public Polynomial substract(Polynomial array2Polynomial){

        //Initializing and setting values to all variables
        Integer degree2 = array2Polynomial.getDegree(), finalDegree=0;
        ArrayList<Integer> array2 = array2Polynomial.getArray();
        Integer i,diff,j;
        //Creating polynomial type and getting ArrayList named substractedArrays to work with
        Polynomial substractedArraysP = new Polynomial();
        ArrayList<Integer> substractedArrays = substractedArraysP.getArray();

        if (degree > degree2){
            finalDegree = degree;
            diff = degree-degree2;
            j = diff;//j will manage the index of the array 1 (avoiding the ones already added to substractedArrays during the while)
            i=0;
            while(diff != 0){
                if(substractedArrays.size() == 0 && polyArray.get(i) == 0){
                    finalDegree--;
                }else{
                    substractedArrays.add(-polyArray.get(i));
                    i++;
                    diff--;
                }
            }
            for(i=0;i<=degree2;i++){
                if(substractedArrays.size() == 0 && (polyArray.get(j)-array2.get(i) == 0)){
                    finalDegree--;
                }else{
                    substractedArrays.add(polyArray.get(j)-array2.get(i));
                    j++;
                }
            }
            substractedArraysP.setDegree(finalDegree);
        }else if(degree < degree2){
            finalDegree = degree2;
            diff = degree2-degree;
            j = diff;//j will manage the index of the array 2 (avoiding the ones already added to addedArrays during the while)
            i=0;
            while(diff != 0){
                if(substractedArrays.size() == 0 && array2.get(i) == 0){
                    finalDegree--;
                }else{
                    substractedArrays.add(-array2.get(i));
                    i++;
                    diff--;
                }
            }
            for(i=0;i<=degree;i++){
                if(substractedArrays.size() == 0 && (polyArray.get(i)-array2.get(j) == 0)){
                    finalDegree--;
                }else{
                    substractedArrays.add(polyArray.get(i)-array2.get(j));
                    j++;
                }
            }
            substractedArraysP.setDegree(finalDegree);
        }
        //both arrays have the same length
        else{
            i=0;
            finalDegree = degree;
            for(i=0;i<=degree;i++){
                if(substractedArrays.size() == 0 && (polyArray.get(i)-array2.get(i) == 0)){
                    finalDegree--;
                }else{
                    substractedArrays.add(polyArray.get(i)-array2.get(i));
                }
            }
            substractedArraysP.setDegree(finalDegree);
        }

        substractedArraysP.setArray(substractedArrays);
        return substractedArraysP;
    }
}