package roll.gui;

import javafx.application.Platform;
import javafx.scene.layout.Region;

public class JavaScriptBridge extends Region {
	private Interactor interactor;
	
	
	public JavaScriptBridge() {
		this.interactor = new Interactor();
	}
	
	public void callback(String data) {
		Platform.exit();
	}
	
	public void testFunction(String input) {
		System.out.println(input);
	}
	
	public String submitOptions(String alphaNum, String alphabet, String dataStructure, String algorithm, String approach) {
//		System.out.println(alphaNum);
//		System.out.println(alphabet);
//		System.out.println(dataStructure);
//		System.out.println(algorithm);
//		System.out.println(approach);
		Algorithm a = Algorithm.PERIODIC;
		Approach push = Approach.UNDER;
		DataStructure ds = DataStructure.TABLE;
		Integer alphabetNum = Integer.parseInt(alphaNum);
		String[] alphabetLetters = new String[alphabetNum];
		alphabetLetters = alphabet.split("\\,");
		for(int i = 0; i < alphabetNum; i++) {
			alphabetLetters[i] = alphabetLetters[i].trim();
			System.out.println(alphabetLetters[i]);
		}
		if(dataStructure.equals("tree")) {
			ds = DataStructure.TREE;
		} else if(dataStructure.equals("table")) {
			ds = DataStructure.TABLE;
		} else {
			assert(false);
		}
		
		if(algorithm.equals("periodic")) {
			a = Algorithm.PERIODIC;
		} else if(algorithm.equals("syntactic")) {
			a = Algorithm.SYNTACTIC;
		} else if(algorithm.equals("recurrent")) {
			a = Algorithm.RECURRENT;
		} else if(algorithm.equals("ldollar")) {
			a = Algorithm.LDOLLAR;
		} else {
			assert(false);
		}
		
		if(approach.equals("under")) {
			push = Approach.UNDER;
		} else if(approach.equals("over")) {
			push = Approach.OVER;
		} else {
			assert(false);
		}
		System.out.println("assign begin");

		this.interactor.assignValue(alphabetNum, alphabetLetters, a, push, ds);
		System.out.println("submit return");
		return "Start Okay";
	}
	
	public String startLearning() {
		System.out.println("startLearning");
		return this.interactor.startLearning();
	}
	
	
}
