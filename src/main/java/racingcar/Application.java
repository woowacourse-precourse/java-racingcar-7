package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import net.bytebuddy.agent.builder.AgentBuilder;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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

    public static List<List<Object>> carStatus(String[] names)
    {
        List<List<Object>> carStatus = new ArrayList<>();
        for (String name : names) {
            List<Object> setCarStatus = new ArrayList<>();
            setCarStatus.add(name);
            setCarStatus.add(0);
            carStatus.add(setCarStatus);
        }
        return carStatus;
    }

    public static List<Object> isRun(List<Object> status)
    {
        if(Randoms.pickNumberInRange(0,9)>=4)
            status.set(1,(int)status.get(1)+1);

        return status;
    }

    public static List<List<Object>> run(List<List<Object>> status)
    {
        List<List<Object>> newStatus=new ArrayList<>();
        for(List<Object> temp: status)
            newStatus.add(isRun(temp));

        return newStatus;
    }

    public static void printResult(List<List<Object>> status)
    {
        for(List<Object> temp : status) {
            System.out.print(temp.get(0) + " : ");
            printBar((int) temp.get(1));
        }
        System.out.println();
    }

    public static void printBar (int number)
    {
        for(int i=0; i<number; i++)
            System.out.print('-');
        System.out.println();
    }

    public static List<List<Object>> runCountTime(int count, List<List<Object>> Status)
    {
        List<List<Object>> preStatus=Status;

        for(int i=0; i<count; i++)
        {
            preStatus=run(preStatus);
            printResult(preStatus);
        }
        return preStatus;
    }

    public static void result(int count, List<List<Object>> status)
    {
        List<List<Object>> finalStatus = runCountTime(count, status);

        int maxDistance = findMaxDistance(finalStatus);
        List<String> winners = findWinners(finalStatus, maxDistance);
        printWinner(winners);
    }

    private static int findMaxDistance(List<List<Object>> status)
    {
        int maxDistance = -1;
        for (List<Object> carStatus : status)
        {
            int currentDistance = (int) carStatus.get(1);
            if (currentDistance > maxDistance)
                maxDistance = currentDistance;
        }
        return maxDistance;
    }

    private static List<String> findWinners(List<List<Object>> status, int maxDistance) {
        List<String> winners = new ArrayList<>();
        for (List<Object> carStatus : status)
        {
            int currentDistance = (int) carStatus.get(1);
            if (currentDistance == maxDistance)
                winners.add((String) carStatus.get(0));
        }
        return winners;
    }

    public static void printWinner(List<String> winner)
    {
        System.out.print("최종 우승자 : ");

        for(int i=0; i<winner.size(); i++)
        {
            System.out.print(winner.get(i));
            if(i<winner.size()-1)
                System.out.print(", ");
        }
    }

    public static void main(String[] args)
    {
        String[] tokenName=nameInput();
        int count=countInput();

        result(count, carStatus(tokenName));
    }
}
