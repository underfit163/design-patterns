package lab124;

import java.io.*;
import java.lang.reflect.Constructor;
import java.util.Arrays;

public class StaticMethos {
    private static TransportFactory factory = new AutoFactory();

    public static void setTransportFactory(TransportFactory factory1) {
        factory = factory1;
    }

    public static Transport createInstance(String name, int size) throws DuplicateModelNameException {
        return factory.createInstance(name, size);
    }

    public static Transport synchronizedTransport(Transport t) {
        return new SynchronizedTransport(t);
    }

    public static void PrintAllNames(Transport model) {
        System.out.println(("Массив названий моделей" + Arrays.toString(model.getNameArray())));
    }

    public static void PrintAllPrices(Transport model) {
        System.out.println("Массив цен моделей" + Arrays.toString(model.getPayArray()));
    }

    public static double AveragePrice(Transport model) {
        double avg = 0;
        for (int i = 0; i < model.getSize(); i++) {
            avg += model.getPayArray()[i];
        }
        return (avg / model.getSize());
    }

    //2 лаба
    public static void outputTransport(Transport t, OutputStream out) throws IOException {
        DataOutputStream dostream = new DataOutputStream(out);
        //dostream.writeUTF(t.getClass().getName());
        dostream.writeUTF(t.getMark());
        dostream.writeInt(t.getSize());
        for (int i = 0; i < t.getSize(); i++) {
            dostream.writeUTF(t.getNameArray()[i]);
            dostream.writeDouble(t.getPayArray()[i]);
        }
        //dostream.flush();
        dostream.close();
    }

    public static Transport inputTransport(InputStream in) throws IOException, DuplicateModelNameException {
        DataInputStream distream = new DataInputStream(in);
        //String nameClass = distream.readUTF();
        String mark = distream.readUTF();
        System.out.println(mark);
        int lenOfModel = distream.readInt();
        String model;
        double price;

        Transport t = createInstance(mark, 0);

        for (int i = 0; i < lenOfModel; i++) {
            model = distream.readUTF();
            price = distream.readDouble();
            if (t != null) {
                t.addModel(model, price);
            }
        }
        distream.close();
        return t;
    }

    public static void writeTransport(Transport t, Writer out) {
        PrintWriter printWriter = new PrintWriter(out);
        //printWriter.println(t.getClass().getName());
        printWriter.println(t.getMark());
        printWriter.println(t.getSize());
        for (int i = 0; i < t.getSize(); i++) {
            printWriter.println(t.getNameArray()[i]);
            printWriter.println(t.getPayArray()[i]);
        }
        printWriter.flush();
    }

    public static Transport readTransport(Reader in) throws DuplicateModelNameException, IOException {
        BufferedReader bufferedReader = new BufferedReader(in);
        //String nameClass = bufferedReader.readLine();
        String mark = bufferedReader.readLine();
        System.out.println(mark);
        int len = Integer.parseInt(bufferedReader.readLine());
        double price;
        String model;

        Transport t = createInstance(mark, 0);

        for (int i = 0; i < len; i++) {
            model = bufferedReader.readLine();
            price = Double.parseDouble(bufferedReader.readLine());
            if (t != null) {
                t.addModel(model, price);
            }
        }
        return t;
    }


    public static Transport createTransport(String name, int k, String trans) {
        try {
            Class<?> clss = Class.forName(trans);
            Constructor<?> constructor = clss.getConstructor(String.class, Integer.TYPE);
            return (Transport) constructor.newInstance(new Object[]{name, k});
        } catch (Exception e) {
            System.out.println("Ошибка создания объекта");
            return null;
        }
    }

}
