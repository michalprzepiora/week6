package pl.com.przepiora.week6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.com.przepiora.week6.model.Movie;
import pl.com.przepiora.week6.repository.MovieRepository;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieApi {

  private final MovieRepository repository;

  @Autowired
  public MovieApi(MovieRepository repository) {
    this.repository = repository;
  }

  @GetMapping
  public List<Movie> getAllMovies(){
    return repository.findAll();
  }

  @PostMapping
  public void addMovie(@RequestBody Movie movie){
    repository.save(movie);
  }

}
