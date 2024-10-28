package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;



public class Application {
    public static void main(String[] args) {


        String name;
        String inputAttempts;
        String delimiter = ",";//기본 구분자



        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        name = readLine();


        String[] nameArr = name.split(delimiter, -1);

        // 이름 길이 유효성 검사
        try {
            for (String carName : nameArr) {
                if (carName.length() > 5) {
                    throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
                }
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }


        System.out.println("시도할 횟수는 몇 회인가요?");
        inputAttempts = readLine();

        int attempts;

        try {
            attempts = Integer.parseInt(inputAttempts);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }

        int[][] scores = new int[name.length()][attempts];

        int[] charScores;
        charScores = new int[nameArr.length];

        System.out.println();
        System.out.println("실행 결과");

        for(int i = 0; i < attempts; i++){
            for(int j = 0; j < nameArr.length; j++) {
                scores[j][i]= pickNumberInRange(0, 9);
                charScores[j] += scores[j][i];


                System.out.print(nameArr[j] + " : "); //+ scores[j][i]
                for(int k = 0; k < charScores[j]; k++){
                    System.out.print("-");
                }
                System.out.println();

            }
            System.out.println();
        }

        // 최종 우승자 선정
        int maxScore = 0;
        for (int score : charScores) {
            if (score > maxScore) {
                maxScore = score;
            }
        }

        // 최고점으로 동점자인 참가자를 하나의 문자열에 저장
        String winners = "";
        for (int i = 0; i < charScores.length; i++) {
            if (charScores[i] == maxScore) {
                if (!winners.isEmpty()) {
                    winners += ", ";
                }
                winners += nameArr[i];
            }
        }


        System.out.println("최종 우승자 : " + winners);


    }
}