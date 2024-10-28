package racingcar.IO;
import camp.nextstep.edu.missionutils.Console;

public class NumberOfIterationInput {
    public static int getIteration(){
        try {
            int iteration = Integer.parseInt(Console.readLine());
            return iteration;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("횟수는 정수만 입력해주세요.");
        }
    }
}
