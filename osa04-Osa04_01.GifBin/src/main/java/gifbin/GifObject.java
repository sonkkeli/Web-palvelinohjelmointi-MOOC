/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gifbin;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class GifObject extends AbstractPersistable<Long>{
    
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] content;
    
}
