package com.shubham.Controller;

import com.cloudinary.Cloudinary;
import com.shubham.Entity.Image;
import com.shubham.Repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("http://localhost:3000/")
public class ImageController {
    @Autowired
    private ImageRepository repository;
    @Autowired
    private Cloudinary cloudinary;

    @PostMapping("/uploadImage")
    public ResponseEntity<?> uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
        try {
            Map map = cloudinary.uploader().upload(file.getBytes(), Map.of());
            repository.save(Image.builder()
                    .name(file.getOriginalFilename())
                    .URL((String) map.get("url")).build());

            return new ResponseEntity<>("Record Inserted Successfully : " + ((String) map.get("url")), HttpStatus.OK);
        } catch (Exception c) {
            return new ResponseEntity<>("Something went wrong", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("getImage/{id}")
    public ResponseEntity<?> downloadImage(@PathVariable Long id){
        if(repository.existsById(id)) {
            return new ResponseEntity<>(repository.findById(id).get().getURL(), HttpStatus.OK);
        } else  {
            return new ResponseEntity<>("Image not found with given ID", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/GetAllImage")
    public ResponseEntity<?> getAllImages() {
        try {
            List<String> links = new LinkedList<>();
            for(Image image : repository.findAll()) {
                links.add(image.getURL());
            }

            return new ResponseEntity<>(links, HttpStatus.OK);
        } catch (Exception c) {
            return new ResponseEntity<>("Something went wrong", HttpStatus.BAD_REQUEST);
        }
    }

}
