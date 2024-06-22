package BridgePattern.Ex3;

public abstract class Container extends Component {
    protected Component[] childen;
    private int size;
    private int DEFAULT_CAPACITY = 2;
    private String tooltipText;
    public Container( String tooltipText) {
        super(tooltipText);
        this.childen = new Component[DEFAULT_CAPACITY];
        this.size = 0;
    }
    private void enlarge() {
        Component[] component1 = new Component[size * 2];
        for (int i = 0; i < size * 2; i++) {
            component1[i] = childen[i];
        }
        childen = component1;
    }
    public void add(Component child) {
        if (size < childen.length) {
            enlarge();
        }
        Component[] childen0 = new Component[childen.length + 1];
        for (int i = 0; i < childen.length - 1; i++) {
            childen[i+1] = childen0[i];
        }
        childen0[childen.length] = child.container;
        this.childen = childen0;
    }
}
