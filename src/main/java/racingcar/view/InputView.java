package racingcar.view;


import camp.nextstep.edu.missionutils.Console;
import java.math.BigInteger;


public class InputView {


   public static String getCarNames() {
       System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
       return Console.readLine();
   }
  
   public static BigInteger getAttempts() {
       System.out.println("시도할 횟수는 몇 회인가요?");
       try {
           String input = Console.readLine().trim();
           BigInteger attempts = new BigInteger(input);
           if (attempts.compareTo(BigInteger.ZERO) <= 0) {
               throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
           }
           return attempts;
       } catch (NumberFormatException e) {
           throw new IllegalArgumentException("숫자를 입력해야 합니다.");
       }
   }
}
