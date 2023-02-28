package com.work.testworkspace.comparable;

public class Car implements Comparable<Car> {
    private String modelName;
    private int modelYear;
    private String color;

    public Car(String modelName, int modelYear, String color) {
        this.modelName = modelName;
        this.modelYear = modelYear;
        this.color = color;
    }

    public String getModel() {
        return this.modelYear + "식 " + this.modelName + " " + this.color;
    }

    // 같은 타입의 인스턴스들 간에 '비교'를 해야 하는 (그럼으로써 객체들 간에 '정렬'을 해줘야 하는) 클래스들은 모두 Comparable 인터페이스를 구현하고 있다.
    // 즉 객체간에 (순서를 정렬하는 등이 가능하도록) 비교를 해야 하는 경우 그 클래스에 기본적으로 구현시켜 쓰도록 하는 인터페이스는 Comparable 인터페이스다.
    // 그리고 그에 따라 Comparable 인터페이스에서 요구하는 .compareTo() 메서드도 오버라이드해서 구현한다.
    // Comparable 인터페이스는 기본적으로 '오름차순'으로 객체를 정렬하게 한다.
    @Override
    public int compareTo(Car carObj) {
        // 차의 연식 year 을 비교해서 같으면 0, 덜 오래됐으면 음수를, 더 오래됐으면 양수를 반환
        if (this.modelYear == carObj.modelYear) {
            return 0;
        } else if (this.modelYear < carObj.modelYear) {
            return -1;
        } else {
            return 1;
        }
    }
}
