package uz.grpc.grpcserver.dto;

import lombok.Builder;

@Builder
public record RegionDTO(
        String id,
        String name,
        String isoCode
) {
}
