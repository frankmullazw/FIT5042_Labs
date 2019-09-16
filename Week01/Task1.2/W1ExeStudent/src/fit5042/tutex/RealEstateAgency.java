package fit5042.tutex;

import fit5042.tutex.repository.PropertyRepository;
import fit5042.tutex.repository.PropertyRepositoryFactory;
import fit5042.tutex.repository.entities.Property;
import java.util.Scanner;

/**
 *
 * TODO Exercise 1.3 Step 3 Complete this class. Please refer to tutorial
 * instructions. This is the main driver class. This class contains the main
 * method for Exercise 1A
 *
 * This program can run without the completion of Exercise 1B.
 *
 * @author Jian
 */
public class RealEstateAgency {

    private String name;
    private final PropertyRepository propertyRepository;

    public RealEstateAgency(String name) throws Exception {
        this.name = name;
        this.propertyRepository = PropertyRepositoryFactory.getInstance();
    }

    // Complete the code
    public void run() throws Exception {
        this.propertyRepository.addProperty(new Property(1, "24 Boston Ave, Malvern East VIC 3145, Australia 2BR(s)", 150, 420000));
        this.propertyRepository.addProperty(new Property(2, "11 Bettina St, Clayton VIC 3168, Australia 3BR(s)", 350, 360000));
        this.propertyRepository.addProperty(new Property(3, "3 Wattle Ave, Glen Huntly VIC 3163, Australia 5BR(s)", 800, 650000));
        this.propertyRepository.addProperty(new Property(4, "3 Hamiltoon St, Bentleigh VIC 3145, Australia 2BR(s)", 170, 435000));
        this.propertyRepository.addProperty(new Property(5, "82 Spring Rd, Hampton East VIC 3145, Australia 1BR(s)", 60, 820000));

        System.out.println("5 Properties have been added successfully\n*********************************************");

        for (Property property : this.propertyRepository.getAllProperties()) {
            System.out.println(property);
        }
        Scanner reader = new Scanner(System.in);
        System.out.println("*********************************************\nEnter the ID of the property you want to search: ");

        // Get input
        int inputId = reader.nextInt();
        reader.close();

        Property searchedProperty = this.propertyRepository.searchPropertyById(inputId);
        if (searchedProperty != null) {
            System.out.println(searchedProperty);
        } else {
            System.out.println("Error: Could not find property!");
        }

    }

}
