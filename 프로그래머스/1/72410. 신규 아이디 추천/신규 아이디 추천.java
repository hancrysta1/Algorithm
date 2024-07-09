class Solution {
    public String solution(String new_id) {
        //1단계
        new_id = new_id.toLowerCase();
        String s ="";
        //2단계
        for(int i=0;i<new_id.length();i++){
            char c = new_id.charAt(i);
            if(Character.isDigit(c) || Character.isLowerCase(c) || c == '-'
                    || c == '_' || c == '.'){
                s+=c;
            }
        }
        //3단계
        s = s.replaceAll("\\.{2,}", ".");
        //4단계
        if(s.startsWith(".")) s = s.substring(1);
        if(s.endsWith(".")) s = s.substring(0,s.length()-1);

        //5단계
        if (s.equals("")) s = "a";

        //6단계
        if(s.length()>=16){
            s = s.substring(0,15);
            if(s.endsWith(".")) s=s.substring(0,14);
        }
        //7단계
        if(s.length()<=2){
            while (s.length()<3){
                s +=String.valueOf(s.charAt(s.length()-1));
            }
        }

        return s;
    }
}