package uz.grpc.grpcserver.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import uz.grpc.grpcserver.domain.Region;

public interface RegionRepository extends ReactiveMongoRepository<Region,Integer> {
}
