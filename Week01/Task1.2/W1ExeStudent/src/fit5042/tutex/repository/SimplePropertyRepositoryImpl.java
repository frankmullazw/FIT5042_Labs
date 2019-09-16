/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.repository;

/**
 * TODO Exercise 1.3 Step 2 Complete this class.
 * 
 * This class implements the PropertyRepository class. You will need to add the keyword
 * "implements" PropertyRepository. 
 * 
 * @author Jian 
 */
import fit5042.tutex.repository.entities.Property;
import java.util.ArrayList;
import java.util.List;
public class SimplePropertyRepositoryImpl implements PropertyRepository{
    
    private ArrayList<Property> properties = new ArrayList<>();

    @Override
    public void addProperty(Property property) throws IllegalArgumentException {
        if (property != null)
            // Do any checks for data integrity
            this.properties.add(property);
        else
            throw new IllegalArgumentException("Cannot Add null property!");
    }

    @Override
    public Property searchPropertyById(int id) throws IllegalArgumentException {
        if (id < 0)
            throw new IllegalArgumentException("Please provide positive id number!");
        
        for(int i = 0; i < this.properties.size(); i++){
            Property property = this.properties.get(i);
            if (property.getId() == id)
                return property;
        }
        return null;
    }

    @Override
    public List<Property> getAllProperties() {
        return this.properties;
    }
    
            
}
