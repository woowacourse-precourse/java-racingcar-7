package InputOutput;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static String[] insertCarsName(){
        return Console.readLine().split(",");
    }
    public static int numberOfRounds(){
        int count = 0;
        try{
            count = Integer.parseInt(Console.readLine());
            if(count < 0){
                throw new IllegalArgumentException("음수가 들어갔습니다.");
            }
            return count;
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("문자가 들어갔습니다.");
        }
    }
}
