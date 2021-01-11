package solution;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args){
        String arg = args[0];
        Integer value = Integer.valueOf(arg);
        if(value> 0 && value<1000000000) {
            String[] split = arg.split("");
            List<String> lastResult = new ArrayList<>();
            List<String> collect = Arrays.stream(split).collect(Collectors.toList());
            List<String> finalResult = permute(collect, 0, lastResult);
            System.out.println("Possible numbers: "+finalResult.size());
        }else{
            System.out.println("Invalid Error");
        }
    }

    static List<String> permute(List<String> valueResult, int sequence, List<String> lastResult){
        for(int i = sequence; i < valueResult.size(); i++){
            Collections.swap(valueResult, i, sequence);
            permute(valueResult, sequence+1,lastResult);
            Collections.swap(valueResult, sequence, i);
        }
        if (sequence == valueResult.size() -1){
            addResult(valueResult, lastResult);
        }
        return lastResult;
    }

    private static void addResult(List<String> arr, List<String> lastResult) {
        String result = result(arr);
        String[] split = result.split("");
        if(!split[0].equals("0")) {
            lastResult.add(result);
            System.out.println(result);
        }
    }

    public static String result(List<String> array){
        String result= "";
        for ( String x : array){
            result +=x;
        }
        return result;
    }
}
