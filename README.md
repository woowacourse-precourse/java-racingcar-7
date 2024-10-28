# java-racingcar-precourse

1. Car 클래스 작성
- Car 생성자 작성
- 자동차 이름을 가져오는 getName() 메소드 작성
- 전진한 횟수 값을 가져오는 move() 메소드 작성
- 전진하는 moving() 메소드 작성
2. 경주하는 자동차 이름 입력, 시도할 횟수 입력 작성
- 경주하는 자동차 이름 입력 문자열을 저장하는 carName 변수 작성
- catName으로 입력된 문자열을 쉼표로 구분하여 Car 객체를 생성해주는 createCars 메소드 작성 (List로 저장)
- 잘못된 문자열을 입력할 경우 IllegalArgumentException 예외처리
- 시도할 횟수 입력 문자열은 Integer.parseInt로 형변환
- 숫자 이외의 값을 입력할 경우 NumberformatException 발생하는 원리를 이용하여 예외처리
3. 랜덤값에 의해 전진하는 Moving 메소드 작성
- Car객체가 저장된 List를 입력받아 반복문을 통해 전진여부 결정
- Randoms.pickNumberInRange를 통해 0~9사이의 값을 받고 값이 4 이상일 경우 Car 클래스의 moving메소드 실행
- 실행 결과를 출력 (repeat 메소드 활용)
4. 최종 우승자를 출력하는 winner 메소드 작성
- Car객체가 저장된 List를 입력받아 반복문을 통해 최대 이동값을 변수에 저장
- 최종 이동값에 해당되는 Car 객체를 찾아 최종 우승자 이름 리스트에 저장
- 저장된 최종 우승자 리스트를 출력 (쉼표로 구분)
