package exampleromanlibrary;

/**
 * @author SITIEH (Ing. Alfonso Martínez, Yeiniel) 
 * @mail sitieh2013@gmail.com
 */

public class RomanNumber {
    
    private final int _number;
    private final String _roman;
       
    public int getNatural(){
        return _number;
    }
    public String getRoman(){
        return _roman;
    }    
   
    public RomanNumber(String roman){
       _number = RomanToNumberLibrary.Number1(roman);
       _roman = roman;
   }
    public RomanNumber(int number){
       _number = number;
       _roman = NumberToRomanLibrary.Roman5(number);
   }
   
    public static RomanNumber createRoman(String roman){
        return new RomanNumber(roman);
    }
    public static RomanNumber createRoman(int number){
        return new RomanNumber(number);
    }
    
    public static RomanNumber sumRoman(RomanNumber romanNumber1, RomanNumber romanNumber2){
        return new RomanNumber(romanNumber1.getNatural() + romanNumber2.getNatural());       
    }
    public RomanNumber sumRoman(RomanNumber romanNumber){
        return new RomanNumber(_number + romanNumber.getNatural());
    }
    
    @Override
    public String toString() {
        return "(Roman = "+ _roman + " Number = "+_number+ ")";
    }

    @Override
    public boolean equals(Object obj) {
        
        RomanNumber temp = (RomanNumber)obj;
        
        return temp.getNatural()==getNatural(); 
    }

    
    public static void main(String[] args){
        
        RomanNumber romanNumber = new RomanNumber(25);
        RomanNumber romanNumber1 = new RomanNumber("XXV");
        
        RomanNumber result = romanNumber.sumRoman(romanNumber1);
        
        System.out.println(romanNumber+" + " + romanNumber1 + " = " + result);
    }
}
