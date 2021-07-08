package avl;

public class AVLMain{

	public static void main(String[] args) {
		AVLBaum<Integer> test01 = new AVLBaum<Integer>();
		test01.add(10);
		test01.add(5);
		test01.printBFs();
		test01.add(4);
		test01.printDotFile("RightRotTest01");
		
		AVLBaum<Integer> test02 = new AVLBaum<Integer>();
		test02.add(10);
		test02.add(5);
		test02.add(12);
		test02.add(4);
		test02.add(6);
		test02.add(3);
		test02.printDotFile("RightRotTest02");
		
		
		AVLBaum<Integer> test03 = new AVLBaum<Integer>();
		test03.add(4);
		test03.add(5);
		test03.add(10);
		test03.printDotFile("LeftRotTest01");
	
	
		AVLBaum<Integer> test04 = new AVLBaum<Integer>();
		test04.add(10);
		test04.add(5);
		test04.add(15);
		test04.add(14);
		test04.add(16);
		test04.add(17);
		test04.printDotFile("LeftRotTest02");
		
		
		AVLBaum<Integer> test05 = new AVLBaum<Integer>();
		test05.add(7);
		test05.add(5);
		test05.add(12);
		test05.add(10);
		test05.add(14);
		test05.add(11);
		test05.printDotFile("LeftRightRotTest01");
		
		AVLBaum<Integer> test07 = new AVLBaum<Integer>();
		test07.add(10);
		test07.add(15);
		test07.add(13);
		test07.printDotFile("RightLeftRotTest01");
		
		AVLBaum<String> test06 = new AVLBaum<String>();
		test06.add("Jan");
		test06.add("Feb");
		test06.add("Mar");
		test06.add("Apr");
		test06.add("Mai");
		test06.add("Jun");
		test06.add("Jul");
		test06.add("Aug");
		test06.add("Sep");
		test06.add("Okt");
		test06.add("Nov");
		test06.add("Dez");
		test06.printDotFile("Jahreszeiten");
		
	}
}
