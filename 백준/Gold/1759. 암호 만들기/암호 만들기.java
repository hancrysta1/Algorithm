//package org.server;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    static String[] arr;
    static StringBuilder sb;
    static int L;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        TreeSet<String> atoms = new TreeSet<>();
        for (int i = 0; i < C; i++) {
            atoms.add(st.nextToken());
        }
        //System.out.println(atoms);
        arr = atoms.toArray(new String[0]);
        sb = new StringBuilder();
        backtrack(0,new ArrayList<>());
        System.out.println(sb);
    }
    public static void backtrack(int startIdx, ArrayList<Character> curr){
        if(curr.size()==L){
            if(isValidPwd(curr)){
                for(char x:curr){
                    sb.append(x);
                }
                sb.append("\n");
                return;
            }
        }
        for(int i=startIdx;i<arr.length;i++){
            curr.add(arr[i].charAt(0));
            backtrack(i+1,curr);
            curr.remove(curr.size()-1);
        }
    }

    public static boolean isValidPwd(ArrayList<Character> pwd){
        int vowel=0; int constant=0;
        for(char x:pwd){
            if("aeiou".indexOf(x)>=0) vowel++;
            else constant++;
        }
        if(vowel>=1 && constant>=2) return true;
        return false;
    }
}

