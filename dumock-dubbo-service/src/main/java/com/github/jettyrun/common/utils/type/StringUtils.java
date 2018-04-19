package com.github.jettyrun.common.utils.type;

/**
 * Created by jetty on 18/2/11.
 */
public class StringUtils {

    public static boolean isBlank(String text){
        return ObjectUtils.isEmpty(text)||text.trim().equals("");
    }


    public static String getLengthStringByIndex(String textParam,int length,char index,boolean tail){

        String text=textParam;
        if(isBlank(text)){
            text=new String();
        }
        if(text.length()>=length){
            return text.substring(text.length()-length,text.length());
        }else{

            int indexNum=length-text.length();
            char[] indexes=new char[indexNum];
            for(int i=0;i<indexNum;i++){
                indexes[i]=index;
            }
            String indexString=new String(indexes);
            if(tail){
                return String.format("%s%s", text, indexString);
            }else{
                return String.format("%s%s",indexString,text);
            }
        }
    }

    public static String replace(String inString, String oldPattern, String newPattern) {
        if (!hasLength(inString) || !hasLength(oldPattern) || newPattern == null) {
            return inString;
        }
        StringBuilder sb = new StringBuilder();
        int pos = 0;
        int index = inString.indexOf(oldPattern);
        int patLen = oldPattern.length();
        while (index >= 0) {
            sb.append(inString.substring(pos, index));
            sb.append(newPattern);
            pos = index + patLen;
            index = inString.indexOf(oldPattern, pos);
        }
        sb.append(inString.substring(pos));
        return sb.toString();
    }


    public static boolean hasLength(CharSequence str) {
        return (str != null && str.length() > 0);
    }
    public static boolean hasLength(String str) {
        return (str != null && !str.isEmpty());
    }



}


