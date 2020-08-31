import info.debatty.java.stringsimilarity.QGram;

import java.util.Map;

public class QGramWrapper {

    private static int N;

    public QGramWrapper(int n) {
        N = n;
    }

    public double distance(String str1, String str2){
        int totalKeys = getTotalKeys(new QGram(N).getProfile(makeString(str1)));
        totalKeys += getTotalKeys(new QGram(N).getProfile(makeString(str2)));
        double distance = new QGram(N).distance(makeString(str1), makeString(str2));
        return (totalKeys - distance)/totalKeys;
    }

    public String printTokens(String str){
        Map<String,Integer> map = new QGram(N).getProfile(makeString(str));
        StringBuilder string = new StringBuilder();
        map.forEach((k,v) -> string.append(String.format("%s    %d \n", k,v)));
        return string.toString();
    }

    static private void appends(StringBuilder str){
        for(int i=0; i<N-1; i++){
            str.append("#");
        }
    }

    static private String makeString(String str){
        StringBuilder aux = new StringBuilder();
        appends(aux);
        aux.append(str);
        appends(aux);
        return aux.toString();
    }

    static private int getTotalKeys(Map<String,Integer> map){
        int totalKeys = 0;
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            totalKeys += entry.getValue();
        }
        return totalKeys;
    }


}
