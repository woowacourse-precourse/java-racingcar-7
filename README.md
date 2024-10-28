# java-racingcar-precourse

## 기능

 * **Player 클래스**  
    * **name 필드**: 게임 플레이어의 이름  
    * **racingProcessCount 필드**: 게임 플레이어의 진행 횟수 
    * **canMoveForward매서드**: 플레이어가 앞으로 전진할지 결정합니다. 
    * **exchangeRacingProcessCountToString매서드**: 전진한 횟수를 "-"문자열로 변경합니다. 
    * **printPlayerPresentState매서드**: 현재 플레이어의 상태를 문자열로 출력합니다.  
 
 
 * **Function 클래스**  
     * **checkNameLengthOverFive매서드**: 이름의 길이가 5를 초과했는지 확인합니다. 
     * **checkNameDuplication매서드**: 중복된 이름이 존재하는지 확인합니다. 
     * **makePlayerList매서드**: 입력된 이름으로 플레이어 정보를 저장하는 ArrayList를 생성합니다. 
     * **processOneSteps매서드**: 한 턴을 진행합니다. 
     * **processSteps매서드**: 전체의 게임을 진행합니다. 
     * **searchWinner매서드**: 승리자를 찾습니다. 
     * **printWinner매서드**: 승리자를 출력합니다. 