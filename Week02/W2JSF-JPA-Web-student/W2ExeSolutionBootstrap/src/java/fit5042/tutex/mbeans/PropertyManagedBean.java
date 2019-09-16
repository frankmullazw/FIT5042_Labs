/*
 * To change this license header, choose License Headers in Project Properties.
 */
package fit5042.tutex.mbeans;

import fit5042.tutex.repository.PropertyRepository;
import fit5042.tutex.repository.entities.Property;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author messomc
 */
@ManagedBean(name = "propertyManagedBean")
@SessionScoped
public class PropertyManagedBean implements Serializable {

    @EJB
    PropertyRepository propertyRepository;

    /**
     * Creates a new instance of PropertyManagedBean
     */
    public PropertyManagedBean() {
    }

    public List<Property> getAllProperties() {
        try {
            return propertyRepository.getAllProperties();
        } catch (Exception ex) {
            Logger.getLogger(PropertyManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Property searchPropertyById(int id)
    {
        try {
            return propertyRepository.searchPropertyById(id);
        } catch (Exception ex) {
            Logger.getLogger(PropertyManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
}
