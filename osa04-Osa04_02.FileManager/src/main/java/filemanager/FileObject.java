/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filemanager;

import javax.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 *
 * @author sonja
 */
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class FileObject extends AbstractPersistable<Long> {
    private String name;
    private Long contentLength;
    private String contentType;
    
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] content;
    
    public void delete(Long id){
        
    }
}
