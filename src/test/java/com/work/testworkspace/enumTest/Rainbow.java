package com.work.testworkspace.enumTest;

enum Rainbow {
    RED(3, "빨강"),
    ORANGE(10, "주황"),
    YELLOW(12, "노랑")
    ;

    private final int key;
    private final String name;

    // 열거형(Enum)의 생성자는 public이 아니다.
    Rainbow(int key, String name) {
        this.key = key;
        this.name = name;
    }

    public int getKey() {
        return this.key;
    }
    public String getName() {
        return this.name;
    }
}
