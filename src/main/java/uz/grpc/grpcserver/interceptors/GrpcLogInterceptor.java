package uz.grpc.grpcserver.interceptors;

import io.grpc.Metadata;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class GrpcLogInterceptor implements ServerInterceptor {
    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> serverCall, Metadata headers,
                                                                 ServerCallHandler<ReqT, RespT> serverCallHandler) {
      log.info("service: {}, method: {}, headers: {}",serverCall.getMethodDescriptor().getServiceName(),serverCall.getMethodDescriptor().getBareMethodName(),
              headers.toString());
        return serverCallHandler.startCall(serverCall,headers);
    }
}
