package uz.grpc.grpcserver.mapper;

import branch.CreatePizzaBranchRequest;
import branch.PizzaBranchData;
import lombok.experimental.UtilityClass;
import uz.grpc.grpcserver.domain.Branch;
import uz.grpc.grpcserver.dto.BranchCreateDTO;
import uz.grpc.grpcserver.dto.BranchResponseDTO;

@UtilityClass
public class BranchMapper {

    public Branch fromGrpcRequestToEntity(CreatePizzaBranchRequest request){
        return Branch.builder()
                .street(request.getStreet())
                .house(request.getHouse())
                .apartment(request.getApartment())
                .latitude(request.getLatitude())
                .longitude(request.getLongitude())
                .build();
    }

    public Branch fromHttpRequestToEntity(BranchCreateDTO createDTO){
        return Branch.builder()
                .street(createDTO.street())
                .house(createDTO.house())
                .apartment(createDTO.apartment())
                .latitude(createDTO.latitude())
                .longitude(createDTO.longitude())
                .region(RegionMapper.toEntity(createDTO.region()))
                .build();
    }


    public BranchResponseDTO toHttpDto(Branch branch){
        return BranchResponseDTO.builder()
                .id(branch.getId())
                .street(branch.getStreet())
                .house(branch.getHouse())
                .apartment(branch.getApartment())
                .latitude(branch.getLatitude())
                .longitude(branch.getLongitude())
//                .region(RegionMapper.toDto(branch.getRegion()))
                .build();
    }

    public PizzaBranchData toGrpc (Branch branch){
        return PizzaBranchData.newBuilder()
                .setId(branch.getId())
                .setStreet(branch.getStreet())
                .setHouse(branch.getHouse())
                .setApartment(branch.getApartment())
                .setLatitude(branch.getLatitude())
                .setLongitude(branch.getLongitude())
                .setRegion(RegionMapper.toGrpc(branch.getRegion()))
                .build();
    }
}
