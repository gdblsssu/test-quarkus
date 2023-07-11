package org.acme.mappers;

import org.acme.dto.OwnersDocumentDTO;
import org.acme.entity.OwnersDocument;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(
        componentModel = "jakarta",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface OwnersDocumentMapper {
    OwnersDocumentMapper INSTANCE = Mappers.getMapper(OwnersDocumentMapper.class);
    OwnersDocumentDTO toDTO(OwnersDocument ownersDocument);
    List<OwnersDocumentDTO> toListDTO(List<OwnersDocument> ownersDocumentList);
    OwnersDocument toEntity(OwnersDocumentDTO ownersDocumentDTO);
}
