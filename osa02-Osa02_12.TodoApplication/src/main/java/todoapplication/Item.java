
package todoapplication;

import java.util.UUID;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 *
 * @author sonja
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item extends AbstractPersistable<Long>{
    private String name;
    private int checked;
}
