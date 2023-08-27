package uz.grpc.grpcserver.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document
public class Region {

    @Id
    Integer id;

    String name;

    String isoCode;

    @ReadOnlyProperty
    @DocumentReference(lazy = true)
    List<District> districts;
}
