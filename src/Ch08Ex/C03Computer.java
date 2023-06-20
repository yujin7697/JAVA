package Ch08Ex;

public class C03Computer {
	String SerialNo;
	String CPUSpec;
	String RAMSpec;
	String DISKSpec;
	
	void PowerON() {
		System.out.println("SerialNo+의 전원을 켭니다");
	}
	void ShowInfo() {
		System.out.println("SerialNo : "+SerialNo+" CPUSpec : "+CPUSpec
				+" RAMSpec : "+RAMSpec+" DISKSpec : "+DISKSpec);
	}
	void PowerOFF() {
		System.out.println("SerialNo+의 전원을 끕니다");
	}
}
