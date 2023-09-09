package uz.grpc.grpcserver.interceptors;

import net.devh.boot.grpc.server.interceptor.GrpcGlobalServerInterceptor;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class InterceptorConfiguration {

    @GrpcGlobalServerInterceptor
    public GrpcLogInterceptor grpcLogInterceptor(){
        return new GrpcLogInterceptor();
    }
}
