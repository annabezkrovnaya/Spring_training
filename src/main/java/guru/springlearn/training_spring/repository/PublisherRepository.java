package guru.springlearn.training_spring.repository;

import guru.springlearn.training_spring.entity.Publisher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends CrudRepository<Publisher, Integer> {
}
