import java.util.ArrayList;
import java.util.Scanner;
import polynomial_pkg.*;

public class Parsing{

    private ArrayList<Integer> parsedArray = new ArrayList<Integer>();
    private Integer degreeA;
    private Polynomial polyArray = new Polynomial();

    //Constructor giving values to parsedArray and degreeA
    public Parsing(){
        parsedArray = polyArray.getArray();
        degreeA = polyArray.getDegree();
    }
    
    public Polynomial parse(String a){
        Parsing p = new Parsing();
        char[] charArray = p.getChar(a);
        String[] semiParsed = p.getTerms(charArray);
        Polynomial polyArray = p.parseArray(semiParsed);
        return polyArray;
    }

    private Polynomial parseArray(String[] semiParsedArray){
        Polynomial finalPolynomial = new Polynomial();
        String[] tempArr = new String[semiParsedArray[0].length()+1];
        String[] tempArr2 = new String[semiParsedArray[0].length()+1];
        ArrayList<Integer> intTempArray = new ArrayList<Integer>();
        ArrayList<Integer> intTempArray2 = new ArrayList<Integer>();

        tempArr = semiParsedArray[0].split("/");
        tempArr2 = semiParsedArray[1].split("/");
        for(int i=0;i<tempArr.length;i++){
            intTempArray.add(Integer.parseInt(tempArr[i]));
            intTempArray2.add(Integer.parseInt(tempArr2[i]));
        }
        //We can set the Degree already, since we will ask the user to input the Polynomial in descending order
        //If the User does not follow this instruction, the coefficients list after parsing will be wrong
        //Here, in case we want to fix that, we would have to order the ArrayList intTempArray2, and any
        //change in position within inTempArray2 would have to be done to intTempArray in the same way,
        //since we assume each position in the arrays relates both the Coefficient and its corresponding exponent
        finalPolynomial.setDegree(intTempArray2.get(0));

        /*------------------ */
        /*NOTE: After this step we assume the ArrayList intTempArray2 is in descending order */
        /*------------------ */

        //We need to add zeros in case we received a Polynomial such as X^5+x^2+1
        //So far we would have as Coeff 1 1 1, but we need 1 0 0 1 0 1
        //We will see if there is the need for a zero using the exponents list
        //Whenever we find a gap (for example between 5 and 2 there are 2 gaps < corresponding to
        //the exponents 4 and 3 >, but between 5 and 4 there would not be any gap)

        /* 2ND NOTE: 
         * This will only add zeros between coefficients, but not add any zeros after the last coeff
         * For example: For x^7+x^5, inTempArray = [1,0,1] instead of [1,0,1,0,0,0,0,0]
         * For x^7, intTempArray = [1] instead of [1,0,0,0,0,0,0,0]
         * This zeros will be added in fillSpacesPolyArray() method, that belongs to Polynomial.java
         */
        Integer sizeArr2 = intTempArray2.size();
        int k=1;
        for(int i=0;i<sizeArr2;i++){
            int j=1;
            if(i!=sizeArr2-1){
                if(i!=0){
                    k=k+1;
                }
                while((intTempArray2.get(i)-j)!=intTempArray2.get(i+1)){
                    intTempArray.add(k,0);
                    j++;
                    k++;
                }
            }
        }
        int stop = 0;
        //Now we assign the coeffs intTempArray array to Polynomial object created
        finalPolynomial.setArray(intTempArray);
        
        return finalPolynomial;
    }

    private char[] getChar(String a){
        int j = 0;
        char[] charArray = new char[a.length()+1];
        if(a.charAt(0)!='-' && a.charAt(0)!='+'){
            charArray[j] = '+';
            j++;
            for(int i=0;i<a.length();i++){
                charArray[j] = a.charAt(i);
                j++;
            }
        }
        else{
            for(int i=0;i<a.length();i++){
                charArray[j] = a.charAt(i);
                j++;
            }
        }
        
        return charArray;
    }

    private String[] getTerms(char[] a){
        int m=0,n=0,o=0,p=0;
        String string1 = "";//Will store the coeffs
        String string2 = "";//Will store exp coeffs to determine the degree of the polynomial
        char[] charArray2 = new char[a.length*2];//Will store all exp numbers
        char[] charArray3 = new char[a.length*2];//Stores all exponencials
        String[] stringArray = new String[a.length];
        Boolean flag = false;

        //Still needs fixing whenever we enter a polynomial w/o constant term such as 6x it will crash

        for(int i=0;i<a.length;i++){
            //Find all the +- in the char[]
            if(a[i]=='+'){
                m=i+1;
                if(a[m]=='x' || a[m]=='X'){
                    charArray2[n]='1';
                    n++;
                }
                while(a[m]!='x'&& a[m]!='X'){
                    charArray2[n]=a[m];
                    m++;
                    n++;
                    if(m==a.length){
                        break;
                    }
                }
                if(m!=a.length){
                    charArray2[n]='/';
                n++;
                }
            }else if(a[i]=='-'){
                m=i+1;
                charArray2[n]='-';
                n++;
                if(a[m]=='x' || a[m]=='X'){
                    charArray2[n]='1';
                    n++;
                }
                while(a[m]!='x'&&a[m]!='X'){
                    charArray2[n]=a[m];
                    m++;
                    n++;
                    if(m==a.length){
                        break;
                    }
                }
                if(m!=a.length){
                    charArray2[n]='/';
                    n++;
                }
            }
            //Find all the ^ in the char[]
            if(a[i]=='^'){
                o=i+1;
                while(a[o]!='+' && a[o]!='-'){
                    charArray3[p]=a[o];
                    o++;
                    p++;
                    if(o == a.length){
                        break;
                    }
                }
                charArray3[p]='/';
                p++;
            }
            if(i!=a.length-1){
                if(a[i]=='X' && a[i+1]!='^'){
                    charArray3[p]='1';
                    p++;
                    charArray3[p]='/';
                    p++;
                }else if(a[i]=='x' && a[i+1]!='^'){
                    charArray3[p]='1';
                    p++;
                    charArray3[p]='/';
                    p++;
                }
            }else{
                if(a[i]=='X'){
                    charArray3[p]='1';
                    p++;
                    charArray3[p]='/';
                    p++;
                }else if(a[i]=='x'){
                    charArray3[p]='1';
                    p++;
                    charArray3[p]='/';
                    p++;
                }
            }
            if(flag = detConstant(a[i])){
                charArray3[p]='0';
            }
        }

        //Passing chars to strings, and saving inside stringArray to return it
        //string1 will posses all coeffs separated by '\'
        //string2 will posses all exponential coeffs separated by '\'
        for(int i=0;i<charArray2.length;i++){
            if(charArray2[i]!=0){
                string1 = string1 + charArray2[i];
            }
        }
        stringArray[0] = string1;
        for(int i=0;i<charArray3.length;i++){
            if(charArray3[i]!=0){
                string2 = string2 + charArray3[i];
            }
        }
        stringArray[1] = string2;

        return stringArray;
    }

    private Boolean detConstant(char a){
        Boolean flag = true;
        if(a=='x' || a=='X')
            flag = false;
        return flag;
    }

    /*Code to test PArsing.java */
    /* 
    public static void main(String[] args){
        
        Scanner stdin = new Scanner(System.in);
        String input = stdin.nextLine();
        Parsing p = new Parsing();
        Polynomial pol = p.parse(input);
        System.out.println("The Array and Degree are: ");
        System.out.println(pol.getDegree());
        System.out.println(pol.getArray());
    } */
}