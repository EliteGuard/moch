package cn.sspu.moch.domains;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class DriveOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Location target;

    @ManyToOne
    private LocationTypeAction operation;

    @ManyToOne
    private DriveOrderStatus status;

    @ManyToOne
    private TransportOrder torder;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dorder")
    private Set<DriveOrderRoute> routes = new HashSet<>();

    private Integer costs;
}
