package cn.sspu.moch.controllers;

import cn.sspu.moch.domains.Map;
import cn.sspu.moch.services.MapService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping(value = "/api")
public class MapServiceController {

    private final MapService mapService;

    public MapServiceController(MapService mapService) {
        this.mapService = mapService;
    }

    @GetMapping(path = "/maps", produces = "application/json")
    public Set<Map> getAllMaps(){
        return this.mapService.getMaps();
    }

    @GetMapping(path = "/map/{id}", produces = "application/json")
    public Map getMapById(@PathVariable String id){
        return  mapService.findById(Long.valueOf(id));
    }

}
