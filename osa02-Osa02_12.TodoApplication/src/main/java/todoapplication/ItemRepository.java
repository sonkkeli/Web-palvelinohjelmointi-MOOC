
package todoapplication;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author sonja
 */
public interface ItemRepository extends JpaRepository<Item,Long>{
    
}
