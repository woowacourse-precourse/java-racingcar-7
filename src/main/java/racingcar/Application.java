package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application
{

    public static void checkWrongInput(String name)
    {
        if(name.length()>5)
            throwInputError();
    }

    public static void throwInputError()
    {
        throw new IllegalArgumentException();
    }

    public static String[] splitNames(String carNames)
    {
        String[] carName = carNames.split(",");
        for(int i=0; i<carName.length;i++)
        {
            carName[i]=carName[i].trim();
            checkWrongInput(carName[i]);
        }
        return carName;
    }

    public static String[] nameInput()
    {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        return splitNames(carNames);
    }

    public static int countInput()
    {
        return Integer.parseInt(Console.readLine());
    }

    public static void main(String[] args)
    {
        //TODO 5글자 이하인지 검증-잘못 입력시 오류
        //TODO 반복횟수 입력
        String[] tokenName=nameInput();
        int count=countInput();
    }
}
