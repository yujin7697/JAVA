package Ch08Ex;

//C03Computer Class

//SerialNo:String
//CPUSpec : String
//RAMSpec : String
//DISKSpec : String
//PowerON() : void 		SerialNo+의 전원을 켭니다 가 출력
//PowerOFF() : void		SerialNo+의 전원을 끕니다 가 출력
//ShowInfo() : void 	Computer객체의 모든 속성이 출력

public class C03ComputerMain {

	public static void main(String[] args) {
		
		C03Computer LGGram1010 = new C03Computer();
		LGGram1010.SerialNo="1010";
		LGGram1010.CPUSpec="I7";
		LGGram1010.RAMSpec="16G";
		LGGram1010.DISKSpec="2TB";
		LGGram1010.PowerON();
		LGGram1010.ShowInfo();
		LGGram1010.PowerOFF();

	}

}
