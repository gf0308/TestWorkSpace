package com.work.testworkspace.runjar;

import org.junit.jupiter.api.Test;

import java.io.IOException;

public class RunJarTest {

    @Test
    void test() throws IOException {
        Runtime runtime = Runtime.getRuntime();
        String command = "java -jar C:\\schedule_test\\jars\\TestRunApp1.jar";
        runtime.exec(command);
    }
}
