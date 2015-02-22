/*
Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
*/
public class Solution {
    public String convertToTitle(int n) {
        if(n <= 0) {
            return "";
        }
        char[] conversion = new char[26];
        for(int i = 0; i < conversion.length; ++i) {
            conversion[i] = (char) (i + 'A');
        }
        StringBuilder res = new StringBuilder("");
        while(n>0) {
            res.insert(0,conversion[(n-1) % 26]);
            n = (n-1) / 26;
        }
        return res.toString();
    }
}
