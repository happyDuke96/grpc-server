package uz.grpc.grpcserver.endpoint.http;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import uz.grpc.grpcserver.domain.Branch;
import uz.grpc.grpcserver.dto.BranchCreateDTO;
import uz.grpc.grpcserver.dto.BranchResponseDTO;
import uz.grpc.grpcserver.mapper.BranchMapper;
import uz.grpc.grpcserver.service.BranchService;
import java.time.Duration;

@RestController
@RequestMapping("/api/v1/branch")
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BranchResource {

    private final BranchService branchService;
    private final static long TIME_OUT_MILLIS= 5000L;

    @Operation(summary = "Create Branch")
    @PostMapping("/create")
    public Mono<ResponseEntity<BranchResponseDTO>> createBranch(@RequestBody BranchCreateDTO createDTO){
        return branchService.createBranch(BranchMapper.fromHttpRequestToEntity(createDTO))
                .doOnNext(Branch::toString)
                .map(branch -> ResponseEntity.ok().body(BranchMapper.toHttpDto(branch)))
                .timeout(Duration.ofMillis(TIME_OUT_MILLIS))
                .doOnError(Throwable::printStackTrace)
                .doOnSuccess(result -> log.info("Created branch: {},{}",result.getStatusCode(),result.getBody()));

    }

    @Operation(summary = "Get Branch by id")
    @GetMapping("/get/{id}")
    public Mono<ResponseEntity<BranchResponseDTO>> getBranch(@PathVariable String id){
        return branchService.getById(id)
                .doOnNext(Branch::toString)
                .map(branch -> ResponseEntity.ok().body(BranchMapper.toHttpDto(branch)))
                .timeout(Duration.ofMillis(TIME_OUT_MILLIS))
                .doOnError(Throwable::printStackTrace)
                .doOnSuccess(result -> log.info("Get Branch with id: {}",result.getBody().id()));
    }
}
