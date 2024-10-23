package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

public class Application
{
    public static String noInputError()
    {
        String input="";
        try
        {
            input=Console.readLine();
        }
        catch (NoSuchElementException e)
        {
            throwInputError();
        }
        return input;
    }

    public static void checkWrongString(String name)
    {
        if(name.isEmpty()||name.length()>5)
            throwInputError();
    }

    public static int checkWrongInt(String input)
    {
        int count=0;
        try
        {
            if(input.isEmpty())
                throwInputError();

            count = Integer.parseInt(input);

            if(count<1)
                throwInputError();
        }
        catch (NumberFormatException e)
        {
            throwInputError();
        }
        return count;
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
            checkWrongString(carName[i]);
        }
        return carName;
    }

    public static String[] nameInput()
    {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = noInputError();
        return splitNames(carNames);
    }

    public static int countInput()
    {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return checkWrongInt(noInputError().trim());
    }

    public static void printInput(String[] names, int num)
    {
        for(String name:names)
            System.out.println(name);

        System.out.println(num);
    }

    public static void main(String[] args)
    {
        String[] tokenName=nameInput();
        int count=countInput();

        printInput(tokenName,count);
    }
}
