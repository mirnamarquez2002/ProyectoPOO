import java.util.ArrayList;
import java.lang.Math.*;

public class Polynomial{

    private Integer degree;
    private ArrayList<Integer> polyArray;

    public Polynomial(){
        degree = 0;
        polyArray = new ArrayList<Integer>();
    }

    public Polynomial(ArrayList<Integer> a1, Integer k){
        degree = k;
        polyArray = new ArrayList<Integer>(a1);
    }

    public void fillSpacesPolyArray(){
        while((degree+1) != polyArray.size()){
            if ((degree+1) > polyArray.size()){
                polyArray.add(0);
            }
        }   
    }

    public void printString(){
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
        
    }

    //New added methods

    private Integer power(Integer a,Integer b){
        //Created power method so it returns an Integer, Math.pow returns a double
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
    
    public Integer evaluate(Integer x){
        Integer i,result=0,j=degree;
        for(i=0;i<=degree;i++){
            result = result+(polyArray.get(i)*power(x,j));
            j--;
        }
        return result;
    }

    public ArrayList<Integer> getArray(){
        return polyArray;
    }

    public Integer getDegree(){
        return degree;
    }

    public void setDegree(Integer degree){
        this.degree = degree;
    }

    public void setArray(ArrayList<Integer> a){
        polyArray = a;
    }

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