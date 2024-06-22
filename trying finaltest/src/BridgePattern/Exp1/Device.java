package BridgePattern.Exp1;

public interface Device {
   public boolean isEnable();
   public boolean enable();
   public boolean disable();
   public int getVolume();
   public void setVolume(int volume);
   public int getChannel();
   public void setChannel(int channel);
}
