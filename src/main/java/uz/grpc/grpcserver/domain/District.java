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
public class District {

    @Id
    Integer id;

    String name;

    @DocumentReference(lazy = true)
    Region region;
}
