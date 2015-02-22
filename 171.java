/*
Related to question Excel Sheet Column Title

Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
*/
public class Solution {
    public int titleToNumber(String s) {
        int column = 0;
        char[] sArr = s.toCharArray();
        for(int i = 0; i < sArr.length; ++i) {
            column = column*26 + sArr[i]-'A' + 1;
        }
        return column;
    }
}
