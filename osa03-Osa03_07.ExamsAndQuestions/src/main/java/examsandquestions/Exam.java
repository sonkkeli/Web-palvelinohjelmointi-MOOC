package examsandquestions;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor 
public class Exam extends AbstractPersistable<Long> {

    private String subject;
    private LocalDate examDate;
    
    @ManyToMany(mappedBy="exams")
    private List<Question> questions = new ArrayList<>();

}
