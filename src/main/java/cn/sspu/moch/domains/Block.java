package cn.sspu.moch.domains;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Block {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private BlockType type;

    @OneToMany (mappedBy = "block")
    private Set<BlockMiscellaneous> misc = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "block_point",
            joinColumns = @JoinColumn(name = "block_id"),
            inverseJoinColumns = @JoinColumn(name = "point_id"))
    private Set<Point> points  = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "block_path",
            joinColumns = @JoinColumn(name = "block_id"),
            inverseJoinColumns = @JoinColumn(name = "point_id"))
    private Set<Path> paths = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "block_location",
            joinColumns = @JoinColumn(name = "block_id"),
            inverseJoinColumns = @JoinColumn(name = "point_id"))
    private Set<Location> locations = new HashSet<>();

    @ManyToOne
    private Map map;

}
