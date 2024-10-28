package racingcar;

import java.util.ArrayList;

class Player {
	String name;
	int racingProcessCount;

	Player(String name) {
		this.name = name;
		this.racingProcessCount = 0;
	}

	public void canMoveForward() {
		if (camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(0, 9) >= 4) {
			this.racingProcessCount++;
		}
	}

	public String exchangeRacingProcessCountToString() {
		String racingString = "";
		for (int i = 0; i < this.racingProcessCount; i++) {
			racingString = racingString + "-";
		}

		return racingString;
	}

	public void printPlayerPresentState() {
		System.out.println(this.name + " : " + this.exchangeRacingProcessCountToString());
	}

}

class Function {
	public static void checkNameLengthOverFive(String name) {
		if (name.length() > 5) {
			throw new IllegalArgumentException();
		}
	}

	public static void checkNameDuplication(ArrayList<String> checkNameDuplicationList, String inputName) {
		if (checkNameDuplicationList.contains(inputName)) {
			throw new IllegalArgumentException();
		}
	}
	
	public static ArrayList<Player> makePlayerList(String nameString) {
		String[] name = nameString.split(",");
		ArrayList<Player> playerList = new ArrayList<Player>(); 
		ArrayList<String> checkNameDuplicationList = new ArrayList<String>(); //중복된 이름이 있는지 확인을 위한 ArrayList

		for (int i = 0; i < name.length; i++) {
			Function.checkNameLengthOverFive(name[i].trim());
			Function.checkNameDuplication(checkNameDuplicationList, name[i].trim());
			checkNameDuplicationList.add(name[i].trim());
			
			playerList.add(new Player(name[i].trim()));
		}

		return playerList;
	}
	
	public static void processOneSteps(ArrayList<Player> playerList) {
		for (int i = 0; i < playerList.size(); i++) {
			playerList.get(i).canMoveForward();
			playerList.get(i).printPlayerPresentState();
		}
	}

	public static void processSteps(ArrayList<Player> playerList, int carryoutCount) {
		for (int i = 0; i < carryoutCount; i++) {
			Function.processOneSteps(playerList);
			System.out.println();
		}
	}

	public static ArrayList<String> searchWinner(ArrayList<Player> playerList, int carryoutCount) {
		ArrayList<String> winnerList = new ArrayList<String>();

		for (int i = 0; i < playerList.size(); i++) {
			if (playerList.get(i).racingProcessCount == carryoutCount) {
				winnerList.add(playerList.get(i).name);
				continue;
			}

			if (i == playerList.size() - 1 && winnerList.size() == 0) {
				carryoutCount--;
				i = -1;
			}
		}

		return winnerList;
	}

	public static void printWinner(ArrayList<String> winnerList) {
		String winner = "";
		for (int i = 0; i < winnerList.size(); i++) {
			if (i == winnerList.size() - 1) {
				winner = winner + winnerList.get(i);
				break;
			}

			winner = winner + winnerList.get(i) + ", ";
		}

		System.out.println("최종 우승자 : " + winner);
	}
}

public class Application {
	public static void main(String[] args) {
		try {
			System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
			String nameString = camp.nextstep.edu.missionutils.Console.readLine();
			System.out.println("시도할 횟수는 몇 회인가요?");
			int carryoutCount = Integer.parseInt(camp.nextstep.edu.missionutils.Console.readLine());

			System.out.println("실행결과");
			ArrayList<Player> playerList = Function.makePlayerList(nameString);
			Function.processSteps(playerList, carryoutCount);
			Function.printWinner(Function.searchWinner(playerList, carryoutCount));
		}catch(NumberFormatException e) {
			throw new IllegalArgumentException();
		}

	}
}
