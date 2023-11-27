package application;

import decoder.FileReader.FileReader;
import decoder.Receiver.Receiver;
import org.apache.logging.log4j.*;

import java.util.Scanner;

public class App {
	// Public
	public App() {};
	public void Run() {
		logger.info("Application Started...");
		printMenu();
		while(true) {
			int a = getUserInput();
			processInput(a);
		}
	}

	// Private
	private void printMenu(){
		System.out.println("Main menu");
		System.out.println("1. Send encoded message");
		System.out.println("2. Application Logs");
		System.out.println("3. Print Menu");
		System.out.println("4. Exit");
	}

	private int getUserInput(){
		int userOption = 0;
		System.out.print("Enter 1 - 4> ");
			String inpuString = sc.nextLine();
			try{
				userOption = Integer.parseInt(inpuString);
			}catch(Exception e){
				System.out.println("please enter 1-6 only");
			}
		return userOption;
	}
	// Handle user input
	private void processInput(int input) {
		if(input == 1){
			encodeMessage();
		}else if(input == 2){
			applicationLog();
		}else if(input == 3){
			printMenu();
		}else if (input == 4){
			exitApplication();
		}else{
			System.out.println("Invalid Input");
		}
	}
	private void encodeMessage(){
		System.out.print("Enter encoded message> ");
		try{
			FileReader.write(sc.nextLine(), "data/incoming.txt");
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
		Receiver r =new Receiver();
		r.init();
	}
	private void applicationLog(){
		String logs = "";
		try{
			logs = FileReader.read("logs/applicationLog.log");
		}catch (Exception e){
			System.out.println("Failed to read logs");
		}
		System.out.print("Application Log:" + logs);
	}

	private void exitApplication(){
		logger.info("Application Exiting...");
		System.out.println("Application Exiting Now...");
		sc.close();
		System.exit(1);
	}
	private final Scanner sc = new Scanner(System.in);
	private static final Logger logger = LogManager.getLogger(App.class.getName());
}
