/*
Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.
*/
public class Solution {
    public String intToRoman(int num) {
        int digits[] = {num % 10, (num / 10) % 10, (num / 100) % 10, (num / 1000) % 10};
        String base[] = {"I", "X", "C", "M"};
        String fifth[] = {"V", "L", "D"};
        String res = "";
        for(int i = 0; i < digits.length; ++i) {
            if(digits[i] != 0) {
                String baseMult = "";
                if(digits[i] % 5 <= 3) {
                    for(int j = 1; j <= digits[i] % 5; ++j) {
                        baseMult = baseMult + base[i];
                    }
                    if(digits[i] >= 5) {
                        baseMult = fifth[i] + baseMult;
                    }
                } else if(digits[i] == 4) {
                    baseMult = base[i] + fifth[i];
                } else if(digits[i] == 9) {
                    baseMult = base[i] + base[i+1];
                }
                res = baseMult + res;
            }
        }
        return res;
    }
}
