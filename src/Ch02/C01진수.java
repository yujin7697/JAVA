package Ch02;

public class C01진수 {
	public static void main(String[] args) {
//		2진수 -> 10진수
//		10101100 = 4+8+32+128 = 172
//		10011010 = 2+8+16+128 = 154
//		01101010 = 2+8+32+64 = 106
//		10010010 = 2+16+128 = 146
		
//		10진수 -> 2진수
//		192	->	11000000
//		224	->	11100000
//		252	->	11111100
//		12	->	00001100
//		15	->	00001111
		
//		코드 예쁘게 정리 : ctrl+shift+f
		System.out.printf("10진수 : %d\n",0b00001111); // 10진수
		System.out.printf("10진수 : %d\n",173); // 10진수
		System.out.printf("10진수 : %d\n",0255);// 8진수(0 : 8진수를 의미하는 접두사)
		System.out.printf("10진수 : %d\n",0xAD);// 16진수(0x : 16진수를 의미하는 접두사)
		
		System.out.printf("8진수 : %o\n",173); // 10진수
		System.out.printf("8진수 : %o\n",0255);// 8진수(0 : 8진수를 의미하는 접두사)
		System.out.printf("8진수 : %o\n",0xAD);// 16진수(0x : 16진수를 의미하는 접두사)
		
		System.out.printf("16진수 : %x\n",173); // 10진수
		System.out.printf("16진수 : %x\n",0255);// 8진수(0 : 8진수를 의미하는 접두사)
		System.out.printf("16진수 : %x\n",0xAD);// 16진수(0x : 16진수를 의미하는 접두사)
	}
}