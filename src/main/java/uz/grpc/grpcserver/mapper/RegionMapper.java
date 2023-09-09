package uz.grpc.grpcserver.mapper;

import branch.RegionGrpc;
import lombok.experimental.UtilityClass;
import uz.grpc.grpcserver.domain.Region;
import uz.grpc.grpcserver.dto.RegionDTO;

@UtilityClass
public class RegionMapper {

    public Region toEntity(RegionDTO regionDTO) {
        return Region.builder()
                .name(regionDTO.name())
                .isoCode(regionDTO.isoCode())
                .build();
    }

    public RegionDTO toDto(Region region) {
        return RegionDTO.builder()
                .id(region.getRegionId())
                .name(region.getName())
                .isoCode(region.getIsoCode())
                .build();
    }


    public RegionGrpc toGrpc(Region region){
        return RegionGrpc.newBuilder()
                .setId(region.getRegionId())
                .setName(region.getName())
                .setIsoCode(region.getIsoCode())
                .build();
    }

}
