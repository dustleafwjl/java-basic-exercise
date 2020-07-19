import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GrammarExercise {
    public static void main(String[] args) {
        //需要从命令行读入
        String firstWordList = "";
        String secondWordList = "";

        List<String> result = findCommonWordsWithSpace(firstWordList,secondWordList);
        //按要求输出到命令行

    }

    public static List<String> findCommonWordsWithSpace(String firstWordList, String secondWordList) {
        //在这编写实现代码
        if(firstWordList.contains(",,") || !firstWordList.matches("[a-zA-Z,]+") || !secondWordList.matches("[a-zA-Z,]+")) {
            throw new RuntimeException("input not valid");
        }
        List<String> firstArr = Arrays.asList(firstWordList.split(","));
        List<String> secondArr = Arrays.asList(secondWordList.split(","));
        List<String> result = firstArr.stream().filter(string -> listContains(secondArr, string)).map(string -> string.toUpperCase().replace("", " ").trim()).distinct().collect(Collectors.toList());
        return result;
    }
    private static boolean listContains(List<String> list, String ele){
        for(String t:list)
        {
            if(t.equalsIgnoreCase(ele))
                return true;
        }
        return false;
    }
}
