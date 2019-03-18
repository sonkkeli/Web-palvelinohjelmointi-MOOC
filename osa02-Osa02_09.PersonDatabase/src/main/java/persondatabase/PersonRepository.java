
package persondatabase;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author sonja
 */
public interface PersonRepository extends JpaRepository<Person,String> {
    
}
