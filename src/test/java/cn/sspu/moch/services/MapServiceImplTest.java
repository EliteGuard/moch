package cn.sspu.moch.services;

import cn.sspu.moch.domains.Map;
import cn.sspu.moch.repositories.MapRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class MapServiceImplTest {

    MapServiceImpl mapService;

    @Mock
    MapRepository mapRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        mapService = new MapServiceImpl(mapRepository);
    }

    @Test
    public void getMapsTest() {
        Map map = new Map();
        map.setId(1L);
        Optional<Map> recipeOptional = Optional.of(map);

        when(mapRepository.findById(anyLong())).thenReturn(recipeOptional);

        Map mapReturned = mapService.findById(1L);

        assertNotNull("Null map returned", mapReturned);
        verify(mapRepository, times(1)).findById(anyLong());
        verify(mapRepository, never()).findAll();
    }
}