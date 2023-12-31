package uz.grpc.grpcserver.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import uz.grpc.grpcserver.domain.Region;

@Repository
public interface RegionRepository extends ReactiveMongoRepository<Region,String> {
}
