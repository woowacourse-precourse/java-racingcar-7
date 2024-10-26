package racingcar;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Input {
  private static final Scanner scanner = new Scanner(System.in);

  public static List<String> inputCarNames() {
    
    System.out.println("자동차들: ");
    String input = scanner.nextLine();
    return List.of(input.split(",")).stream().map(String::trim).collect(Collectors.toList());
  }
    
  public static int inputRound() {
    System.out.println("라운드: ");
    return scanner.nextInt();
  }
}
