package hack;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;



public class Hack {
	
	static final Scanner scanner = new Scanner(System.in);
	static final String PATH = "/Users/tom-pt7164/Documents";
	static BrowserHistory browserHistory = new BrowserHistory();
	static FileWriter fileWriter = null;
	static BufferedReader reader = null;
	
	static void readFromFile() throws IOException{
		
		reader = new BufferedReader(new FileReader(PATH + "/test.txt"));

		ArrayList<String> urlHistoryArrayList = new ArrayList<>();
		String line;
		while((line = reader.readLine()) != null) {
			urlHistoryArrayList.add(line);
			System.out.println("URl read :" + line);
		}
		browserHistory.setHistoryUrl(urlHistoryArrayList);
		reader.close();
		
	}
	
	static void writeToFile() throws IOException {
		
		fileWriter = new FileWriter(PATH + "/test.txt", true);
		final ArrayList<String> historyUrList = browserHistory.getHistoryUrl();
		for(String url : historyUrList) {
			fileWriter.write(url + "\n");
		}
		fileWriter.close();
	}
	
	static void visit() throws InvalidURLException {
		System.out.println("Enter the url you have to visit: ");
		String input = scanner.nextLine();
		browserHistory.visit(input);	
	}
	
	static void display() {
		browserHistory.displayWithIndex();
	}
	
	static void delete()throws NumberFormatException, IndexOutOfBoundsException{
		System.out.println("\t History urls");
		browserHistory.displayWithIndex();
		
		System.out.println("Enter url index to delete :");
		String input = scanner.nextLine();
		
	
		int number = Integer.parseInt(input);
		browserHistory.delete(number);
		
	}
	
	public static void main(String[] args) {
		String input = "";
		int choice = 0;		
			
		while(true) {
			System.out.println("\n-----------------------");
			System.out.println("1. read");
			System.out.println("2. write");
			System.out.println("3. visit");
			System.out.println("4. delete");
			System.out.println("5. display");
			System.out.println("6. exit");
			System.out.println("Enter your choice :");
			
			try {
				input = scanner.nextLine();
				choice = Integer.parseInt(input);
				
				if(choice == 6) {
					break;
				}
				
				switch(choice) {
				case 1: readFromFile();
				break;
				case 2:	writeToFile();
				break;
				case 3: visit();
				break;
				case 4: delete();
				break;
				case 5: display();
				break;
				default: System.out.println("Enter a number between 1 to 5");
				}
			} catch (NumberFormatException e) {
				System.out.println("Please enter a number");
			}catch (IndexOutOfBoundsException e) {
				System.out.println(e.getMessage());
			}
			catch (FileNotFoundException e) {
				System.out.println("Sorry File not found");
			}
			catch (IOException e) {
				System.out.println("Error accessing file");
			}
			catch (Exception e) {
				System.out.println("Sorry some unexpected error ocuured");
			}
		}
	}
}
