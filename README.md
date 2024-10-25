# java-racingcar-precourse

# 문제해석

1. 사용자들에게 자동차 이름을 입력받음
2. 경기 진행 횟수를 입력받음
3. 랜덤값을 이용해 각 사용자들의 이동값에 따라 우승자가 정해짐
4. 공동우승 가능

# 요구사항
제공된 라이브러리 이외의 외부 라이브러리 사용금지 

프로그램 종료 시 System.exit() 호출 금지


camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현
 - Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 PickNumberInRange()를 활용
 - 사용자 입력 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용

indent depth 3 이하로 구현


3항 연산자 사용 제외


1기능 1함수 작성


테스트 코드 작성 및 작동확인

# 기능구현
사용자 입력 
  - 자동차 이름 입력
    - 5글자 이하
    - 구분자 ( , ) 기준으로 분리
      
  - 시도횟수 입력
    - 정수 입력
      
Random값 처리
  - 0 ~ 9 사이의 값을 추출
    - 4 이상일 경우 이동

출력
  -진행 출력
    - 시도횟수 차수별 입력된 자동차 이동 진행사항 출력 
      - 줄바꿈 기준으로 사용자 이동 진행사항 출력
    
  - 우승자 출력 
    - 가장 높은 이동 값을 가진 자동차 이름 출력
      - 최종 우승자 : <String> 
    - 구분자( , )를 가진 중복 우승자 출력
      - 최종 우승자 : <String> , <String>
    
사용자가 잘못된 값을 입력할 경우 예외처리(IllegalArgumentException)후 종료 
  - 자동차 이름 입력이 5글자 초과될 경우
  - 시도횟수 입력이 정수가 아닐 경우
