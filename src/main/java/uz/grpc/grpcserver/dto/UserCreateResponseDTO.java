package uz.grpc.grpcserver.dto;

public record UserCreateResponseDTO(
        Integer id,
        String name,
        String lastName,
        Integer age,
        AddressDTO address
) {
}
