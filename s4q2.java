import java.util.*;

public class s4q2 {
    public static void main(String[] args) {
        HashMap<String, String> citySTDMap = new HashMap<>();
        
        citySTDMap.put("Nashik", "9090");
        citySTDMap.put("Mumbai", "6969");
        citySTDMap.put("Pune", "9696");
        citySTDMap.put("Delhi", "1431");
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the name of the city to add: ");
        String newCity = scanner.nextLine();
        if (citySTDMap.containsKey(newCity)) 
            System.out.println("City already exists in the collection.");
        else {
            System.out.print("Enter the STD code for " + newCity + ": ");
            String stdCode = scanner.nextLine();
            citySTDMap.put(newCity, stdCode);
            System.out.println("City and its STD code added successfully.");
        }
        
        System.out.print("Enter the name of the city to remove: ");
        String cityToRemove = scanner.nextLine();
        if (citySTDMap.containsKey(cityToRemove)) {
            citySTDMap.remove(cityToRemove);
            System.out.println(cityToRemove + " and its STD code removed successfully.");
        } else 
            System.out.println("City not found in the collection.");
        
        System.out.print("Enter the name of the city to search: ");
        String cityToSearch = scanner.nextLine();
        if (citySTDMap.containsKey(cityToSearch)) 
            System.out.println("STD code for " + cityToSearch + " is: " + citySTDMap.get(cityToSearch));
        else System.out.println("City not found in the collection.");
        
        scanner.close();
    }
}
