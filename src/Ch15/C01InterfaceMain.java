package Ch15;

interface Remocon{
	void ON();
	void OFF();
	void ChangeChannel(int channel);
}

class TV implements Remocon{
	int channel;
	public void ON() {System.out.println("TV를 켭니다.");}
	public void OFF() {System.out.println("TV를 끕니다.");}
	public void ChangeChannel(int channel) {
		System.out.println("TV채널 변경 : " + channel);
		this.channel = channel;
	}
}

interface Browser{
	void Searchable(String url);
}

class SmartTV extends TV implements Browser{
	public void Searchable(String url) {
		System.out.println("브라우저에서 URL " + url + " 접속 요청합니다.");
	}
	
}

class Radio implements Remocon{
	int channel;
	public void ON() {System.out.println("Radio를 켭니다.");}
	public void OFF() {System.out.println("Radio를 끕니다.");}
	public void ChangeChannel(int channel) {
		System.out.println("Radio채널 변경 : " + channel);
		this.channel = channel;
	}
}

public class C01InterfaceMain {
	public static void TurnOn(Remocon controller) {
		controller.ON();
	}
	public static void TurnOff(Remocon controller) {
		controller.OFF();
	}
	public static void ChangeChannel(Remocon controller, int channel) {
		controller.ChangeChannel(channel);
	}
	public static void SearchBrowser(Browser browser, String url) {
		browser.Searchable(url);
	}
	public static void main(String[] args) {
		TV tv1 = new TV();
		Radio radio1 = new Radio();
//		TurnOn(tv1);
//		TurnOff(tv1);
//		TurnOn(radio1);
//		TurnOff(radio1);
//		ChangeChannel(radio1,20);
//		ChangeChannel(tv1,10);
		SmartTV tv2 = new SmartTV();
		TurnOn(tv2);
		ChangeChannel(tv2,100);
		TurnOff(tv2);
	}
}
