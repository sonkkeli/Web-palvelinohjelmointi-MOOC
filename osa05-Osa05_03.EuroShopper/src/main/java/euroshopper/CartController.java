
package euroshopper;

import java.util.UUID;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author sonja
 */
@Controller
public class CartController {
    
    @Autowired
    private ShoppingCart cart;
    
    @Autowired
    private ItemRepository itemRepo;
    
    @Autowired
    private HttpSession session;
    
    @GetMapping("/cart")
    public String showCart(Model model){        
        model.addAttribute("items", cart.getItems());
        model.addAttribute("sum", cart.getSum());
        return "cart";
    }
    
    @PostMapping(value="/cart/items/{id}")
    public String add(@PathVariable(value="id") Long id){
        
        Item item = itemRepo.getOne(id);
        System.out.println(item);
        
        cart.addToCart(item);
        System.out.println(cart);
        return "redirect:/cart";
    }
}
