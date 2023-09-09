package uz.grpc.grpcserver.dto;

public record BranchCreateDTO(
        String street,
        String house,
        String apartment,
        String latitude,
        String longitude,
        RegionDTO region){
}
