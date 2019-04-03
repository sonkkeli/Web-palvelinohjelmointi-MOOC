package filemanager;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class DefaultController {
    
    @Autowired
    FileObjectRepository fileRepo;

    @GetMapping("/")
    public String redirect() {
        return "redirect:/files";
    }
    @GetMapping("/files")
    public String viewFiles(Model model) {
        model.addAttribute("files", fileRepo.findAll());
        return "files";
    } 
    
    @PostMapping("/files")
    public String save(@RequestParam("file") MultipartFile file) throws IOException {
        FileObject fo = new FileObject();
        fo.setName(file.getOriginalFilename());
        fo.setContentType(file.getContentType());
        fo.setContentLength(file.getSize());
        fo.setContent(file.getBytes());

        fileRepo.save(fo);

        return "redirect:/files";
    }
    
    @GetMapping(path="/files/{id}")
    public ResponseEntity<byte[]> viewFile(@PathVariable Long id){
        FileObject fo = fileRepo.getOne(id);
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType( MediaType.parseMediaType( fo.getContentType() ) );
        headers.setContentLength( fo.getContentLength() );
        headers.add("Content-Disposition", "attachment; filename=" + fo.getName());
        
        return new ResponseEntity<>(fo.getContent(), headers, HttpStatus.CREATED);
    }
    
    @DeleteMapping("/files/{id}")
    public String delete(@PathVariable(value="id") Long id){
        fileRepo.delete(fileRepo.getOne(id));
        return "redirect:/files";
    }
}
