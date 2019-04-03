package gifbin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class DefaultController {
    
    @Autowired
    private GifObjectRepository gifRepo;

    @GetMapping("/")
    public String redirect() {
        return "redirect:/gifs";
    }
    
    @GetMapping("/gifs")
    public String redirectGifs() {
        return "redirect:/gifs/1";
    }
    
    @GetMapping(path = "/gifs/{id}")
    public String showGif(Model model, @PathVariable Long id){
        Long count = gifRepo.count();
        Long previous;
        Long next;
        
        if (id - 1 < 1){
            previous = null;
        } else {
            previous = id - 1;
        }
        
        if (id + 1 > count){
            next = null;
        } else {
            next = id + 1;
        }
        model.addAttribute("count", count);
        model.addAttribute("current", id);
        model.addAttribute("previous", previous);
        model.addAttribute("next", next);
        
        return "gifs";
    }
    
    @GetMapping(path="/gifs/{id}/content", produces = "image/gif")
    @ResponseBody
    public byte[] getGifs(@PathVariable Long id){
        return gifRepo.getOne(id).getContent();
    }    
    
    @PostMapping("/gifs")
    public String save(@RequestParam("file") MultipartFile file) throws IOException {
        if (file.getContentType().equals("image/gif")){
            GifObject gif = new GifObject();
            gif.setContent(file.getBytes());
            gifRepo.save(gif);
        }       

        return "redirect:/gifs";
    }
}
