package com.b2b.spring.boot.demo.mapper;
import com.b2b.spring.boot.demo.Entity.User;
import com.b2b.spring.boot.demo.dto.IndirizzoRecord;
import com.b2b.spring.boot.demo.dto.ModificaUser;
import com.b2b.spring.boot.demo.dto.NuovoUser;
import com.b2b.spring.boot.demo.dto.UserRecord;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Mapping(target = "dettaglio", source = "dettaglio", qualifiedByName = "setDettaglioFromIndirizzoRecord")
    User toEntity(NuovoUser dto);

    @Mapping(target = "dettaglio", source = "dettaglio", qualifiedByName = "setIndirizzoRecordFromDettaglio")
    UserRecord toRecord(User entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "dettaglio", source = "dettaglio", qualifiedByName = "setDettaglioFromIndirizzoRecord")
    User partialUpdate(@MappingTarget User entity, ModificaUser dto);

    @Named("setDettaglioFromIndirizzoRecord") // questo è quello scritto nel qualifiedbyname
    default String setDettaglioFromIndirizzoRecord(IndirizzoRecord indirizzo) {
        try {
            return OBJECT_MAPPER.writeValueAsString(indirizzo);
        } catch (JsonProcessingException e){
            throw new RuntimeException(e);
        }
    }

    @Named("setIndirizzoRecordFromDettaglio")
    default IndirizzoRecord setIndirizzoRecordFromDettaglio(String dettaglio) {
        try {
            return OBJECT_MAPPER.readValue(dettaglio, IndirizzoRecord.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
