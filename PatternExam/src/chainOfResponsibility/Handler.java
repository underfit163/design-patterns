package chainOfResponsibility;

public interface Handler {
    void readWrite(String file1, String file2);
    void setNext(Handler handler);
}
