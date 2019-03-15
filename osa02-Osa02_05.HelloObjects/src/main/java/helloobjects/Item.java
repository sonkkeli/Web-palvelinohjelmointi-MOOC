package helloobjects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Item {

    private String name;
    private String type;
    
    @Override
    public String toString(){
        return this.name + " (" + this.type +")";
    }
}
