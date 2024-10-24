package racingcar;
import camp.nextstep.edu.missionutils.Console;

public class Input {
  public static String[] carName(){
    System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    String[] names = Console.readLine().split(",");
    for(String s: names){
      if(s.isEmpty() || s.length() > 5){
        throw new IllegalArgumentException("자동차 이름이 공백이거나 5자를 초과하였습니다.");
      }
    }
    return names;
  }
}
