package sec.project.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class SignupRepositoryImpl implements SignupRepositoryCustom{
    
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<String> getSignupsByName(String name, String owner) {
        
        Query query = em.createQuery("SELECT name FROM Signup WHERE owner='" + owner + "' AND name = '"+name+"'");
        List<String> names = query.getResultList();
        return names;
    }
}
