package usagelist;
import java.util.Scanner;
class Main
{
	static Scanner sc;
	static UsageList list;
	public static void main (String[] args)
	{
		list=new UsageList();
		sc=new Scanner(System.in);
		System.out.println("\nEnter the below options\n\n1 - put an item \n2 - get an item by index \n3 - get lest used item \n4 - print \n5 - Exit");
		int option=0;
		while(option!=5)
		{
			System.out.print("\n\nEnter your input - ");
			option=sc.nextInt();
			if(option!=5)
			{
				getOption(option);
			}
		}
	}
	
	public static void getOption(int option)
	{
		switch (option)
		{
			case 1:
				System.out.println("\n\nEnter an item");
				sc.nextLine();
				list.put(sc.nextLine());
				System.out.println("\nThe updated list is\n");
				list.print();
				break;
				
			case 2:
				System.out.println("\n\nEnter the index");
				list.get(sc.nextInt());
				System.out.println("\nThe updated list is\n");
				list.print();
				break;
				
			case 3:
				System.out.println("The least used item is  -  "+ list.getLeastUsed());
				break;
				
			case 4:
				System.out.println("\n\nThe list is\n");
				list.print();
				break;
		}
	
	}
}