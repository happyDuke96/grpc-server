package uz.grpc.grpcserver.dto;

public record DistrictDTO(
        Integer id,
        String name,
        Integer code,
        Integer regionId) {
}
