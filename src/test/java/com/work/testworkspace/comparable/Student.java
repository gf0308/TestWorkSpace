package com.work.testworkspace.comparable;

public class Student implements Comparable {

    private String studentNo;
    private String studentName;

    public Student(String studentNo, String studentName) {
        this.studentNo = studentNo;
        this.studentName = studentName;
    }

    public String getStudentNo() {
        return studentNo;
    }
    public String getStudentName() {
        return studentName;
    }

    @Override
    public int compareTo(Object student) {
        int thisStuNo = Integer.parseInt(this.studentNo);
        Student compareStudent = (Student) student;
        int compareStuNo = Integer.parseInt(compareStudent.getStudentNo());

        if (thisStuNo == compareStuNo) {
            return 0;
        } else if (thisStuNo < compareStuNo) {
            return -1;
        } else {
            return 1;
        }
    }
}
