package Ch10;

class TV{
	BasicController basicController;
	ExtraController extraController;
	TV(){
		basicController = new BasicController();
		extraController = new ExtraController();
	}
	void TvInfo() {
		basicController.showInfo();
	}
	
}
class BasicController{
//	Basic Controller
//	Module - on/off
//	Module - ChangeChannel
//	Module - SetVolumn
	OnOff onoff;
	Channel channel;
	Volumn volumn;
	void setOnoff(OnOff onoff) {
		this.onoff=onoff;
	}
	void setChannel(Channel channel) {
		this.channel=channel;
	}
	void setVolumn(Volumn volumn) {
		this.volumn=volumn;
	}
	void showInfo() {
		System.out.println("현재 OnOff : " + onoff.isOn);
		System.out.println("현재 Channel : " + channel.curChannel);
		System.out.println("현재 Volumn : " + volumn.curVolumn);
	}
}
class OnOff{
	boolean isOn;
	void on() {
		System.out.println("power on");
		isOn = true;
	}
	void off() {
		System.out.println("power off");
		isOn = false;
	}
}
class Channel{
	int curChannel;
	void setChannel(int channel) {
		curChannel = channel;
	}
}
class Volumn{
	
	int curVolumn;
	void setVolumn(int volumn) {
		curVolumn = volumn;
		
	}
}
class ExtraController{
//	Extra Controller
//	Module - InternetSearching
//	Module - Netflex
}


public class C02FunctionRef {
	public static void main(String[] args) {
		TV tv1 = new TV();
		tv1.basicController.setOnoff(new OnOff());
		tv1.basicController.setChannel(new Channel());
		tv1.basicController.setVolumn(new Volumn());
		
		tv1.TvInfo();
		tv1.basicController.onoff.on();
		tv1.TvInfo();
		tv1.basicController.channel.setChannel(10);
		tv1.basicController.volumn.setVolumn(20);
		tv1.TvInfo();
	}
}
