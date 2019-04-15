package euroshopper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OrderController {
    
    @Autowired
    private ShoppingCart cart;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private OrderRepository orderRepository;

    @RequestMapping("/orders")
    public String list(Model model) {
        model.addAttribute("orders", orderRepository.findAll());
        return "orders";
    }

    @PostMapping("/orders")
    public String order(@RequestParam String name, @RequestParam String address) {

        List<OrderItem> items = new ArrayList<>();
        for (Item item : cart.getItems().keySet()){
            Long amount = cart.getItems().get(item);
            OrderItem it = new OrderItem();
            it.setItem(item);
            it.setItemCount(amount);
            items.add(it);            
        }
        Order order = new Order();
        order.setName(name);
        order.setAddress(address);
        order.setOrderItems(items);

        orderRepository.save(order);
        cart.clearCart();

        return "redirect:/orders";
    }
}
