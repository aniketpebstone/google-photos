package org.google.photos;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class GooglePhotosController {
	
	 List<Image> list=new ArrayList<>();
	@PostConstruct
	public void initialize()
	{
		 list=new ArrayList<>();	
		 Image image=new Image();
		 image.setName("photo1");
		 image.setUrl("http:9000/images/a1.jpg");
		 list.add(image);
		 image=new Image();
		 image.setName("photo2");
		 image.setUrl("http:9000/images/a2.jpg");
		 list.add(image);
	}
	
	@GetMapping(value="/status")
	public ResponseEntity<?> getStatus(){
		return ResponseEntity.ok().build();
	}
	
	@PreAuthorize("#oauth2.hasScope('read-photos')")
	@GetMapping(value = "/photos")
	public ResponseEntity<?> photos() {
     return ResponseEntity.ok(list);
	}
	
	@PreAuthorize("#oauth2.hasScope('read-metadata')")
	@GetMapping(value = "/photos-with-meta")
	public ResponseEntity<?> photosWithMeta() {
     return ResponseEntity.ok(list);
	}
	
}
