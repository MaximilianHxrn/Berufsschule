package util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import geschenkkatalog_Vorlage.INode;



public class Util {
	
	private final static Random RANDOM = new Random();
	private static int nullcounter = 0;

	public static String create(Object... str) {
		StringBuilder buf = new StringBuilder(100);
		for (int i = 0; i < str.length; i++) {
			buf.append(str[i].toString());
		}
		return buf.toString();
	}

	public static String createWithSpace(Object... str) {
		StringBuilder buf = new StringBuilder(100);
		for (int i = 0; i < str.length; i++) {
			buf.append(str[i].toString());
			buf.append(" ");
		}
		return buf.toString();
	}
	
	public static int getZufallszahl(int max) {
		if(max <= 1) {
			return 1;
		}
		return RANDOM.nextInt(max)+1;
	}
	
	public static void printDOTFile(String name, INode<?> root) throws IOException {
		File f = new File("DotFiles\\" + name + ".txt");
		FileWriter writer = new FileWriter(f);
		BufferedWriter bwriter = new BufferedWriter(writer);
		
		bwriter.write("digraph BST {\n");
		bwriter.write("    node [fontname=\"Arial\"];\n");
		
		if(root == null) {
			bwriter.write("\n");
		}
		else {
			nullcounter = 0;
			printTree(root,bwriter);
		}
		
		bwriter.write("}\n");
		bwriter.close();
	}

	private static void printTree(INode<?> root, BufferedWriter bwriter) throws IOException {
		
		if(root.getLeftNode()!=null) {
			String s = "    \"" + root.getElement() + "\"-> \"" + root.getLeftNode().getElement() +"\"";
			s += ";\n"; 
			bwriter.write(s);
			printTree(root.getLeftNode(), bwriter);
		}
		else {
			printDotNull(root, bwriter);
		}
		if(root.getRightNode()!=null) {
			String s = "    \"" + root.getElement() + "\"-> \"" + root.getRightNode().getElement() +"\"";
			s += ";\n"; 
			bwriter.write(s);
			printTree(root.getRightNode(), bwriter);
		}
		else {
			printDotNull(root, bwriter);
		}
	}
	
	private static void printDotNull(INode<?> child, BufferedWriter bwriter) throws IOException {
		StringBuilder build = new StringBuilder();
		build.append("    null").append(nullcounter).append(" [shape=point];\n");
		build.append("    \"").append(child.getElement()).append("\"-> null").append(nullcounter).append(";\n");
		bwriter.write(build.toString());
		nullcounter++;
	}
}
