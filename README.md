# java-racingcar-precourse

구현할 기능 목록
1. 입출력 기능
   - camp.nextstep.edu.missionutils.Console의 readLine()을 활용
   - 사용자가 각 자동차 이름을 입력 
     - 쉼표를 기준으로 구분
     - 5자 이하만 가능
     - 사용자가 이동 횟수 입력
   - 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력
   - 최종 우승자 출력
     - 우승자는 한 명 이상 가능
     - 공동우승시 쉼표로 구분

2. 자동차 기능
   - 전진조건 무작위 0~9 사이 값이 4 이상
     - camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용

3. 예외처리 기능
   - 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료

