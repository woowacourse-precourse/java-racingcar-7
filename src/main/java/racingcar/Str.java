package racingcar;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Str {
    private static String DELIMITER = ",";
    private String check(String str){
        str = str.trim();

        String regex = "[^a-zA-Z0-9\\s]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);

        if(matcher.find())
            throw new IllegalArgumentException("특수문자 들어옴");

        return str;
    }

    public ArrayList<Car> arrayToList(String inputString){
        String[] strs = inputString.split(DELIMITER);
        ArrayList<Car> list = new ArrayList<>();
        for(String str : strs){
            list.add(new Car(check(str)));
        }
        return list;
    }
}
