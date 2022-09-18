public class MotifWidgetFactory implements  WidgetFactory{
    @Override
    public MotifScrollBar createScrollBar() {
        System.out.println("MotifScrollBar");
        return new MotifScrollBar();
    }

    @Override
    public MotifWindow createWindow() {
        return new MotifWindow();
    }
}
