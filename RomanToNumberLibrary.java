package exampleromanlibrary;

import java.util.ArrayList;

/**
 * @author SITIEH (Ing. Alfonso Martínez, Yeiniel) 
 * @mail sitieh2013@gmail.com
 */

public class RomanToNumberLibrary {
    
    public static int Number1(String numberRoman)
    {
        int total = 0, number = 0;
        
        for (int i = 0; i < numberRoman.length(); i++) {
            int numberNow = GetNumber(numberRoman.charAt(i));
            
            if (number == 0){
                number = numberNow; continue;}

            if (number < numberNow)
                number = -number;

            total += number;
            number = numberNow;
        }
        return total + number;
    }
    
    public static int Number2(String numberRoman)
    {
        int[] array = new int[numberRoman.length()];

        for (int i = 0; i < numberRoman.length(); i++)
        {
            int n1 = GetNumber(numberRoman.charAt(i));
                
            if (i == 0){
                array[i] = n1; continue;
            }

            int n0 = array[i - 1];

            if (n0 < n1)
               array[i - 1] = -n0;

            array[i] = n1;
        }

        int total = 0;

        for(int i : array){ total += i;}

        return total;
    }

        public static int Number3(String numberRoman)
        {
            int number = 0;
            int back = 0;

            for (int j = numberRoman.length() - 1; j >= 0; j--)
            {
                int compare = GetNumber(numberRoman.charAt(j));
                if (compare < back)
                    number -= compare;
                else
                    number += compare;
                back = compare;
            }
            return number;
        }
    
    private static int GetNumber(char roman)
    {
        return roman == 'M' ? 1000 :
               roman == 'D' ? 500 :
               roman == 'C' ? 100 :
               roman == 'L' ? 50 :
               roman == 'X' ? 10 :
               roman == 'V' ? 5 :
               roman == 'I' ? 1 : 0;
    }
}
