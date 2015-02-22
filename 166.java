/*
Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

For example,

    Given numerator = 1, denominator = 2, return "0.5".
    Given numerator = 2, denominator = 1, return "2".
    Given numerator = 2, denominator = 3, return "0.(6)".

*/
import java.util.ArrayList;

public class Solution {
    public String fractionToDecimal(int inumerator, int idenominator) {
        StringBuilder res = new StringBuilder("");
        long numerator = inumerator;
        long denominator = idenominator;
        if(denominator == 0) {
            return res.toString();
        }
        if(numerator == 0) {
            return "0";
        }
        if((numerator >= 0) != (denominator >= 0)){
            res.append("-");
        }
        if(numerator < 0) {
            numerator = -numerator;
        }
        if(denominator < 0) {
            denominator = -denominator;
        }
        long decimal = numerator / denominator;
        long reminder = numerator % denominator;
        res.append(decimal);
        if(reminder != 0) {
            res.append(".");
            ArrayList<Long> reminders = new ArrayList<>();
            while(!reminders.contains(reminder) && reminder != 0) {
                reminders.add(reminder);
                reminder = (reminder * 10) % denominator;
            }
            int i = 0;
            for(; i < reminders.size() && reminders.get(i) != reminder; ++i) {
                res.append((reminders.get(i) * 10) / denominator);
            }
            if(reminder != 0) {
                res.append("(");
                for(; i < reminders.size(); ++i) {
                    res.append((reminders.get(i) * 10) / denominator);
                }
                res.append(")");
            }
        }
        return res.toString();
    }
}
