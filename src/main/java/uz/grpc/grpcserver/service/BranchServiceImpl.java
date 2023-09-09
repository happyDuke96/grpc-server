package uz.grpc.grpcserver.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Signal;
import uz.grpc.grpcserver.domain.Branch;
import uz.grpc.grpcserver.repository.BranchRepository;

@Service
@Slf4j
@RequiredArgsConstructor
public class BranchServiceImpl implements BranchService {

    private final BranchRepository branchRepository;

    @Override
    public Mono<Branch> createBranch(Branch branchData) {
        return branchRepository.save(branchData)
                .doOnSuccess(Branch::toString)
                .doOnError(Throwable::getMessage);
    }

    @Override
    public Mono<Branch> getById(String id) {
        return branchRepository.findById(id)
                .doOnEach(Signal::get)
                .doOnError(Throwable::getMessage);
    }
}
