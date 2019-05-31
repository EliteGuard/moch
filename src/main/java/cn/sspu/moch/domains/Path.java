package cn.sspu.moch.domains;


import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Path {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private BigDecimal length;
    private Integer cost;
    private BigDecimal maxVelocity;
    private BigDecimal maxReverseVelocity;

    @ManyToOne
    private PathType type;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "path")
    private Set<ControlPoint> controlPoints = new HashSet<>();

    @ManyToOne
    private Point start;

    @ManyToOne
    private Point end;

    private Boolean disabled;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "path")
    private Set<PathMiscellaneous> misc = new HashSet<>();

    @ManyToMany(mappedBy = "paths")
    private Set<Block> blocks;

    @ManyToOne
    private Map map;

}
