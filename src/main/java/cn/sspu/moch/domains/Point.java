package cn.sspu.moch.domains;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Point {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private BigDecimal xPosition;
    private BigDecimal yPosition;
    private BigDecimal angle;

    @ManyToOne
    private PointType type;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "point")
    private Set<PointMiscellaneous> misc = new HashSet<>();

    @ManyToMany(mappedBy = "points")
    private Set<Block> blocks;

    @ManyToOne
    private Map map;

}
