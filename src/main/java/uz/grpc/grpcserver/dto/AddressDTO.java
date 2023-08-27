package uz.grpc.grpcserver.dto;

public record AddressDTO(
        String street,
        String house,
        RegionDTO region) {
}
