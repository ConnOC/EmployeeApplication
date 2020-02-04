/**
 * 
 * @author 20192310 - Conn O'Cleirigh
 *
 */

public class Employee 
{
	private int employeeId;
	private String employeeName;
	private String title;
	private double salary;
	private Department employeeDepartment;
	private boolean current;
/**
 * null constructor for create an employee
 */
public Employee()
{
	
}
/**
 * constructor for employee with following properites
 * @param employeeID
 * @param employeeName
 * @param salary
 * @param employeeDepartment
 * @param current
 */
public Employee(int employeeID, String employeeName, double salary, Department employeeDepartment, boolean current)
{
this.employeeId = employeeID;
this.employeeName = employeeName;
this.salary = salary;
this.employeeDepartment = employeeDepartment;
this.current = current;
}
/**
 * displays each detail for employee
 */
public void printDetails()
{
	System.out.println("ID:\t" + employeeId);
	System.out.println("Name:\t" + employeeName);
	System.out.println("salary:\t" + salary);
	System.out.println("department:\t" + employeeDepartment.getDepartmentName());
	System.out.println("current employee:\t" + current);
}

public int getEmployeeId() {
	return employeeId;
}

public void setEmployeeId(int employeeId) {
	this.employeeId = employeeId;
}

public String getEmployeeName() {
	return employeeName;
}

public void setEmployeeName(String employeeName) {
	this.employeeName = employeeName;
}

public double getSalary() {
	return salary;
}

public void setSalary(double salary) {
	this.salary = salary;
}

public  Department getEmployeeDepartment() {
	return employeeDepartment;
}

public void setEmployeeDepartment(Department employeeDepartment) {
	this.employeeDepartment = employeeDepartment;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public boolean isCurrent() {
	return current;
}

public void setCurrent(boolean current) {
	this.current = current;
}

}
