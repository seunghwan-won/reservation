package seunghwan.won.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import seunghwan.won.service.ImageService;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(path = "api/img")
public class ApiImageController {
    @Autowired
    ImageService imageService;

    @GetMapping(path = "map", produces = MediaType.IMAGE_PNG_VALUE)
    public @ResponseBody
    byte[] mapImage(@RequestParam(name = "id", required = true) int displayInfoId, HttpServletRequest request) {
        return imageService.getMapImage(displayInfoId, request);
    }
}
