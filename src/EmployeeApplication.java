import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * 
 * @author 20192310 - Conn O'Cleirigh
 *
 */
public class EmployeeApplication 
{

	private static Scanner input = new Scanner(System.in);
	private static InputStreamReader textInput = new InputStreamReader(System.in);
	private static BufferedReader reader = new BufferedReader(textInput);
	
		
	private static ArrayList<Department> allDepartments = new ArrayList<Department>();
	private static ArrayList<Employee> allEmployees = new ArrayList<Employee>();
	private static ArrayList<Exception> bugReport = new ArrayList<Exception>();
	private static int centralEmployeeID = 105;
	private static int centralDepartmentID = 1003;

	/**calss prepolulate and mainMenu
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{
		prePopulate();
		mainMenu();
	}
	
	/**
	 * creates new employees and department
	 */
	public static void prePopulate() 
	{
		Department mark = new Department(1001,"Marketing", "jim daly");// create the course computer science
		allDepartments.add(mark);//ad cs to the list of all courses
		Department sales = new Department(1002, "Sales", "joe brolly");
		allDepartments.add(sales);
		
		
		Employee e1 = new Employee(101, "joe dagg", 30000, mark, true);
		Employee e2 = new Employee(102, "sally sanders", 30000, mark, true);
		Employee e3 = new Employee(103,"henry harrison", 30000, sales, true);
		Employee e4 = new Employee(104, "fred flinstone", 30000, sales ,true);
		
		mark.addEmployee(e1);
		mark.addEmployee(e2);
		sales.addEmployee(e3);
		sales.addEmployee(e4);

		allEmployees.add(e1);
		allEmployees.add(e2);
		allEmployees.add(e3);
		allEmployees.add(e4);
	}	
	
	/**
	 * user chooses between employee and department menu
	 */
	public static void mainMenu()
		{
			System.out.println("press 1 for employee menu");
			System.out.println("press 2 for department menu");
			
			
			String choice = input.next();
			switch(choice)
			{
				case "1":
				{
					System.out.println("loading employee menu");
					employeeMenu();
					break;
				}
				
				case "2":
				{
				System.out.println("loading department menu");
				departmentMenu();
				break;
				}
			
				
			
			
			
			}
			
					
			
			
			mainMenu();
		}

	
	/**
	 * chooce between each employee related mothod, each case direct by switch stattemnent
	 */
	private static void employeeMenu()
	{
		System.out.println("press 1 to add an employee");// addemplyees
		
		System.out.println("press 2 to  print all employees");// prinalltemployess
		System.out.println("press 3 to print employees by department");// printemployesbydepartment
		System.out.println("press 4 to edit employee");
		System.out.println("press 5 to delete employee");
		System.out.println("press 6 to go to department menu");
		//optional edit and delete
	

		String choice = input.next();
		
		switch(choice)
		{
			case"1":
			{
				try {
				addEmployee();
				}
				catch(Exception e)
				{
					bugReport.add(e);
					System.out.println("Error logged");
				}
				break;
			}
			
			case"2":
			{	try {
				printAllEmployees();
				}
				catch(Exception e)
				{
				bugReport.add(e);
				System.out.println("Error logged");
				}
				break;
				
				
			}
			case"3":
			{
				try {
				printEmployeesByDepartment();
				}
				catch(Exception e)
				{
				bugReport.add(e);
				System.out.println("Error logged");
				}
				break;
			}
			case"4":
			{
				try {
				editEmployee();
				}
				catch(Exception e)
				{
				bugReport.add(e);
				System.out.println("Error logged");
				}
				break;
			}
			case"5":
			{
				try {
				deleteEmployee();
				}
				catch(Exception e)
				{
				bugReport.add(e);
				System.out.println("Error logged");
				}
				break;
			}
			case"6":
			{
				try {
					departmentMenu();
					}
					catch(Exception e)
					{
					bugReport.add(e);
					System.out.println("Error logged");
					}
					break;
			}
		
		
		}
	
	employeeMenu();	
	}
	/**
	 * empoloyee is deleted and
	 */
	private static void deleteEmployee() 
	{
		printAllEmployees();
		System.out.println("choose ID number of employee to delete");
		int chosenEmployee = input.nextInt();
		
		for(Employee e: allEmployees)
		{
			if(chosenEmployee==e.getEmployeeId())
			{
				allEmployees.remove(e);
				for(Department d: allDepartments)
				{
					if(e.getEmployeeDepartment().equals(d))
					{
						e.setEmployeeDepartment(null);
						d.removeEmployee(e);
						employeeMenu();
					}
				}
			}
		}
	
		
	}

/**
 * user can edit each property of employee, chooses by ID
 * @throws Exception
 */
	private static void editEmployee() throws Exception
	{
		printAllEmployees();
		System.out.println("choose ID number of Employee to edit");
		int chosenEmployee = input.nextInt();
		
		for(Employee e: allEmployees)
		{
			if(chosenEmployee == e.getEmployeeId())
			{
				System.out.println("enter new name for "+e.getEmployeeName());
				e.setEmployeeName(reader.readLine());
				System.out.println("enter new title for "+e.getTitle());
				e.setTitle(reader.readLine());
				System.out.println("enter new salary");
				e.setSalary(input.nextDouble());
				
				e.getEmployeeDepartment().removeEmployee(e);

				
				System.out.println("enter new department by ID");
				printAllDepartments();
				int employeeDepartment = input.nextInt();
				
				for(Department d: allDepartments)
				{
					if(employeeDepartment==d.getDepartmentID())
					{
						e.setEmployeeDepartment(d);; //adds chosen club to player
						d.addEmployee(e); // adds player to the club
						
						System.out.print(e.getEmployeeName()+" is now in the department of "+d.getDepartmentName());
						System.out.println("*****");
						
					}
				}
			}
			}
			
		
	}
	

/**
 * user can choose to call each department related method, uses switch statement to calll
 */
	private static void departmentMenu()
	{
		System.out.println("press 1 to add a department");// addddepartment
		System.out.println("press 2 to print all departments");
		System.out.println("press 3 to print total wages");//printtotal wages
		System.out.println("press 4 to print wages by department");// printwagesbydepartment
		System.out.println("press 5 to edit a department");
		System.out.println("press 6 to delete a department");
		System.out.println("press 7 to go to employee menu");
	
String choice = input.next();
		
		switch(choice)
		{
		case"1":
		{
			try {
				addDepartment();
				}
				catch(Exception e)
				{
				bugReport.add(e);
				System.out.println("Error logged");
				}
				break;
		}
		case"2":
		{
			try {
				printAllDepartments();
				}
				catch(Exception e)
				{
				bugReport.add(e);
				System.out.println("Error logged");
				}
				break;
		}
		
		case"3":
		{
			try {
				printTotalWages();
				}
				catch(Exception e)
				{
				bugReport.add(e);
				System.out.println("Error logged");
				}
				break;
		}
		case"4":
		{
			try {
				printWagesByDepartment();
				}
				catch(Exception e)
				{
				bugReport.add(e);
				System.out.println("Error logged");
				}
				break;
		}
		case "5":
		{
			try {
				editDepartment();
				}
				catch(Exception e)
				{
				bugReport.add(e);
				System.out.println("Error logged");
				}
				break;
		}
		case "6":
		{
			try {
				deleteDepartment();
				}
				catch(Exception e)
				{
				bugReport.add(e);
				System.out.println("Error logged");
				}
				break;
		}
		case "7":
		{
			try {
				employeeMenu();
				}
				catch(Exception e)
				{
				bugReport.add(e);
				System.out.println("Error logged");
				}
				break;
		}
		}
	departmentMenu();
	}

/**
 * user selected department by id then it is deleted
 */
	private static void deleteDepartment()
	{
		
			printAllDepartments();
			System.out.println("choose ID number of department to delete");
			int chosenDepartment = input.nextInt();
			
			for(Department d: allDepartments)
			{
				if(chosenDepartment==d.getDepartmentID())
				{
					allDepartments.remove(d);
					
				}	
			}
		
	}

/**
 * user choosed department by id than can change the propetied os chosen department
 * @throws Exception
 */
	private static void editDepartment() throws Exception
	{
		printAllDepartments();
		System.out.println("choose ID number of player to edit");
		int chosenDepartment = input.nextInt();
		
		for(Department d: allDepartments)
		{
			if(chosenDepartment == d.getDepartmentID())
			{
				System.out.println("enter new name for "+ d.getDepartmentName());
				d.setDepartmentName(reader.readLine());
				System.out.println("enter new head name for "+ d.getHeadName());
				d.setHeadName(reader.readLine());
				
			}
		}
	}

/**
 * all employes details are print for each empoyee
 */
	private static void printAllEmployees()
	{
		for(Employee e: allEmployees)
		{
			
			e.printDetails();
		}
		
	}
/**
 * user chooses department by ID and then total wages for that department are outputted
 */
	private static void printWagesByDepartment()
	{
		printAllDepartments();
		double totalWages = 0;
		System.out.println("enter department id of desired department");
		int chosenDepartment = input.nextInt();
		for(Department d: allDepartments)
		{
			
			if(d.getDepartmentID()==chosenDepartment)
			{
				
				for(Employee e: d.getDepartmentEmployeeList())
				{
				if(e.isCurrent()==true)
				{
					totalWages = totalWages+e.getSalary();
				}
				System.out.println("total wages are €"+totalWages);
			}
			
			}
		}
		}
	
	

/**
 * all wages for current employees are calulated the outputted
 */
	private static void printTotalWages()
	{
	double totalWages = 0;
	for(Employee e: allEmployees)
	{
		if(e.isCurrent()==true)
			{
			totalWages = totalWages+e.getSalary();
			}
	}
	System.out.println("total wages are €"+totalWages);
	}

/**
 * new employee is created nand each propery is added by user
 * @throws Exception
 */
	private static void addEmployee() throws Exception
	{
			Employee e = new Employee();
			e.setEmployeeId(centralEmployeeID);
			centralEmployeeID++;
			System.out.println("enter emplyoee name");
			e.setEmployeeName(reader.readLine());
			e.setCurrent(true);
			System.out.println("enter salary");
			e.setSalary(input.nextDouble());
			System.out.println("enter job title");
			e.setTitle(reader.readLine());
			System.out.println("choose employee deparmtent by ID number");
			printAllDepartments();
			int employeeDepartment = input.nextInt();
			
			for(Department d: allDepartments)
			{
				if(employeeDepartment==d.getDepartmentID())
				{
					e.setEmployeeDepartment(d);; //adds chosen club to player
					d.addEmployee(e); // adds player to the club
					System.out.println(e.getEmployeeName()+" is now in the department of "+d.getDepartmentName());
				}
			}
			allEmployees.add(e);
		}
		
	/**
	 * department is creteas, id added, user asked for the remaining properties
	 * @throws Exception
	 */
	private static void addDepartment() throws Exception
	{
		Department d = new Department(); //Creates an empty Department Object
		d.setDepartmentID(centralDepartmentID);
		centralDepartmentID++;
		System.out.println("Enter department name");
		d.setDepartmentName(reader.readLine());
		System.out.println("enter department head name");
		d.setHeadName(reader.readLine());
		System.out.println(d.getDepartmentName() + " has been sucessfully created");
		allDepartments.add(d);
	}
	
	private static void printAllDepartments() 
	{
		for(Department d: allDepartments)
		{
			System.out.println(d.getDepartmentID() + "\t" + d.getDepartmentName());
		}
		
		
	}

/**
 * department is chosen, employees diplayed in said department
 */
	private static void printEmployeesByDepartment()
	{
		printAllDepartments();
		System.out.println("enter department id of desired department");
		int choice = input.nextInt();
		for(Department d: allDepartments)
		{
				if(choice==d.getDepartmentID())
				{
					d.printEmployees();
				}
			}
	}
}
