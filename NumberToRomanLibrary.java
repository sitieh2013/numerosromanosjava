package exampleromanlibrary;

/**
 * @author SITIEH (Ing. Alfonso Martínez, Yeiniel) 
 * @mail sitieh2013@gmail.com
 */
public class NumberToRomanLibrary {
    
    public static String Roman1(int natural)
    {
        String numberRoman = "";
        
        //thousand
        int unitThousand = natural / 1000;
        int unit = natural % 1000;
        numberRoman += unitThousand == 1 ? "M" :
                 unitThousand == 2 ? "MM" :
                 unitThousand == 3 ? "MMM" : "";
        
        //hundred
        int unitHundred = unit / 100;
        unit = unit % 100;   
        numberRoman += unitHundred == 1 ? "C" : 
                  unitHundred == 2 ? "CC":
                  unitHundred == 3 ? "CCC":
                  unitHundred == 4 ? "CD":
                  unitHundred == 5 ? "D":
                  unitHundred == 6 ? "DC":
                  unitHundred == 7 ? "DCC":
                  unitHundred == 8 ? "DCCC":
                  unitHundred == 9 ? "CM" : "";
        
        //dozen
        int unitDozens = unit / 10;
        unit = unit % 10;
        numberRoman += unitDozens == 1 ? "X" :
                  unitDozens == 2 ? "XX" :
                  unitDozens == 3 ? "XXX" :
                  unitDozens == 4 ? "XL" :
                  unitDozens == 5 ? "L" :
                  unitDozens == 6 ? "LX" :
                  unitDozens == 7 ? "LXX" :
                  unitDozens == 8 ? "LXXX" :
                  unitDozens == 9 ? "XC" : "";
        
        return numberRoman += unit == 1 ? "I" :
                  unit == 2 ? "II" :
                  unit == 3 ? "III" :
                  unit == 4 ? "IV" :
                  unit == 5 ? "V" :
                  unit == 6 ? "VI" :
                  unit == 7 ? "VII" :
                  unit == 8 ? "VIII" :
                  unit == 9 ? "IX" : "";
    }
    
    public static String Roman2(int natural)
    {
        String[][] list =
        {
            new String[] {"","M","MM","MMM"},
            new String[] {"","C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
            new String[] {"","X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
            new String[] {"","I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"}
        };

        //thousand
        int unitThousand = natural / 1000;
        int unit = natural % 1000;
       //hundred
        int unitHundred = unit / 100;
        unit = unit % 100;
        //dozen
        int unitDozens = unit / 10;
        unit = unit % 10;

        return list[0][unitThousand] + list[1][unitHundred] + list[2][unitDozens] + list[3][unit];
    }
    
    public static String Roman3(int natural)
    {
        String numberRoman = "";
        int[] pow = new int[]{1000, 100, 10, 1};
        
        for(int p : pow )
        {
            int integer = (natural / p) * p;
            natural -= integer;

            if (integer <= 0) continue;
            numberRoman += getRomans1(integer);
        }

        return numberRoman;
    }
    
    public static String Roman4(int natural)
    {
        String numberRoman = "";
        String textNatural = String.valueOf(natural);

        for (int i = 0, j = textNatural.length() - 1; i < textNatural.length(); i++, j--)
        {
            int num = Integer.parseInt(String.valueOf(textNatural.charAt(i)));
            int potencia = (int)Math.pow(10, j);
            int valor = num * potencia;

            numberRoman += getRomans1(valor);
        }
        return numberRoman;
    }
    
    public static String Roman5(int natural)
    {
        return (natural >= 1000
                ? Roman5(natural, 1000)
                : (natural >= 100
                ? Roman5(natural, 100)
                : (natural >= 10 ? Roman5(natural, 10)
                : getRomans1(natural))));
    }
    private static String Roman5(int natural, int pow)
    {
        int integer = natural / pow;
        int roman = integer * pow;
        int rest = natural - roman;

        return getRomans1(roman) + Roman5(rest);
    }
    
    public static String Roman6(int natural)
    {
        String numberRoman = "";
        int[] numbers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        for (int i = 0; i < numbers.length; i++)
        {
            int number = numbers[i];
            while (natural >= number)
            {
                numberRoman += getRomans2(number);
                natural -= number;
            }
        }
        return numberRoman;
    }
    
        public static String Roman7(int natural)
        {
            String[] letter = new String[] { "M", "D", "C", "L", "X", "V", "I" };
            int[] value = { 1000, 500, 100, 50, 10, 5, 1, 0 };

            int meter;
            int rest = natural;
            String roman = "";
            for (int i = 0; i < 7; i++)
            {
                if (rest >= value[i])      
                {                       
                    meter = rest / value[i];  
                    if (rest >= value[i + i % 2] * (4 + (4 * (i % 2) + i % 2)))
                    { 
                        roman += letter[i + (i % 2)] + letter[i - 1]; 
                        rest += i % 2 * (value[i + 1] - value[i]);   
                    }
                    else
                        for (int j = 0; j < meter; j++)  
                            roman += letter[i];
                }
                rest %= value[i];
            }
            return roman;
        }
    
        public static String Roman8(int natural)
        {
            String[] romans = new String[] { "I", "V", "X", "L", "C", "D", "M" };
            String romano = String.valueOf(natural);
            String roman = "";
            int s = 4;
            for (int i = 6; i >= 0; i -= 2)
            {
                if (romano.length() == s)
                {
                    char value = romano.charAt(0);
                    int back = i;

                    switch (value)
                    {
                        case '1': { roman += romans[i]; } break;
                        case '2': { roman += romans[i] + romans[i]; } break;
                        case '3': { roman += romans[i] + romans[i] + romans[i]; } break;
                        case '4': { roman += romans[i] + romans[i + 1]; } break;
                        case '5': { roman += romans[i + 1]; } break;
                        case '6': { roman += romans[i + 1] + romans[back]; } break;
                        case '7': { roman += romans[i + 1] + romans[back] + romans[back]; } break;
                        case '8': { roman += romans[i + 1] + romans[back] + romans[back] + romans[back]; } break;
                        case '9': { roman += romans[i] + romans[i + 2]; } break;
                        default: { roman += ""; } break;
                    }
                   
                    romano = romano.substring(1);
                }
                s--;
            }
            return roman;
        }
        
    private static String getRomans1(int number)
    {
        switch (number)
        {
            case 1: return "I";
            case 2: return "II";
            case 3: return "III";
            case 4: return "IV";
            case 5: return "V";
            case 6: return "VI";
            case 7: return "VII";
            case 8: return "VIII";
            case 9: return "IX";
            case 10: return "X";
            case 20: return "XX";
            case 30: return "XXX";
            case 40: return "XL";
            case 50: return "L";
            case 60: return "LX";
            case 70: return "LXX";
            case 80: return "LXXX";
            case 90: return "XC";
            case 100: return "C";
            case 200: return "CC";
            case 300: return "CCC";
            case 400: return "CD";
            case 500: return "D";
            case 600: return "DC";
            case 700: return "DCC";
            case 800: return "DCCC";
            case 900: return "CM";
            case 1000: return "M";
            case 2000: return "MM";
            case 3000: return "MMM";
            default: return "";
        }
    }
    private static String getRomans2(int number)
    {
        switch (number)
        {
            case 1: return "I";
            case 4: return "IV";
            case 5: return "V";
            case 9: return "IX";
            case 10: return "X";
            case 40: return "XL";
            case 50: return "L";
            case 90: return "XC";
            case 100: return "C";
            case 400: return "CD";
            case 500: return "D";
            case 900: return "CM";
            case 1000: return "M";
            default: return "";
        }
    }
    
    
}
