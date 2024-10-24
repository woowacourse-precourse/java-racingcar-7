# java-racingcar-precourse

1. 자동차 이름 입력
   - camp.nextstep.edu.missionutils.Console 사용
   - 이름은 쉼표 기준으로 구분 (Split 사용)
   - 5자 이하만 가능 
   - ArrayList사용
   - car 클래스 생성

3. 시도할 횟수 입력
    - camp.nextstep.edu.missionutils.Console 사용
   
4. 자동차마다 무작위 값(0~9)을 구하기  
    - camp.nextstep.edu.missionutils.Randoms 사용
    - 2번에서 입력한 시도할 횟수만큼 자동차 객체들이 무작위 값을 구한다
    - CarValueAssigner 클래스 생성

5. 무작위 값이 4이상일 경우 전진 기능 구현
    - 차수마다 자동차의 위치를 표현 (-)
    - 무작위 값이 4 이상일 경우 전진하며 차수별 실행결과에 - 추가 	
    - CarMover 클래스 생성

6. 자동차 경주 게임을 완료한 후 우승자 기능 구현 (1명 이상일 수 있다.)
    - WinnerDeterminer 클래스 생성
    - 자동차마다 -의 개수를 측정하여 우승자 추출
