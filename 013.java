/*
Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.
*/

public class Solution {
    class Pair {
        public int first;
        public int second;
        public Pair(int f, int s){
            first = f;
            second = s;
        }
    }
    public int romanToInt(String s) {
        int res = 0;
        char[] num = s.toCharArray();
        int pos = 0;
        while(pos < num.length) {
            char unit = 0, dec = 0, five = 0;
            int unitVal = 0, decVal = 0, fiveVal = 0;
            Pair p = null;
            switch(num[pos]) {
                case 'M' : 
                    pos++;
                    p = parseThous(num,pos);
                    break;
                case 'D' :
                    unit = 'C'; unitVal = 100;
                    fiveVal = 5*unitVal;
                    pos++;
                    p = parseFive(num,pos,fiveVal,unit, unitVal);
                    break;
                case 'L' :
                    unit = 'X' ; unitVal = 10;
                    fiveVal = 5*unitVal;
                    pos++;
                    p = parseFive(num,pos,fiveVal,unit, unitVal);
                    break;
                case 'V' :
                    unit = 'V' ; unitVal = 1; 
                    fiveVal = 5*unitVal;
                    pos++;
                    p = parseFive(num,pos,fiveVal,unit, unitVal);
                    break;
                case 'C' :
                    unit = 'C'; unitVal = 100; five = 'D'; dec = 'M';
                    fiveVal = 5*unitVal;
                    decVal = 10*unitVal;
                    pos++;
                    p = parseUnit(num,pos,unit,unitVal,five,fiveVal,dec,decVal);
                    break;
                case 'X' :
                    unit = 'X'; unitVal = 10; five = 'L' ; dec = 'C';
                    fiveVal = 5*unitVal;
                    decVal = 10*unitVal;
                    pos++;
                    p = parseUnit(num,pos,unit,unitVal,five,fiveVal,dec,decVal);
                    break;
                case 'I' :
                    unit = 'I'; unitVal = 1; five = 'V' ; dec = 'X';
                    fiveVal = 5*unitVal;
                    decVal = 10*unitVal;
                    pos++;
                    p = parseUnit(num,pos,unit,unitVal,five,fiveVal,dec,decVal);
                    break;
            }
            res += p.first;
            pos = p.second;
        }
        return res;
    }
    
    public Pair parseThous(char num[], int pos){
        // num[pos-1] == 'M'
        int base = 1000;
        while(pos < num.length && num[pos] == 'M'){
            base += 1000;
            pos++;
        }
        return new Pair(base,pos);
    }
    
    public Pair parseFive(char num[], int pos, int fiveVal, char unit, int unitVal) {
        int base = fiveVal;
        while(pos < num.length && num[pos] == unit) {
            base += unitVal;
            pos++;
        }
        return new Pair(base,pos);
    }
    
    public Pair parseUnit(char num[], int pos, char unit, int unitVal, char five, int fiveVal, char dec, int decVal) {
        // read a unit
        int base = unitVal;
        if(pos < num.length) { 
            if(num[pos] == five) {
                base = fiveVal - unitVal;
                pos++;
            } else if(num[pos] == dec) {
                base = decVal - unitVal;
                pos++;
            } else {
                base = unitVal;
                while(pos < num.length && num[pos] == unit) {
                    base += unitVal;
                    pos++;
                }
            }
        }
        return new Pair(base,pos);
    }
}
