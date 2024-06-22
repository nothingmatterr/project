package BridgePattern.Ex3;

 public abstract class Component implements ComponentWithContextualHelp {
     private String tooltipText;
     protected Container container;
     public Component(String tooltipText) {
         this.tooltipText = tooltipText;
     }
     public void showHelp() {
         if (tooltipText != null) {
             System.out.println(tooltipText);
         }
         else {
             container.showHelp();
         }
     }

}
