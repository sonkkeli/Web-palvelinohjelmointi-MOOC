package examsandquestions;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Question extends AbstractPersistable<Long> {

    private String title;
    private String content;
    
    @ManyToMany
    private List<Exam> exams = new ArrayList<>();

}
