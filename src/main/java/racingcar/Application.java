package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] nameList = splitName(getName());
        System.out.println("시도할 횟수는 몇 회인가요?");
        int num = Integer.parseInt(getNum());
        result(nameList, num);

    }

    // 이름을 입력하는 메소드
    public static String getName() {
        String name = Console.readLine();

        if (name.trim().isEmpty() ||  name.matches(",+") || !name.contains(",")){
            throw new IllegalArgumentException("이름이 공백이거나, 구분자가 없거나, 구분자로만 입력되어 있습니다.");
        }
        return name;
    }

    // 몇 회 실행할건지 입력하는 메소드
    public static String getNum() {
        String num = Console.readLine(); // 사용자 입력 받기

        try {
            int number = Integer.parseInt(num);

            if (number <= 0) {
                throw new IllegalArgumentException("음수 혹은 0은 입력할 수 없습니다.");
            }
            return num;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값을 입력할 수 없습니다."); // 숫자가 아닌 경우
        }
    }

    // 랜덤 숫자 생성 메소드
    public static int randomNum(){
        int a = Randoms.pickNumberInRange(0,9);
        return a;
    }

    // 랜덤 숫자가 4 이상인 경우 "-"를 리턴하는 메소드
    public static String numBar(int randomNum){
        String bar;
        if(randomNum>3){
            return "-";
        }
        return "";
    }

    // "-"의 갯수를 숫자로 변환하고 최댓값의 인덱스를 구하는 메소드
    public static ArrayList<Integer> barToNum(String[] barList){

        int[] numbers = new int[barList.length];

        for(int i = 0; i < barList.length; i++){
            numbers[i] = barList[i].length();
        }

        // 변환된 숫자 중 최댓값의 인덱스를 배열에 할당
        ArrayList<Integer> indexNum = new ArrayList<>();

        int maxValue = 0;
        for (int value : numbers){
            if(value > maxValue) {
                maxValue = value;
            }
        }

        for(int i =0; i < numbers.length; i++){
            if (numbers[i] == maxValue){
                indexNum.add(i);
            }
        }

        return indexNum;
    }

    // 이름을 , 단위로 구분하는 메소드
    public static String[] splitName(String name){
        return name.split(",");
    }

    // 결과를 출력하는 메소드
    public static void result(String[] nameList, int num){
        System.out.println("실행 결과");

        String[] barList = new String[nameList.length];
        for(int j = 0; j< barList.length; j ++){
            barList[j] = "";
        }

        int i = 0;
        while(i<num){
            for(int j =0; j< nameList.length; j++){
                barList[j] +=numBar(randomNum());
                System.out.println(nameList[j] +" : " + barList[j]);
            }
            System.out.println();
            i++;
        }
        ArrayList<Integer> winnerNum = barToNum(barList);
        ArrayList<String> winnerName = new ArrayList<>();

        for(int n : winnerNum){
            winnerName.add(nameList[n]);
        }

        String result = String.join(", ", winnerName);

        // 결과출력
        if(winnerName.size() == nameList.length){
            System.out.println("전부 동점입니다");
        } else{
            System.out.println("최종 우승자 : " + result);
        }

    }

}
