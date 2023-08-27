package uz.grpc.grpcserver.dto;

public record RegionDTO(
        Integer id,
        String name,
        Integer code,
        Integer isoCode) {
}
