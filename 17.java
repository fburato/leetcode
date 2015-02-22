/*
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

*/

import java.util.LinkedList;
public class Solution {
    public char combinations[][] = 
    { {' '}, // 0
      null, // 1
      {'a','b','c'}, //2
      {'d','e','f'}, //3
      {'g','h','i'}, //4
      {'j','k','l'}, //5
      {'m','n','o'}, //6
      {'p','q','r','s'}, //7
      {'t','u','v'}, //8
      {'w','x','y','z'} //9
    };
    public List<String> letterCombinations(String digits) {
        List<String> result = new LinkedList();
        letterCombinations(digits,0,result,"");
        return result;
    }
    
    public void letterCombinations(String digits, int index, List<String> result, String current) {
        if(index == digits.length()){
            result.add(current);
        } else if(digits.charAt(index) == '1' || digits.charAt(index) < '0' || digits.charAt(index) > '9'){
            throw new RuntimeException();
        } else {
            char currentComb[] = combinations[digits.charAt(index) - '0'];
            for(int i = 0; i < currentComb.length ;++i) {
                letterCombinations(digits,index+1,result, current + currentComb[i]);
            }
        }
    }
}
