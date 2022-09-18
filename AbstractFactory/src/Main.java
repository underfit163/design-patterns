public class Main {
    public static void main(String[] args) {
        WidgetFactory widgetFactory = new MotifWidgetFactory();
        Client client = new Client(widgetFactory);
        client.getScrollBar();

        widgetFactory = new PMWidgetFactory();
        Client client1 = new Client(widgetFactory);
        client1.getScrollBar();
    }
}
