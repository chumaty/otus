//  Придумать несколько взаимосвязанных классов, в которых использовать три способа обработки исключений (вывод ошибки, rethrow и еще один, на выбор)
//  А так же использована конструкция try-with-resource
//  Вместо обращения к реальным ресурсам можно использовать классы-заглушки

package Lesson13;
import java.io.IOException;

public class myMain {
    public static void main(String[] args) {

        myException exception = new myException();

        // №1
                System.out.println("#One");
                exception.myExceptionOne();

        // №2
                System.out.println("#Two");
                try {
                    exception.myExceptionTwo();
                } catch (IOException e) {
                    e.printStackTrace();
                }

        // №3:
        System.out.println("#Three");
        try {
            exception.myExceptionThree();
        } catch (Exception e) {
            System.out.println("Вывод какой то ошибки ...");
            System.out.println(e.getMessage());
        }
    }
}
