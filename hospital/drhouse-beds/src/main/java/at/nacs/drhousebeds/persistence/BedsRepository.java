package at.nacs.drhousebeds.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface BedsRepository extends MongoRepository<Patient, String> {
}
