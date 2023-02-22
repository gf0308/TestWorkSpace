package com.work.testworkspace.filestore;

public class EmptyFileException extends RuntimeException {
    public EmptyFileException() {
        super("파일이 선택되지 않았거나, 파일의 내용이 없습니다.");
    }
}