package racingcar.view;

import java.util.Scanner;

public class InputView {
    Scanner scanner = new Scanner(System.in);
    public String InputCarsName(){
        return scanner.nextLine();
    }

    public Integer InputTrialCount(){
        return scanner.nextInt();
    }
}
