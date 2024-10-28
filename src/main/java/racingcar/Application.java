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



}

public class Application {
	public static void main(String[] args) {

	}
}
