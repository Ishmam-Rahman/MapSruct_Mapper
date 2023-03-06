package com.example.MapSruct.controller;

import com.example.MapSruct.dto.Destination;
import com.example.MapSruct.dto.Source;
import com.example.MapSruct.service.SampleMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeRestController {

  private SampleMapper mapper = Mappers.getMapper(SampleMapper.class);

  @GetMapping("/get-destination")
  public Destination getDestination() {

    StopWatch sw = new StopWatch();
    sw.start();
    Destination destination = mapper.sourceToDestination(getSource(1L, "ABC"));
    sw.stop();
    Long elapsedTime = sw.getTotalTimeMillis();
    System.out.println("Elapsed time: " + elapsedTime + " milliseconds");
    return destination;
  }

  public Source getSource(Long id, String name) {
    Source sc = new Source(id, name);
    return sc;
  }
}
