package racingcar;

public class Util {
   public static boolean isValidRoundNumber(Input input) {
       try{
           Integer.parseInt(input.getRounds());
           return true;
       } catch (NumberFormatException e) {
           return false;
       }
   }
}
