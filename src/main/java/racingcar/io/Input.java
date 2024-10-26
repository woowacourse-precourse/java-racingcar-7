package racingcar.io;

import javax.swing.text.html.parser.Parser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Input {

    public static ArrayList<String> inputCarName() {

        System.out.println("참여할 자동차 이름을 알려주세요");

        // "apple,orange,3,4"
        String input = readLine();

        return splitCarName(input);

    }


    public static int inputTryNumber() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String tryNum = readLine();
        return tryNumberValidation(tryNum);
    }
    public static ArrayList<String> splitCarName (String input) {

        String[] str = input.split(",");

        carNameValidation(str);

        ArrayList<String> splitInput = new ArrayList<>();

        for(String name : str){
            splitInput.add(name);
        }

        return splitInput;
    }

    public static int tryNumberValidation(String tryNum) {
        int parserInt = 0;
        try {
            parserInt = Integer.parseInt(tryNum);
        } catch (Exception e) {
            throw new IllegalArgumentException("시도횟수는 숫자만 입력가능합니다.");
        }
        return parserInt;

    }
    public static boolean carNameValidation(String[] str) {

        if(str.length == 0) {
            throw new IllegalArgumentException("이름을 입력해주세요, 비어있는 이름이 있습니다. ");
        }

        for(String name : str) {
            if(name.length() == 0) {
                throw new IllegalArgumentException("이름을 입력해주세요, 비어있는 이름이 있습니다. ");
            }

            if(name.length()>5)
                throw new IllegalArgumentException("이름을 5자 이내로 입력하세요.");
        }
            return true;
    }

        public static void print (ArrayList<String> prints) {
            for (String print : prints) {
                System.out.println("*"+print);
            }
        }

    }
