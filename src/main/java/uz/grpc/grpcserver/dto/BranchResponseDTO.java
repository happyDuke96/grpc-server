package uz.grpc.grpcserver.dto;

import lombok.Builder;

@Builder
public record BranchResponseDTO(
        String id,
        String street,
        String house,
        String apartment,
        String latitude,
        String longitude,
        RegionDTO region
) {
}
