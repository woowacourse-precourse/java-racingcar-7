# java-racingcar-precourse

# 기능 구현 목록 작성
1. 자동차는 이름과 위치를 가진다.
2. 자동차의 이름이 String이 아니거나, 5글자가 넘으면 예외를 발생시킨다.
3. 자동차는 움직이는 기능을 가진다.
    - 랜덤 넘버가 4이상이면 전진한다.
4. 사용자는 경주할 자동차들의 이름과 시도 횟수를 입력한다.
5. 사용자가 잘못된 값을 입력할 경우 'IllegalArgumentExcpetion'을 발생시킨다.
    - 자동차의 구분자가 , 가 아닌 경우
    - 구분자가 존재하지 않는 경우
    - 구분자 사이에 공백이 존재하는 경우
    - 시도 횟수가 숫자가 아닌 경우
    - 문자열이 구분자로 끝나는 경우
6. 우승자를 발표한다.
   - 가장 많이 이동한 자동차의 이름을 가져온다.
   - 우승자가 여러 명인 경우 , 로 구분한다.
