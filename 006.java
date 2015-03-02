/*
 The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R

And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);

convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR". 
*/

public class Solution {
    public String convert(String s, int nRows) {
        if(nRows == 1){
            return s;
        }
        int period = 2*nRows - 2;
        String res = "";
        for(int i = 0; i < nRows; ++i) {
            int distance[];
            if(i == 0 || i == nRows-1) {
                distance = new int[] {period,period};
            } else {
                int baseDist = nRows -1 - i;
                distance = new int[] {baseDist*2,i*2};
            } 
            int index = 0;
            for(int j = i; j < s.length();) {
                res = res + s.charAt(j);
                j += distance[index];
                index = (index + 1) %2;
            }
        }
        return res;
    }
 
}
