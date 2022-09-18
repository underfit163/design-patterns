public class PMWidgetFactory implements WidgetFactory{
    @Override
    public PMScrollBar createScrollBar() {
        System.out.println("PMScrollBar");
        return new PMScrollBar();
    }

    @Override
    public PMWindow createWindow() {
        return new PMWindow();
    }
}
