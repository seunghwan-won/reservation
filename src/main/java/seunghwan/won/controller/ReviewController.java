package seunghwan.won.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import seunghwan.won.service.DetailService;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Map;

@Controller
@RequestMapping(path = "review")
public class ReviewController {
    @Autowired
    DetailService detailService;

    @GetMapping()
    public String reviewPage(@RequestParam(name = "id", required = true) int productId, Model model) {
        Map<String, Object> result = detailService.getDetail(productId);
        model.addAttribute("commentList", result.get("comments"));
        model.addAttribute("displayInfo", result.get("displayInfo"));
        model.addAttribute("averageScore", result.get("averageScore"));
        return "review";
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PostMapping(path = "upload")
    public String reviewUpload(@RequestParam(name = "reviewImage") MultipartFile file) {

        System.out.println("파일 이름 : " + file.getOriginalFilename());
        System.out.println("파일 크기 : " + file.getSize());

        try(
                // 맥일 경우
                FileOutputStream fos = new FileOutputStream("/Users/seunghwanwon/Desktop/" + file.getOriginalFilename());
                // 윈도우일 경우
//                FileOutputStream fos = new FileOutputStream("c:/tmp/" + file.getOriginalFilename());
                InputStream is = file.getInputStream();
        ){
            int readCount = 0;
            byte[] buffer = new byte[1024];
            while((readCount = is.read(buffer)) != -1){
                fos.write(buffer,0,readCount);
            }
        }catch(Exception ex){
            throw new RuntimeException("file Save Error");
        }

        return "myreservation";
    }
}
