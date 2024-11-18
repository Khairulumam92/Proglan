public class Employee {
    public String name;
    public int id;
    public double salary;
    public String department;

    public static final double BONUS_RATE = 0.1;

    public Employee(String name, int id, double salary, String department) {
        this.name = name;
        this.id = id;
        this.salary = salary;
        this.department = department;
    }

    public void printDetails() {
        System.out.println("Employee ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Salary: " + salary);
        System.out.println("Department: " + department);
    }

    public void applyBonus() {
        double bonus = salary * BONUS_RATE;
        salary += bonus;
        System.out.println("Bonus applied! New salary: " + salary);
    }

    public void updateDepartment(String newDepartment) {
        department = newDepartment;
        System.out.println("Department updated to: " + department);
    }
}

class Project {
    public String projectName;
    public String projectDeadline;
    public Employee projectLeader;
    public double budget;

    public Project(String projectName, String projectDeadline, Employee projectLeader, double budget) {
        this.projectName = projectName;
        this.projectDeadline = projectDeadline;
        this.projectLeader = projectLeader;
        this.budget = budget;
    }

    public void printProjectDetails() {
        System.out.println("Project Name: " + projectName);
        System.out.println("Project Deadline: " + projectDeadline);
        System.out.println("Budget: " + budget);
        projectLeader.printDetails();
    }

    public void updateBudget(double newBudget) {
        budget = newBudget;
        System.out.println("Budget updated to: " + budget);
    }
}

class Client {
    public String clientName;
    public String clientEmail;
    public Project project;

    public Client(String clientName, String clientEmail, Project project) {
        this.clientName = clientName;
        this.clientEmail = clientEmail;
        this.project = project;
    }

    public void printClientDetails() {
        System.out.println("Client Name: " + clientName);
        System.out.println("Client Email: " + clientEmail);
        project.printProjectDetails();
    }
}

class MainApp {
    public static void main(String[] args) {
        Employee emp = new Employee("John Doe", 12345, 75000, "Engineering");
        Project proj = new Project("AI Development", "2024-12-31", emp, 1000000);

        Client client = new Client("Acme Corp", "contact@acme.com", proj);

        client.printClientDetails();
        emp.applyBonus();
        emp.updateDepartment("Research and Development");
        proj.updateBudget(1200000);
    }
}