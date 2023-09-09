package uz.grpc.grpcserver.endpoint.grpc;

import io.grpc.Status;
import io.grpc.StatusException;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.advice.GrpcAdvice;
import net.devh.boot.grpc.server.advice.GrpcExceptionHandler;
import javax.validation.ConstraintViolationException;

@GrpcAdvice
@Slf4j
public class GrpcExceptionAdvice {

    @GrpcExceptionHandler(RuntimeException.class)
    public StatusException handleRuntime(RuntimeException ex){
        var status = Status.INTERNAL.withDescription(ex.getLocalizedMessage()).withCause(ex);
        log.error("Grpc RuntimeException: ", ex);
        return status.asException();
    }

    @GrpcExceptionHandler(ConstraintViolationException.class)
    public StatusException handleConstraintViolationException(ConstraintViolationException ex) {
        var status = Status.INVALID_ARGUMENT.withDescription(ex.getLocalizedMessage()).withCause(ex);
        log.error("ConstraintViolationException: ", ex);
        return status.asException();
    }

}
