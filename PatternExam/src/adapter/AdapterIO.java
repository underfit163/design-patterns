package adapter;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class AdapterIO implements Adapter{

    DataOutputStream dos;

    @Override
    public void charsToBytes(String[] strings) {
        try {
            dos = new DataOutputStream(new FileOutputStream("fileAdapter"));
            for (String string : strings) {
                dos.write(string.getBytes());
            }
            dos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
