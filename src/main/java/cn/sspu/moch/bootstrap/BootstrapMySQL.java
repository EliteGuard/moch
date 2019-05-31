package cn.sspu.moch.bootstrap;

import cn.sspu.moch.domains.Map;
import cn.sspu.moch.repositories.MapRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Profile({"dev", "prod"})
public class BootstrapMySQL implements ApplicationListener<ContextRefreshedEvent> {

    private final MapRepository mapRepository;

    public BootstrapMySQL(MapRepository mapRepository) {
        this.mapRepository = mapRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        if (mapRepository.count() == 0L){
            log.debug("Loading Maps");
            loadMaps();
        }
    }

    private void loadMaps(){
        Map map1 = new Map();
        map1.setName("SSPU_B19_F1");
        mapRepository.save(map1);

    }
}
