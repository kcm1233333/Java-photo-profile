package com.example.demo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


//import org.glassfish.jersey.media.multipart.MultiPartFeature;
//import org.glassfish.jersey.media.multipart.MultiPartMediaTypes;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/user")
public class uploadPhoto {
	//System.out.println("Hello World");
	@PostMapping("/unggah")
	public  String unggahGambar (
			@RequestParam(required=false, name="berkasGam") MultipartFile berkas 
			) throws Exception{
	//MODEL --> entity
		//DTO--> request response, apa yang dibutuhkan restAPI 
		//DTO, Req, Res--> serializerNumUID
		//UpdateProfilePhoto
		byte[] bit=berkas.getBytes();
		Path path=Paths.get("D:\\profile_photo", "345"+".png");
		System.out.println(path);
		String pure="Success";
		Files.write( path, bit);
		
	 return pure;
	}
}
