package uz.grpc.grpcserver.domain;


import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document
public class Address {

    @Id
    Integer id;

    String street;

    String house;

    Integer regionId;

    @DocumentReference(lazy = true)
    Region region;

    Integer districtId;

    @DocumentReference(lazy = true)
    District district;
}

