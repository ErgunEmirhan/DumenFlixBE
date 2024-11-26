package com.mcann.dumenflix.controller;

import static com.mcann.dumenflix.constant.RestApis.*;
import com.mcann.dumenflix.dto.response.BaseResponse;
import com.mcann.dumenflix.entity.MovieCard;
import com.mcann.dumenflix.service.MovieCardService;
import com.mcann.dumenflix.utility.enums.Genre;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(MOVIE)
@RequiredArgsConstructor
@CrossOrigin("*")
public class MovieCardController {
	private final MovieCardService movieCardService;
	
	@GetMapping(MOVIELIST)
	public ResponseEntity<BaseResponse<List<MovieCard>>> getAllMovies() {
		return ResponseEntity.ok(BaseResponse.<List<MovieCard>>builder()
				                         .code(200)
				                         .data(movieCardService.getAllMovies())
				                         .message("Success")
				                         .success(true)
		                                 .build()
		);
	}
	
	@GetMapping(MOVIEBYGENRE)
	public ResponseEntity<BaseResponse<List<MovieCard>>> getMoviesByGenre(Genre genre) {
		return ResponseEntity.ok(BaseResponse.<List<MovieCard>>builder()
		                                     .code(200)
		                                     .data(movieCardService.getMoviesByGenre(genre))
		                                     .message("Success")
		                                     .success(true)
		                                     .build()
		);
	}
	
	@GetMapping(MOVIEBYTITLE)
	public ResponseEntity<BaseResponse<List<MovieCard>>> getMoviesByName(String name){
		return ResponseEntity.ok(BaseResponse.<List<MovieCard>>builder()
		                                     .code(200)
		                                     .data(movieCardService.getMoviesByName(name))
		                                     .message("Success")
		                                     .success(true)
		                                     .build()
		);
	}
}