package cn.sspu.moch.domains;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private BigDecimal xPosition;
    private BigDecimal yPosition;

    @ManyToOne
    private LocationType type;

    @Lob
    private Byte[] image;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "location")
    private Set<LocationMiscellaneous> miscellaneous = new HashSet<>();

    @ManyToMany(mappedBy = "locations")
    private Set<Block> blocks;

    @ManyToOne
    private Map map;
}
