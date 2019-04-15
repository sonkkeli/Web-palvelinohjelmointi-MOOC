package euroshopper;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import lombok.*;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 *
 * @author sonja
 */

@Data
@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ShoppingCart implements Serializable {
    private Map<Item,Long> items;
    private int sum;
    
    public ShoppingCart(){
        this.items = new HashMap<>();
        this.sum = 0;
    }
    
    public void addToCart(Item item){
        this.sum += item.getPrice();
        if (items.containsKey(item)){
            Long amount = this.items.get(item);
            this.items.replace(item, amount +1);
        } else {
            this.items.put(item, 1L);
        }
    }
    public void clearCart(){
        this.items = new HashMap<>();
        this.sum = 0;
    }
}
