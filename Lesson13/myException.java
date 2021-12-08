package Lesson13;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.List;

public class myException {

    public String myExceptionOne() {
        List myRandomList = Arrays.asList("one", "two");
        try {
            return (String) myRandomList.get(3);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Бяда при обращении к списку ...");
        }
        return null;
    }

    public String[] myExceptionTwo() throws IOException {
        BufferedReader myFileByffer = null;

        try {
            FileReader myFile = new FileReader("/dev/null/fakeFile");
            myFileByffer = new BufferedReader(myFile);

            int num = 1;
            String[] linesInFile = new String[num];
            for (int i = 0; i < num; i++) {
                linesInFile[i] = myFileByffer.readLine();
            }

            return linesInFile;

        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Что-то пошло не так с чтением файла ...");

        } finally {
            if (myFileByffer != null)
                myFileByffer.close();
        }
        return null;
    }

    public String[] myExceptionThree() {
        try (FileReader myFile = new FileReader("fakeFile")) {

            BufferedReader myFileByffer = null;
            try {
                BufferedReader myFileBuffer = new BufferedReader(myFile);

                int num = 1;
                String[] lineInFile = new String[num];
                for (int i = 0; i < num; i++) {
                    lineInFile[i] = myFileBuffer.readLine();
                }
                return lineInFile;

            } catch (Exception e) {
                System.out.println("Бяда с буфером ...");
                System.out.println(e.getMessage());
            } finally {
                if (myFileByffer != null)
                    myFileByffer.close();
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException("Файл потерялся", e);
        } catch (IOException e) {
            System.out.println("Бяда ...");
            e.printStackTrace();
        }
        return null;
    }
}