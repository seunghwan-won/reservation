package seunghwan.won.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import seunghwan.won.service.CommentService;
import seunghwan.won.service.DetailService;
import seunghwan.won.service.FileService;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Map;

@Controller
@RequestMapping(path = "review")
public class ReviewController {
    private final String UPLOAD_PATH = "/Users/seunghwanwon/Documents/dev/java/playground/reservation/src/main/webapp/resource/img/";
    @Autowired
    DetailService detailService;

    @Autowired
    CommentService commentService;

    @Autowired
    FileService fileService;

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
    public String reviewUpload(@RequestParam(name = "reviewImage") MultipartFile file,
                               @RequestParam(name = "comment") String comment,
                               @RequestParam(name = "productId") int productId,
                               @RequestParam(name = "reservationInfoId") int reservationInfoId,
                               @RequestParam(name = "score") int score) {

        StringBuilder saveFileName = new StringBuilder(UPLOAD_PATH + file.getOriginalFilename());
        String fileName = file.getOriginalFilename();
        try (
                // 맥일 경우
                FileOutputStream fos = new FileOutputStream(saveFileName.toString());
                // 윈도우일 경우
//                FileOutputStream fos = new FileOutputStream("c:/tmp/" + file.getOriginalFilename());
                InputStream is = file.getInputStream();
        ) {
            int readCount = 0;
            byte[] buffer = new byte[1024];
            while ((readCount = is.read(buffer)) != -1) {
                fos.write(buffer, 0, readCount);
            }
        } catch (Exception ex) {
            throw new RuntimeException("file Save Error");
        }
        int commentId = commentService.save(comment,productId,reservationInfoId, score);
        int fileId = fileService.save(fileName, saveFileName.toString());
        int commentImageId = commentService.commentImageSave(reservationInfoId, commentId, fileId);
        return "myreservation";
    }
}
