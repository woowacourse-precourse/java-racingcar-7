# java-racingcar-precourse

# [구현할 기능목록]
##
### Car class
name: 자동차 이름
position: 자동차의 현재 위치
##
car(): 자동차 이름으로 객체생성
move(): 무작위 숫자를 확인하여 전진할지 멈출지 결정하는 메소드
getPosition(): 현재 자동차의 위치반환 메소드
getName(): 자동차의 이름 반환 메소드
#
### Race class
cars: Car의 객체 리스트
moveCount: 자동차들 총 이동 횟수
#
addCar(Car car): 자동차를 경주에 추가하는 메소드
setMoveCount(): 이동 횟수를 설정하는 메소드
getMoveCount(): 이동 횟수를 반환하는 메소드
playTurn(): 각 자동차의 move() 메서드를 호출하여 위치를 업데이트하는 메소드
getCarsStatus(): 현재 모든 자동차의 상태를 반환하는 메소드 
getWinners(): 최종 위치에 따라 우승자를 계산하는 메소드
#
## RaceController class
race: Race 인스턴스
inputHandler: InputHandler 인스턴스
#
startRace(): 경주를 초기화하고 자동차를 추가한 후 이동 횟수를 설정하는 메소드
executeRace(): 턴을 실행하고 각 턴의 상태를 출력하는 메소드
endRace(): 경주가 끝난 후 우승자를 출력하는 메소드
printRaceStatus(): 각 턴에서 자동차들의 위치를 출력
#
## InputHandler class
inputCarNames(): 자동차 이름을 사용자로부터 입력받는 메소드
inputMoveCount(): 이동할 횟수를 사용자로부터 입력받는 메소드
#
## InputValidator class
validateCarNames(): 자동차이름 길이 검증 메소드
validateMoveCount: 이동 횟수가 1 이상인지 검증하는 메소드
#
