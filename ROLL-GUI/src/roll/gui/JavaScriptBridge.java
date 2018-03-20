package roll.gui;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

import javafx.application.Platform;
import javafx.scene.layout.Region;

// this class is used to bridge the javascript and java 
// by using "app.methodname()" in javascript
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
		System.out.println("answerMem");
		String returnedStr = this.interactor.answerMemQuery(isMem);
		return returnedStr;
	}
	
	public String answerEqui(int isCorrect, String counterExample) throws IOException {
		boolean isEqui = (isCorrect == 1) ? true : false;
		String returnedStr;
		if(isEqui) {
			returnedStr = "F-Playing";
		}

		System.out.println("answerEqui");
		returnedStr = this.interactor.answerEquiQuery(isEqui, counterExample);
		return returnedStr;
	}
	
	public String answerEquiAgain(String ce) throws IOException {
		return this.interactor.answerEquiQueryAgain(ce);
	}
	
	public String startAutomaticLearning(String autDataStructure, String autAlgorithm, String autApproach, String inputBA) throws UnsupportedEncodingException, FileNotFoundException, IOException {
		//TODO: add bridge here.
		DataStructure autDs = DataStructure.TABLE;
		Algorithm autA = Algorithm.PERIODIC;
		Approach autPush = Approach.UNDER;
		
		if(autDataStructure.equals("tree")) {
			autDs = DataStructure.TREE;
		} else if(autDataStructure.equals("table")) {
			autDs = DataStructure.TABLE;
		} else {
			assert(false);
		}
		
		if(autAlgorithm.equals("periodic")) {
			autA = Algorithm.PERIODIC;
		} else if(autAlgorithm.equals("syntactic")) {
			autA = Algorithm.SYNTACTIC;
		} else if(autAlgorithm.equals("recurrent")) {
			autA = Algorithm.RECURRENT;
		} else if(autAlgorithm.equals("ldollar")) {
			autA = Algorithm.LDOLLAR;
		} else {
			assert(false);
		}
		
		if(autApproach.equals("under")) {
			autPush = Approach.UNDER;
		} else if(autApproach.equals("over")) {
			autPush = Approach.OVER;
		} else {
			assert(false);
		}
		
		System.out.println("Input is:");
		System.out.println(inputBA);
		try(Writer schreiber = new BufferedWriter(new OutputStreamWriter(
		//TODO: change path when release	
		new FileOutputStream("C:\\Users\\10244\\Desktop\\inputBA.ba"), "utf-8"))){
			schreiber.write(inputBA);
		}
		
		
	
		//TODO: add interaction with interactor here
		
		return inputBA;
	}
	
	public void terminate() {
		this.interactor = null;
	}
	
	
}
