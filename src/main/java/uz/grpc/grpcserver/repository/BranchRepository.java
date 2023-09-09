package uz.grpc.grpcserver.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import uz.grpc.grpcserver.domain.Branch;

@Repository
public interface BranchRepository extends ReactiveMongoRepository<Branch,String> {

}
