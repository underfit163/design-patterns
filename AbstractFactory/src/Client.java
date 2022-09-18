public class Client {
    private ScrollBar scrollBar;
    private Window window;
    private WidgetFactory widgetFactory;

    public Client(WidgetFactory widgetFactory) {
        this.widgetFactory = widgetFactory;
        this.scrollBar = widgetFactory.createScrollBar();
        this.window = widgetFactory.createWindow();
    }

    public ScrollBar getScrollBar() {
        return scrollBar;
    }

    public Window getWindow() {
        return window;
    }
}
