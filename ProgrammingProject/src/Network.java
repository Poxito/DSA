import java.util.Scanner;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Collections;
import java.lang.Comparable;
import java.util.List;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileInputStream.*;

public class Network {

	protected static ArrayList<Object> ourNetwork;
	protected Stack<Friend> friendStack;
	
	public Network() {
		ourNetwork = new ArrayList<Object>();
		friendStack = new Stack<Friend>();
	}
	
	public static ArrayList<Object> getOurNetwork() {
		return ourNetwork;
	}
	
	/**
	 * 
	 * @param path
	 * @throws IOException
	 */
	public void read_info(String path) throws IOException {
		String line = "";  
		String splitBy = ",";
     
        //Creating Scanner instance to read File in Java
        Scanner scnr = new Scanner(new File("C:\\Users\\Poxito\\Desktop\\2. Kurtsoa\\DSA\\ProgrammingProject\\cliquesDSA2021\\" + path));//"C:\Users\Poxito\Desktop\2. Kurtsoa\DSA\ProgrammingProject\cliquesDSA2021\peopleG612054.txt" +
        
		while (scnr.hasNextLine()) {  
			line = scnr.nextLine();
			String[] info = line.split(splitBy); // use comma as separator
			Friend user = new Friend(info[0], info[1], info[2], info[3], info[4], info[5], info[6], info[7], info[8], info[9], info[10]);
			ourNetwork.add(user);
		}
		scnr.close();
	}
	
	/**
	 * 
	 * @throws FileNotFoundException
	 */
	public void printData() throws FileNotFoundException {
		String writePath = "C:\\Users\\Poxito\\Desktop\\2. Kurtsoa\\DSA\\ProgrammingProject\\NetworkInformation1.txt";
		
		File wrname = new File (writePath);
		PrintWriter outFile = new PrintWriter (wrname);
		
		for(Object user : ourNetwork) {
			if(user instanceof Friend) {
				outFile.println(((Friend) user).print());
			}else {
				outFile.println(((Relationships) user).print());
			}
		}
		outFile.close();
	}
	
	/**
	 * 
	 * @param path
	 * @throws IOException
	 */
	public void load_relationships(String path) throws IOException {
		String line = "";  
		String splitBy = ",";
     
        //Creating Scanner 
		Scanner scnr = new Scanner(new File("C:\\Users\\Poxito\\Desktop\\2. Kurtsoa\\DSA\\ProgrammingProject\\cliquesDSA2021\\" + path));
        
        line = scnr.nextLine();
        
		while (scnr.hasNextLine()) {  
			line = scnr.nextLine();
			String[] rela = line.split(splitBy); // use comma as separator
			Relationships userXuser = new Relationships(rela[0], rela[1]);
			ourNetwork.add(userXuser);
		}
		scnr.close();
	}
	
	/**
	 * 
	 * @param surname
	 * @param press
	 * @throws FileNotFoundException
	 */
	public void printFriends(String surname, int press) throws FileNotFoundException {
		
		Friend f1;
        boolean found = false;
        
        for(int i = 0; i < ourNetwork.size(); i++) {
            if(ourNetwork.get(i) instanceof Friend) {
                if(((Friend) ourNetwork.get(i)).getLastname().equals(surname)) {
                    friendStack.push((Friend) ourNetwork.get(i));found = false;
                }
            }
        }
        
        String writePath = "C:\\Users\\Poxito\\Desktop\\2. Kurtsoa\\DSA\\ProgrammingProject\\FriendsYouLookedFor.txt";
        File wrname = new File (writePath);
        PrintWriter outFile = new PrintWriter (wrname);
        
        while(!friendStack.isEmpty()) {
        	f1 = friendStack.pop();
        	for(int j = 0;j < ourNetwork.size();j++) {
        		if(ourNetwork.get(j) instanceof Relationships) {
                    if(press == 1) {
                        if(((Relationships) ourNetwork.get(j)).getFriend1().equals(f1.getId())) {
                            System.out.println(((Relationships) ourNetwork.get(j)).getFriend2());
                        }else if(((Relationships) ourNetwork.get(j)).getFriend2().equals(f1.getId())){
                            System.out.println(((Relationships) ourNetwork.get(j)).getFriend1());
                        }
                    }else if(press == 0){
                        if(((Relationships) ourNetwork.get(j)).getFriend1().equals(f1.getId())) {
                            outFile.println(((Relationships) ourNetwork.get(j)).getFriend2());
                        }else if(((Relationships) ourNetwork.get(j)).getFriend2().equals(f1.getId())){
                            outFile.println(((Relationships) ourNetwork.get(j)).getFriend1());
                        }
                    }
                }
        	}
        }outFile.close();
    }
	
	/**
	 * 
	 * @param city
	 */
	public void cityPeople(String city) {
		
		for(int i=0; i < ourNetwork.size(); i++) {
			if(ourNetwork.get(i) instanceof Friend) {
				if(((Friend) ourNetwork.get(i)).getBirthPlace().equals(city)) {
					System.out.println(((Friend) ourNetwork.get(i)).getId());
					System.out.println(((Friend) ourNetwork.get(i)).getLastname());
				}
			}
		}		
	}
	
	/**
	 * 
	 * @param year1
	 * @param year2
	 */
	public void yearsPeople(int year1, int year2) {
		//the first year has to be the oldest year
		ArrayList<Friend> friendList = new ArrayList<Friend>();
		String[] userYear;
		
		for(int i =  0; i < ourNetwork.size(); i++) {
			if(ourNetwork.get(i) instanceof Friend) {
				userYear = ((Friend) ourNetwork.get(i)).getBirthDate().split("-");
				if(Integer.parseInt(userYear[2]) > year1 && Integer.parseInt(userYear[2]) < year2) {
					friendList.add((Friend) ourNetwork.get(i));
				}
			}
		}
		Collections.sort(friendList);
		for(Friend f : friendList) {
			System.out.println(f.getName() + " " + f.getLastname() + " was born in " + f.getBirthDate());
		}
	}
	
	/**
	 *  recover the values of the 
	 *  attributes name, surname, birthplace and studiedat of the people on the network 
	 *  whose birthplace matches the hometown of the people who are described in 
	 *  residential.txt. People whose birthplace/hometown is unknown do not affect the 
	 *  result of this operation.
	 * @throws IOException
	 */
	public void loadResidential() throws IOException {
		String line = "";  
		Friend f1;
     
        Scanner scnr = new Scanner(new File("C:\\Users\\Poxito\\Desktop\\2. Kurtsoa\\DSA\\ProgrammingProject\\cliquesDSA2021\\residential.txt"));
        
		while (scnr.hasNextLine()) {  
			line = scnr.nextLine();
			for(int i=0; i < ourNetwork.size();i++) {
				if(ourNetwork.get(i) instanceof Friend) {
					if(((Friend) ourNetwork.get(i)).getId().equals(line)) {
						friendStack.push((Friend) ourNetwork.get(i)); // his/her hometown will be used later
						System.out.println("These are " + line + "'s atributes: \n" ); //name, surname, birthplace and studiedat
						System.out.println(" Name: " + ((Friend)ourNetwork.get(i)).getName() + "\n Surname: " + ((Friend)ourNetwork.get(i)).getLastname() + "\n Birthplace: " + ((Friend)ourNetwork.get(i)).getBirthPlace() + "\n StudiedAt: " + ((Friend)ourNetwork.get(i)).getStudiedAt() + "\n");
					}
				}
			}
		}
		scnr.close();
		//
		while(!friendStack.isEmpty()) {
        	f1 = friendStack.pop();
        	for(int j = 0; j < ourNetwork.size();j++) {
        		if(ourNetwork.get(j) instanceof Friend) {
        			if(f1.getHome().equals(((Friend) ourNetwork.get(j)).getHome()))
            			System.out.println(((Friend) ourNetwork.get(j)).getId());
        		}
        	}
        }
	}
	
	/**
	 * This method prints in console the different classes. A class is a group of users that like exactly the 
	 * same films.
	 */
	public void usersIntoClasses() {
		String profile = "";
		ArrayList<String> allProfiles = new ArrayList<String>();
		ArrayList<String> classes = new ArrayList<String>();
		for(int i=0; i < ourNetwork.size();i++) {
			if(ourNetwork.get(i) instanceof Friend) {
				profile = ((Friend) ourNetwork.get(i)).getFilms();
				if(allProfiles.size()==0) {
					allProfiles.add(profile);
					classes.add(((Friend) ourNetwork.get(i)).getName() + " " + ((Friend) ourNetwork.get(i)).getLastname());
				}else if(!allProfiles.contains(profile)){
					allProfiles.add(profile);
					classes.add(((Friend) ourNetwork.get(i)).getName() + " " + ((Friend) ourNetwork.get(i)).getLastname());
				}else {
					String adaptedClass = classes.get(allProfiles.indexOf(profile));
					classes.set(allProfiles.indexOf(profile), adaptedClass + ", " + ((Friend) ourNetwork.get(i)).getName() + " " + ((Friend) ourNetwork.get(i)).getLastname());
				}
			}
		}
		for(int i=0; i<classes.size(); i++) {
			System.out.println("The films that the user like: " + allProfiles.get(i));
			System.out.println("The users that are into the class: " + classes.get(i));
		}
	}
	
	
	
	
	public static void main(String args[]) {
		  
		try {  
			Network Network = new Network();
			
			System.out.println("My Menu:");
			System.out.println("1. Load people into the our network");
			System.out.println("2. Load the relatioships between the people");
			System.out.println("3. Print out the information of the people");
			System.out.println("4. Search for any data about the person you wanna know, update that data if you want");
			System.out.println("5. Search for the shortest or largest chain");
			System.out.println("Enter -1 if you want to log out");
			int number;
			Scanner keyboard = new Scanner(System.in);
			number = keyboard.nextInt();
			String path;
			
			while (number != -1) {
			
				switch(number) {
				case 1:
					path = keyboard.next();
					Network.read_info(path);
					break;
				case 2:
					path = keyboard.next();
					Network.load_relationships(path);
					break;
				case 3:
					Network.printData();
					break;
				case 4:
					System.out.println("Enter 1 if you want to find the friends of a user by entering his/her surname");
					System.out.println("Enter 2 if you want to know who were born on a certain city, you have to write the city");
					System.out.println("Enter 3 if you want to know who were born in a period, enter the two dates");
					System.out.println("Enter 4 if you want to know who was born in the town the people of residential.txt");
					System.out.println("Enter 5 if you want to clasify the users with the same profiles into classes");
					
					int search = keyboard.nextInt();
					switch(search) {
					case 1 :
						// 6
						System.out.println("Enter a surname of a person that is in the network");
						String surname = keyboard.next();
						System.out.println("Enter 1 if you want print the information in the console, enter 0 if you want to print the information in a document");
						int press = keyboard.nextInt();
						Network.printFriends(surname, press);
						break;
					case 2 :
						//7
						System.out.println("Enter a city to know who was born there");
						String city = keyboard.next();
						Network.cityPeople(city);
						break;
					case 3 :
						//8
						System.out.println("Enter two years, the years are two Integer");
						int date1 = keyboard.nextInt();
						int date2 = keyboard.nextInt();
						Network.yearsPeople(date1, date2);
						break;
					case 4 :
						//9
						Network.loadResidential();
						break;
					case 5 :
						//10
						Network.usersIntoClasses();
						break;
					default:
						
					}
					break;
				case 5 :
					Graph graph = new Graph(8,19, "C:\\Users\\Poxito\\Desktop\\2. Kurtsoa\\DSA\\graph8.txt", "C:\\Users\\Poxito\\Desktop\\2. Kurtsoa\\DSA\\graph88.txt","Jon232");
					
					System.out.println("Enter 1 if you want to find the shortest chain betwenn two users");
					System.out.println("Enter 2 if you want to find the largest chain between two users");
					System.out.println("Enter 3 if you want to know which groups have at least four members");
				
					int x = keyboard.nextInt();
					switch(x) {
					case 1:
						//11
						System.out.println("Enter the id of the first user");
						String idUserBreadth = keyboard.next();
						
						System.out.println("Enter the id of the second user");
						String idUserLastBreadth = keyboard.next();
						
						BreadthFirstSearch minChain = new BreadthFirstSearch(graph, graph.returnHashtableValue(idUserBreadth));//graphUsers,graph.returnHashtableValue(idUserLast)
						
						Stack<Integer> shortChain = new Stack<Integer>();
						shortChain = minChain.pathTo(graph.returnHashtableValue(idUserLastBreadth));
						
						while(!shortChain.isEmpty()) {
							System.out.println(shortChain.pop());
						}
						
						break;
					case 2:
						//12 DepthFirstSearch
						System.out.println("Enter the id of the first user");
						String idUserDepth = keyboard.next();
						System.out.println("Enter the id of the second user");
						String idUser2Depth = keyboard.next();
						
						DepthFirstSearch maxChain = new DepthFirstSearch(graph, graph.returnHashtableValue(idUserDepth));
						Stack<Integer> largeChain = new Stack<Integer>();
						largeChain = maxChain.pathTo(graph.returnHashtableValue(idUser2Depth));
						
						while(!largeChain.isEmpty()) {
							System.out.println(largeChain.pop());
						}
						
						break;
					case 3:
						//13
						
						break;
					default:
						
					}
				default:	
					
				}
				number = keyboard.nextInt();
			}
			keyboard.close();
		} catch (IOException e)  {  
			e.printStackTrace();  
		}
		
	}
}
