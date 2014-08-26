/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reillycal;

/**
 *
 * @author Reilly Noonan Grant
 */
public class BaseConverter {
    private static final char[] values= new char[]{'0','1','2','3','4','5','6','7','8','9',
   'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P',
   'Q','R','S','T','U','V','W','X','Y','Z'};;
    
    /**
     * Converts a number in non base 10 between 1-36 inclusive to base ten
     * @param rep a representation of a number in a given base
     * @param base the base of the number
     */
    public static int convertToTen(char[] rep, int base){
        int sum=0;
        for (int i=rep.length-1; i>=0;i--){
            if(valueOf(rep[i])>=base){return -1;}
            sum+= valueOf(rep[i])*Math.pow(base, rep.length-(i+1)) ;
        }
        return sum;
    }
    /**
     * 
     * @param rep a representation of the number in the given base b1
     * @param b1 the initial base
     * @param bF the final base
     * @return character array representing the number in the final base
     */
    public static char[] convertGen(char[] rep, int b1, int bF){
        if(b1==bF){return rep;}
        char[] temp;
        int bTen= convertToTen(rep,b1);
        int length = 0;
        while(Math.pow(bF,length)<bTen){length++;}//finds length of final char[]
        temp = new char[length]; for(char c:temp){c='0';}
        int i =0;
        while(bTen>0&&i<temp.length){
            int Exponent= length-(i+1);
            int k =0;
            while(bTen>(Math.pow(bF,Exponent))){
                k++;
            bTen-=(Math.pow(bF, Exponent));
            }
            if(i!=temp.length-1){
            temp[i]= values[k];
            }
            else{temp[i]=values[k+1];}
            i++;
        }
        return temp;
    }
    
    /**
     * Finds the index of the character in the array value
     */
    private static int valueOf(char c){
        for(int i =0; i< values.length; i++){
            if(values[i]==c){return i;}
        }
        return 1000;
    }
    
}
