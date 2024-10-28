package racingcar.view;


import camp.nextstep.edu.missionutils.Console;
import racingcar.exception.ErrorCode;

public class InputView {

    public String getRacingCarNamesWithDelimeter(){

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        try{
            String carNamesWithDelimeter = Console.readLine();
            return carNamesWithDelimeter;

        }catch (Exception e){
            throw new IllegalArgumentException(ErrorCode.ABNORMAL_USER_INPUT.getMessage());
        }

    }

    public int getCountOfTry(){

        System.out.println("시도할 횟수는 몇 회인가요?");
        String countOfTry = Console.readLine();

        try{
            return Integer.valueOf(countOfTry);
        }catch(Exception e){
            throw new IllegalArgumentException(ErrorCode.CANT_CONVERT_TO_INTEGER.getMessage());
        }
    }


}
