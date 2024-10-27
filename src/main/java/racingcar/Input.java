package racingcar;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Input {
  private static final Scanner scanner = new Scanner(System.in);

  public static List<String> inputCarNames() {
    System.out.println("자동차들: ");
    String input = scanner.nextLine();
    return Stream.of(input.split(",")).map(String::trim).toList();
  }
    
  public static int inputRound() {
    System.out.println("라운드: ");
    return scanner.nextInt();
  }
}
