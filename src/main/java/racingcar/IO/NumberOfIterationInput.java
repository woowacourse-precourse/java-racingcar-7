package racingcar.IO;
import camp.nextstep.edu.missionutils.Console;

public class NumberOfIterationInput {
   public static int getIteration(){
       int iteration = Integer.parseInt(Console.readLine());
       return iteration;
   }
}
