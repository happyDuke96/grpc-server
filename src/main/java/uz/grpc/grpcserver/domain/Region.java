package uz.grpc.grpcserver.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import java.io.Serializable;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(collection = "region")
public class Region implements Serializable {

    @Id
    @Field("region_id")
    @Indexed(unique = true)
    String regionId;

    @Field("name")
    String name;

    @Field("iso_code")
    String isoCode;
}
