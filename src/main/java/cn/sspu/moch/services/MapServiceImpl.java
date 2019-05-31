package cn.sspu.moch.services;

import cn.sspu.moch.domains.Map;
import cn.sspu.moch.exceptions.NotFoundException;
import cn.sspu.moch.repositories.MapRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class MapServiceImpl implements MapService {

    private final MapRepository mapRepository;

    public MapServiceImpl(MapRepository mapRepository) {
        this.mapRepository = mapRepository;
    }

    @Override
    public Set<Map> getMaps() {
        Set<Map> mapSet = new HashSet<>();
        mapRepository.findAll().iterator().forEachRemaining(mapSet::add);
        return mapSet;
    }

    @Override
    public Map findById(Long l) {
        Optional<Map> mapOptional = mapRepository.findById(l);

        if (!mapOptional.isPresent()) {
            throw new NotFoundException("Map Not Found. For ID value: " + l.toString() );
        }

        return mapOptional.get();
    }
}
