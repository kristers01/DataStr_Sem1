package service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

import datastr.MyArrayList;
import model.Student;


//TODO nokopēt Student klasi un ielikt model pakotnē
//TODO izveidot MyArrayList<Student> un to notestēt ar visām funkcijām
public class MainService {

	public static void main(String[] args) {
	
		MyArrayList<Integer> myList = new MyArrayList<Integer>(3);
		
		myList.add(100);
		myList.add(200);
		myList.add(-100);
		try {
			myList.print();//100 200 -100
			myList.add(1, 1000);
			myList.print();//100 1000 200 -100
			myList.remove(0);
			myList.print();//1000 200 -100
			myList.add(200);
			myList.add(200);
			myList.print();//1000 200 -100 200 200
			System.out.println(myList.search(200));//1 3 4
			System.out.println(Arrays.toString(myList.getNeighbours(200)));//-100 200
			myList.print();//1000 200 -100 200 200
			myList.sort();
			myList.print();
			
			myList.makeEmpty();
			myList.add(100000);
			myList.print();//100000
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		System.out.println("-----------------------------");
		MyArrayList<Student> allStudents = new MyArrayList<Student>();
		
		Student s1 = new Student("Janis", "Berzins");
		Student s2 = new Student("Liga", "Jauka");
		Student s3 = new Student("Baiba", "Kalnina");
		
		allStudents.add(s1);//Janis
		allStudents.add(s2);//Janis Liga
		try
		{
			allStudents.add(0, s3); //Baiba Janis Liga
			allStudents.print();//Baiba Janis Liga
			
			System.out.println(allStudents.search(s1));//1
			System.out.println(Arrays.toString(allStudents.getNeighbours(s1)));//Liga
			
			allStudents.print();//Baiba Janis Liga
			//allStudents.sort();
			allStudents.print();//Baiba Janis Liga
				
			
			allStudents.remove(1);
			allStudents.print();//Baiba Liga
			
			allStudents.makeEmpty();
			allStudents.add(s1);
			allStudents.print();//Janis
			
		
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		try {
			MyArrayList<Integer> numbersFromFile = readFromFile("C:\\Users\\s22rukmkris\\java\\DataStr_Semi1\\src\\resources\\DataStruct_1.txt");
			numbersFromFile.print();
		} catch (Exception e) {
			System.out.println(e);
		}

		
		
		
		
		
		
	}
	public static MyArrayList readFromFile(String path) throws Exception, FileNotFoundException, NumberFormatException {
		if(path == null || path.length() < 3) throw new Exception ("Problem with file path");
		
		MyArrayList<Integer> listForNumbers = new MyArrayList<Integer>();
		File file = new File(path);
		//varbut izveidot failu FileInputStream
		Scanner scanner = new Scanner(file);
		
		while(scanner.hasNextLine()) {
			String line = scanner.nextLine();
			
			Integer tempNumber = Integer.parseInt(line);
			listForNumbers.add(tempNumber);
		}
		scanner.close();
		return listForNumbers;
		
	}

}