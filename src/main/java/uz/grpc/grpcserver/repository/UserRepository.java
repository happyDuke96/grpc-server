package uz.grpc.grpcserver.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import uz.grpc.grpcserver.domain.User;

public interface UserRepository extends ReactiveMongoRepository<User,Integer> {
}
