package com.example.voice;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class App {

	private LiveSpeechRecognizer recognizer;
	boolean activate = false;
	Process p;
	String work = null;
	private static final String voiceName = "kevin16";

	public void InitAssistant() {
		System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
		Configuration config = new Configuration();
		config.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
		config.setDictionaryPath("src\\dic.dic");
		config.setLanguageModelPath("src\\lm.lm");

		try {
			recognizer = new LiveSpeechRecognizer(config);
		} catch (IOException e) {
			System.out.println(e);
		}

		startSpeechRecognition();

	}

	@SuppressWarnings("deprecation")
	public void startSpeechRecognition() {
		recognizer.startRecognition(true);
		SpeechResult result;

		System.out.println("Say hi to pelepe");

		while ((result = recognizer.getResult()) != null) {
			String command = result.getHypothesis();

			if (command.equalsIgnoreCase("hi")) {
				pelepeIntro();
				pelepeGreetings();
			} else if (command.equalsIgnoreCase("open chrome")) {
				openChrome();
			} else if (command.equalsIgnoreCase("close chrome")) {
				closeChrome();
			} else if (command.equalsIgnoreCase("open youtube")) {
				openYoutube();
			} else if (command.equalsIgnoreCase("close youtube")) {
				closeYoutube();
			} else if (command.equalsIgnoreCase("open facebook")) {
				openFacebook();
			} else if (command.equalsIgnoreCase("close facebook")) {
				closeFacebook();
			} else if (command.equalsIgnoreCase("open word")) {
				openWord();
			} else if (command.equalsIgnoreCase("close word")) {
				closeWord();
			} else if (command.equalsIgnoreCase("open edge")) {
				openEdge();
			} else if (command.equalsIgnoreCase("close edge")) {
				closeEdge();
			} else if (command.equalsIgnoreCase("open calculator")) {
				openCalc();
			} else if (command.equalsIgnoreCase("close calculator")) {
				closeCalc();
			} else if (command.equalsIgnoreCase("open instagram")) {
				openInstagram();
			} else if (command.equalsIgnoreCase("close instagram")) {
				closeInstagram();
			} else if (command.equalsIgnoreCase("open excel")) {
				openExcel();
			} else if (command.equalsIgnoreCase("close excel")) {
				closeExcel();
			} else if (command.equalsIgnoreCase("open powerpoint")) {
				openPpt();
			} else if (command.equalsIgnoreCase("close powerpoint")) {
				closePpt();
			} else if (command.equalsIgnoreCase("open notepad")) {
				openNotepad();
			} else if (command.equalsIgnoreCase("close notepad")) {
				closeNotepad();
			} else if (command.equalsIgnoreCase("open control panel")) {
				openCP();
			} else if (command.equalsIgnoreCase("close control panel")) {
				closeCP();
			} else if (command.equalsIgnoreCase("open player")) {
				openGrooveMusic();
			} else if (command.equalsIgnoreCase("close player")) {
				closeGrooveMusic();
			} else {
				work = null;
			}

			if (work != null) {
				// Execute the command
				try {
					p = Runtime.getRuntime().exec(work);
				} catch (IOException e) {
					System.out.println(e);
				}
			}
		}
	}

	// SYSTEM OPERATIONS

	public void pelepeIntro() {
		System.out.println("Hey there, i am pelepe. your personal computer companion.");
		speak("Hey there, i am pelepe. your personal computer companion.");
	}

	public void pelepeGreetings() {
		System.out.println("How can i help you, mister pogi?");
		speak("How can i help you, mister pogi?");
	}

	public void openChrome() {
		System.out.println("Opening chrome...");
		speak("Opening chrome");
		work = "cmd /c start chrome.exe";
	}

	public void closeChrome() {
		System.out.println("Closing chrome...");
		speak("Closing chrome");
		work = "cmd /c start taskkill /im chrome.exe /f";
	}

	public void openYoutube() {
		System.out.println("Opening youtube...");
		speak("Opening youtube");
		work = "cmd /c start chrome www.youtube.com";
	}

	public void closeYoutube() {
		System.out.println("Closing youtube...");
		speak("Closing youtube");
		work = "cmd /c start taskkill /IM chrome.exe";
	}

	public void openFacebook() {
		System.out.println("Opening facebook...");
		speak("Opening facebook");
		work = "cmd /c start chrome www.facebook.com";
	}

	public void closeFacebook() {
		System.out.println("Closing facebook...");
		speak("Closing facebook");
		work = "cmd /c start taskkill /im chrome.exe";
	}

	public void openInstagram() {
		System.out.println("Opening instagram...");
		speak("Opening instagram");
		work = "cmd /c start chrome wwww.instagram.com";
	}

	public void closeInstagram() {
		System.out.println("Closing instagram...");
		speak("Closing instagram");
		work = "cmd /c start taskkill /im chrome.exe";
	}

	public void openWord() {
		System.out.println("Opening word...");
		speak("Opening word");
		work = "cmd /c start winword";
	}

	public void closeWord() {
		System.out.println("Closing word...");
		speak("Closing word");
		work = "cmd /c start taskkill /im winword.exe /f";
	}

	public void openEdge() {
		System.out.println("Opening edge...");
		speak("Opening edge");
		work = "cmd /c start microsoft-edge:";
	}

	public void closeEdge() {
		System.out.println("Closing edge...");
		speak("Closing edge");
		work = "cmd /c start taskkill /im MicrosoftEdge.exe /f";
	}

	public void openCalc() {
		System.out.println("Opening calculator...");
		speak("Opening calculator");
		work = "cmd /c start calc";
	}

	public void closeCalc() {
		System.out.println("Closing calculator...");
		speak("Closing calculator");
		work = "cmd /c start taskkill /im calculator.exe /f";
	}

	public void openExcel() {
		System.out.println("Opening excel...");
		speak("Opening excel");
		work = "cmd /c start excel";
	}

	public void closeExcel() {
		System.out.println("Closing excel...");
		speak("Closing excel");
		work = "cmd /c start taskkill /im excel.exe /f";
	}

	public void openPpt() {
		System.out.println("Opening powerpoint...");
		speak("Opening powerpoint");
		work = "cmd /c start powerpnt";
	}

	public void closePpt() {
		System.out.println("Closing powerpoint...");
		speak("Closing powerpoint");
		work = "cmd /c start taskkill /im powerpnt.exe /f";
	}

	public void openNotepad() {
		System.out.println("Opening notepad...");
		speak("opening notepad");
		work = "cmd /c start notepad";
	}

	public void closeNotepad() {
		System.out.println("Closing notepad...");
		speak("closing notepad");
		work = "cmd /c start taskkill /im notepad.exe /f";
	}

	public void openCP() {
		System.out.println("Opening control panel...");
		speak("opening control panel");
		work = "cmd /c start control";
	}

	public void closeCP() {
		System.out.println("Closing control panel...");
		speak("closing control panel");
		work = "cmd /c start taskkill /im control.exe /f";
	}

	public void openGrooveMusic() {
		System.out.println("Opening player...");
		speak("opening player");
		work = "cmd /c start vlc";
	}

	public void closeGrooveMusic() {
		System.out.println("Closing player...");
		speak("closing player");
		work = "cmd /c start taskkill /im vlc.exe /f";
	}

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException {
		App va = new App();
		va.InitAssistant();
	}

	public void speak(String speechText) {
		Voice voice;
		VoiceManager voiceManager = VoiceManager.getInstance();
		voice = voiceManager.getVoice(voiceName);
		voice.allocate();
		voice.speak(speechText);
	}

}
