package uz.grpc.grpcserver.dto;

import java.time.LocalDateTime;

public record ErrorResponse(
        int status,
        String message,
        LocalDateTime dateTime
) {
}
