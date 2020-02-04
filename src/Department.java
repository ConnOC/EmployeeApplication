import java.util.ArrayList;
/**
 * 
 * @author 20192310 - Conn O'Cleirigh
 *
 */
/**
 * 
 * properties for department object
 *
 */
public class Department 
{
private int departmentID;
private String departmentName;
private String headName;
private ArrayList<Employee> departmentEmployeeList = new ArrayList<Employee>();

/**
 * constructor to create department wiht the following properties
 */
public Department(int departmentID, String departmentName, String headName) {
	this.departmentID = departmentID;
	this.departmentName = departmentName;
	this.headName = headName;
	
}
/**
 * null contructor, you can create department with no properties
 */
public Department()
{
	
}
/**
 * id and named printed for each employee in the arrayList department employee lsit
 */
public void printEmployees()
{
	for(Employee e: departmentEmployeeList)
	{
		System.out.println(e.getEmployeeId()+"\t"+e.getEmployeeName());
	}
}
/**
 * removes employee from arrayList department employee lsit
 * @param e
 */
public void removeEmployee(Employee e)
{
	departmentEmployeeList.remove(e);
}
/**
 * addes employee to ArrayList departmentEmployeeList
 * @param e
 */
public void addEmployee(Employee e)
{
	departmentEmployeeList.add(e);
}
/**
 * prints department name and the details on employees in that department
 */
public void printDepartment()
{
	System.out.println(departmentName + "employee list");
	System.out.println("******************************");
	for(Employee e: departmentEmployeeList)
	{
		e.printDetails();
	}
	System.out.println("********************************");
	
	}


public int getDepartmentID() {
	return departmentID;
}

public void setDepartmentID(int departmentID) {
	this.departmentID = departmentID;
}

public String getDepartmentName() {
	return departmentName;
}

public void setDepartmentName(String departmentName) {
	this.departmentName = departmentName;
}

public String getHeadName() {
	return headName;
}

public void setHeadName(String headName) {
	this.headName = headName;
}

public ArrayList<Employee> getDepartmentEmployeeList() {
	return departmentEmployeeList;
}

public void setDepartmentEmployeeList(ArrayList<Employee> departmentEmployeeList) {
	this.departmentEmployeeList = departmentEmployeeList;
}




}
