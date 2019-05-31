package cn.sspu.moch.domains;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class LocationType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany (cascade = CascadeType.ALL, mappedBy = "type")
    private Set<LocationTypeAction> actions = new HashSet<>();

    @Lob
    private Byte[] image;

    @OneToMany (cascade = CascadeType.ALL, mappedBy = "type")
    private Set<LocationTypeMiscellaneous> miscellaneous = new HashSet<>();

}
