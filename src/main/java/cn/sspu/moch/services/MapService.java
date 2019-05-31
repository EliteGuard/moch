package cn.sspu.moch.services;

import cn.sspu.moch.domains.Map;

import java.util.Set;

public interface MapService {

    Set<Map> getMaps();

    Map findById(Long l);
}
