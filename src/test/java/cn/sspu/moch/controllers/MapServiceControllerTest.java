package cn.sspu.moch.controllers;

import cn.sspu.moch.domains.Map;
import cn.sspu.moch.exceptions.NotFoundException;
import cn.sspu.moch.services.MapService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class MapServiceControllerTest {

    @Mock
    MapService mapService;

    MapServiceController mapController;

    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        mapController = new MapServiceController(mapService);
        mockMvc = MockMvcBuilders.standaloneSetup(mapController)
                .setControllerAdvice(new ControllerExceptionHandler())
                .build();
    }

    @Test
    public void getAllMaps() throws Exception{
        Map map = new Map();
        map.setId(1L);
        Set<Map> maps = new HashSet<>();
        maps.add(map);

        when(mapService.getMaps()).thenReturn(maps);

        mockMvc.perform(get("/api/maps"))
            .andExpect(status().isOk());
    }

    @Test
    public void getMapByIdTest() throws Exception{
        Map map = new Map();
        map.setId(1L);

        when(mapService.findById(anyLong())).thenReturn(map);

        mockMvc.perform(get("/api/map/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void getMapNotFoundTest() throws Exception {

        when(mapService.findById(anyLong())).thenThrow(NotFoundException.class);

        mockMvc.perform(get("/map/1"))
                .andExpect(status().isNotFound());
    }
}