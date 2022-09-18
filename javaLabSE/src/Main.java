import lab124.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.TransformerException;
import java.io.*;
import java.util.*;
import java.util.concurrent.locks.*;

public class Main {
    public static void main(String[] args) {
        //testLab2();
        //testLab3();

        //Паттерны
        //Лаба 1
        testLab1P();
        //Лаба 2
        //testLab2P(args);
        //Лаба 3
//        try {
//            testLab3P(args);
//        } catch (DuplicateModelNameException | IOException | NoSuchModelNameException e) {
//            e.printStackTrace();
//        } catch (XMLStreamException e) {
//            e.printStackTrace();
//        } catch (ParserConfigurationException e) {
//            e.printStackTrace();
//        } catch (TransformerException e) {
//            e.printStackTrace();
//        } catch (SAXException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }


        //Лаба 4
        /*try {
            testLab4P();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }*/
    }

    private static void testLab3P(String[] args) throws DuplicateModelNameException, IOException, NoSuchModelNameException, XMLStreamException, ParserConfigurationException, TransformerException, SAXException, ClassNotFoundException {
        //1
        /*int checkSize = 3;
        Handler handler = new LineHandler(checkSize);
        handler.setNextHandler(new ColumnHandler(checkSize));
        Transport transport2 = StaticMethos.createInstance("BmwHandler",2);
        handler.write(transport2);
        Transport transport5 = StaticMethos.createInstance("BmwHandler",5);
        handler.write(transport5);*/

        //2
        /*StaticMethos.setTransportFactory(new AutoFactory());

        Transport transportCommand = StaticMethos.createInstance("BmwCommand",4);
        transportCommand.setPrintCommand(new ColumnCommand(transportCommand));
        transportCommand.print(new FileWriter("Transport_Command"));*/

        //3
        /*Car car = (Car) StaticMethos.createInstance("BmwCommand", 5);
        Iterator<Car.Model> iterator = car.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }*/

        //4
        Car carMemento = (Car) StaticMethos.createInstance("Bmw", 5);
        carMemento.addModel("Внедорожный", 20);
        StaticMethos.PrintAllNames(carMemento);
        StaticMethos.PrintAllPrices(carMemento);

        Car.Memento memento = carMemento.createMemento();
        carMemento.setName("Внедорожный", "Мементо");
        StaticMethos.PrintAllNames(carMemento);
        StaticMethos.PrintAllPrices(carMemento);

        Car car = carMemento.setMemento(memento);
        StaticMethos.PrintAllNames(car);
        StaticMethos.PrintAllPrices(car);

        //7
        /*if (args.length != 2) {
            System.out.println("Нужно 2 параметра!");
        } else {
            Strategy strategy = new DomAnalyzer();
            strategy.check(args[0], args[1]);
        }*/
        //9
        /*Visitor visitor = new PrintVisitor();

        List<Transport> elements = new ArrayList<> (
        );
        elements.add(new Car("opel", 4));
        elements.add(new Bike("bmw",4));
        for (Transport transport:
             elements) {
            transport.accept(visitor);
        }*/
    }


    private static void testLab4P() throws DuplicateModelNameException, IOException, ClassNotFoundException {
        Bike bmw = new Bike("БМВ", 4);
        bmw.addModel("Гоночный", 3);
        bmw.addModel("Трассовый", 5);
        bmw.addModel("Велосипед", 10);
        bmw.addModel("Внедорожный", 20);

        DAOFactory factory = new ObjectDAOFactory();
        //DAOFactory factory = new lab124.TextDAOFactory();
        DAO dao = factory.getDAO();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название файла:");
        String fileText = scanner.nextLine();

        dao.writeTransport(bmw, fileText);
        Transport transport = dao.readTransport(fileText);

        StaticMethos.PrintAllNames(transport);
        StaticMethos.PrintAllPrices(transport);
    }

    private static void testLab2P(String[] args) throws DuplicateModelNameException {
        //1
        Adapter adapter = new AdapterIO();
        String name = "fileIO";
        try {
            adapter.charsToBytes(args, new FileOutputStream(name));
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(name)));
            while (br.ready()) System.out.println(br.readLine());
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //2
        Bike bmw = new Bike("БМВ", 4);
        bmw.addModel("Гоночный", 3);
        bmw.addModel("Трассовый", 5);
        bmw.addModel("Велосипед", 10);
        bmw.addModel("Внедорожный", 20);
        Transport transport = StaticMethos.synchronizedTransport(bmw);
        Thread t1 = new Thread(() -> {
            System.out.println("t1");
            System.out.println(Arrays.toString(transport.getNameArray()));
            System.out.println(Arrays.toString(transport.getPayArray()));
        });
        Thread t2 = new Thread(() -> {
            System.out.println("t2");
            System.out.println(Arrays.toString(transport.getNameArray()));
            System.out.println(Arrays.toString(transport.getPayArray()));
        });
        t1.start();
        t2.start();
    }


    private static void testLab1P() {
        try {
            //1
           /* lab124.Singleton singleton = lab124.Singleton.getInstance();
            System.out.println("Reading from config...");
            int value1 = singleton.getSingletonProperty();
            System.out.println("Value1: " + value1);
            int value2 = singleton.getMainProperty();
            System.out.println("Value2: " + value2);*/

            //--------------------2--------------------
            Bike bmw = new Bike("БМВ", 4);
            bmw.addModel("Гоночный", 3);
            bmw.addModel("Трассовый", 5);
            bmw.addModel("Велосипед", 10);
            bmw.addModel("Внедорожный", 20);

            System.out.println("Размерность массива");
            System.out.println(bmw.getSize());
            System.out.println("Массив названий БМВ");
            System.out.println(Arrays.toString(bmw.getNameArray()));
            System.out.println("Массив цен БМВ");
            System.out.println(Arrays.toString(bmw.getPayArray()));

            Car lada = new Car("Лада", 3);
            lada.addModel("Калина", 100);
            lada.addModel("Веста", 421);
            lada.addModel("Приора", 50);
            lada.dellModel("Приора");
            System.out.println(lada.getSize());
            System.out.println(Arrays.toString(lada.getNameArray()));
            System.out.println(Arrays.toString(lada.getPayArray()));

            //2
//            TransportFactory transportFactory = new BikeFactory();
//            StaticMethos.setTransportFactory(transportFactory);
//
//            System.out.println("Введите имя файла: ");
//            Scanner scan = new Scanner(System.in);
//            String filename = scan.nextLine();
//            FileOutputStream fout = new FileOutputStream(filename);
//            StaticMethos.outputTransport(lada, fout);
//            fout.close();
//
//            FileInputStream fin = new FileInputStream(filename);
//            Transport tCopy = StaticMethos.inputTransport(fin);
//            fin.close();
//            System.out.println("САМОЕ ВАЖНОЕ: ");
//            System.out.println("Было: " + lada.getClass().getName() + " стало: " + tCopy.getClass().getName());
//            System.out.println("Оригинал: ");
//            System.out.println("Модели: ");
//            StaticMethos.PrintAllNames(lada);
//            System.out.println("Цены: ");
//            StaticMethos.PrintAllPrices(lada);
//            System.out.println("Копия: ");
//            System.out.println("Модели: ");
//            StaticMethos.PrintAllNames(tCopy);
//            System.out.println("Цены: ");
//            StaticMethos.PrintAllPrices(tCopy);
//            System.out.println("------------");
//
//            transportFactory = new AutoFactory();
//            StaticMethos.setTransportFactory(transportFactory);
//
//            System.out.println("Введите имя файла: ");
//            filename = scan.nextLine();
//            FileWriter fileWriter = new FileWriter(filename);
//            StaticMethos.writeTransport(bmw, fileWriter);
//            fileWriter.close();
//
//            FileReader fileReader = new FileReader(filename);
//            Transport t2Copy = StaticMethos.readTransport(fileReader);
//            fileReader.close();
//            System.out.println("САМОЕ ВАЖНОЕ: ");
//            System.out.println("Было: " + bmw.getClass().getName() + " стало: " + t2Copy.getClass().getName());
//            System.out.println("Оригинал: ");
//            System.out.println("Модели: ");
//            StaticMethos.PrintAllNames(bmw);
//            System.out.println("Цены: ");
//            StaticMethos.PrintAllPrices(bmw);
//            System.out.println("Копия: ");
//            System.out.println("Модели: ");
//            StaticMethos.PrintAllNames(t2Copy);
//            System.out.println("Цены: ");
//            StaticMethos.PrintAllPrices(t2Copy);
//            System.out.println("-----------------");

            //3
//            Transport ladaCopy = (Transport) lada.clone();
//            System.out.println("-----------До изменения названия-------: ");
//            StaticMethos.PrintAllNames(lada);
//            StaticMethos.PrintAllNames(ladaCopy);
//            lada.setName("Калина", "Гранта");
//            System.out.println("-----------После изменения названия-------: ");
//            StaticMethos.PrintAllNames(lada);
//            StaticMethos.PrintAllNames(ladaCopy);

            Transport bmwCopy = (Transport) bmw.clone();
            System.out.println("-----------До изменения названия-------: ");
            StaticMethos.PrintAllNames(bmw);
            StaticMethos.PrintAllNames(bmwCopy);
            bmw.setName("Велосипед", "ВелосипедCopy");
            System.out.println("-----------После изменения названия-------: ");
            StaticMethos.PrintAllNames(bmw);
            StaticMethos.PrintAllNames(bmwCopy);


        } catch (DuplicateModelNameException | NoSuchModelNameException e) {
            e.printStackTrace();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }

    private static void testLab3() {
        try {
            //laba3
            Transport lada = new Car("Лада", 10);
            lada.addModel("Калина", 150);
            lada.addModel("Веста", 421);
            lada.addModel("Приора", 50);
            //1
            /*System.out.println("1 задание:");
            lab124.NameThread nt = new lab124.NameThread(lada);
            lab124.PricesThread pt = new lab124.PricesThread(lada);
            nt.setPriority(Thread.MIN_PRIORITY);
            pt.setPriority(Thread.MAX_PRIORITY);
            pt.start();
            nt.start();*/

            System.out.println("2 задание:");
            TransportSynchronizer ts = new TransportSynchronizer(lada);
            Thread trp = new Thread(new RunPricesThread(ts));
            Thread trm = new Thread(new RunModelsThread(ts));
            trp.start();
            trm.start();

            //3
            System.out.println("3 задание:");
            ReentrantLock lock = new ReentrantLock();
            Thread tlm = new Thread(new LockModelsThread(lada, lock));
            Thread tlp = new Thread(new LockPricesThread(lada, lock));
            tlm.start();
            tlp.start();

            //4
           /* System.out.println("4 задание:");
            lab124.Transport t1 = new Car("T1", 1);
            lab124.Transport t2 = new Car("T2", 2);
            lab124.Transport t3 = new Car("T3", 1);
            lab124.Transport t4 = new Car("T4", 1);
            ExecutorService es = Executors.newFixedThreadPool(2);
            lab124.MarkTread mt1 = new lab124.MarkTread(t1);
            lab124.MarkTread mt2 = new lab124.MarkTread(t2);
            lab124.MarkTread mt3 = new lab124.MarkTread(t3);
            lab124.MarkTread mt4 = new lab124.MarkTread(t4);
            es.submit(mt1);
            es.submit(mt2);
            es.submit(mt3);
            es.submit(mt4);
            es.shutdown();*/

            //5
            /*System.out.println("5 задание:");
            ArrayBlockingQueue<lab124.Transport> arr = new ArrayBlockingQueue<>(1);
            String[] names = {"first.txt", "second.txt", "third.txt", "fourth.txt", "fifth.txt"};
            for (String name : names) {
                Thread th = new Thread(new CreationThread(name, arr));
                th.start();
            }
            lab124.Transport[] tr = new lab124.Transport[5];
            for (int i = 0; i < tr.length; i++) {
                tr[i] = arr.take();
                System.out.println(tr[i].getMark());
            }*/

        } catch (DuplicateModelNameException e) {
            e.printStackTrace();
        }
    }

    private static void testLab2() {
        //2 лаба
        try {
            Bike bmw = new Bike("БМВ", 4);
            bmw.addModel("Гоночный", 3);
            bmw.addModel("Трассовый", 5);
            bmw.addModel("Велосипед", 10);
            bmw.addModel("Внедорожный", 20);
            //bmw.addModel("Внедорожный", 20);
            bmw.setPayNew("Гоночный", 1000);
            //bmw.setPayNew("НетИмени",1000000);
            bmw.setName("Внедорожный", "ОдноКолесный");
            //bmw.setName("Внедорожный", "Трассовый");
            bmw.dellModel("ОдноКолесный");
            //bmw.dellModel("НетТакойМодели");
            System.out.println("Размерность массива");
            System.out.println(bmw.getSize());
            System.out.println("Массив названий БМВ");
            System.out.println(Arrays.toString(bmw.getNameArray()));
            System.out.println("Массив цен БМВ");
            System.out.println(Arrays.toString(bmw.getPayArray()));
            System.out.println("Конкретная цена");
            System.out.println(bmw.getPriceModel("Трассовый"));

            Car lada = new Car("Лада", 3);
            lada.addModel("Калина", 100);
            lada.addModel("Веста", 421);
            lada.addModel("Приора", 50);
            lada.dellModel("Приора");
            System.out.println(lada.getSize());
            System.out.println(Arrays.toString(lada.getNameArray()));
            System.out.println(Arrays.toString(lada.getPayArray()));

             /*System.out.println("-------------------------2 lab----------------------");
             System.out.println("Введите имя файла: ");
             Scanner scan = new Scanner(System.in);
             String filename = scan.nextLine();
             FileOutputStream fout = new FileOutputStream(filename);
             lab124.StaticMethos.outputTransport(bmw, fout);
             fout.close();

             FileInputStream fin = new FileInputStream(filename);
             lab124.Transport tCopy = lab124.StaticMethos.inputTransport(fin);
             fin.close();
             System.out.println(tCopy.getClass());
             System.out.println("Оригинал: ");
             System.out.println("Модели: ");
             lab124.StaticMethos.PrintAllNames(bmw);
             System.out.println("Цены: ");
             lab124.StaticMethos.PrintAllPrices(bmw);
             System.out.println("Копия: ");
             System.out.println("Модели: ");
             lab124.StaticMethos.PrintAllNames(tCopy);
             System.out.println("Цены: ");
             lab124.StaticMethos.PrintAllPrices(tCopy);
             System.out.println("------------");

             System.out.println("Введите имя файла: ");
             filename = scan.nextLine();
             FileWriter fileWriter = new FileWriter(filename);
             lab124.StaticMethos.writeTransport(bmw,fileWriter);
             fileWriter.close();

             FileReader fileReader = new FileReader(filename);
             lab124.Transport t2Copy = lab124.StaticMethos.readTransport(fileReader);
             fileReader.close();

             System.out.println("Оригинал: ");
             System.out.println("Модели: ");
             lab124.StaticMethos.PrintAllNames(bmw);
             System.out.println("Цены: ");
             lab124.StaticMethos.PrintAllPrices(bmw);
             System.out.println("Копия: ");
             System.out.println("Модели: ");
             lab124.StaticMethos.PrintAllNames(t2Copy);
             System.out.println("Цены: ");
             lab124.StaticMethos.PrintAllPrices(t2Copy);
             System.out.println("-----------------");
             //запись в символьный поток
            System.out.println("Введите класс транспортного средства, марку, кол-во моделей, название модели, стоимость: ");
             lab124.Transport s2 = lab124.StaticMethos.readTransport(new InputStreamReader(System.in));
             //чтение из символьного потока

             lab124.StaticMethos.writeTransport(s2,  new OutputStreamWriter(System.out));

             System.out.println("Введите имя файла записи: ");
             String filename1 = scan.nextLine();

             ObjectOutputStream out2 = new ObjectOutputStream(new FileOutputStream(filename1));
             out2.writeObject(bmw);
             out2.close();

             FileInputStream fin2 = new FileInputStream(filename1);
             ObjectInputStream ois = new ObjectInputStream(fin2);
             lab124.Transport s3 = (lab124.Transport) ois.readObject();
             fin2.close();
             lab124.StaticMethos.PrintAllNames(s3);
             lab124.StaticMethos.PrintAllPrices(s3);*/
        } catch (DuplicateModelNameException | ModelPriceOutOfBoundsException | NoSuchModelNameException | NullPointerException e) {
            System.out.println(e);
        }
    }
}