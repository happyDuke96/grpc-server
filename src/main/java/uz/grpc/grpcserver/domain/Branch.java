package uz.grpc.grpcserver.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(collection = "branch")
public class Branch implements Serializable {

    @Id
    @Indexed(unique = true)
    String id;

    String street;

    String house;

    String apartment;

    String latitude;

    String longitude;

    @Field("region")
    @DocumentReference(lookup = "{ 'region_id' : ?#{#target} }")
    Region region;
}
