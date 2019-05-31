package cn.sspu.moch.domains;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Map {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "map")
    private Set<Point> points = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "map")
    private Set<Point> paths = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "map")
    private Set<Point> locations = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "map")
    private Set<Point> vehicles = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "map")
    private Set<Block> blocks = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "map")
    private Set<TransportOrder> orders = new HashSet<>();
}
