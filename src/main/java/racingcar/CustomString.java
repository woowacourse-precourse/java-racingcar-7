package racingcar;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomString {
    private static String DELIMITER = ",";

    public ArrayList<Car> arrayToList(String inputString){
        String[] strs = inputString.split(DELIMITER);
        ArrayList<Car> list = new ArrayList<>();
        for(String str : strs){
            list.add(new Car(check(str)));
        }
        return list;
    }

    private String check(String str){
        str = str.trim();

        if(str.length() >= 6 || str.isEmpty())
            throw new IllegalArgumentException("too long name");

        String regex = "[^a-zA-Z0-9\\s]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);

        if(matcher.find())
            throw new IllegalArgumentException("특수문자 들어옴");

        return str;
    }

    public int stringToInt(String input){
        if(input.isEmpty())
            throw new IllegalArgumentException("empty count");
        int re = Integer.parseInt(input);
        if(re <= 0)
            throw new IllegalArgumentException("count <= 0");

        return re;
    }
}
