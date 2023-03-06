package com.example.MapSruct.service;

import com.example.MapSruct.dto.Destination;
import com.example.MapSruct.dto.Source;
import org.mapstruct.Mapper;

@Mapper
public interface SampleMapper {
  Destination sourceToDestination(Source source);
}
