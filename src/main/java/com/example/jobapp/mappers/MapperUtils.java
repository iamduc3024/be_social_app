package com.example.jobapp.mappers;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import lombok.experimental.UtilityClass;

@UtilityClass
public class MapperUtils {

    public static <S, D> D map(S source, Class<D> destionation) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(source, destionation);
    }

    public static <S, D> void map(S source, D destionation) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        modelMapper.map(source, destionation);
    }

}
