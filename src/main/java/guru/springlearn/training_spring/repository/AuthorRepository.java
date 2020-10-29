package guru.springlearn.training_spring.repository;

import guru.springlearn.training_spring.entity.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Integer>{
}
