package racingcar;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {
   public static boolean isValidRoundNumber(Input input) {
       try{
           Integer.parseInt(input.getRounds());
           return true;
       } catch (NumberFormatException e) {
           return false;
       }
   }

    public static boolean isValidCarNamesInput(Input input) {
       String regex = "^([\\s\\w\\uAC00-\\uD7A3\\p{Punct}]{1,5})(,(?!$)[\\s\\w\\uAC00-\\uD7A3\\p{Punct}]{1,5})*$|^([\\s\\w\\uAC00-\\uD7A3\\p{Punct}]{1,5})$";
       Pattern pattern = Pattern.compile(regex);
       Matcher matcher = pattern.matcher(input.getCarNames());
       return matcher.matches();
    }
}
