package com.work.testworkspace.io;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.assertj.core.api.Assertions.*;

public class FileExistDeleteTest {
    private static final String MESSAGE_NO_SUCH_FILE = "There is no such file.";
    private static final String MESSAGE_FILE_DELETE_COMPLETE = "File delete complete.";
    private static final String MESSAGE_FILE_DELETE_FAIL = "File delete fail...!";


    @DisplayName("파일삭제테스트: 해당 파일이 실제로 존재하여 파일삭제가 성공하는 경우")
    @Test
    void fileDeleteTest_fileDeleteComplete() throws Exception {
        String filePath = "D:/fileExistDeleteTest.txt";
        File file = createFile(filePath);
        String deleteResult = deleteFile(file);

        assertThat(deleteResult).isEqualTo(MESSAGE_FILE_DELETE_COMPLETE);
    }

    @DisplayName("파일삭제테스트: 해당 파일이 존재하지 않아 그러한 파일 없음이라고 실패가 뜨는 경우")
    @Test
    void fileDeleteTest_noSuchFile() throws Exception {
        String filePath = "D:/fileExistDeleteTest.txt";
        File file = createFile(filePath);
        String deleteResult = deleteFile(file);

        assertThat(deleteResult).isEqualTo(MESSAGE_NO_SUCH_FILE);
    }

    @DisplayName("파일삭제테스트: 해당 파일(디렉토리)이 삭제가 실패하는 경우(디렉토리 내부에 파일이 있기 때문에)")
    @Test
    void fileDeleteTest_fileDeleteFail() throws Exception {
        String filePath = "D:/fileDeleteTestDirectory"; // 내부에 파일이 존재하고 있는 폴더경로
        File file = createFile(filePath);
        String deleteResult = deleteFile(file);

        assertThat(deleteResult).isEqualTo(MESSAGE_FILE_DELETE_FAIL); // 아마 .delete 시 실패가 뜰것이다(내부에 파일이 있으므로)
    }

    @DisplayName("파일삭제테스트: 해당 디렉토리 내부에 파일이 있기 때문에 바로 디렉토리를 삭제할 수 없는 경우, 내부의 파일들을 모두 제거한 후에 디렉토리까지 삭제하는 테스트")
    @Test
    void fileDeleteTest_directoryDeleteAfterFileDelete() throws Exception {
        String filePath = "D:/fileDeleteTestDirectory"; // 내부에 파일이 존재하고 있는 폴더경로
        File file = createFile(filePath);
        String deleteResult = deleteFile(file);

        assertThat(deleteResult).isEqualTo(MESSAGE_FILE_DELETE_COMPLETE);
    }


    private static String deleteFile(File file) throws Exception {
        if (!file.exists()) {
            return MESSAGE_NO_SUCH_FILE;
        }

        if (file.isDirectory()) {
            deleteFilesOfDirectory(file);
        }

        boolean deleteResult = file.delete();

        if (!deleteResult) throw new Exception(MESSAGE_FILE_DELETE_FAIL);

        return MESSAGE_FILE_DELETE_COMPLETE;
    }

    private static void deleteFilesOfDirectory(File file) throws Exception {
        for (File f : file.listFiles()) {
            boolean deleteResult = f.delete();
            if (!deleteResult) throw new Exception(MESSAGE_FILE_DELETE_FAIL);
        }
    }

    private static File createFile(String filePath) {
        return new File(filePath);
    }

}
