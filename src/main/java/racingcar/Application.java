package racingcar;

import java.util.ArrayList;

class Player {
	String name;
	int racingProcessCount;

	Player(String name) {
		this.name = name;
		this.racingProcessCount = 0;
	}

	public String getName() {
		return this.name;
	}

	public int getRacingProcessCount() {
		return this.racingProcessCount;
	}
}

class GameController {
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
		ArrayList<String> checkNameDuplicationList = new ArrayList<String>(); // 중복된 이름이 있는지 확인을 위한 ArrayList

		for (int i = 0; i < name.length; i++) {
			GameController.checkNameLengthOverFive(name[i].trim());
			GameController.checkNameDuplication(checkNameDuplicationList, name[i].trim());
			checkNameDuplicationList.add(name[i].trim());

			playerList.add(new Player(name[i].trim()));
		}

		return playerList;
	}

	public static void processOneStep(ArrayList<Player> playerList) {
		for (int i = 0; i < playerList.size(); i++) {
			GameController.canMoveForward(playerList.get(i));
			ShowView.printPlayerPresentState(playerList.get(i));
		}
	}

	public static void processSteps(ArrayList<Player> playerList, int carryoutCount) {
		for (int i = 0; i < carryoutCount; i++) {
			GameController.processOneStep(playerList);
			System.out.println();
		}
	}

	public static ArrayList<String> getWinnerList(ArrayList<Player> playerList, int carryoutCount) {
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

	public static String getWinnerString(ArrayList<String> winnerList) {
		String winner = "";
		for (int i = 0; i < winnerList.size(); i++) {
			if (i == winnerList.size() - 1) {
				winner = winner + winnerList.get(i);
				break;
			}

			winner = winner + winnerList.get(i) + ", ";
		}

		return winner;
	}

	public static void canMoveForward(Player player) {
		if (camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(0, 9) >= 4) {
			player.racingProcessCount++;
		}
	}

	public static String exchangeRacingProcessCountToString(Player player) {
		return "-".repeat(player.racingProcessCount);
	}
}

class ShowView {
	public static void showInputPlayerNameAlert() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
	}
	
	public static void showGameProcessNumberAlert() {
		System.out.println("시도할 횟수는 몇 회인가요?");
	}

	public static void showGameResultAlert() {
		System.out.println("실행 결과");
	}

	public static void printWinner(String winner) {
		System.out.println("최종 우승자 : " + winner);
	}

	public static void printPlayerPresentState(Player player) {
		System.out.println(player.name + " : " + GameController.exchangeRacingProcessCountToString(player));
	}
}

public class Application {
	public static void main(String[] args) {
		try {
			ShowView.showInputPlayerNameAlert();
			String nameString = camp.nextstep.edu.missionutils.Console.readLine();
			ShowView.showGameProcessNumberAlert();
			int carryoutCount = Integer.parseInt(camp.nextstep.edu.missionutils.Console.readLine());

			ShowView.showGameResultAlert();
			ArrayList<Player> playerList = GameController.makePlayerList(nameString);
			GameController.processSteps(playerList, carryoutCount);
			ShowView.printWinner(
					GameController.getWinnerString(GameController.getWinnerList(playerList, carryoutCount)));
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException();
		}
	}
}
