
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
public class Course extends AbstractPersistable<Long>{
    
    private String name;
    
    @ManyToMany
    @JoinTable(
            name="Enrollment", 
            joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id")
    )
    private List<Student> students = new ArrayList<>();
}
