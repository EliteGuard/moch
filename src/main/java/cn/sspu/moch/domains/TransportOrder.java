package cn.sspu.moch.domains;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class TransportOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDateTime createdTime;
    private LocalDateTime deadlineTime;
    private LocalDateTime finishedTime;

    @ManyToOne
    private Location source;

    @ManyToOne
    private Location target;

    @ManyToOne
    private Vehicle intendedVehicle;

    @ManyToOne
    private Vehicle executingVehicle;

    @ManyToOne
    private TransportOrderStatus status;

    @ManyToOne
    private TransportOrderCategory category;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private Set<TransportOrderEvent> events = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "torder")
    private Set<DriveOrder> driveOrders = new HashSet<>();

    @ManyToOne
    private Map map;

}
