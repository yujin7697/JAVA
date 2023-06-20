package Ch18Ex;


class 재료{
	
}

class 민초 {
	String meterial;
	민초(String m){this.meterial=m;}
	@Override
	public String toString() {
		return "민초 [meterial=" + meterial + "]";
	}
	
}

class 캬라멜 extends 재료{
	String meterial;
	캬라멜(String m){this.meterial=m;}
	@Override
	public String toString() {
		return "캬라멜 [meterial=" + meterial + "]";
	}
}
class 버터옥수수 extends 재료{
	String meterial;
	버터옥수수(String m){this.meterial=m;}
	@Override
	public String toString() {
		return "버터옥수수 [meterial=" + meterial + "]";
	}
	
}

class PopCorn <T extends 재료>{
	private T meterial;
	PopCorn(T meterial){
		this.meterial = meterial;
	}
	void ShowInfo(){
		System.out.println(meterial.toString()+"맛 팝콘");
	}
}

public class C01Generic {
	public static void main(String[] args) {
		PopCorn<캬라멜> ob1 = new PopCorn<캬라멜>(new 캬라멜("캬라멜"));
		ob1.ShowInfo();
		PopCorn<버터옥수수> ob2 = new PopCorn<버터옥수수>(new 버터옥수수("버터옥수수"));
		ob2.ShowInfo();
		
	}
}
