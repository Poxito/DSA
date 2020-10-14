import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.CharBuffer;
import java.io.BufferedReader;
import java.io.File;

public class Network {

	ArrayList<Friend> ourNetwork = new ArrayList();
	
	public void read_info() throws IOException {
		String line = "";  
		String splitBy = ",";
		
		//parsing a CSV file into BufferedReader class constructor  
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Poxito\\Desktop\\2. Kurtsoa\\DSA\\ProgrammingProject\\peopleG612054.csv"));  
		while ((line = br.readLine()) != null) {  //returns a Boolean value  
	
			String[] info = line.split(splitBy); // use comma as separator
			Friend user = new Friend(info[0], info[1], info[2], info[3], info[4], info[5], info[6], info[7], info[8], info[9], info[10]);
			ourNetwork.add(user);
			//System.out.println("User--> [Id=" + info[0] + ", Name=" + info[1] + ", Last name=" + info[2] + ", Birth Date=" + info[3] + ", Gender= " + info[4] + ", Birth place= " + info[5] +"Home= " + info[6] + "Studied at= " + info[7] + "Work places= " + info[8] + "Films= " + info[9] + "Groupcode= "+ info[10]);  
			//System.out.println(user.name);
		}
	}
	
	public static void main(String args[]) {
		  
		try {  
			Network Instagramoak = new Network();
			
			System.out.println("My Menu:");
			System.out.println("1. Load people into the Instagramos");
			System.out.println("2. Load the relatioships between the people");
			System.out.println("3. Print out the information of the people");
			System.out.println("4. Search for any data about the person you wanna know");
			
			int number;
			Scanner keyboard = new Scanner(System.in);
			number = keyboard.nextInt();
			
			switch(number) {
				case 1:
					Instagramoak.read_info();
					break;
				case 2:
					//metodos de la clase Relationships
					break;
				case 3:
					//metodos de la clase Print
					break;
				case 4:
					//metodos de la clase Search
					break;
				case 5:
					//metodos de la clase LogOut
					break;
				default:	
			}
			keyboard.close();
		} catch (IOException e)  {  
			e.printStackTrace();  
		}
		
	}
}
