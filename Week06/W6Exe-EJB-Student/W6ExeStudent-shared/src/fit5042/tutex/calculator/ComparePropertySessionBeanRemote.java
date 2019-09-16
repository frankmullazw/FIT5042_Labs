package fit5042.tutex.calculator;

import javax.ejb.Remote;

/**
 * This interface defines common behavior and functionality involved in the management 
 *of properties across all implementations
 * 
 * @author mukar
 */
@Remote
public interface ComparePropertySessionBeanRemote {
    
    /**
     * 
     * 
     * @param propertyId Integer identifier for the new added property
     */
    void addPropertyId(int propertyId);
    
    /**
     * Removes a property matching the id.
     * 
     * @param propertyId Integer identifier for the property to be removed
     */
    void removePropertyId(int propertyId);
    
    /**
     * 
     * @return 
     */
    int bestPerRoom();
    
}
