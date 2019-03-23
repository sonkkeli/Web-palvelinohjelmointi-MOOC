
package examsandquestions;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author sonja
 */
public interface QuestionRepository extends JpaRepository<Question, Long>{
    
}
