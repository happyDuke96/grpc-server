package uz.grpc.grpcserver.dto;

public record UserCreateDTO(
        String name,
        String lastName,
        Integer age,
        AddressDTO address
){
}
