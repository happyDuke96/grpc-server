package uz.grpc.grpcserver.service;

import reactor.core.publisher.Mono;
import uz.grpc.grpcserver.domain.Branch;

public interface BranchService {

    Mono<Branch> createBranch(Branch branchData);

    Mono<Branch> getById(String id);

}
