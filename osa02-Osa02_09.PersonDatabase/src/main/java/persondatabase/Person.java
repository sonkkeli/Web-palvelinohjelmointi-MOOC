
package persondatabase;

import javax.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 *
 * @author sonja
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person extends AbstractPersistable<Long>{
    private String name;
}
