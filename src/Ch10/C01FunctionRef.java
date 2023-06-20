package Ch10;

class Controller{
	Module module;
	
	void setModule(Module module) {
		this.module = module;
	}
	Module getModule() {
		return module;
	}
}

class Module{
	Module(){System.out.println("Module 생성 this : " + this);}
	void Func1() {System.out.println("Module's Func1()");}
	void Func2() {System.out.println("Module's Func2()");}
	void Func3() {System.out.println("Module's Func3()");}
	
}

public class C01FunctionRef {
	public static void main(String[] args) {
		Controller controller1 = new Controller();
		controller1.setModule(new Module());//Module module = new Module()
		controller1.module.Func1();
		controller1.module.Func2();
		controller1.module.Func3();
		System.out.println("Controller module : " + controller1.getModule());
	}
}
