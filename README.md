# java-racingcar-precourse

## 구현할 기능 목록
* 사용자로부터 경주할 자동차 이름을 입력받아 쉼표(,)를 기준으로 저장
  * 이름이 5자 이하가 아닐 경우 IllegalArgumentException을 발생시킨 후 애플리케이션 종료
  * 입력을 받을 때 공백을 포함할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션 종료
* 시도할 횟수를 입력받기
  * 0 이하의 수 또는 숫자가 아닌 값 입력시 IllegalArgumentException을 발생시킨 후 애플리케이션 종료
* 차수별 실행 결과를 출력하기
* 단독 우승자 안내 문구를 출력하기
  * 공동 우승자가 존재할 경우 공동 우승자를 모두 출력하기