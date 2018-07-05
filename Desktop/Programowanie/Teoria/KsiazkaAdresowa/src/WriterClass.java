import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriterClass extends ArrayListClass {

    private String filePath;

    public WriterClass(String filePath){
        this.filePath = filePath;
    }
    public void writerClasser() {

        try {
            FileWriter fileWriter = new FileWriter(filePath);
            BufferedWriter writer = new BufferedWriter(fileWriter);


            for (Person str : persList) {
                writer.write(str.toString().toUpperCase());
            }
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
