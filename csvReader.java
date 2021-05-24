import java.io.*;
import java.util.*;
public class csvReader{
	public static void main(String[]args)
	{	
		try{
			BufferedReader inFile = new BufferedReader(new FileReader("csvFileTest.csv"));
			Scanner kb = new Scanner(System.in);
			System.out.println("Enter the type of information you would like to see? \n(1) ID Numbers, (2) Phone Numbers, (3) emails, (ANY OTHER KEY) for all info");
			String input = kb.nextLine();
			int choice;
			try{
				choice = Integer.parseInt(input);
				if(choice < 1 || choice > 3)choice = -1;
			}catch(NumberFormatException e){
				choice = -1;
			}

			String line = "";
			while((line = inFile.readLine())!=null)
			{
				String[] info = line.split(",");
				displayInfo(info, choice);
			}
			inFile.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	static void displayInfo(String[] info, int choice)
	{
		if(choice == -1){
			for(int i = 0; i < info.length-1; i++) //info.length - 1 to avoid having a comma attached to the end of the final piece of info
				System.out.print(info[i]+", ");
			System.out.print(info[info.length - 1]);
		}
		if(choice == 1) System.out.print(info[0]+", "+info[1]);
		if(choice == 2) System.out.print(info[1]+", "+info[2]);
		if(choice == 3) System.out.print(info[1]+", "+info[3]);

		System.out.println();
	}
}
