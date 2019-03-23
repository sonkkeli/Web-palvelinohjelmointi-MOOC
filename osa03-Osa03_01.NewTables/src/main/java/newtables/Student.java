
package newtables;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 *
 * @author sonja
 */
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Student extends AbstractPersistable<Long>{
    
    @Column (name="first_name")
    private String firstName;
    
    @Column (name="last_name")
    private String lastName;
    
    @ManyToMany(mappedBy = "students")
    private List<Course> courses = new ArrayList<>();
}
