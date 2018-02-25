package roll.gui;

import java.io.IOException;

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
	
	
	public String submitOptions(String alphaNum, String alphabet, String dataStructure, String algorithm, String approach) throws IOException {
//		System.out.println(alphaNum);
//		System.out.println(alphabet);
//		System.out.println(dataStructure);
//		System.out.println(algorithm);
//		System.out.println(approach);
		Algorithm a = Algorithm.PERIODIC;
		Approach push = Approach.UNDER;
		DataStructure ds = DataStructure.TABLE;
		Integer alphabetNum = Integer.parseInt(alphaNum);
		char[] alphabetLetters = new char[alphabetNum];
		for(int i = 0; i < alphabetNum; i++) {
			alphabetLetters[i] = alphabet.toCharArray()[i];
			System.out.print(alphabetLetters[i]);
			System.out.println();
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
		this.interactor = new Interactor();
		this.interactor.assignValue(alphabetNum, alphabetLetters, a, push, ds);
		System.out.println("submit return");
		return this.interactor.startLearning();
	}
	
	public String startLearning() throws IOException {
		System.out.println("startPlaying");
		return this.interactor.startLearning();
	}
	
	public String equiSyncAck() throws IOException {
		String returnedStr = this.interactor.equiSyncAck();
		return returnedStr;
	}
	
	public String answerMem(int inLanguage) throws IOException {
		boolean isMem = inLanguage == 1? true : false;
		String returnedStr = this.interactor.answerMemQuery(isMem);
		return returnedStr;
	}
	
	public String answerEqui(int isCorrect, String counterExample) throws IOException {
		//TODO
		boolean isEqui = (isCorrect == 1) ? true : false;
		String returnedStr;
		if(isEqui) {
			returnedStr = "F-Playing";
		}
		returnedStr = this.interactor.answerEquiQuery(isEqui, counterExample);
		return returnedStr;
	}
	
	public void terminate() {
		this.interactor = null;
	}
	
	
}
