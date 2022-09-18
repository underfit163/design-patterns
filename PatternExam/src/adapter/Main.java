package adapter;

public class Main {
    public static void main(String[] args) {
        Adapter adapter = new AdapterIO();
        adapter.charsToBytes(new String[]{"dd", "aaa", "ffff"});
    }
}
