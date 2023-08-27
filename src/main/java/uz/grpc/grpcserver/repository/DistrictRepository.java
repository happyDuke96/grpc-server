package uz.grpc.grpcserver.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import uz.grpc.grpcserver.domain.District;

public interface DistrictRepository extends ReactiveMongoRepository<District,Integer> {
}
