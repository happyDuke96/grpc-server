package uz.grpc.grpcserver.endpoint.grpc;

import branch.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;
import uz.grpc.grpcserver.domain.Branch;
import uz.grpc.grpcserver.interceptors.GrpcLogInterceptor;
import uz.grpc.grpcserver.mapper.BranchMapper;
import uz.grpc.grpcserver.service.BranchService;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.time.Duration;

@GrpcService(interceptors = {GrpcLogInterceptor.class})
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PizzaBranchGrpcService extends ReactorBranchServiceGrpc.BranchServiceImplBase {

    private final BranchService branchService;
    private final Validator validator;
    private final static long TIME_OUT_MILLIS = 5000L;

    @Override
    public Mono<CreatePizzaBranchResponse> createBranch(Mono<CreatePizzaBranchRequest> request) {
        return request.flatMap(req -> branchService.createBranch(validate(BranchMapper.fromGrpcRequestToEntity(req)))
                .doOnNext(Branch::toString)
                .map(branch -> CreatePizzaBranchResponse.newBuilder().setBranch(BranchMapper.toGrpc(branch)).build())
                .timeout(Duration.ofMillis(TIME_OUT_MILLIS))
                .doOnError(Throwable::printStackTrace)
                .doOnSuccess(result -> log.info("Created branch: {}", result.getBranch())));
    }

    @Override
    public Mono<GetPizzaBranchByIdResponse> getBranchById(Mono<GetPizzaBranchByIdRequest> request) {
        return request.flatMap(req -> branchService.getById(req.getId()))
                .doOnNext(Branch::toString)
                .map(branch -> GetPizzaBranchByIdResponse.newBuilder().setBranch(BranchMapper.toGrpc(branch)).build())
                .timeout(Duration.ofMillis(TIME_OUT_MILLIS))
                .doOnError(Throwable::printStackTrace)
                .doOnSuccess(result -> log.info("Get Branch with id: {}", result.getBranch().getId()));
    }

    private <T> T validate(T data) {
        var errors = validator.validate(data);
        if (!errors.isEmpty()) throw new ConstraintViolationException(errors);
        return data;
    }
}
