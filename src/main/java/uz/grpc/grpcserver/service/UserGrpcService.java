package uz.grpc.grpcserver.service;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;
import user.CreateUserRequest;
import user.CreateUserResponse;
import user.GetUserByIdRequest;
import user.GetUserByIdResponse;

@Slf4j
@net.devh.boot.grpc.server.service.GrpcService()
public class GrpcService extends user.ReactorUserServiceGrpc.UserServiceImplBase {

    @Override
    public Mono<CreateUserResponse> createUser(Mono<CreateUserRequest> request) {
        return super.createUser(request);
    }

    @Override
    public Mono<GetUserByIdResponse> getUserById(Mono<GetUserByIdRequest> request) {
        return super.getUserById(request);
    }
}
