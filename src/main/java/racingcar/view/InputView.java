package racingcar.view;

import java.util.Scanner;

public class InputView {
    Scanner scanner = new Scanner(System.in);
    public String InputCarNames(){
        return scanner.nextLine();
    }

    public Integer InputTrialCount(){
        return scanner.nextInt();
    }
}
