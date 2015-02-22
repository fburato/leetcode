/*
Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
*/
public class Solution {
    public String simplifyPath(String path) {
        String[] directories = path.split("/");
        String[] res = new String[directories.length];
        int start = 0, end = directories.length-1;
        if(start <= end && (directories[start].equals("") || directories[start].equals("..") || directories[start].equals("."))) {
            start++;
        }
        if(end >= start && directories[end].equals("")) {
            end--;
        }
        int pointer = 0;
        for(int j = start; j <= end; ++j) {
            if(directories[j].equals("..")){
                pointer = Math.max(0,pointer-1);
            } else if(directories[j].equals(".") || directories[j].equals("")){
                pointer = pointer;
            } else {
                res[pointer] = directories[j];
                pointer++;
            }
        }
        String absolute = "/", sep = "";
        for(int i = 0; i < pointer; ++i) {
            absolute = absolute + sep + res[i];
            sep = "/";
        }
        return absolute;
    }
}
