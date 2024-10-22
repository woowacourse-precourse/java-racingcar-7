# java-racingcar-precourse

1. 사용자에게 자동차 이름 입력받기 <br>
   (camp.nextstep.edu.missionutils.Console의 readLine()을 활용) <br>
   예) "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분 / 자동차 이름은 5자 이하)" <br>
   _예외처리_
   - 자동차 이름 5글자 초과할 시
   - 쉼표 사이 공백 또는 빈문자열인 경우
2. 사용자에게 시도할 횟수 입력받기 <br>
   예) "시도할 횟수는 몇 회인가요?" <br>
    _예외처리_
   - 입력값이 0 이하인 경우 
   - 입력값이 숫자가 아닌 경우 
3. 입력받은 횟수만큼 자동차는 전진 또는 멈출 수 있다. 
   - 전진하는 조건 0-9 사이 무작위 값을 구한 후 4이상인 경우 전진 <br>
     (camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용 <br>
     예) Randoms.pickNumberInRange(0, 9); 하면 0-9 사이의 정수 한 개 반환) <br>
   - 전진하는 자동차 출력 시 자동차 이름을 같이 출력 <br>
 
   예) <br>
   실행 결과 <br>
    pobi : - <br>
    woni : <br>
    jun : -<br>
    
    pobi : --<br>
    woni : -<br>
    jun : --<br>
    
    pobi : ---<br>
    woni : --<br>
    jun : ---<br>
    
    pobi : ----<br>
    woni : ---<br>
    jun : ----<br>
    
    pobi : -----<br>
    woni : ----<br>
    jun : -----<br>
4. 입력받은 횟수 종료 후 우승자 출력 <br>
   - 우승자는 한 명 이상일 수 있다. 
   - 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다. <br>
   예) "최종 우승자 : pobi, jun"  
