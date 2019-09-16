/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.calculator;

import fit5042.tutex.repository.entities.Property;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mukar
 */
@Stateful
public class ComparePropertySessionBean implements ComparePropertySessionBeanRemote{
    
    @PersistenceContext(unitName = "W6ExeStudent-ejbPU")
    private EntityManager entityManager;
    
    private List<Integer> propertyList;

    @Override
    public void addPropertyId(int propertyId) {
        if (propertyId > -1)
            propertyList.add(propertyId);
    }

    @Override
    public void removePropertyId(int propertyId) {
        if (propertyList.contains(new Integer(propertyId)))
            propertyList.remove(new Integer(propertyId));
    }

    @Override
    public int bestPerRoom() {
        if (propertyList.size() > 0){
            Property property = entityManager.find(Property.class, propertyList.get(0));
            int bestId = property.getPropertyId();
            double bestPrice = property.getPrice() / property.getNumberOfBedrooms();
            for (int propertyId: propertyList){
                Property currentProperty = entityManager.find(Property.class, propertyId);
                double currentPrice =  currentProperty.getPrice() / currentProperty.getNumberOfBedrooms();
                if (currentPrice < bestPrice){
                    bestPrice = currentPrice;
                    bestId = currentProperty.getPropertyId();
                }
            }
            return bestId;
        }else return 0;
    }
    
    
    @PostConstruct
   public void init(){
       this.propertyList = new ArrayList<Integer>();
       
   }
}
