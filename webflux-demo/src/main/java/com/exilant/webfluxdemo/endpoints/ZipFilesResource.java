package com.exilant.webfluxdemo.endpoints;

import java.io.FileInputStream;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class ZipFilesResource {

	String basePath = "/Users/vinodkumar/Documents/__temp";

	@GetMapping(path = "/downloadfile", produces = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public Mono<byte[]> downloadOneZip() {
		String filename = basePath + "/Archive.zip";

		try {
			FileInputStream file = new FileInputStream(filename);
			byte[] bytes = new byte[file.available()];
			file.read(bytes);
			file.close();
			return Mono.just(bytes);
		} catch (Exception e) {
			e.printStackTrace();
			return Mono.just(new byte[] {});
		}
	}
}
