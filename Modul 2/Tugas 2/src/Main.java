public class Main {
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
