package lab124;

import java.io.IOException;
import java.io.OutputStream;

public class AdapterIO implements Adapter  {

    public void charsToBytes(String [] strings, OutputStream outputStream) throws IOException {

        for (String string : strings) {
            outputStream.write(string.getBytes());
            outputStream.write('\n');
            outputStream.flush();
        }
    }
}
